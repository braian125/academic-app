package co.edu.udea.adsii.plataformaeducativa.component.roadmap.io.gateway;

import co.edu.udea.adsii.plataformaeducativa.component.roadmap.io.repository.RoadmapRepository;
import co.edu.udea.adsii.plataformaeducativa.component.roadmap.model.Roadmap;
import co.edu.udea.adsii.plataformaeducativa.component.roadmap.service.RoadmapGateway;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class RoadmapGetwayImpl implements RoadmapGateway {

    private RoadmapRepository roadmapRepository;

    public RoadmapGetwayImpl(RoadmapRepository roadmapRepository) {
        this.roadmapRepository = roadmapRepository;
    }

    @Override
    public Roadmap save(@NotNull Roadmap roadmapToCreate) {
        final Roadmap roadmapToBeCreated = roadmapToCreate.toBuilder().createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        final Roadmap roadmapCreated = roadmapRepository.save(roadmapToBeCreated);
        return roadmapCreated;
    }
}
