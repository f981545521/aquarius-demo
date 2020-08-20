package cn.acyou.aquarius.demo.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author youfang
 * @version [1.0.0, 2020/8/20]
 **/
@Service
public class TestService {
    /**
     * · @SentinelResource 注解用来标识资源是否被限流、降级。上述例子上该注解的属性 sayHello 表示资源名。
     *
     * @param name
     * @return
     */
    @SentinelResource(value = "sayHello")
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
