package cn.acyou.aquarius.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youfang
 * @version [1.0.0, 2020-8-19 下午 08:09]
 **/
@RestController
@RefreshScope
public class EchoController {
    @Value("${user.name}")
    private String name;
    @Value("${env}")
    private String env;
    @Value("${common.name}")
    private String commonName;

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        System.out.println(name);
        System.out.println(env);
        System.out.println(commonName);
        return "Hello Nacos Discovery " + string;
    }
}
