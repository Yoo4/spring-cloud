package springcloud.feignservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.feignservice.feign.BalancedFeign;


@RestController
public class FeignController {
    @Autowired
    BalancedFeign balancedFeign;

    @RequestMapping("/test")
    public String makeFeign() {
        return balancedFeign.sayFromClientOne();
    }
}
