package me.itsyc.itrace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Cust {

    @Id
    @Column(unique = true, nullable = false)
    private Long custId;  // 客户标识

    @Column
    private Long custGroupId;  // 客户群标识

    @Column
    private String custNumber;  // 客户编码

    @Column
    private String custName;  // 客户名称

    @Column
    private Date createDate;  // 创建时间

    @Column
    private Date updateDate;  // 创建时间

    @Column
    private int areaId;  // 区域标识

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Long getCustGroupId() {
        return custGroupId;
    }

    public void setCustGroupId(Long custGroupId) {
        this.custGroupId = custGroupId;
    }

    public String getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(String custNumber) {
        this.custNumber = custNumber;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
}
