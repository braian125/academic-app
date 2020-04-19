package co.edu.udea.adsii.plataformaeducativa.component.user.service;

import co.edu.udea.adsii.plataformaeducativa.component.user.model.Role;
import co.edu.udea.adsii.plataformaeducativa.component.user.service.model.RoleSaveCmd;

import javax.validation.constraints.NotNull;

public interface UserService {

    Role createRole(@NotNull RoleSaveCmd roleToCreateCmd);

}