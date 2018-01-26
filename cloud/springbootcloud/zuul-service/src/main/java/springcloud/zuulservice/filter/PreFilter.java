package springcloud.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PreFilter extends ZuulFilter{

    private Logger logger = LoggerFactory.getLogger(PreFilter.class);
    public PreFilter() {
        super();
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        logger.info("pre--模拟身份认证");
        // TODO: 2017/12/24  身份不通过，跟oauth,jwt
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.put("start",System.currentTimeMillis());
        return null;
    }
}
