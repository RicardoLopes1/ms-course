package br.com.rlopes.hrworker.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import br.com.rlopes.hrworker.dto.WorkerDTO;
import br.com.rlopes.hrworker.entity.Worker;
import br.com.rlopes.hrworker.mapper.GenericMapper;
import br.com.rlopes.hrworker.service.WorkerService;
import br.com.rlopes.hrworker.util.FilterOperator;

class WorkerControllerTest {

    @Mock
    private WorkerService workerServiceMock;

    @Mock
    private GenericMapper mapperMock;

    @Mock
    private List<FilterOperator> filtersMock;

    @Mock
    private List<Worker> workersMock;

    @Mock
    private List<WorkerDTO> workersDtoMock;

    @InjectMocks
    private WorkerController workerController;

    private Worker worker;
    private WorkerDTO workerDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Long id = 1L;
        String name = "João";
        Double dailyIncome = 200.0;
        worker = Worker.builder()
            .id(id)
            .name(name)
            .dailyIncome(dailyIncome)
            .build();
        workerDto = WorkerDTO.builder()
            .name(name)
            .dailyIncome(dailyIncome)
            .build();
    }

    @Test
    void findAll_shouldReturnAllWorkersAndStatus200() {
        // Arrange
        when(workerServiceMock.findAll(filtersMock))
            .thenReturn(workersMock);
        when(mapperMock.mapList(workersMock, WorkerDTO.class))
            .thenReturn(workersDtoMock);

        Double dailyIncome = 100.0;

        // Act
        var response = workerController.findAll(anyString(), dailyIncome);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findById_IfWorkerExists_shouldReturnWorkerAndStatusOK() {
        // Arrange
        Long id = 1L;
        when(workerServiceMock.findById(id))
            .thenReturn(worker);
        when(mapperMock.map(worker, WorkerDTO.class))
            .thenReturn(workerDto);

        // Act
        var response = workerController.findById(id);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        var body = response.getBody();
        assertNotNull(body);
        assertEquals(WorkerDTO.class, body.getClass());
    }
}
