package com.rdlts.arcus.identity.user.domian.valueobject;

import io.micrometer.common.util.StringUtils;
import lombok.Builder;

import javax.annotation.Nonnull;

/**
 * Arcus Profile
 * <a href="https://wcnn2j4xsnan.feishu.cn/wiki/G9i9wHfpaiioXEkI1BHcvEDQnRg">
 *     Arcus 用户资料
 *     </a>
 * @param username 用户名称
 * @param avatar 头像
 */
@Builder
public record ArcusProfile(
        @Nonnull String username,
        String avatar) {

    public ArcusProfile(String username, String avatar) {
        if (StringUtils.isEmpty(username)) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        this.username = username;
        this.avatar = avatar;
    }
}
