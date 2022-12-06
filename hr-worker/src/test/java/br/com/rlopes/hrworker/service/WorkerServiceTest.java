package br.com.rlopes.hrworker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;

import br.com.rlopes.hrworker.entity.Worker;
import br.com.rlopes.hrworker.exception.NotFoundException;
import br.com.rlopes.hrworker.repository.WorkerRepository;
import br.com.rlopes.hrworker.util.FilterOperator;
import br.com.rlopes.hrworker.util.SpecificationQuery;

class WorkerServiceTest {

    @Mock
    private WorkerRepository workerRepositoryMock;

    @Mock
    private SpecificationQuery specificationQueryMock;

    @Mock
    private List<FilterOperator> filtersMock;

    @Mock
    private List<Worker> workersMock;

    @Mock
    private Specification<Worker> specificationMock;

    @InjectMocks
    private WorkerService workerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAll_shouldReturnAllWorkers() {
        // Arrange
        when(workerRepositoryMock.findAll(specificationMock))
            .thenReturn(workersMock);

        // Act
        var response = workerService.findAll(filtersMock);

        // Assert
        assertNotNull(response);
    }

    @Test
    void findById_IfWorkerExists_shouldReturnWorker() {
        // Arrange
        Long id = 1L;
        when(workerRepositoryMock.findById(id))
            .thenReturn(Optional.of(new Worker()));

        // Act
        var response = workerService.findById(id);

        // Assert
        assertEquals(Worker.class, response.getClass());
    }

    @Test
    void findById_IfWorkerDoesNotExist_shouldThrowsNotFoundException() {
        // Arrange
        Long id = 0L;

        // Assert
        assertThrows(NotFoundException.class, () -> {
            // Act
            workerService.findById(id);
        });
    }
}
