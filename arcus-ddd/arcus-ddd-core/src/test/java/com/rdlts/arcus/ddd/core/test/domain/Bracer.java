package com.rdlts.arcus.ddd.core.test.domain;

import com.rdlts.arcus.ddd.core.domain.DomainEntity;
import com.rdlts.arcus.ddd.core.domain.EntityVersion;
import lombok.*;

import javax.annotation.Nonnull;

/**
 * Bracer - 游击士
 *
 * @author wangjialong
 * @since 2025/8/4 09:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Bracer implements DomainEntity<BracerID> {

    @Nonnull
    BracerID id;

    @Nonnull
    String name;

    @Nonnull
    @Builder.Default
    EntityVersion entityVersion = EntityVersion.ZERO_VERSION;

    @Nonnull
    @Override
    public BracerID identity() {
        return id;
    }

    @Nonnull
    @Override
    public EntityVersion version() {
        return entityVersion;
    }
}
