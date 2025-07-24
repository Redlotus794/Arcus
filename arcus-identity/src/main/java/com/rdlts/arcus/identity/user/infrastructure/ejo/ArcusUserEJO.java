package com.rdlts.arcus.identity.user.infrastructure.ejo;

import com.rdlts.arcus.ddd.core.domain.EntityJsonObject;
import com.rdlts.arcus.identity.user.domian.entity.ArcusUser;
import com.rdlts.arcus.identity.user.domian.valueobject.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Optional;

/**
 * ArcusUserEJO
 *
 * @author wangjialong
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Schema(description = "Arcus User Entity JSON Object")
public final class ArcusUserEJO extends EntityJsonObject<ArcusUser> {

    @Schema(description = "User ID", example = "user123")
    String userId;

    @Schema(description = "Profile Name", example = "John Doe")
    String profileName;

    @Schema(description = "Profile Avatar URL", example = "https://example.com/avatar.jpg")
    String profileAvatar;

    @Schema(description = "Encrypted Password", example = "encryptedPassword123")
    String encryptedPassword;

    @Schema(description = "Salt for Password Encryption", example = "randomSaltValue")
    String salt;

    @Schema(description = "Iterations for PBKDF2", example = "10000")
    int iterations;

    @Schema(description = "Key Length for PBKDF2", example = "256")
    int keyLength;

    @Schema(description = "Email Address", example = "abc@def.com")
    String email;

    public ArcusUserEJO(ArcusUser entity) {
        super(entity);
    }

    @Override
    public ArcusUser toEntity() {
        return ArcusUser.builder()
                .userId(new ArcusUserId(userId))
                .email(new ArcusUserEmail(email))
                .profile(new ArcusProfile(profileName, profileAvatar))
                .encryptedPassword(new ArcusUserEncryptedPassword(encryptedPassword,
                        new Pbkdf2Param(salt, iterations, keyLength)))
                .build()
                ;
    }

    @Override
    public void populate(ArcusUser entity) {
        this.userId = entity.getUserId().id();
        this.email = Optional.ofNullable(entity.getEmail()).map(ArcusUserEmail::emailAddress).orElse(null);
        this.profileName = entity.getProfile().username();
        this.profileAvatar = entity.getProfile().avatar();
        this.encryptedPassword = entity.getEncryptedPassword().encryptedPassword();
        this.salt = entity.getEncryptedPassword().pbkdf2Param().salt();
        this.iterations = entity.getEncryptedPassword().pbkdf2Param().iterations();
        this.keyLength = entity.getEncryptedPassword().pbkdf2Param().keyLength();
    }
}
