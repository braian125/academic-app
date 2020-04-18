package co.edu.udea.adsii.plataformaeducativa.component.user.io.web.v1.model;


import co.edu.udea.adsii.plataformaeducativa.component.user.service.model.RoleSaveCmd;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleSaveRequest {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 10)
    private String name;

    public static RoleSaveCmd toModel(@NotNull RoleSaveRequest roleToCreate) {
        return RoleSaveCmd.builder().name(roleToCreate.getName()).build();

    }
}
