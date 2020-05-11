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
    public Career findById(@NotNull Long id) {
        logger.debug("Begin findById id = {}", id);

        Career careerFound = careerGateway.findById(id);

        logger.debug("End findById careerFound = {}", careerFound);

        return careerFound;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Career> findByParameters(@NotNull CareerQuerySearchCmd queryCriteria, @NotNull Pageable pageable) {
        logger.debug("Begin findByParameters queryCriteria = {}, pageable = {}", queryCriteria, pageable);

        Page<Career> careersFound = careerGateway.findByParameters(queryCriteria, pageable);

        logger.debug("End findByParameters careersFound = {}", careersFound);

        return careersFound;
    }

    @Override
    public Career update(@NotNull Long id, @NotNull CareerSaveCmd careerToUpdateCmd) {
        logger.debug("Begin update id = {}, careerToUpdateCmd = {}", id, careerToUpdateCmd);

        Career careerInDataBase = findById(id);

        Career careerToUpdate = careerInDataBase.toBuilder().name(careerToUpdateCmd.getName())
                .description(careerToUpdateCmd.getDescription()).icon(careerToUpdateCmd.getIcon())
                .active(careerToUpdateCmd.getActive()).build();

        Career careerUpdated = careerGateway.update(careerToUpdate);

        logger.debug("End update careerUpdated = {}", careerUpdated);

        return careerUpdated;
    }
}
