package com.rdlts.arcus.identity.user.domain;

import com.rdlts.arcus.identity.base.ArcusIdentityBaseTest;
import com.rdlts.arcus.identity.user.domian.entity.ArcusUser;
import com.rdlts.arcus.identity.user.domian.repository.ArcusUserRepository;
import com.rdlts.arcus.identity.user.domian.valueobject.*;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArcusUserRepositoryTest extends ArcusIdentityBaseTest {

    @Resource
    ArcusUserRepository arcusUserRepository;

    @Test
    void testSaveAndFindUser() {
        ArcusUserId userId = arcusUserRepository.nextIdentity();
        ArcusUser user = ArcusUser.builder()
                .userId(userId)
                .profile(ArcusProfile.builder()
                        .username(RandomStringUtils.secure().nextAlphabetic(6))
                        .avatar("http://example.com/avatar.png")
                        .build())
                .encryptedPassword(new ArcusUserEncryptedPassword(
                        "encrypted",
                         new Pbkdf2Param("salt", 1000, 256)))
                .email(new ArcusUserEmail(RandomStringUtils.secure().nextAlphabetic(7) + "@example.com"))
                .build();
        arcusUserRepository.save(user);
        Optional<ArcusUser> found = arcusUserRepository.find(userId);
        assertTrue(found.isPresent());
        assertEquals(userId, found.get().getUserId());
    }
}
