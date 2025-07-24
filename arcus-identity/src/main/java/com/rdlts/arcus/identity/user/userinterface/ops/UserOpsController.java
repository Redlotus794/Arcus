package com.rdlts.arcus.identity.user.userinterface.ops;

import com.rdlts.arcus.identity.user.applicationservice.ArcusUserApplicationService;
import com.rdlts.arcus.identity.user.userinterface.request.CreateArcusUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserOpsController
 *
 * @author wangjialong
 * @since 2025/7/22 14:52
 */
@RequestMapping("/ops/v1/user")
@RestController
@Tag(description = "User Operations Controller", name = "User Ops Controller")
public class UserOpsController {

    ArcusUserApplicationService arcusUserApplicationService;

    @Autowired
    public UserOpsController(ArcusUserApplicationService arcusUserApplicationService) {
        this.arcusUserApplicationService = arcusUserApplicationService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create Arcus User", description = "Create a new Arcus user")
    public String createUser(@RequestBody @Valid CreateArcusUserRequest createArcusUserRequest) {
        return arcusUserApplicationService.createUser(createArcusUserRequest).id();
    }
}
