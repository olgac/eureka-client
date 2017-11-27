package com.olgac.eurekaclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services")
class ServiceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{name}")
    public List<ServiceInstance> getByName(@PathVariable String name) {
        return this.discoveryClient.getInstances(name);
    }
}