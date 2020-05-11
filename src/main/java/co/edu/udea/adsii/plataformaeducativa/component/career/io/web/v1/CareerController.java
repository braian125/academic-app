package co.edu.udea.adsii.plataformaeducativa.component.career.io.web.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.udea.adsii.plataformaeducativa.component.career.io.web.v1.model.CareerListResponse;
import co.edu.udea.adsii.plataformaeducativa.component.career.io.web.v1.model.CareerQuerySearchRequest;
import co.edu.udea.adsii.plataformaeducativa.component.career.io.web.v1.model.CareerSaveRequest;
import co.edu.udea.adsii.plataformaeducativa.component.career.model.Career;
import co.edu.udea.adsii.plataformaeducativa.component.career.service.CareerService;
import co.edu.udea.adsii.plataformaeducativa.component.career.service.model.CareerQuerySearchCmd;
import co.edu.udea.adsii.plataformaeducativa.component.career.service.model.CareerSaveCmd;
import co.edu.udea.adsii.plataformaeducativa.component.shared.model.ErrorDetails;
import co.edu.udea.adsii.plataformaeducativa.component.shared.model.ResponsePagination;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping(path = "/api/v1/careers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CareerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    CareerService careerService;

    @Autowired
    public CareerController(CareerService careerService) {
        this.careerService = careerService;
    }

    @PostMapping
    @ApiOperation(value = "Create an Career.", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created."),
            @ApiResponse(code = 400, message = "Payload is invalid.", response = ErrorDetails.class),
            @ApiResponse(code = 404, message = "Resource not found.", response = ErrorDetails.class),
            @ApiResponse(code = 500, message = "Internal server error.", response = ErrorDetails.class) })
    @ResponseStatus(value = HttpStatus.CREATED)
    @CrossOrigin(exposedHeaders = { HttpHeaders.LOCATION })
    public ResponseEntity<Void> create(@Valid @NotNull @RequestBody CareerSaveRequest careerToCreate) {
        logger.debug("Begin create: careerToCreate = {}", careerToCreate);

        CareerSaveCmd careerToCreateCmd = CareerSaveRequest.toModel(careerToCreate);

        Career careerCreated = careerService.create(careerToCreateCmd);

        URI location = fromUriString("/api/v1/careers").path("/{id}").buildAndExpand(careerCreated.getId()).toUri();

        logger.debug("End create: careerCreated = {}", careerCreated);

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    @ApiOperation(value = "Find careers by parameters.", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CareerListResponse.class),
            @ApiResponse(code = 400, message = "Payload is invalid.", response = ErrorDetails.class),
            @ApiResponse(code = 500, message = "Internal server error.", response = ErrorDetails.class)

    })
    public ResponsePagination<CareerListResponse> findByParameters(
            @Valid @NotNull CareerQuerySearchRequest queryCriteria,
            @PageableDefault(page = 0, size = 10, direction = Sort.Direction.DESC, sort = "id") Pageable pageable) {
        logger.debug("Begin findByParameters: queryCriteria = {}, pageable= {}", queryCriteria, pageable);

        CareerQuerySearchCmd queryCriteriaCmd = CareerQuerySearchRequest.toModel(queryCriteria);

        Page<Career> careersFound = careerService.findByParameters(queryCriteriaCmd, pageable);
        List<CareerListResponse> usersFoundList = careersFound.stream().map(CareerListResponse::fromModel)
                .collect(Collectors.toList());

        logger.debug("End findByParameters: careersFound = {}", careersFound);

        return ResponsePagination.fromObject(usersFoundList, careersFound.getTotalElements(), careersFound.getNumber(),
                usersFoundList.size());
    }
}