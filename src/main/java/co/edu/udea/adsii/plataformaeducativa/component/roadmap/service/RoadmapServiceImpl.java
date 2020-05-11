package co.edu.udea.adsii.plataformaeducativa.component.roadmap.service;

import co.edu.udea.adsii.plataformaeducativa.component.roadmap.model.Roadmap;
import co.edu.udea.adsii.plataformaeducativa.component.roadmap.service.model.RoadmapSaveCmd;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Service
@Transactional
public class RoadmapServiceImpl implements RoadmapService {

    private RoadmapGateway roadmapGateway;

    public RoadmapServiceImpl(RoadmapGateway roadmapGateway) {
        this.roadmapGateway = roadmapGateway;
    }

    @Override
    public Roadmap create(@NotNull RoadmapSaveCmd roadmapToCreateCmd) {
        Roadmap roadmapToCreate = RoadmapSaveCmd.toModel(roadmapToCreateCmd);
        Roadmap roadmapCreated = roadmapGateway.save(roadmapToCreate);
        return roadmapCreated;
    }
}
