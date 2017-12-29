package com.cefothe.microservices.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HealthAccountController {

    public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNT-SERVICES";

    @LoadBalanced
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("account/health")
    public String healthAccount(){
      return   restTemplate.getForObject(ACCOUNTS_SERVICE_URL+"/health", String.class);
    }
}
