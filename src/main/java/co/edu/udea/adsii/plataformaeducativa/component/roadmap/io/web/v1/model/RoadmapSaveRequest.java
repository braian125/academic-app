package co.edu.udea.adsii.plataformaeducativa.component.roadmap.io.web.v1.model;

import co.edu.udea.adsii.plataformaeducativa.component.roadmap.service.model.RoadmapSaveCmd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoadmapSaveRequest {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
    private String description;

    private Boolean active = false;

    public static RoadmapSaveCmd toModel(@NotNull RoadmapSaveRequest roadmapToCreateCmd) {
        return RoadmapSaveCmd.builder()
                .name(roadmapToCreateCmd.getName())
                .description(roadmapToCreateCmd.getDescription())
                .active(roadmapToCreateCmd.getActive())
                .build();
    }
}
