package com.vk.demo.gadgetdistributor.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("api1")
public interface Api1Client {

    @RequestMapping(value = "/api1/findAll", method = RequestMethod.GET, consumes = "application/json")
    Object findAll();
}
