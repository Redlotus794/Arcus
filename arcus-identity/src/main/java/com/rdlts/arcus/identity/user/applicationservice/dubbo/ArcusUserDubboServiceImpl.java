package com.rdlts.arcus.identity.user.applicationservice.dubbo;

import com.rdlts.arcus.identity.user.applicationservice.ArcusUserApplicationService;
import com.rdlts.arcus.identity.user.applicationservice.command.CreateArcusUserCommand;
import com.rdlts.arcus.identity.user.applicationservice.dubbo.dto.RegisterUserDto;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * ArcusUserDubboServiceImpl
 *
 * @author wangjialong
 * @since 2025/7/29 13:13
 */
@DubboService
@Service
public class ArcusUserDubboServiceImpl implements ArcusUserDubboService {

    @Resource
    ArcusUserApplicationService arcusUserApplicationService;

    @Override
    public String registerUser(RegisterUserDto registerUserDto) {
        arcusUserApplicationService.createUser(new CreateArcusUserCommand() {
            @Override
            public String username() {
                return registerUserDto.getUsername();
            }

            @Override
            public String password() {
                return registerUserDto.getPassword();
            }

            @Override
            public String email() {
                return registerUserDto.getEmail();
            }
        });
        return "abc";
    }
}
