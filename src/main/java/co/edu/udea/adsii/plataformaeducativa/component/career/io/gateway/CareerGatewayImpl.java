package co.edu.udea.adsii.plataformaeducativa.component.career.io.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import co.edu.udea.adsii.plataformaeducativa.component.career.io.repository.CareerRepository;
import co.edu.udea.adsii.plataformaeducativa.component.career.model.Career;
import co.edu.udea.adsii.plataformaeducativa.component.career.service.CareerGateway;
import co.edu.udea.adsii.plataformaeducativa.component.career.service.model.CareerQuerySearchCmd;

import javax.persistence.criteria.Predicate;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Repository
class CareerGatewayImpl implements CareerGateway {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String RESOURCE_NOT_FOUND = "Career not found";

    private CareerRepository careerRepository;

    public CareerGatewayImpl(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    @Override
    public Career save(@NotNull Career careerToCreate) {
        logger.debug("Begin save careerToCreate = {}", careerToCreate);

        final Career careerToBeCreated = careerToCreate.toBuilder().createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now()).build();

        final Career careerCreated = careerRepository.save(careerToBeCreated);

        logger.debug("End save careerCreated = {}", careerCreated);

        return careerCreated;
    }

    @Override
    public Page<Career> findByParameters(@NotNull CareerQuerySearchCmd queryCriteria, @NotNull Pageable pageable) {
        logger.debug("Begin findByParameters queryCriteria = {}, pageable = {}", queryCriteria, pageable);

        Specification<Career> specification = buildCriteria(queryCriteria);

        Page<Career> resourcesFound = careerRepository.findAll(specification, pageable);

        logger.debug("End findByParameters resourcesFound = {}", resourcesFound);

        return resourcesFound;
    }

    private Specification<Career> buildCriteria(@NotNull CareerQuerySearchCmd queryCriteria) {
        logger.debug("Begin buildCriteria queryCriteria = {}", queryCriteria);

        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (nonNull(queryCriteria.getName())) {
                predicates.add(criteriaBuilder
                        .and(criteriaBuilder.like(root.get("name"), "%" + queryCriteria.getName() + "%")));
            }

            if (nonNull(queryCriteria.getDescription())) {
                predicates.add(criteriaBuilder.and(
                        criteriaBuilder.like(root.get("description"), "%" + queryCriteria.getDescription() + "%")));
            }

            if (nonNull(queryCriteria.getIcon())) {
                predicates.add(criteriaBuilder
                        .and(criteriaBuilder.like(root.get("icon"), "%" + queryCriteria.getIcon() + "%")));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}