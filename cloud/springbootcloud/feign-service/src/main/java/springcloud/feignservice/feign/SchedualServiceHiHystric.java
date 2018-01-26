package springcloud.feignservice.feign;

public class SchedualServiceHiHystric implements BalancedFeign{
    @Override
    public String sayFromClientOne() {
        return "服务终止";
    }
}
