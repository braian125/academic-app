package co.edu.udea.adsii.plataformaeducativa.component.roadmap.io.web.v1;

import co.edu.udea.adsii.plataformaeducativa.component.roadmap.io.web.v1.model.RoadmapSaveRequest;
import co.edu.udea.adsii.plataformaeducativa.component.roadmap.io.web.v1.model.RoadmapSaveResponse;
import co.edu.udea.adsii.plataformaeducativa.component.roadmap.model.Roadmap;
import co.edu.udea.adsii.plataformaeducativa.component.roadmap.service.RoadmapService;
import co.edu.udea.adsii.plataformaeducativa.component.roadmap.service.model.RoadmapSaveCmd;
import co.edu.udea.adsii.plataformaeducativa.component.shared.model.ErrorDetails;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@RequestMapping(path = "/api/v1/roadmaps", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = { "Roadmaps" }, value = "Roadmaps")
public class RoadmapController {

    private RoadmapService roadmapService;

    public RoadmapController(RoadmapService roadmapService) {
        this.roadmapService = roadmapService;
    }

    @PostMapping
    @ApiOperation(value = "Create an User.", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created."),
            @ApiResponse(code = 400, message = "Payload is invalid.", response = ErrorDetails.class),
            @ApiResponse(code = 404, message = "Resource not found.", response = ErrorDetails.class),
            @ApiResponse(code = 500, message = "Internal server error.", response = ErrorDetails.class) })
    @ResponseStatus(value = HttpStatus.CREATED)
    @CrossOrigin(exposedHeaders = { HttpHeaders.LOCATION })
    public RoadmapSaveResponse create(@Valid @NotNull @RequestBody RoadmapSaveRequest roadmapToCreate) {
        RoadmapSaveCmd roadmapToCreateCmd = RoadmapSaveRequest.toModel(roadmapToCreate);
        Roadmap roadmapCreated = roadmapService.create(roadmapToCreateCmd);
        RoadmapSaveResponse roadmapToRespond = RoadmapSaveResponse.fromModel(roadmapCreated);
        return roadmapToRespond;
    }
}
