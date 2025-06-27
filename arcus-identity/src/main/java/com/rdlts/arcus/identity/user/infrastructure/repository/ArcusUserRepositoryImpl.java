package com.rdlts.arcus.identity.user.infrastructure.repository;

import com.rdlts.arcus.identity.user.domian.entity.ArcusUser;
import com.rdlts.arcus.identity.user.domian.repository.ArcusUserRepository;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserId;
import com.rdlts.arcus.identity.user.infrastructure.adapter.ArcusUserAdapter;
import com.rdlts.arcus.identity.user.infrastructure.dao.ArcusUserDao;
import com.rdlts.arcus.identity.user.infrastructure.dao.ArcusUserDaoAdapter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class ArcusUserRepositoryImpl implements ArcusUserRepository {

    @Resource
    ArcusUserDaoJpaRepository arcusUserDaoJpaRepository;

    @Override
    public ArcusUserId nextIdentity() {
        return ArcusUserId.gen();
    }

    @Override
    public Optional<ArcusUser> find(ArcusUserId arcusUserId) {
        final ArcusUserDao arcusUserDao = arcusUserDaoJpaRepository.findByUserId(arcusUserId.id());
        if (arcusUserDao != null) {
            return Optional.of(ArcusUserAdapter.adapt(arcusUserDao));
        }
        return Optional.empty();
    }

    @Override
    public Collection<ArcusUser> findAll() {
        return List.of();
    }

    @Override
    public void save(ArcusUser entity) {
        arcusUserDaoJpaRepository.save(ArcusUserDaoAdapter.adapt(entity));
    }

    @Override
    public void saveAll(Collection<ArcusUser> entityCollection) {

    }

    @Override
    public void remove(ArcusUser entity) {

    }

    @Override
    public void removeAll(Collection<ArcusUser> entityCollection) {

    }
}
