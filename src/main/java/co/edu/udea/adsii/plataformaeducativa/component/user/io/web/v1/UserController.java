package co.edu.udea.adsii.plataformaeducativa.component.user.io.web.v1;

import co.edu.udea.adsii.plataformaeducativa.component.shared.model.ErrorDetails;
import co.edu.udea.adsii.plataformaeducativa.component.user.io.web.v1.model.RoleSaveRequest;
import co.edu.udea.adsii.plataformaeducativa.component.user.io.web.v1.model.RoleSaveResponse;
import co.edu.udea.adsii.plataformaeducativa.component.user.model.Role;
import co.edu.udea.adsii.plataformaeducativa.component.user.service.UserService;
import co.edu.udea.adsii.plataformaeducativa.component.user.service.model.RoleSaveCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@RestController
@RequestMapping(path = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/roles")
    @ApiOperation(value = "Create an Role.", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Created."),
            @ApiResponse(code = 400, message = "Payload is invalid.", response = ErrorDetails.class),
            @ApiResponse(code = 404, message = "Resource not found.", response = ErrorDetails.class),
            @ApiResponse(code = 500, message = "Internal server error.", response = ErrorDetails.class)
    })
    public ResponseEntity<Void> createRole(@Valid @NotNull @RequestBody RoleSaveRequest roleToCreate) {
        RoleSaveCmd roleToCreateCmd = RoleSaveRequest.toModel(roleToCreate);
        Role roleCreated = userService.createRole(roleToCreateCmd);
        URI location = fromUriString("/api/v1/users/roles").path("/{id}")
                .buildAndExpand(roleCreated.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}