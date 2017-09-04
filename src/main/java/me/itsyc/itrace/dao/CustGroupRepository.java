package me.itsyc.itrace.dao;

import me.itsyc.itrace.entity.CustGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustGroupRepository extends JpaRepository<CustGroup, Long> {

    CustGroup findByCustGroupName(String custGroupName);

    @Query("from CustGroup c where cust_group_name=:name")
    CustGroup findUser(@Param("name") String name);
}
