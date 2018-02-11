package springcloud.feignservice.feign;

public class SchedualServiceHystric implements BalancedFeign{
    @Override
    public String sayFromClientOne() {
        return "服务终止";
    }
}
