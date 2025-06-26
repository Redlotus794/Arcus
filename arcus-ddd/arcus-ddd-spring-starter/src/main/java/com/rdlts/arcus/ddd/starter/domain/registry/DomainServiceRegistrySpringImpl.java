package com.rdlts.arcus.ddd.starter.domain.registry;

import com.rdlts.arcus.ddd.core.domain.DomainService;
import com.rdlts.arcus.ddd.core.domain.DomainServiceRegistry;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@SuppressWarnings("all")
public class DomainServiceRegistrySpringImpl implements DomainServiceRegistry, ApplicationContextAware {

    private static DomainServiceRegistrySpringImpl INSTANCE;

    private ApplicationContext applicationContext;

    public static DomainServiceRegistry getInstance() {
        return INSTANCE;
    }

    @Override
    public <T extends DomainService> T findService(Class<T> clazz) {
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("加载领域服务注册表...");
        this.applicationContext = applicationContext;
        INSTANCE = this;
    }
}
