package com.rdlts.arcus.identity.user.infrastructure.repository;

import com.rdlts.arcus.identity.user.infrastructure.po.ArcusUserPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Arcus User 数据访问对象接口 - Arcus User Data Access Object Interface
 *
 */
public interface ArcusUserDAO extends JpaRepository<ArcusUserPO, Long> {

    ArcusUserPO findByUserId(String userId);
}
