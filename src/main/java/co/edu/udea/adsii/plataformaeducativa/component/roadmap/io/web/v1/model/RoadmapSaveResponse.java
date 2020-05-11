package co.edu.udea.adsii.plataformaeducativa.component.roadmap.io.web.v1.model;

import co.edu.udea.adsii.plataformaeducativa.component.roadmap.model.Roadmap;

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
public class RoadmapSaveResponse {

    private Long id;

    private String name;

    private String description;

    private Boolean active;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    public static RoadmapSaveResponse fromModel(Roadmap roadmap) {
        return RoadmapSaveResponse.builder().id(roadmap.getId()).name(roadmap.getName()).active(roadmap.getActive())
                .description(roadmap.getDescription()).updateDate(roadmap.getUpdateDate())
                .createDate(roadmap.getCreateDate()).build();
    }
}
