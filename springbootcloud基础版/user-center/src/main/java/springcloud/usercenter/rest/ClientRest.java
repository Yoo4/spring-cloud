package springcloud.usercenter.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRest {
    @Value("${itOcean:James}")
    private String language;

    @RequestMapping("/test")
    public String test() throws InterruptedException {
//        Thread.sleep(7000);
        return "test1 "+language;
    }
}
