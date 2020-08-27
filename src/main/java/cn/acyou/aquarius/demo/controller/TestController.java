package cn.acyou.aquarius.demo.controller;

import cn.acyou.aquarius.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author youfang
 * @version [1.0.0, 2020/8/20]
 **/
@RestController
public class TestController {
    @Autowired
    private TestService service;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @LoadBalanced
    private RestTemplate loadBalanced;

    @GetMapping(value = "/testRestTemplate")
    public String testRestTemplate(){
        /**
         * URI需要使用虚拟主机名（即服务名，而不是主机名）。
         *
         */
        String results = restTemplate.getForObject("http://localhost:8054/rest/test1", String.class);
        System.out.println(results);
        Map<String, Object> params = new HashMap<>();
        params.put("name", "waitme");
        ResponseEntity<Result<String>> responseEntity = restTemplate
                .exchange("http://localhost:8054/rest/test3", HttpMethod.POST,
                        new HttpEntity<>(params),
                        new ParameterizedTypeReference<Result<String>>() {
                        });
        System.out.println(responseEntity);


        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(params);
        ResponseEntity<String> testPost1R = restTemplate.postForEntity("http://localhost:8054/rest/testPost1", httpEntity, String.class);
        System.out.println(testPost1R);




        return "ok";
    }

    @GetMapping(value = "/hello/{name}")
    public String apiHello(@PathVariable String name) {
        return service.sayHello(name);
    }
}
