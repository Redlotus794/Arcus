package com.rdlts.arcus.identity.user.applicationservice.command;

import com.rdlts.arcus.ddd.core.domain.cqrs.Command;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusPassword;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusProfile;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserEmail;

/**
 * 创建 Arcus 用户
 */
public interface CreateArcusUserCommand extends Command {

    ArcusProfile profile();

    ArcusUserEmail arcusUserEmail();

    ArcusPassword newPassword();
}
