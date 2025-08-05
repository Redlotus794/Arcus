package com.rdlts.arcus.identity.user.applicationservice.dubbo;

import com.rdlts.arcus.identity.user.applicationservice.ArcusUserApplicationService;
import com.rdlts.arcus.identity.user.applicationservice.command.CreateArcusUserCommand;
import com.rdlts.arcus.identity.user.applicationservice.dubbo.dto.RegisterUserDto;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusPassword;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusProfile;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserEmail;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserId;
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
        final ArcusUserId user = arcusUserApplicationService.createUser(new CreateArcusUserCommand() {
            @Override
            public ArcusProfile profile() {
                return ArcusProfile.builder()
                        .username(registerUserDto.getUsername())
                        .avatar(registerUserDto.getAvatar())
                        .build();
            }

            @Override
            public ArcusUserEmail arcusUserEmail() {
                return new ArcusUserEmail(registerUserDto.getEmail());
            }

            @Override
            public ArcusPassword newPassword() {
                return new ArcusPassword(registerUserDto.getPassword());
            }
        });
        return user.id();
    }
}
