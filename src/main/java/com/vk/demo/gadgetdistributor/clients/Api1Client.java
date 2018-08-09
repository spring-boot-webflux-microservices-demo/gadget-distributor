package com.vk.demo.gadgetdistributor.clients;

import com.vk.demo.gadgetdistributor.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("api1")
public interface Api1Client {

    @RequestMapping(value = "/api1/findUser/{id}", method = RequestMethod.GET, consumes = "application/json")
    User findUser(@PathVariable("id") String id);
}
