package com.rdlts.arcus.identity.user.domian.valueobject;

/**
 * <a href="https://wcnn2j4xsnan.feishu.cn/wiki/AuDVwVo6YiAHNxkLGjncd4qgnMh">
 *     Arcus 用户唯一标识
 *     </a>
 *
 * @param id
 * @author wangjialong
 * @since 2025-06-25
 */
public record ArcusUserId(String id) {

    public ArcusUserId {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("User ID cannot be null or blank");
        }
    }

    public static ArcusUserId gen() {
        // 生成一个新的用户ID，通常使用UUID或其他唯一标识符生成方式
        String generatedId = java.util.UUID.randomUUID().toString();
        return new ArcusUserId(generatedId);
    }
}
