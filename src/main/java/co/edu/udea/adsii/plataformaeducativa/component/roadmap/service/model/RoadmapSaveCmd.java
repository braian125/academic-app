package co.edu.udea.adsii.plataformaeducativa.component.roadmap.service.model;

import co.edu.udea.adsii.plataformaeducativa.component.roadmap.model.Roadmap;

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
public class RoadmapSaveCmd {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
    private String description;

    public static Roadmap toModel(@NotNull RoadmapSaveCmd roadmapToCreateCmd) {
        return Roadmap.builder()
                .name(roadmapToCreateCmd.getName())
                .description(roadmapToCreateCmd.getDescription())
                .build();
    }
}
