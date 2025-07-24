package com.rdlts.arcus.identity.user.userinterface.rest;

import com.rdlts.arcus.ddd.core.domain.EntityJsonObject;
import com.rdlts.arcus.identity.user.domian.entity.ArcusUser;
import com.rdlts.arcus.identity.user.domian.repository.ArcusUserRepository;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserId;
import com.rdlts.arcus.identity.user.infrastructure.ejo.ArcusUserEJO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ArcusUserController
 * Arcus User的RESTful控制器
 *
 * @author wangjialong
 * @since 2025-06-30
 */
@RestController
@RequestMapping("/api/v1/arcus-user")
@Tag(name = "Arcus User RESTful Controller", description = "RESTful Controller for Arcus User")
public class ArcusUserRESTfulController {

    ArcusUserRepository arcusUserRepository;

    @Autowired
    public ArcusUserRESTfulController(ArcusUserRepository arcusUserRepository) {
        this.arcusUserRepository = arcusUserRepository;
    }

    @GetMapping("/")
    @Operation(summary = "Get All Arcus Users", description = "Retrieve all Arcus users")
    public Collection<ArcusUserEJO> getAll() {
        return arcusUserRepository.findAll()
                .stream()
                .map(t -> EntityJsonObject.toEJO(ArcusUserEJO.class, t))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Arcus User by ID", description = "Retrieve an Arcus user by their ID")
    public ArcusUserEJO getBy(@PathVariable String id) {
        return arcusUserRepository
                .find(new ArcusUserId(id))
                .map(t -> EntityJsonObject.toEJO(ArcusUserEJO.class, t))
                .orElse(null);
    }

    @PostMapping("/")
    @Operation(summary = "Create Arcus User", description = "Create a new Arcus user")
    public String create(@RequestBody ArcusUserEJO arcusUserEJO) {
        final ArcusUser entity = arcusUserEJO.toEntity();
        entity.setUserId(arcusUserRepository.nextIdentity());
        arcusUserRepository.save(entity);
        return entity.getUserId().id();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Arcus User", description = "Update an existing Arcus user by their ID")
    public void update(@PathVariable String id, @RequestBody ArcusUserEJO arcusUserEJO) {
        final ArcusUserId arcusUserId = new ArcusUserId(id);
        final Optional<ArcusUser> arcusUser = arcusUserRepository.find(arcusUserId);
        if (arcusUser.isEmpty()) {
            throw new IllegalArgumentException("User with ID " + id + " does not exist.");
        }

        if (!StringUtils.equals(id, arcusUserEJO.getUserId())) {
            throw new IllegalArgumentException("ID mismatch: " + id + " does not match " + arcusUserEJO.getUserId());
        }

        final ArcusUser newEntity = arcusUserEJO.toEntity();
        newEntity.setEntityVersion(arcusUser.get().getEntityVersion());

        arcusUserRepository.save(newEntity);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Arcus User", description = "Delete an Arcus user by their ID")
    public void delete(@PathVariable String id) {
        final ArcusUserId arcusUserId = new ArcusUserId(id);
        final Optional<ArcusUser> arcusUser = arcusUserRepository.find(arcusUserId);
        if (arcusUser.isEmpty()) {
            throw new IllegalArgumentException("User with ID " + id + " does not exist.");
        }
        arcusUserRepository.remove(arcusUser.get());
    }

}
