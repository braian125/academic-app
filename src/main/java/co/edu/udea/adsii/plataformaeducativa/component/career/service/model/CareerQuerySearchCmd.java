package co.edu.udea.adsii.plataformaeducativa.component.career.service.model;

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
public class CareerQuerySearchCmd {

    private String name;

    private String description;

    private String icon;

    private Boolean active;
}