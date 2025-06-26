package com.rdlts.arcus.ddd.starter.domain.registry;

import com.rdlts.arcus.ddd.core.domain.DomainServiceRegistry;
import com.rdlts.arcus.ddd.starter.domain.base.ArcusDDDSpringStarterBaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link DomainServiceRegistrySpringImpl}
 */
public class DomainServiceRegistrySpringImplTest extends ArcusDDDSpringStarterBaseTest {

    @Test
    public void testInstance() {
        final DomainServiceRegistry instance = DomainServiceRegistry.instance();
        Assertions.assertThat(instance).isNotNull();
    }
}
