package com.hpfs.distillery.retailer.service;

import com.hpfs.distillery.retailer.dto.VehicleRouteDto;
import com.hpfs.distillery.retailer.model.VehicleRoute;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class VehicleRouteSpecification implements Specification<VehicleRoute> {

    private static final String LIKE_OPERATOR = "%";

    private VehicleRouteDto criteria;

    public VehicleRouteSpecification(VehicleRouteDto criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<VehicleRoute> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.isNotBlank(criteria.getDistillerySource())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("distillerySource")),
                    LIKE_OPERATOR + criteria.getDistillerySource().toLowerCase() + LIKE_OPERATOR));
        }
        if (StringUtils.isNotBlank(criteria.getVehicleNum())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("vehicleNum")),
                    LIKE_OPERATOR + criteria.getVehicleNum().toLowerCase() + LIKE_OPERATOR));
        }
        return andTogether(predicates, criteriaBuilder);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder builder) {
        return builder.and(predicates.toArray(new Predicate[0]));
    }
}