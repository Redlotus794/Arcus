package com.rdlts.arcus.identity.user.domian.valueobject;

/**
 * Pbkdf2Param
 * <p>
 * Represents parameters for PBKDF2 password hashing.
 * </p>
 *
 * @author wangjialong
 * @since 2025-06-26
 */
public record Pbkdf2Param(String salt,
                          int iterations,
                          int keyLength) {

    public static final Pbkdf2Param DEFAULT = new Pbkdf2Param("defaultSalt", 100, 256);

    public Pbkdf2Param {
        if (salt == null || salt.isBlank()) {
            throw new IllegalArgumentException("Salt cannot be null or blank");
        }
        if (iterations <= 0) {
            throw new IllegalArgumentException("Iterations must be a positive integer");
        }
        if (keyLength <= 0) {
            throw new IllegalArgumentException("Key length must be a positive integer");
        }
    }
}
