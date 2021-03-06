package com.whackon.witmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>系统功能 - Consumer 启动类</b>
 * @author He'l'lo'World r
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SystemConsumerStarter {
    public static void main(String[] args) {
        SpringApplication.run(SystemConsumerStarter.class, args);
    }
}
