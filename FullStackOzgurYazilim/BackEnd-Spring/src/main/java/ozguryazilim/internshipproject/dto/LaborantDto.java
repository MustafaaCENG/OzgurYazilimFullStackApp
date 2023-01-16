package ozguryazilim.internshipproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ozguryazilim.internshipproject.dao.entity.Report;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LaborantDto {

    private Long id;
    private String name;
    private String surname;
    private int hospitalNumber;
    // private List<ReportDto> reportDto;
}
