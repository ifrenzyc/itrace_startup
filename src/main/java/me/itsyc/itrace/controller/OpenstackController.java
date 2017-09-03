package me.itsyc.itrace.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class OpenstackController {

    @RequestMapping("/")
    String helloWorld() {
        return "Hello World!";
    }

    /**
     * URL: http://localhost:8080/itsyc/openstack?action=create
     *
     * @param action
     * @return
     */
    @RequestMapping("/itsyc/openstack")
    String openstack(@RequestParam("action") String action) {
        String status;
        switch (action) {
            case "create":
                status = "running";
                break;
            case "suspend":
                status = "suspended";
                break;
            case "pause":
                status = "paused";
                break;
            case "resume":
                status = "running";
                break;
            case "unpause":
                status = "running";
                break;
            case "stop":
                status = "stoped";
                break;
            default:
                status = "";
                break;
        }
        return status;
    }
}
