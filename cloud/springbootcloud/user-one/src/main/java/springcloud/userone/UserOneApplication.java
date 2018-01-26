package springcloud.userone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class UserOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserOneApplication.class, args);
	}
    // TODO: 2017/12/28
    /**
     * 服务通过feign调服务的时候，由于服务A将认证信息传给Feign时，
     * feign是另起一个线程更，而不是使用当前含认证信息的线程传递给服务B，
     * 因此需要加一个配置，此处为controller中的HystrixCredentialsContext
     */
}
