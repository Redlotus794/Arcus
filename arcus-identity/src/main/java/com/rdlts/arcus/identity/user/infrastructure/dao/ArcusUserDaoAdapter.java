package com.rdlts.arcus.identity.user.infrastructure.dao;

import com.rdlts.arcus.identity.user.domian.entity.ArcusUser;

/**
 * ArcusUserDao 适配器
 *
 * @see com.rdlts.arcus.ddd.core.domain.Adapter
 */
public class ArcusUserDaoAdapter {

    public static ArcusUserDao adapt(ArcusUser arcusUser) {
        if (arcusUser == null) {
            return null;
        }

        return ArcusUserDao.builder()
                .userId(arcusUser.getUserId().id())
                .username(arcusUser.getProfile().name())
                .encryptedPassword(arcusUser.getEncryptedPassword().encryptedPassword())
                .email(arcusUser.getEmail() == null ? null : arcusUser.getEmail().emailAddress())
                .iteration(arcusUser.getEncryptedPassword().pbkdf2Param().iterations())
                .keyLength(arcusUser.getEncryptedPassword().pbkdf2Param().keyLength())
                .salt(arcusUser.getEncryptedPassword().pbkdf2Param().salt())
                .entityVersion(arcusUser.getEntityVersion().version())
                .avatar(arcusUser.getProfile().avatar())
                .build();
    }
}
