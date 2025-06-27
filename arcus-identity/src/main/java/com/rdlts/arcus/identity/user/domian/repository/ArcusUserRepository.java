package com.rdlts.arcus.identity.user.domian.repository;

import com.rdlts.arcus.ddd.core.domain.DomainRepository;
import com.rdlts.arcus.identity.user.domian.entity.ArcusUser;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserId;

public interface ArcusUserRepository extends DomainRepository<ArcusUser, ArcusUserId> {
}
