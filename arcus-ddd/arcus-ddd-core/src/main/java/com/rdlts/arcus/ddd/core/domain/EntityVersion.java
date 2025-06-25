package com.rdlts.arcus.ddd.core.domain;

import javax.annotation.Nonnull;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * 实体版本 - Entity Version
 * <img src="https://github.com/Redlotus794/Arucs/blob/main/docs/pic/entityversion.jpg?raw=true" alt="Entity Version Diagram" width="600" height="400"/>
 * <p>
 * 该 record 表示实体的版本号，不可变且线程安全。
 * </p>
 * @author wangjialong
 * @since 2025-06-25
 */
@SuppressWarnings("unused")
public record EntityVersion(long version) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 零版本号
     */
    public static final EntityVersion ZERO_VERSION = new EntityVersion(0L);

    /**
     * 获取零版本号
     *
     * @see EntityVersion#ZERO_VERSION
     * @return EntityVersion 零版本号
     */
    public static EntityVersion zeroVersion() {
        return ZERO_VERSION;
    }

    /**
     * 下一个版本号
     * @return 新的 EntityVersion
     */
    public EntityVersion next() {
        return new EntityVersion(this.version + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityVersion that = (EntityVersion) o;
        return version == that.version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(version);
    }

    @Override
    @Nonnull
    public String toString() {
        return "EntityVersion{" +
                "version=" + version +
                '}';
    }
}
