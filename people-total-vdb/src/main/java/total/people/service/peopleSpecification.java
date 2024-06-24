package total.people.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import total.people.entity.People;

public class peopleSpecification {

    public static Specification<People> getSpecifications(Map<String, String> includeFilters, Map<String, String> excludeFilters) {
        return new Specification<People>() {
            @Override
            public Predicate toPredicate(Root<People> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                includeFilters.forEach((key, value) -> {
                    if (value != null && !value.trim().isEmpty()) {
                        // Adjust the logic to handle partial search for employee_size
                        if (key.equals("employee_size")) {
                            // Split values by comma and create predicates for each value
                            String[] sizeValues = value.split(",");
                            List<Predicate> sizePredicates = new ArrayList<>();
                            for (String size : sizeValues) {
                                sizePredicates.add(criteriaBuilder.like(root.get(key), "%" + size.trim() + "%"));
                            }
                            // Combine size predicates with OR
                            predicates.add(criteriaBuilder.or(sizePredicates.toArray(new Predicate[0])));
                        } else {
                            // Split values by comma and create predicates for each value
                            String[] values = value.split(",");
                            List<Predicate> valuePredicates = new ArrayList<>();
                            for (String v : values) {
                                valuePredicates.add(criteriaBuilder.equal(root.get(key), v.trim()));
                            }
                            // Combine predicates with OR
                            predicates.add(criteriaBuilder.or(valuePredicates.toArray(new Predicate[0])));
                        }
                    }
                });

                // Exclude filters
                excludeFilters.forEach((key, value) -> {
                    if (value != null && !value.trim().isEmpty()) {
                        // Split values by comma and create predicates for each value
                        String[] values = value.split(",");
                        List<Predicate> valuePredicates = new ArrayList<>();
                        for (String v : values) {
                            valuePredicates.add(criteriaBuilder.notEqual(root.get(key), v.trim()));
                        }
                        // Combine predicates with AND
                        predicates.add(criteriaBuilder.and(valuePredicates.toArray(new Predicate[0])));
                    }
                });

                // Combine all predicates with AND
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
