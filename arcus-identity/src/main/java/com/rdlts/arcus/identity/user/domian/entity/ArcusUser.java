package com.rdlts.arcus.identity.user.domian.entity;

import com.rdlts.arcus.ddd.core.domain.DomainEntity;
import com.rdlts.arcus.ddd.core.domain.EntityVersion;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusProfile;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserEmail;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserEncryptedPassword;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserId;
import lombok.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * <a href="https://wcnn2j4xsnan.feishu.cn/wiki/SRf8wsawqi2cIYkAJgDcY9vSnbh">
 *     Arcus 用户
 *     </a>
 *
 * @author wangjialong
 * @since 2025-06-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ArcusUser implements DomainEntity<ArcusUserId> {

    @Nonnull
    ArcusUserId userId;

    @Nonnull
    ArcusProfile profile;

    @Nonnull
    ArcusUserEncryptedPassword encryptedPassword;

    @Nullable
    ArcusUserEmail email;

    @Nonnull
    @Builder.Default
    EntityVersion entityVersion = EntityVersion.ZERO_VERSION;

    @Nonnull
    @Override
    public ArcusUserId identity() {
        return this.userId;
    }

    @Nonnull
    @Override
    public EntityVersion version() {
        return this.entityVersion;
    }
}
