package com.servicefeign.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eureka-client-1",fallback = SchedualServiceHiHystric.class)
public interface BalancedFeign {
    @RequestMapping(value = "/wang",method = RequestMethod.GET)
    String sayFromClientOne();
}
