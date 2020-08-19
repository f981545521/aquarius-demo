package cn.acyou.aquarius.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AquariusDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AquariusDemoApplication.class, args);
    }

}
