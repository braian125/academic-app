package co.edu.udea.adsii.plataformaeducativa.component.roadmap.service;

import co.edu.udea.adsii.plataformaeducativa.component.roadmap.model.Roadmap;
import javax.validation.constraints.NotNull;

public interface RoadmapGateway {

    Roadmap save(@NotNull Roadmap roadmapToCreate);
}
