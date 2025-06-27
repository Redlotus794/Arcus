package com.rdlts.arcus.ddd.starter.domain.registry;

import com.rdlts.arcus.ddd.core.domain.DomainService;
import com.rdlts.arcus.ddd.core.domain.DomainServiceRegistry;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 领域服务注册表的 Spring 实现。
 * <p>
 * 通过容器初始化，发现并注册所有{@link DomainService}
 * 当需要在非spring的实例中调用时，可以通过{@link DomainServiceRegistry#instance()} 获取实例。
 * </p>
 *
 * e.g.
 * <pre>{@code
 *  DomainServiceRegistry.instance()
 *  .findService(TestDomainService.class)
 *  .testMethod();
 * }
 * </pre>
 *
 * @author wangjialong
 * @since 2025-06-27
 * @see DomainService
 * @see DomainServiceRegistry
 */
@Service
@Log4j2
public class DomainServiceRegistrySpringImpl implements DomainServiceRegistry, ApplicationContextAware {

    private static DomainServiceRegistrySpringImpl INSTANCE;

    private final ConcurrentHashMap<Class<? extends DomainService>, DomainService> serviceMap = new ConcurrentHashMap<>();

    public DomainServiceRegistry getInstance() {
        if (INSTANCE == null) {
            throw new IllegalStateException("DomainServiceRegistrySpringImpl 未初始化，请确保已正确配置 Spring 上下文。");
        }
        return INSTANCE;
    }

    @Override
    public <T extends DomainService> T findService(Class<T> clazz) {
        DomainService service = serviceMap.get(clazz);
        if (service == null) {
            throw new IllegalArgumentException("未找到领域服务: " + clazz.getName());
        }
        return clazz.cast(service);
    }

    @Override
    public void setApplicationContext(@Nonnull ApplicationContext applicationContext) throws BeansException {
        log.info("加载领域服务注册表...");
        applicationContext.getBeansOfType(DomainService.class)
                .forEach((name, service) -> {
                    serviceMap.put(service.getClass(), service);
                    log.info("注册领域服务e: {}", service.getClass().getName());
                });
        INSTANCE = this;
    }
}
