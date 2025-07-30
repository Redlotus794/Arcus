package com.rdlts.arcus.identity.user.applicationservice.impl;

import com.rdlts.arcus.identity.user.applicationservice.ArcusUserApplicationService;
import com.rdlts.arcus.identity.user.applicationservice.command.CreateArcusUserCommand;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserId;
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

    @Transactional(rollbackFor = Exception.class)
    @Nonnull
    public ArcusUserId createUser(CreateArcusUserCommand createArcusUserCommand) {
//        ArcusUser arcusUser = ArcusUser.builder()
//                .userId(ArcusUserId.gen())
//                .encryptedPassword(createUserCommand.encryptedPassword())
//                .email(createUserCommand.email())
//                .entityVersion(EntityVersion.gen())
//                .build();
        throw new NotImplementedException("createUser not implemented yet!");
    }
}
