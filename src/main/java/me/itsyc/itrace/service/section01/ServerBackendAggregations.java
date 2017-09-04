package me.itsyc.itrace.service.section01;

import java.util.ArrayList;
import java.util.List;

public class ServerBackendAggregations {

    String serviceName;
    List<Long> backendCosts = new ArrayList<>();
    Long backendCostAvg;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<Long> getBackendCosts() {
        return backendCosts;
    }

    public void setBackendCosts(List<Long> backendCosts) {
        this.backendCosts = backendCosts;
    }

    public Long getBackendCostAvg() {
        return backendCostAvg;
    }

    public void setBackendCostAvg(Long backendCostAvg) {
        this.backendCostAvg = backendCostAvg;
    }
}
