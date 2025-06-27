package com.rdlts.arcus.identity.user.infrastructure.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "arcus_identity_user", schema="arcus_identity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ArcusUserDao extends IdBasedDao {

    @Column(name = "user_id", nullable = false, unique = true, length = 36)
    private String userId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "encrypted_password", nullable = false)
    private String encryptedPassword;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "iteration", nullable = false)
    private int iteration;

    @Column(name = "key_length", nullable = false)
    private int keyLength;

    @Column(name = "salt", nullable = false, length = 64)
    private String salt;

    @Column(name = "entity_version")
    private Long entityVersion;

    @Column(name = "avatar", length = 1024)
    private String avatar;
}
