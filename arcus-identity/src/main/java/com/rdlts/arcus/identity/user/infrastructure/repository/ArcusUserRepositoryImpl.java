package com.rdlts.arcus.identity.user.infrastructure.repository;

import com.rdlts.arcus.identity.user.domian.entity.ArcusUser;
import com.rdlts.arcus.identity.user.domian.repository.ArcusUserRepository;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserId;
import com.rdlts.arcus.identity.user.infrastructure.adapter.ArcusUserAdapter;
import com.rdlts.arcus.identity.user.infrastructure.po.ArcusUserPO;
import com.rdlts.arcus.identity.user.infrastructure.po.ArcusUserPOAdapter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class ArcusUserRepositoryImpl implements ArcusUserRepository {

    @Resource
    ArcusUserDAO arcusUserDAO;

    @Override
    public ArcusUserId nextIdentity() {
        return ArcusUserId.gen();
    }

    @Override
    public Optional<ArcusUser> find(ArcusUserId arcusUserId) {
        final ArcusUserPO arcusUserPO = arcusUserDAO.findByUserId(arcusUserId.id());
        if (arcusUserPO != null) {
            return Optional.of(ArcusUserAdapter.adapt(arcusUserPO));
        }
        return Optional.empty();
    }

    @Override
    public Collection<ArcusUser> findAll() {
        return List.of();
    }

    @Override
    public void save(ArcusUser entity) {
        arcusUserDAO.save(ArcusUserPOAdapter.adapt(entity));
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
