package com.rdlts.arcus.identity.user.applicationservice.dubbo;

import com.rdlts.arcus.identity.user.applicationservice.dubbo.dto.RegisterUserDto;

/**
 * ArcusUserDubboService
 *
 * @author wangjialong
 * @since 2025/7/29 10:56
 */
@SuppressWarnings("all")
public interface ArcusUserDubboService {

    /**
     * registerUser
     * @param registerUserDto Register user data transfer object
     * @return User ID
     */
    String registerUser(RegisterUserDto registerUserDto);
}
