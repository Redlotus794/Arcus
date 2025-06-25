package com.rdlts.arcus.ddd.core.domain.discard;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * 实体版本 - Entity Version
 * <img src="https://github.com/Redlotus794/Arucs/blob/main/docs/pic/entityversion.jpg?raw=true" alt="Entity Version Diagram" width="600" height="400"/>
 * java 8 的版本
 * @author wangjialong
 * @since 2023/4/12
 */
@Deprecated
@SuppressWarnings("unused")
public final class EntityVersion implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final EntityVersion ZERO_VERSION = new EntityVersion(0L);

    private long version;

    public EntityVersion() {
        this(0L);
    }

    public EntityVersion(long version) {
        this.version = version;
    }

    public static EntityVersion zeroVersion() {
        return ZERO_VERSION;
    }

    /**
     * 下一个版本号
     * @return new EntityVersion
     */
    public EntityVersion next() {
        return new EntityVersion(this.version + 1);
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
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
        return Objects.hashCode(version);
    }

    @Override
    public String toString() {
        return "EntityVersion{" +
                "version=" + version +
                '}';
    }
}
