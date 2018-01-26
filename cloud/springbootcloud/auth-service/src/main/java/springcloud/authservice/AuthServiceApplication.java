package springcloud.authservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springcloud.authservice.entity.Account;
import springcloud.authservice.repository.AccountRepository;

@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
@EnableAutoConfiguration
@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    public void init(){
        try {
            Account account=new Account();
            account.setName("asd");
            account.setPassword("123");
            account.setRoles(new String []{"ROLE_USER"});
            accountRepository.deleteAll();
            accountRepository.save(account);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
