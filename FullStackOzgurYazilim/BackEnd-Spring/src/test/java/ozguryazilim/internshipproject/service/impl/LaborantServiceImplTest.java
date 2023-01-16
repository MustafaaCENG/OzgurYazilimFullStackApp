package ozguryazilim.internshipproject.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import ozguryazilim.internshipproject.dao.LaborantRepository;
import ozguryazilim.internshipproject.dao.entity.Laborant;
import ozguryazilim.internshipproject.dto.LaborantDto;

@RunWith(MockitoJUnitRunner.class)
public class LaborantServiceImplTest {

    @Mock
    private LaborantRepository laborantRepository;

    @Mock
    private ModelMapper modelMapper;

    private LaborantServiceImpl laborantService;

    @Before
    public void setUp() {
        laborantService = new LaborantServiceImpl(laborantRepository, modelMapper);
    }

    @Test
    public void testGetAll() {

        List<Laborant> laborants = Arrays.asList(new Laborant(), new Laborant());
        when(laborantRepository.findAll()).thenReturn(laborants);
        when(modelMapper.map(laborants, LaborantDto[].class)).thenReturn(new LaborantDto[0]);

        List<LaborantDto> result = laborantService.getAll();

        verify(laborantRepository).findAll();
        verify(modelMapper).map(laborants, LaborantDto[].class);
        assertThat(result).isNotNull();
    }

    @Test
    public void testSave() {

        LaborantDto laborantDto = new LaborantDto();
        Laborant laborant = new Laborant();
        when(modelMapper.map(laborantDto, Laborant.class)).thenReturn(laborant);
        when(laborantRepository.save(laborant)).thenReturn(laborant);

        LaborantDto result = laborantService.save(laborantDto);

        verify(modelMapper).map(laborantDto, Laborant.class);
        verify(laborantRepository).save(laborant);
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(laborant.getId());
    }

    @Test
    public void testGetById() {

        long id = 1L;
        Laborant laborant = new Laborant();
        when(laborantRepository.getOne(id)).thenReturn(laborant);
        when(modelMapper.map(laborant, LaborantDto.class)).thenReturn(new LaborantDto());

        LaborantDto result = laborantService.getById(id);


        verify(laborantRepository).getOne(id);
        verify(modelMapper).map(laborant, LaborantDto.class);
        assertThat(result).isNotNull();
    }

    @Test
    public void testDelete() {

        long id = 1L;

        boolean result = laborantService.delete(id);

        verify(laborantRepository).deleteById(id);
        assertThat(result).isTrue();
    }
}

