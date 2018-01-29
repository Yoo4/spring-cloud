package com.springcloud.test;

import com.springcloud.zuul.ZuulServiceBootstrap;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: James Wang
 * @Data: 2018/1/3 14:58
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ZuulServiceBootstrap.class)
@WebMvcTest
public class BaseUnitTest {
}
