package com.rdlts.arcus.identity.user.domian.domainservice;

import com.rdlts.arcus.ddd.core.domain.DomainService;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusPassword;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserEncryptedPassword;
import com.rdlts.arcus.identity.user.domian.valueobject.Pbkdf2Param;
import io.micrometer.common.util.StringUtils;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * PasswordEncryptDomainService 密码加密领域服务
 */
@Service
public class PasswordEncryptionDomainService implements DomainService {

    /**
     * 使用 PBKDF2 算法加密密码
     *
     * @param password    用户输入的密码
     * @param pbkdf2Param 包含密码、盐值、迭代次数和密钥长度的参数对象
     * @return ArcusUserEncryptedPassword 加密后的密码
     * @throws RuntimeException 加密失败时抛出
     */
    @Nonnull
    public ArcusUserEncryptedPassword pbkdf2WithHmacSHA256(@Nonnull ArcusPassword password, @Nonnull Pbkdf2Param pbkdf2Param) {
        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder(
                "",
                pbkdf2Param.salt().length(),
                pbkdf2Param.iterations(),
                Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256
        );

        return new ArcusUserEncryptedPassword(
                pbkdf2PasswordEncoder.encode(password.val()),
                pbkdf2Param
        );
    }
}
