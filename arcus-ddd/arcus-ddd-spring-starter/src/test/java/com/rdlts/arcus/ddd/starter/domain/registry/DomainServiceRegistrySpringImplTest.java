package com.rdlts.arcus.ddd.starter.domain.registry;

import com.rdlts.arcus.ddd.core.domain.DomainServiceRegistry;
import com.rdlts.arcus.ddd.starter.domain.base.ArcusDDDSpringStarterBaseTest;
import jakarta.annotation.Resource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link DomainServiceRegistrySpringImpl}
 */
public class DomainServiceRegistrySpringImplTest extends ArcusDDDSpringStarterBaseTest {

    @Resource
    DomainServiceRegistry domainServiceRegistry;

    @Test
    public void testDomainServiceRegistryInstance() {
        final DomainServiceRegistry instance = DomainServiceRegistry.instance();
        Assertions.assertThat(instance).isNotNull();
        // 保证实例和spring初始化的bean是一个实例。
        Assertions.assertThat(instance).isEqualTo(domainServiceRegistry);
    }
}
