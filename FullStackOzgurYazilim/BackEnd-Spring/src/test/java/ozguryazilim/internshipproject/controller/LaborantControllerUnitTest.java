package ozguryazilim.internshipproject.controller;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


import ozguryazilim.internshipproject.dto.LaborantDto;
import ozguryazilim.internshipproject.service.impl.LaborantServiceImpl;

@ExtendWith(MockitoExtension.class)
class LaborantControllerTest {

    @Mock
    private LaborantServiceImpl laborantService;

    @InjectMocks
    private LaborantController laborantController;

    @Test
    void testGetAllLaborants() {

        List<LaborantDto> laborants = List.of(
                new LaborantDto(1L, "John", "Doe", 1324657),
                new LaborantDto(2L, "Jane", "Doe", 1234567)
        );
        when(laborantService.getAll()).thenReturn(laborants);

        ResponseEntity<List<LaborantDto>> response = laborantController.getAll();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(laborants);
    }

    @Test
    void testGetLaborantById() {

        Long id = 1L;
        LaborantDto laborant = new LaborantDto(id, "John", "Doe", 7654321);
        when(laborantService.getById(id)).thenReturn(laborant);

        ResponseEntity<LaborantDto> response = laborantController.getById(id);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(laborant);
    }


    @Test
    void testGetLaborantById_NotFound() {

        Long id = 1L;
        when(laborantService.getById(id)).thenReturn(null);

        ResponseEntity<LaborantDto> response = laborantController.getById(id);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isNull();
    }

    @Test
    void testCreateLaborant() {

        LaborantDto laborantDto = new LaborantDto(null, "John", "Doe", 1234657);
        LaborantDto createdLaborant = new LaborantDto(1L, "John", "Doe", 1234657);
        when(laborantService.save(laborantDto)).thenReturn(createdLaborant);

        ResponseEntity<LaborantDto> response = laborantController.createLaborant(laborantDto);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(createdLaborant);
    }

}
