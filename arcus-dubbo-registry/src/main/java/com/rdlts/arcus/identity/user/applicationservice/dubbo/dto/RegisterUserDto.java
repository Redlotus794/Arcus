package com.rdlts.arcus.identity.user.applicationservice.dubbo.dto;

import lombok.*;

/**
 * RegisterUserDto
 *
 * @author wangjialong
 * @since 2025/7/29 13:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class RegisterUserDto {

    String username;

    String password;

    String email;

    String phone;
}
