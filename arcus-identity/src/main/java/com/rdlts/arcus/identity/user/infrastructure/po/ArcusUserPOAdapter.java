package com.rdlts.arcus.identity.user.infrastructure.po;

import com.rdlts.arcus.identity.user.domian.entity.ArcusUser;

/**
 * ArcusUserDao 适配器
 *
 * @see com.rdlts.arcus.ddd.core.domain.Adapter
 */
public class ArcusUserPOAdapter {

    public static ArcusUserPO adapt(ArcusUser arcusUser) {
        if (arcusUser == null) {
            return null;
        }

        return ArcusUserPO.builder()
                .userId(arcusUser.getUserId().id())
                .username(arcusUser.getProfile().username())
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
