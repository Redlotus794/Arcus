package com.rdlts.arcus.adv.usertinterface.view.request;

import com.rdlts.arcus.adv.usertinterface.view.validator.PhoneNumber;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * RegisterUserRequest
 *
 * @author wangjialong
 * @since 2025/7/24 09:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@Schema(name = "Register User Request", description = "Request object for registering a new user in the Arcus system")
public class RegisterUserRequest {

    @NotBlank
    @Schema(name = "username", description = "Username for the new user", example = "john_doe")
    String username;

    @Email
    @Schema(name = "email", description = "Email address for the new user", example = "abc@def.com")
    String email;

    @PhoneNumber(allowEmpty = false)
    @Schema(name = "phone", description = "Phone Number", example = "1231231234")
    String phone;

    @NotBlank
    @Schema(name = "password", description = "Raw Password for the new user", example = "P@ssw0rd!")
    String password;

    @Schema(name = "avatar", description = "Avatar URL for the new user", example = "https://example.com/avatar.jpg")
    String avatar;
}
