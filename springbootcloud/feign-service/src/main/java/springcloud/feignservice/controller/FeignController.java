package springcloud.feignservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.feignservice.feign.BalancedFeign;
import springcloud.feignservice.feign.ResourcesFeign;


@RestController
public class FeignController {
    @Autowired
    BalancedFeign balancedFeign;

    @Autowired
    ResourcesFeign resourcesFeign;

    @RequestMapping("/test")
    public String makeFeign() {
        return balancedFeign.sayFromClientOne();
    }

    @RequestMapping("/resources/user")
    public String resourcesFeign() {
        return resourcesFeign.UserOneError();
    }
}
