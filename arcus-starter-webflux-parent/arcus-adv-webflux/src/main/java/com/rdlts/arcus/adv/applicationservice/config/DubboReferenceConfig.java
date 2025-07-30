package com.rdlts.arcus.adv.applicationservice.config;

import com.rdlts.arcus.identity.user.applicationservice.dubbo.ArcusUserDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DubboReferenceConfig
 * 延迟加载service机制
 *
 * @author wangjialong
 * @since 2025/7/30 10:04
 */
@Configuration
public class DubboReferenceConfig {

    @Bean
    @DubboReference
    public ReferenceBean<ArcusUserDubboService> arcusUserDubboService() {
        return new ReferenceBean();
    }


}
