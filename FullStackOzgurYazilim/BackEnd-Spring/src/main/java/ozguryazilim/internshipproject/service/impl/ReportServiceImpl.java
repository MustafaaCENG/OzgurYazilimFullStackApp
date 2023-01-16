package ozguryazilim.internshipproject.service.impl;

import javax.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import ozguryazilim.internshipproject.dao.LaborantRepository;
import ozguryazilim.internshipproject.dao.ReportRepository;
import ozguryazilim.internshipproject.dao.entity.Laborant;
import ozguryazilim.internshipproject.dao.entity.Report;
import ozguryazilim.internshipproject.dto.ReportDto;
import ozguryazilim.internshipproject.service.ReportService;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private LaborantRepository laborantRepository;

    @Autowired
    private ModelMapper modelMapper;


    // I add this constructor for testing
    public ReportServiceImpl(ReportRepository reportRepository, LaborantRepository laborantRepository, ModelMapper modelMapper) {
        this.reportRepository = reportRepository;
        this.laborantRepository=laborantRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ReportDto> getAll() {
        List<Report> data = reportRepository.findAll();
        return Arrays.asList(modelMapper.map(data, ReportDto[].class));
    }

    @Override
    public ReportDto getById(Long id) {
        Report p = reportRepository.getReferenceById(id);
        return modelMapper.map(p, ReportDto.class);
    }
    @Override
    public List<ReportDto> getBySearch(String value){
        List <Report> data1 = reportRepository.findByNameContainingIgnoreCase(value);
        List <Report> data2 = reportRepository.findBySurnameContainingIgnoreCase(value);
        List <Report> data3 = reportRepository.findByLaborantSurnameContainingIgnoreCase(value);
        List <Report> data4 = reportRepository.findByLaborantNameContainingIgnoreCase(value);
        List <Report> data = new ArrayList<>();
        data.addAll(data1);
        data.addAll(data2);
        data.addAll(data3);
        data.addAll(data4);
        return Arrays.asList(modelMapper.map(data, ReportDto[].class));
    }

    @Override
    public List<ReportDto> getByDateQuery(){
        List <Report> data = reportRepository.findAll();
        data.sort(Report::compareTo);
        return Arrays.asList(modelMapper.map(data, ReportDto[].class));
    }
  @Override
  public ReportDto create(ReportDto reportDto) {
      Report p = modelMapper.map(reportDto, Report.class);
      Optional<Laborant> laborant = laborantRepository.findById(reportDto.getLaborantId());
      if(!laborant.isPresent())
          throw new RuntimeException("not found");
         long millis=System.currentTimeMillis();
         java.sql.Date date=new java.sql.Date(millis+10800000);
       p.setCreatedDate(date);
       p.setLaborant(laborant.get());
       p.setAdminFirstName( laborant.get().getName());
       p.setAdminLastName( laborant.get().getSurname());
      laborant.get().getReport().add(p);
      //Long id = p.getLaborant().getId();
      // Laborant laborant = laborantRepository.findByHospitalNumber(reportDto.getLaborantid());
      // laborant.getReport().add(p);
      p = reportRepository.save(p);
      reportDto.setId(p.getId());
      return reportDto;
  }



 // public ReportDto create(ReportDto reportDto) {
 //     // Retrieve the Laborant with the specified id
 //     Optional<Laborant> laborant = laborantRepository.findById(reportDto.getLaborantid());

 //     // Create a new Report object and set its fields
 //     Report report = new Report();
 //     report.setFileNo(reportDto.getFileNo());
 //     report.setNameAndSurname(reportDto.getNameAndSurname());
 //     report.setNationalID(reportDto.getNationalID());
 //     report.setDisease(reportDto.getDisease());
 //     report.setDescription(reportDto.getDescription());
 //     report.setCreatedDate(reportDto.getCreatedDate());
 //     report.setPhotoUrl(reportDto.getPhotoUrl());

 //     // Set the Laborant for the Report
 //     report.setLaborant(laborant);

 //     // Save the Report to the database
 //     reportRepository.save(report);

 //     // Return the saved Report
 //     return reportDto;
 // }

    @Override
    public ReportDto update(Long id, ReportDto reportDto) {
        Report reportDb = reportRepository.getReferenceById(id);
        if(reportDb == null)
          throw new IllegalArgumentException("Note Does Not Exist ID:" + id);
        reportDb.setFileNo(reportDto.getFileNo());
        reportDb.setName(reportDto.getName());
        reportDb.setSurname(reportDto.getSurname());
        reportDb.setNationalID(reportDto.getNationalID());
        reportDb.setDisease(reportDto.getDisease());
        reportDb.setDescription(reportDto.getDescription());
        reportDb.setCreatedDate(reportDto.getCreatedDate());
        reportDb.setPhotoUrl(reportDto.getPhotoUrl());
        reportRepository.save(reportDb);
        return modelMapper.map(reportDb, ReportDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        reportRepository.deleteById(id);
        return true;
    }
}
