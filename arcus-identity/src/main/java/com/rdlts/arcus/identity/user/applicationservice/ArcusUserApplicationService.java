package com.rdlts.arcus.identity.user.applicationservice;

import com.rdlts.arcus.identity.user.applicationservice.directive.CreateArcusUserCommand;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserId;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;

/**
 * UserManagementApplicationService
 * <a href="https://wcnn2j4xsnan.feishu.cn/wiki/DST9wlTvqiwuqQkinesc8KqXnjg">
 *     用户管理应用服务
 *     </a>
 *
 * @author wangjialong
 * @since 2025-06-26
 */
@Service
public class ArcusUserApplicationService {

    /**
     * createUser
     * @param createArcusUserCommand CreateUserCommand
     * @return ArcusUserId 返回创建的用户的id
     */
    @Transactional(rollbackFor = Exception.class)
    @Nonnull
    public ArcusUserId createUser(CreateArcusUserCommand createArcusUserCommand) {
//        ArcusUser arcusUser = ArcusUser.builder()
//                .userId(ArcusUserId.gen())
//                .encryptedPassword(createUserCommand.encryptedPassword())
//                .email(createUserCommand.email())
//                .entityVersion(EntityVersion.gen())
//                .build();
        throw new NotImplementedException("createUser not implemented yet!");
    }
}
