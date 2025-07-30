package com.rdlts.arcus.identity;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ArcusIdentityApplication
 *
 * @author wangjialong
 * @since 2025/7/23 15:32
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
public class ArcusIdentityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArcusIdentityApplication.class, args);
    }
}
