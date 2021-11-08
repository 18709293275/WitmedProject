package com.whackon.witmed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>系统功能 - Provider 启动类</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@MapperScan("com.whackon.witmed.*.dao")
@EnableEurekaClient
@SpringBootApplication
public class SystemProviderStarter {
    public static void main(String[] args) {
        SpringApplication.run(SystemProviderStarter.class, args);
    }
}
