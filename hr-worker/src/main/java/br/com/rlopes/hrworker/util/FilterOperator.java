package br.com.rlopes.hrworker.util;

import br.com.rlopes.hrworker.enums.QueryOperator;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FilterOperator {

    private String field;
    private String value;
    private QueryOperator operator;
}
