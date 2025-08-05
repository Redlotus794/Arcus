package com.rdlts.arcus.identity.user.userinterface.request;

import com.rdlts.arcus.identity.user.applicationservice.command.CreateArcusUserCommand;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusPassword;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusProfile;
import com.rdlts.arcus.identity.user.domian.valueobject.ArcusUserEmail;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * CreateArcusUserRequest
 *
 * @author wangjialong
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Schema(description = "Request body for creating an Arcus user")
public class CreateArcusUserRequest implements CreateArcusUserCommand {

    @NotBlank
    @Schema(description = "Username of the new user", example = "alice", requiredMode = Schema.RequiredMode.REQUIRED)
    String username;

    @NotBlank
    @Schema(description = "Password for the new user", example = "P@ssw0rd", requiredMode = Schema.RequiredMode.REQUIRED)
    String password;

    @Schema(description = "Email address of the user", example = "alice@example.com")
    String email;

    @Schema(description = "Avatar URL for the user", example = "https://example.com/avatar/alice.png")
    String avatar;

    @Override
    public ArcusProfile profile() {
        return new ArcusProfile(username, avatar);
    }

    @Override
    public ArcusUserEmail arcusUserEmail() {
        return new ArcusUserEmail(this.email);
    }

    @Override
    public ArcusPassword newPassword() {
        return new ArcusPassword(this.password);
    }
}
