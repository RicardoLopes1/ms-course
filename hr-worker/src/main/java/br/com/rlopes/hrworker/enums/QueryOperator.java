package br.com.rlopes.hrworker.enums;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public enum QueryOperator {

    EQUALS {
        @Override
        public Predicate getPredicate(CriteriaBuilder builder, Path<String> field, String value) {
            return builder.equal(field, value);
        }
    },
    GREATER_THAN {
        @Override
        public Predicate getPredicate(CriteriaBuilder builder, Path<String> field, String value) {
            return builder.greaterThan(field, value);
        }
    },
    IN {
        @Override
        public Predicate getPredicate(CriteriaBuilder builder, Path<String> field, String value) {
            return builder.in(field).value(value);
        }
    },
    LESS_THAN {
        @Override
        public Predicate getPredicate(CriteriaBuilder builder, Path<String> field, String value) {
            return builder.lessThan(field, value);
        }
    },
    LIKE {
        @Override
        public Predicate getPredicate(CriteriaBuilder builder, Path<String> field, String value) {
            return builder.like(field, value);
        }
    },
    NOT_EQUALS {
        @Override
        public Predicate getPredicate(CriteriaBuilder builder, Path<String> field, String value) {
            return builder.notEqual(field, value);
        }
    };

    public abstract Predicate getPredicate(CriteriaBuilder builder, Path<String> field, String value);
}
