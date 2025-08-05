package com.rdlts.arcus.identity.user.applicationservice.dubbo.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * RegisterUserDto
 * Dubbo的默认序列化hessian2 需要dto对象实现Serializable接口
 *
 * @author wangjialong
 * @since 2025/7/29 13:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class RegisterUserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    String username;

    String password;

    String email;

    String phone;

    String avatar;
}
