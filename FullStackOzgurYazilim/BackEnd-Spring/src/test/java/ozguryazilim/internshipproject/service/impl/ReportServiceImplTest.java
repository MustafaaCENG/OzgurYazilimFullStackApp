package ozguryazilim.internshipproject.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
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
import ozguryazilim.internshipproject.dao.ReportRepository;
import ozguryazilim.internshipproject.dao.entity.Report;
import ozguryazilim.internshipproject.dto.ReportDto;

@RunWith(MockitoJUnitRunner.class)
public class ReportServiceImplTest {

    @Mock
    private ReportRepository reportRepository;

    @Mock
    private LaborantRepository laborantRepository;

    @Mock
    private ModelMapper modelMapper;

    private ReportServiceImpl reportService;

    @Before
    public void setUp() {
        reportService = new ReportServiceImpl(reportRepository, laborantRepository, modelMapper);
    }

    @Test
    public void testGetAll() {

        List<Report> reports = Arrays.asList(new Report(), new Report());
        when(reportRepository.findAll()).thenReturn(reports);
        when(modelMapper.map(reports, ReportDto[].class)).thenReturn(new ReportDto[0]);

        List<ReportDto> result = reportService.getAll();

        verify(reportRepository).findAll();
        verify(modelMapper).map(reports, ReportDto[].class);
        assertThat(result).isNotNull();
    }

    @Test
    public void testGetById() {

        Long id = 1L;
        Report report = new Report();
        when(reportRepository.getReferenceById(id)).thenReturn(report);
        when(modelMapper.map(report, ReportDto.class)).thenReturn(new ReportDto());

        ReportDto result = reportService.getById(id);

        verify(reportRepository).getReferenceById(id);
        verify(modelMapper).map(report, ReportDto.class);
        assertThat(result).isNotNull();
    }

    @Test
    public void testGetBySearch() {
        String value = "test";
        List<Report> reports1 = Arrays.asList(new Report());
        List<Report> reports2 = Arrays.asList(new Report());
        List<Report> reports3 = Arrays.asList(new Report());
        List<Report> reports4 = Arrays.asList(new Report());
        when(reportRepository.findByNameContainingIgnoreCase(value)).thenReturn(reports1);
        when(reportRepository.findBySurnameContainingIgnoreCase(value)).thenReturn(reports2);
        when(reportRepository.findByLaborantSurnameContainingIgnoreCase(value)).thenReturn(reports3);
        when(reportRepository.findByLaborantNameContainingIgnoreCase(value)).thenReturn(reports4);
        when(modelMapper.map(any(), any())).thenReturn(new ReportDto[0]);

        List<ReportDto> result = reportService.getBySearch(value);

        verify(reportRepository).findByNameContainingIgnoreCase(value);
        verify(reportRepository).findBySurnameContainingIgnoreCase(value);
        verify(reportRepository).findByLaborantSurnameContainingIgnoreCase(value);
        verify(reportRepository).findByLaborantNameContainingIgnoreCase(value);
        verify(modelMapper).map(any(), any());
        assertThat(result).isNotNull();
    }

    @Test
    public void testGetByDateQuery() {

        List<Report> reports = Arrays.asList(new Report(), new Report());
        when(reportRepository.findAll()).thenReturn(reports);
        when(modelMapper.map(reports, ReportDto[].class)).thenReturn(new ReportDto[0]);

        List<ReportDto> result = reportService.getByDateQuery();

        verify(reportRepository).findAll();
        verify(modelMapper).map(reports, ReportDto[].class);
        assertThat(result).isNotNull();
    }
}