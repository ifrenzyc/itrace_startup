package me.itsyc.itrace.dao;

import me.itsyc.itrace.entity.Cust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustRepository extends JpaRepository<Cust, Long> {


    Cust findByCustName(String custName);

    @Query("from Cust c where cust_name=:name")
    Cust findUser(@Param("name") String name);
}
