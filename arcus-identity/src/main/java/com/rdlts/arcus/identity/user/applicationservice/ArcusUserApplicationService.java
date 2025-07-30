package com.rdlts.arcus.identity.user.applicationservice;

import com.rdlts.arcus.identity.user.applicationservice.command.CreateArcusUserCommand;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserId;

/**
 * UserManagementApplicationService
 * <a href="https://wcnn2j4xsnan.feishu.cn/wiki/DST9wlTvqiwuqQkinesc8KqXnjg">
 *     用户管理应用服务
 *     </a>
 *
 * @author wangjialong
 * @since 2025-06-26
 */
public interface ArcusUserApplicationService {

    /**
     * createUser
     * @param createArcusUserCommand CreateUserCommand
     * @return ArcusUserId 返回创建的用户的id
     */
    ArcusUserId createUser(CreateArcusUserCommand createArcusUserCommand);
}
