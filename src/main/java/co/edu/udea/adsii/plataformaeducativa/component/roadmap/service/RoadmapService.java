package co.edu.udea.adsii.plataformaeducativa.component.roadmap.service;

import co.edu.udea.adsii.plataformaeducativa.component.roadmap.model.Roadmap;
import co.edu.udea.adsii.plataformaeducativa.component.roadmap.service.model.RoadmapSaveCmd;
import javax.validation.constraints.NotNull;

public interface RoadmapService {

    Roadmap create(@NotNull RoadmapSaveCmd userToCreateCmd);
}
