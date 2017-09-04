package me.itsyc.itrace.service.section01;

public class ServiceNetworkAggregations {

    String serviceName;
    Long maxNetworkCost;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getMaxNetworkCost() {
        return maxNetworkCost;
    }

    public void setMaxNetworkCost(Long maxNetworkCost) {
        this.maxNetworkCost = maxNetworkCost;
    }
}
