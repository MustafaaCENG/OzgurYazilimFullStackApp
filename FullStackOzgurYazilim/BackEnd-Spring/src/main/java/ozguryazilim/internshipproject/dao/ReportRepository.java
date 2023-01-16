package ozguryazilim.internshipproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ozguryazilim.internshipproject.dao.entity.Report;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {

    List<Report> findByNameContainingIgnoreCase(String data);
    List<Report> findBySurnameContainingIgnoreCase(String data);
    List<Report> findByLaborantSurnameContainingIgnoreCase(String data);
    List<Report> findByLaborantNameContainingIgnoreCase(String data);

    // List<Report> queryByCreatedDate();

}
