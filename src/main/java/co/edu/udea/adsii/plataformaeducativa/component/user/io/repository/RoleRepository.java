package co.edu.udea.adsii.plataformaeducativa.component.user.io.repository;


import co.edu.udea.adsii.plataformaeducativa.component.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
