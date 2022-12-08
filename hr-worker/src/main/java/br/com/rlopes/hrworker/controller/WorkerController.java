package br.com.rlopes.hrworker.controller;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rlopes.hrworker.dto.WorkerDTO;
import br.com.rlopes.hrworker.enums.QueryOperator;
import br.com.rlopes.hrworker.mapper.GenericMapper;
import br.com.rlopes.hrworker.service.WorkerService;
import br.com.rlopes.hrworker.util.FilterOperator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;
    private final GenericMapper mapper;
    private Environment env;

    @GetMapping("/configs")
    public ResponseEntity<Void> getConfigs() {
        log.info("CONFIG = " + env.getProperty("test.config"));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<WorkerDTO>> findAll(
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "dailyIncome", required = false) Double dailyIncome
    ) {

        List<FilterOperator> filters = List.of(
            FilterOperator.builder()
                .field("name")
                .value(name)
                .operator(QueryOperator.LIKE).build(),
            FilterOperator.builder()
                .field("dailyIncome")
                .value(dailyIncome != null ? String.valueOf(dailyIncome) : null)
                .operator(QueryOperator.EQUALS).build()
        );

        var workers = workerService.findAll(filters);
        return ResponseEntity.ok(mapper.mapList(workers, WorkerDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerDTO> findById(@PathVariable Long id) {
        /*
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        log.info("PORT = " + env.getProperty("local.server.port"));
        var worker = workerService.findById(id);
        return ResponseEntity.ok(mapper.map(worker, WorkerDTO.class));
    }

}
