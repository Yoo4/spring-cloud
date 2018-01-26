package springcloud.feignservice.feign;

public class ResourcesHystric implements ResourcesFeign {
    @Override
    public String UserOneError() {
        return "UserOne服务停止";
    }
}
