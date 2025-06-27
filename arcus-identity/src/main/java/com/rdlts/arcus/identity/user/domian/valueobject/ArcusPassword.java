package com.rdlts.arcus.identity.user.domian.valueobject;

import io.micrometer.common.util.StringUtils;

import javax.annotation.Nonnull;

/**
 * ArcusPassword
 * <a href="https://wcnn2j4xsnan.feishu.cn/wiki/XfHmwn8daiR30FkyPfXcQPyfnkb">
 *     Arcus 密码
 *     </a>
 * @param val 密码明文
 */
public record ArcusPassword(@Nonnull String val) {

    public ArcusPassword {
        if (StringUtils.isEmpty(val)) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        if (val.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }


    }
}
