package springboot.servicecenter.listener;

import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 用于监听eureka服务停机通知
 * Created by zhang on 2017/12/22
 */
@Configuration
@EnableScheduling
public class EurekaInstanceCanceledListener implements ApplicationListener{
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        //服务挂掉事件
        if(applicationEvent instanceof EurekaInstanceCanceledEvent) {

            EurekaInstanceCanceledEvent event = (EurekaInstanceCanceledEvent) applicationEvent;
            //获取当前Eureka实例中的节点信息(遍历方式)
            PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
            //获取注册的应用
            Applications applications = registry.getApplications();
            //遍历获取已注册节点中与当前失效节点ID一致的节点信息
            applications.getRegisteredApplications().forEach((registeredApplication) -> {
                registeredApplication.getInstances().forEach((instance) -> {
                    if(instance.getInstanceId().equals(event.getServerId())) {
                        System.out.println("服务："+instance.getAppName()+"挂啦！！！");
                        // todo: 2047.12.22 扩展消息提醒 邮件手机短信等
                    }
                });

            });
            System.out.println("123");
        }

        if(applicationEvent instanceof EurekaInstanceRegisteredEvent) {
            EurekaInstanceRegisteredEvent event = (EurekaInstanceRegisteredEvent) applicationEvent;
            System.out.println("服务："+event.getInstanceInfo().getAppName()+"注册成功");
        }

        if(applicationEvent instanceof EurekaInstanceRenewedEvent) {
            EurekaInstanceRenewedEvent event = (EurekaInstanceRenewedEvent) applicationEvent;
            System.out.println("服务："+event.getInstanceInfo().getAppName()+"注册成功");
        }

        if(applicationEvent instanceof EurekaRegistryAvailableEvent){
            EurekaRegistryAvailableEvent event = (EurekaRegistryAvailableEvent) applicationEvent;
            System.out.println("服务available");
        }
    }
}
