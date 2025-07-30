package com.rdlts.arcus;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ArcusAcroDesignVueApplication
 *
 * @author wangjialong
 * @since 2025/7/24 08:38
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
public class ArcusAcroDesignVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArcusAcroDesignVueApplication.class, args);
    }
}
