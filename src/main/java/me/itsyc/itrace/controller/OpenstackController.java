package me.itsyc.itrace.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class OpenstackController {

    @RequestMapping("/")
    String helloWorld() {
        return "Hello World!";
    }


    @RequestMapping("/itsyc")
    String main() {
        return "2333";
    }
}
