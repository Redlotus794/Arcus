package com.rdlts.arcus.identity.user.infrastructure.adapter;

import com.rdlts.arcus.ddd.core.domain.EntityVersion;
import com.rdlts.arcus.identity.user.domian.entity.ArcusUser;
import com.rdlts.arcus.identity.user.domian.valueobject.*;
import com.rdlts.arcus.identity.user.infrastructure.ejo.ArcusUserEJO;
import com.rdlts.arcus.identity.user.infrastructure.po.ArcusUserPO;

import javax.annotation.Nonnull;

public class ArcusUserAdapter {

    @Nonnull
    public static ArcusUser adapt(@Nonnull ArcusUserPO arcusUserPO) {
        return ArcusUser.builder()
                .userId(new ArcusUserId(arcusUserPO.getUserId()))
                .profile(new ArcusProfile(arcusUserPO.getUsername(), arcusUserPO.getAvatar()))
                .encryptedPassword(new ArcusUserEncryptedPassword(
                        arcusUserPO.getEncryptedPassword(),
                        new Pbkdf2Param(
                            arcusUserPO.getSalt(),
                            arcusUserPO.getIteration(),
                            arcusUserPO.getKeyLength())))
                .email(arcusUserPO.getEmail() == null ? null : new ArcusUserEmail(arcusUserPO.getEmail()))
                .entityVersion(new EntityVersion(arcusUserPO.getEntityVersion()))
                .build();
    }
}
