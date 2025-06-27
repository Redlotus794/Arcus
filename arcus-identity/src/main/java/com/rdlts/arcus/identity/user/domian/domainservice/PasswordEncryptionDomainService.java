package com.rdlts.arcus.identity.user.domian.domainservice;

import com.rdlts.arcus.ddd.core.domain.DomainService;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusPassword;
import com.rdlts.arcus.identity.user.domian.valueobject.Pbkdf2Param;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * PasswordEncryptDomainService 密码加密领域服务
 */
@Service
public class PasswordEncryptionDomainService implements DomainService {

    /**
     * base64算法生成盐值
     *
     * @param key 为空，则随机生成一个key
     * @return 随机盐值
     */
    @Nonnull
    public static String generateSalt(String key) {
        if (StringUtils.isEmpty(key)) {
            byte[] salt = new byte[16];
            new SecureRandom().nextBytes(salt);
            return Base64.getEncoder().encodeToString(salt);
        }

        return Base64.getEncoder().encodeToString(key.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 使用 PBKDF2 算法加密密码
     *
     * @param password 用户输入的密码
     * @param pbkdf2Param 包含密码、盐值、迭代次数和密钥长度的参数对象
     * @return 加密后的密码
     * @throws RuntimeException 加密失败时抛出
     */
    @Nonnull
    public static String pbkdf2WithHmacSHA256(@Nonnull ArcusPassword password,
                                              @Nonnull Pbkdf2Param pbkdf2Param) {
        int iterations = pbkdf2Param.iterations();
        int keyLength = pbkdf2Param.keyLength();
        byte[] saltBytes = Base64.getDecoder().decode(pbkdf2Param.salt());
        char[] passwordChars = password.val().toCharArray();
        PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, iterations, keyLength);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("密码加密失败", e);
        } finally {
            spec.clearPassword();
        }
    }
}
