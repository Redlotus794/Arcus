package com.rdlts.jdk_feature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JdkFeaturesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdkFeaturesApplication.class, args);
    }
}
