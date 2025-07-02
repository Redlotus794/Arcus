package com.rdlts.arcus.identity.user.infrastructure.ejo;

import com.rdlts.arcus.identity.user.domian.entity.ArcusUser;
import lombok.*;

/**
 * Entity Java Object (EJO) for {@link ArcusUser}
 *
 * @see ArcusUser
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ArcusUserEJO {

    String userId;

    String profileName;

    String profileAvatar;

    String encryptedPassword;

    String salt;

    int iterations;

    int keyLength;

    String email;

    long entityVersion;
}
