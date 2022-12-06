package br.com.rlopes.hrworker.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rlopes.hrworker.entity.Worker;
import br.com.rlopes.hrworker.exception.NotFoundException;
import br.com.rlopes.hrworker.repository.WorkerRepository;
import br.com.rlopes.hrworker.util.FilterOperator;
import br.com.rlopes.hrworker.util.SpecificationQuery;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    @Transactional(readOnly = true)
    public List<Worker> findAll(List<FilterOperator> filters) {
        var specificationQuery = new SpecificationQuery();
        var spec = specificationQuery.<Worker>getSpec(filters);
        return workerRepository.findAll(spec);
    }

    @Transactional(readOnly = true)
    public Worker findById(Long id) {
        return workerRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Worker not found."));
    }
}
