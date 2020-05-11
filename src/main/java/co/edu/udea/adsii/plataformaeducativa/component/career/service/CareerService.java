package co.edu.udea.adsii.plataformaeducativa.component.career.service;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.edu.udea.adsii.plataformaeducativa.component.career.model.Career;
import co.edu.udea.adsii.plataformaeducativa.component.career.service.model.CareerQuerySearchCmd;
import co.edu.udea.adsii.plataformaeducativa.component.career.service.model.CareerSaveCmd;

public interface CareerService {

    Career create(@NotNull CareerSaveCmd careerToCreateCmd);

    Page<Career> findByParameters(@NotNull CareerQuerySearchCmd queryCriteriaCmd, @NotNull Pageable pageable);

}