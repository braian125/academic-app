package co.edu.udea.adsii.plataformaeducativa.component.career.io.web.v1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import co.edu.udea.adsii.plataformaeducativa.component.career.model.Career;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CareerListResponse {

    private Long id;

    private String name;

    private String description;

    private String icon;

    private Boolean active;

    private LocalDateTime updateDate;

    public static CareerListResponse fromModel(Career career) {
        return CareerListResponse.builder().id(career.getId()).name(career.getName())
                .description(career.getDescription()).icon(career.getIcon()).active(career.getActive())
                .updateDate(career.getUpdateDate()).build();
    }
}