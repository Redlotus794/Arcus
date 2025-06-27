package com.rdlts.arcus.identity.user.infrastructure.repository;

import com.rdlts.arcus.identity.user.infrastructure.dao.ArcusUserDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArcusUserDaoJpaRepository extends JpaRepository<ArcusUserDao, Long> {

    ArcusUserDao findByUserId(String userId);
}
