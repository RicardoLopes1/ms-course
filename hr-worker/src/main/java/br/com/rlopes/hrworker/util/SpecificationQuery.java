package br.com.rlopes.hrworker.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

public class SpecificationQuery {

    public <T> Specification<T> getSpec(List<FilterOperator> filters) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();

            filters.stream().filter(filter -> filter.getValue() != null)
                    .forEach(filter -> {
                        var aField = root.<String>get(filter.getField());
                        var aPredicate = filter.getOperator().getPredicate(builder, aField, filter.getValue());
                        predicates.add(aPredicate);
                    });

            var predicatesArray = predicates.toArray(new Predicate[predicates.size()]);
            return builder.and(predicatesArray);
        };
    }
}
