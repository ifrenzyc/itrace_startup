package me.itsyc.itrace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class CustGroup {

    @Id
    @Column(nullable = false)
    private Long custGroupId;

    @Column(nullable = false, length = 30)
    private String custGroupCode;  // 客户群编码

    @Column(nullable = false, length = 32)
    private String custGroupName;  // 客户群名称

    @Column
    private Date createDate;  // 创建时间

    @Column
    private Date updateDate;  // 创建时间

    @Column
    private Integer areaId;  // 区域标识
}
