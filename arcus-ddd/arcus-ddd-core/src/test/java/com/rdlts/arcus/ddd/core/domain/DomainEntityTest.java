package com.rdlts.arcus.ddd.core.domain;

import com.rdlts.arcus.ddd.core.test.domain.Bracer;
import com.rdlts.arcus.ddd.core.test.domain.BracerID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * DomainEntityTest
 *
 * @author wangjialong
 * @since 2025/8/4 09:15
 */
public class DomainEntityTest {

    @Test
    public void testReturnIdentityType() {
        System.out.println("DomainEntityTest.testReturnIdentityType");
        // 测试 DomainEntity 的基本功能
        // 这里可以添加具体的测试逻辑，例如创建实体、验证状态等
        Bracer estelle = Bracer.builder()
                .id(BracerID.of("bracer-001"))
                .name("Estelle")
                .build();

        Assertions.assertEquals(estelle.identity(), BracerID.of("bracer-001"));
        Assertions.assertEquals("Estelle", estelle.getName());
        Assertions.assertEquals(EntityVersion.ZERO_VERSION, estelle.getEntityVersion());
    }

}
