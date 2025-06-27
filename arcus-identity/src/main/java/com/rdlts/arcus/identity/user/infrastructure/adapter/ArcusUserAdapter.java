package com.rdlts.arcus.identity.user.infrastructure.adapter;

import com.rdlts.arcus.ddd.core.domain.EntityVersion;
import com.rdlts.arcus.identity.user.domian.entity.ArcusUser;
import com.rdlts.arcus.identity.user.domian.valueobject.*;
import com.rdlts.arcus.identity.user.infrastructure.dao.ArcusUserDao;

import javax.annotation.Nonnull;

public class ArcusUserAdapter {

    @Nonnull
    public static ArcusUser adapt(@Nonnull ArcusUserDao arcusUserDao) {
        return ArcusUser.builder()
                .userId(new ArcusUserId(arcusUserDao.getUserId()))
                .profile(new ArcusProfile(arcusUserDao.getUsername(), arcusUserDao.getAvatar()))
                .encryptedPassword(new ArcusUserEncryptedPassword(
                        arcusUserDao.getEncryptedPassword(),
                        new Pbkdf2Param(
                            arcusUserDao.getSalt(),
                            arcusUserDao.getIteration(),
                            arcusUserDao.getKeyLength())))
                .email(arcusUserDao.getEmail() == null ? null : new ArcusUserEmail(arcusUserDao.getEmail()))
                .entityVersion(new EntityVersion(arcusUserDao.getEntityVersion()))
                .build();
    }
}
