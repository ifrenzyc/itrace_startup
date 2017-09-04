package me.itsyc.itrace.service.section01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Section01Bootstrap {

    public static void main(String[] args) throws IOException {
        // 读取文件，将文本解析完到对象数组
        // 这里从 Classpath 开始读取文件
        InputStream in = Section01Bootstrap.class.getClassLoader().getResourceAsStream("service.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        List<ServiceResult> services = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            ServiceResult service = doParserServiceText(line);

            services.add(service);
        }

        // 统计
        List<ServerBackendAggregations> serverBackendAggregations = new ArrayList<>();
        List<ServiceNetworkAggregations> serviceNetworkAggregations = new ArrayList<>();
        for (ServiceResult serv : services) {
            String serviceName = serv.getServiceName();

            boolean isExists = false;
            for (ServerBackendAggregations aggregations : serverBackendAggregations) {
                if (serviceName.equals(aggregations.getServiceName())) {
                    isExists = true;

                    aggregations.getBackendCosts().add(serv.getBackendCost());
                }
            }

            if (!isExists) {
                ServerBackendAggregations aggregations = new ServerBackendAggregations();
                aggregations.setServiceName(serviceName);
                aggregations.getBackendCosts().add(serv.getBackendCost());
                serverBackendAggregations.add(aggregations);
            }

            isExists = false;
            for (ServiceNetworkAggregations aggregations : serviceNetworkAggregations) {
                if (serviceName.equals(aggregations.getServiceName())) {
                    isExists = true;

                    Long networkCost = serv.getFrontendCost() - serv.getBackendCost();
                    if (networkCost > aggregations.getMaxNetworkCost()) {
                        aggregations.setMaxNetworkCost(networkCost);
                    }
                }
            }

            if (!isExists) {
                ServiceNetworkAggregations aggregations = new ServiceNetworkAggregations();
                aggregations.setServiceName(serviceName);
                Long networkCost = serv.getFrontendCost() - serv.getBackendCost();
                aggregations.setMaxNetworkCost(networkCost);
                serviceNetworkAggregations.add(aggregations);
            }
        }

        for (ServerBackendAggregations aggregations : serverBackendAggregations) {
            List<Long> aggs = aggregations.getBackendCosts();
            Long total = aggs.stream().mapToLong(Long::longValue).sum();
            aggregations.setBackendCostAvg( (total / aggs.size()) );
        }

        System.out.println("后端平均耗时前5及其平均值：");
        serverBackendAggregations.sort(Comparator.comparing(ServerBackendAggregations::getBackendCostAvg));

        List<ServerBackendAggregations> tail = serverBackendAggregations.subList(Math.max(serverBackendAggregations.size() - 5, 0),
                serverBackendAggregations.size());
        for(ServerBackendAggregations aggregations : tail) {

            System.out.println(aggregations.getServiceName() + " : " + aggregations.getBackendCostAvg());
        }

        System.out.println("前端耗时减去后端耗时差值前5及其差值：");
        serviceNetworkAggregations.sort(Comparator.comparing(ServiceNetworkAggregations::getMaxNetworkCost));

        List<ServiceNetworkAggregations> tail2 = serviceNetworkAggregations.subList(Math.max(serviceNetworkAggregations.size() - 5, 0),
                serviceNetworkAggregations.size());
        for(ServiceNetworkAggregations aggregations : tail2) {

            System.out.println(aggregations.getServiceName() + " : " + aggregations.getMaxNetworkCost());
        }
    }

    public static ServiceResult doParserServiceText(String text) {
        String[] cols = text.split("\\|");

        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setUuid(cols[0]);
        serviceResult.setServiceName(cols[1]);
        serviceResult.setBackendCost(Long.valueOf(cols[6]));
        serviceResult.setFrontendCost(Long.valueOf(cols[7]));

        return serviceResult;
    }
}