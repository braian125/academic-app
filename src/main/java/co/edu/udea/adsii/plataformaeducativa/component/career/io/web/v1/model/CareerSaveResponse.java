package co.edu.udea.adsii.plataformaeducativa.component.career.io.web.v1.model;

import co.edu.udea.adsii.plataformaeducativa.component.career.model.Career;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CareerSaveResponse {

    private Long id;

    private String name;

    private String description;

    private String icon;

    private Boolean active;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    public static CareerSaveResponse fromModel(Career career) {
        return CareerSaveResponse.builder().id(career.getId()).name(
                career.getName()).description(career.getDescription()).icon(career.getIcon()).active(career.getActive()).createDate(
                career.getCreateDate()).updateDate(
                career.getUpdateDate()).build();
    }
}