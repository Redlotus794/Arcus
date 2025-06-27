package com.rdlts.arcus.identity.user.domian.valueobject;

import lombok.Builder;

/**
 * Arcus Profile
 * <a href="https://wcnn2j4xsnan.feishu.cn/wiki/G9i9wHfpaiioXEkI1BHcvEDQnRg">
 *     Arcus 用户资料
 *     </a>
 * @param name
 * @param avatar
 */
@Builder
public record ArcusProfile(String name, String avatar) {

}
