package springcloud.feignservice.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "user-one",fallback = ResourcesHystric.class)   //
public interface ResourcesFeign {
    @RequestMapping(value = "/resources/user",method = RequestMethod.GET)
    String UserOneError();
}
