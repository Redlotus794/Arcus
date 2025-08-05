package com.rdlts.arcus.identity.user.applicationservice.impl;

import com.rdlts.arcus.identity.user.applicationservice.ArcusUserApplicationService;
import com.rdlts.arcus.identity.user.applicationservice.command.CreateArcusUserCommand;
import com.rdlts.arcus.identity.user.domian.domainservice.PasswordEncryptionDomainService;
import com.rdlts.arcus.identity.user.domian.entity.ArcusUser;
import com.rdlts.arcus.identity.user.domian.repository.ArcusUserRepository;
import com.rdlts.arcus.identity.user.domian.valueobject.*;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;

/**
 * ArcusUserApplicationServiceImpl
 *
 * @author wangjialong
 * @since 2025/7/29 09:00
 */
@Service
public class ArcusUserApplicationServiceImpl implements ArcusUserApplicationService {

    @Resource
    ArcusUserRepository arcusUserRepository;

    @Resource
    PasswordEncryptionDomainService passwordEncryptionDomainService;

    @Transactional(rollbackFor = Exception.class)
    @Nonnull
    public ArcusUserId createUser(CreateArcusUserCommand createArcusUserCommand) {
        final ArcusUserEncryptedPassword arcusUserEncryptedPassword = passwordEncryptionDomainService.pbkdf2WithHmacSHA256(
                createArcusUserCommand.newPassword(),
                Pbkdf2Param.DEFAULT);

        ArcusUser arcusUser = ArcusUser.builder()
                .userId(arcusUserRepository.nextIdentity())
                .email(createArcusUserCommand.arcusUserEmail())
                .encryptedPassword(arcusUserEncryptedPassword)
                .profile(createArcusUserCommand.profile())
                .build();

        arcusUserRepository.save(arcusUser);
        return arcusUser.getUserId();
    }
}
