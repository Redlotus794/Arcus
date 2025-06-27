package com.rdlts.arcus.identity.user.domian.valueobject;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * ArcusUserEncryptedPassword
 * <a href="https://wcnn2j4xsnan.feishu.cn/wiki/IJtYwO1dXi6AQgka19DcOpfInkh">
 * Arcus 用户加密密码
 * </a>
 *
 * @param encryptedPassword 密码密文
 * @author wangjialong
 * @since 2025-06-26
 */
public record ArcusUserEncryptedPassword(String encryptedPassword,
                                         Pbkdf2Param pbkdf2Param) {

    public ArcusUserEncryptedPassword generate(ArcusPassword plainPassword) {
//        DomainServiceRegistry.instance()
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ArcusUserEncryptedPassword that = (ArcusUserEncryptedPassword) o;

        return new EqualsBuilder()
                .append(pbkdf2Param, that.pbkdf2Param)
                .append(encryptedPassword, that.encryptedPassword)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(encryptedPassword)
                .append(pbkdf2Param)
                .toHashCode();
    }
}
