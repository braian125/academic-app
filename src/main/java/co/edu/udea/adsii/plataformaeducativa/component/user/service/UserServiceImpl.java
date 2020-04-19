package co.edu.udea.adsii.plataformaeducativa.component.user.service;


import co.edu.udea.adsii.plataformaeducativa.component.user.model.Role;
import co.edu.udea.adsii.plataformaeducativa.component.user.service.model.RoleSaveCmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserGateway userGateway;

    @Autowired
    public UserServiceImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public Role createRole(@NotNull RoleSaveCmd roleToCreateCmd) {
        Role roleToCreate = RoleSaveCmd.toModel(roleToCreateCmd);
        return userGateway.saveRole(roleToCreate);
    }
}