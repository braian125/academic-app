package co.edu.udea.adsii.plataformaeducativa.component.career.io.web.v1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.edu.udea.adsii.plataformaeducativa.component.career.service.model.CareerSaveCmd;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CareerSaveRequest {

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

    public static CareerSaveCmd toModel(CareerSaveRequest careerToCreate) {
        return CareerSaveCmd.builder().name(careerToCreate.getName()).description(careerToCreate.getDescription())
                .icon(careerToCreate.getIcon()).active(careerToCreate.getActive()).build();
    }
}