package me.itsyc.itrace.service.section01;

/**
 * Created by yangc on 04/07/2017.
 */
public class ServiceResult {

    public String uuid;
    public String serviceName;
    public Long backendCost;
    public Long frontendCost;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getBackendCost() {
        return backendCost;
    }

    public void setBackendCost(Long backendCost) {
        this.backendCost = backendCost;
    }

    public Long getFrontendCost() {
        return frontendCost;
    }

    public void setFrontendCost(Long frontendCost) {
        this.frontendCost = frontendCost;
    }
}
