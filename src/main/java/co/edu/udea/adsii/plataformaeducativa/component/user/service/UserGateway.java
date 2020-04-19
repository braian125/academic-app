package co.edu.udea.adsii.plataformaeducativa.component.user.service;


import co.edu.udea.adsii.plataformaeducativa.component.user.model.Role;

import javax.validation.constraints.NotNull;

public interface UserGateway {

    Role saveRole(@NotNull Role roleToCreate);

}