package com.rdlts.arcus.ddd.core.test.domain;

import javax.annotation.Nonnull;

/**
 * BracerID
 *
 * @author wangjialong
 * @since 2025/8/4 09:36
 */
public record BracerID(String id) {

    public static BracerID of(String id) {
        return new BracerID(id);
    }

    @Nonnull
    @Override
    public String toString() {
        return "BracerID{" +
                "id='" + id + '\'' +
                '}';
    }
}
