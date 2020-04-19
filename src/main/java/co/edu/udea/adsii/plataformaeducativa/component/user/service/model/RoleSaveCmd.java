package co.edu.udea.adsii.plataformaeducativa.component.user.service.model;

import co.edu.udea.adsii.plataformaeducativa.component.user.model.Role;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleSaveCmd {

    @NotNull
    @NotBlank
    @Column(unique = true)
    @Size(min = 3, max = 10)
    private String name;

    public static Role toModel(@NotNull RoleSaveCmd roleToCreateCmd) {
        return Role.builder().name(roleToCreateCmd.getName()).build();
    }
}