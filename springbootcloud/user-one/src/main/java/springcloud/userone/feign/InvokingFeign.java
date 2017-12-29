package springcloud.userone.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "user-two")
public interface InvokingFeign {
    @RequestMapping(value = "/resources/user",method = RequestMethod.GET)
    String InvokingTwo();
}


