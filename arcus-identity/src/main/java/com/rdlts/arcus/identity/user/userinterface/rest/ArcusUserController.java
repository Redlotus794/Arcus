package com.rdlts.arcus.identity.user.userinterface.rest;

import com.rdlts.arcus.identity.user.userinterface.request.CreateArcusUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * ArcusUserController
 * Arcus User的REST控制器
 *
 * @author wangjialong
 * @since 2025-06-30
 */
@RestController
@RequestMapping("/api/v1/arcus-user")
@Tag(name = "Arcus User Controller", description = "REST Controller for Arcus User")
public class ArcusUserController {

    @GetMapping("/")
    @Operation(summary = "Get All Arcus Users", description = "Retrieve all Arcus users")
    public void getAll() {

    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Arcus User by ID", description = "Retrieve an Arcus user by their ID")
    public void getBy(@PathVariable String id) {

    }

    @PostMapping("/")
    @Operation(summary = "Create Arcus User", description = "Create a new Arcus user")
    public void create(@RequestBody @Validated CreateArcusUserRequest createArcusUserRequest) {

    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Arcus User", description = "Update an existing Arcus user by their ID")
    public void update(@PathVariable String id) {

    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Arcus User", description = "Delete an Arcus user by their ID")
    public void delete(@PathVariable String id) {

    }

}
