package ozguryazilim.internshipproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import ozguryazilim.internshipproject.dao.ReportRepository;
import ozguryazilim.internshipproject.dao.entity.Report;
import ozguryazilim.internshipproject.dto.ReportDto;

import java.util.Date;
import java.util.List;

public interface ReportService {

    List<ReportDto> getAll();

    ReportDto getById(Long id);

    ReportDto create(ReportDto reportDto);

    ReportDto update(Long id, ReportDto reportDto);

    List<ReportDto> getBySearch(String value);

    List<ReportDto> getByDateQuery();
    Boolean delete(Long id);
}
