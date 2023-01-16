package ozguryazilim.internshipproject.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ozguryazilim.internshipproject.dto.ReportDto;
import ozguryazilim.internshipproject.service.impl.ReportServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReportController.class)
public class ReportControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReportServiceImpl reportService;

    @Test
    public void testGetAllReports() throws Exception {
        ReportDto report1 = new ReportDto();
        report1.setId(1L);
        report1.setName("Report 1");
        report1.setDescription("Description of report 1");

        ReportDto report2 = new ReportDto();
        report2.setId(2L);
        report2.setName("Report 2");
        report2.setDescription("Description of report 2");

        List<ReportDto> reports = Arrays.asList(report1, report2);

        when(reportService.getAll()).thenReturn(reports);

        mockMvc.perform(get("/api/reports")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Report 1")))
                .andExpect(jsonPath("$[0].description", is("Description of report 1")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Report 2")))
                .andExpect(jsonPath("$[1].description", is("Description of report 2")));
    }

    @Test
    public void testGetReportById() throws Exception {
        ReportDto report = new ReportDto();
        report.setId(1L);
        report.setName("Report 1");
        report.setDescription("Description of report 1");

        when(reportService.getById(1L)).thenReturn(report);

        mockMvc.perform(get("/api/reports/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Report 1")))
                .andExpect(jsonPath("$.description", is("Description of report 1")));
    }



    @Test
    public void testGetReportsBySearch() throws Exception {
        ReportDto report1 = new ReportDto();
        report1.setId(1L);
        report1.setName("Report 1");
        report1.setDescription("Description of report 1");

        ReportDto report2 = new ReportDto();
        report2.setId(2L);
        report2.setName("Report 2");
        report2.setDescription("Description of report 2");

        List<ReportDto> reports = Arrays.asList(report1, report2);

        when(reportService.getBySearch("report")).thenReturn(reports);

        mockMvc.perform(get("/api/reports/search/report")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Report 1")))
                .andExpect(jsonPath("$[0].description", is("Description of report 1")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Report 2")))
                .andExpect(jsonPath("$[1].description", is("Description of report 2")));
    }



    @Test
    public void testGetReportsByDateQuery() throws Exception {
        ReportDto report1 = new ReportDto();
        report1.setId(1L);
        report1.setName("Report 1");
        report1.setDescription("Description of report 1");

        ReportDto report2 = new ReportDto();
        report2.setId(2L);
        report2.setName("Report 2");
        report2.setDescription("Description of report 2");

        List<ReportDto> reports = Arrays.asList(report1, report2);

        when(reportService.getByDateQuery()).thenReturn(reports);

        mockMvc.perform(get("/api/reports/queryDate")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Report 1")))
                .andExpect(jsonPath("$[0].description", is("Description of report 1")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Report 2")))
                .andExpect(jsonPath("$[1].description", is("Description of report 2")));
    }


}
