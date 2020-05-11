package co.edu.udea.adsii.plataformaeducativa.component.career.io.web.v1.model;

import co.edu.udea.adsii.plataformaeducativa.component.career.service.model.CareerQuerySearchCmd;
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
public class CareerQuerySearchRequest {

    private String name;

    private String description;

    private String icon;

    private Boolean active;

    public static CareerQuerySearchCmd toModel(CareerQuerySearchRequest queryCriteria) {
        return CareerQuerySearchCmd.builder().name(queryCriteria.getName()).description(queryCriteria.getDescription())
                .icon(queryCriteria.getIcon()).active(queryCriteria.getActive()).build();
    }
}