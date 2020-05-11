package co.edu.udea.adsii.plataformaeducativa.component.career.service.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.edu.udea.adsii.plataformaeducativa.component.career.model.Career;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CareerSaveCmd {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
    private String name;

    @NotNull
    @NotBlank
    private String description;

    @Column
    private String icon;

    @Builder.Default
    private Boolean active = true;

    public static Career toModel(@NotNull CareerSaveCmd careerToCreateCmd) {
        return Career.builder().name(careerToCreateCmd.getName()).description(careerToCreateCmd.getDescription())
                .icon(careerToCreateCmd.getIcon()).active(careerToCreateCmd.getActive()).build();
    }
}