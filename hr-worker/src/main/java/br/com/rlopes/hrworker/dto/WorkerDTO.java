package br.com.rlopes.hrworker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDTO {

    private String name;
    private Double dailyIncome;
}
