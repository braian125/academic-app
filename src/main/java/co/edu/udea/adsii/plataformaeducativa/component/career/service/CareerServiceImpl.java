package co.edu.udea.adsii.plataformaeducativa.component.career.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.adsii.plataformaeducativa.component.career.model.Career;
import co.edu.udea.adsii.plataformaeducativa.component.career.service.model.CareerQuerySearchCmd;
import co.edu.udea.adsii.plataformaeducativa.component.career.service.model.CareerSaveCmd;

import javax.validation.constraints.NotNull;

@Service
@Transactional
public class CareerServiceImpl implements CareerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private CareerGateway careerGateway;

    public CareerServiceImpl(CareerGateway careerGateway) {
        this.careerGateway = careerGateway;
    }

    @Override
    public Career create(@NotNull CareerSaveCmd careerToCreateCmd) {
        logger.debug("Begin create careerToCreateCmd = {}", careerToCreateCmd);

        Career careerToCreate = CareerSaveCmd.toModel(careerToCreateCmd);

        Career careerCreated = careerGateway.save(careerToCreate);

        logger.debug("End create careerCreated = {}", careerCreated);

        return careerCreated;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Career> findByParameters(@NotNull CareerQuerySearchCmd queryCriteria, @NotNull Pageable pageable) {
        logger.debug("Begin findByParameters queryCriteria = {}, pageable = {}", queryCriteria, pageable);

        Page<Career> careersFound = careerGateway.findByParameters(queryCriteria, pageable);

        logger.debug("End findByParameters careersFound = {}", careersFound);

        return careersFound;
    }
}
