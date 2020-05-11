package co.edu.udea.adsii.plataformaeducativa.component.career.io.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.edu.udea.adsii.plataformaeducativa.component.career.model.Career;

@Repository
public interface CareerRepository extends PagingAndSortingRepository<Career, Long>, JpaSpecificationExecutor<Career> {
    
}