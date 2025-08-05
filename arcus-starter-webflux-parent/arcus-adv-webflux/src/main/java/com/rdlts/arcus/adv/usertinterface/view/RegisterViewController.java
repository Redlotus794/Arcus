package com.rdlts.arcus.adv.usertinterface.view;

import com.rdlts.arcus.adv.usertinterface.view.request.RegisterUserRequest;
import com.rdlts.arcus.common.sharedkernel.response.ArcusRestResponseBody;
import com.rdlts.arcus.identity.user.applicationservice.dubbo.ArcusUserDubboService;
import com.rdlts.arcus.identity.user.applicationservice.dubbo.dto.RegisterUserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * RegisterViewController
 *
 * @author wangjialong
 * @since 2025/7/23 15:32
 */
@RequestMapping("/view/register")
@RestController
@Tag(name = "Register View Controller", description = "Arcus Acro Design Vue 的注册页面控制器")
@Log4j2
public class RegisterViewController {

    ArcusUserDubboService arcusUserDubboService;

    @Autowired
    public RegisterViewController(ArcusUserDubboService arcusUserDubboService) {
        this.arcusUserDubboService = arcusUserDubboService;
    }

    @PostMapping("/")
    @Operation(summary = "Register a new user", description = "Register a new user in the Arcus system")
    public Mono<ArcusRestResponseBody<String>> registerUser(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        log.info("Registering a new user in the Arcus system, {}", registerUserRequest);

        final String userId = arcusUserDubboService.registerUser(RegisterUserDto.builder()
                .username(registerUserRequest.getUsername())
                .password(registerUserRequest.getPassword())
                .phone(registerUserRequest.getPhone())
                .email(registerUserRequest.getEmail())
                .build());

        return Mono.just(ArcusRestResponseBody.success(userId));
    }
}
