package com.servicefeign.controller;

import com.servicefeign.feign.BalancedFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    BalancedFeign balancedFeign;

    @RequestMapping("/wang")
    public String makeFeign() {
        return balancedFeign.sayFromClientOne();
    }
}
