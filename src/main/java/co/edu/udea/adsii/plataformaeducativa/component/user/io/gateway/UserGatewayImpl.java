package co.edu.udea.adsii.plataformaeducativa.component.user.io.gateway;


//import co.edu.udea.adsii.plataformaeducativa.component.shared.web.exception.NotFoundException;
import co.edu.udea.adsii.plataformaeducativa.component.user.io.repository.RoleRepository;
import co.edu.udea.adsii.plataformaeducativa.component.user.model.Role;
import co.edu.udea.adsii.plataformaeducativa.component.user.service.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Repository
public class UserGatewayImpl implements UserGateway {

    private RoleRepository roleRepository;

    @Autowired
    public UserGatewayImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role saveRole(@NotNull Role roleToCreate) {
        final Role roleToBeCreated =
                roleToCreate.toBuilder().createDate(LocalDateTime.now()).updateDate(LocalDateTime.now())
                        .name(roleToCreate.getName()).build();
        return roleRepository.save(roleToBeCreated);
    }
}