package me.itsyc.itrace.controller;

import me.itsyc.itrace.dao.CustRepository;
import me.itsyc.itrace.entity.Cust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@EnableAutoConfiguration
public class CustController {

    @Autowired
    private CustRepository custRepository;


    @RequestMapping("/cust/save")
    String save(@RequestParam("name") String name) {
        Cust cust = new Cust();
        cust.setCustId(1001L);
        cust.setCustGroupId(10010L);
        cust.setCustNumber("233");
        cust.setCustName(name);
        cust.setCreateDate(new Date());
        cust.setUpdateDate(new Date());
        cust.setAreaId(200);

        custRepository.save(cust);

        return "Successful!";
    }


    @RequestMapping("/cust/get")
    String get(@RequestParam("name") String name) {
        Cust cust = custRepository.findByCustName(name);

        return cust.getCustId().toString();
    }
}
