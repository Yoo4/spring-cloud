package springcloud.feignservice.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "user-center",fallback = SchedualServiceHiHystric.class)
public interface BalancedFeign {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String sayFromClientOne();
}
