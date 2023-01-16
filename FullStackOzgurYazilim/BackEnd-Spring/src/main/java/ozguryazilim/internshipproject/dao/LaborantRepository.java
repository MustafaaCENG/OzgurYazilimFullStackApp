package ozguryazilim.internshipproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ozguryazilim.internshipproject.dao.entity.Laborant;
import ozguryazilim.internshipproject.dto.LaborantDto;

@Repository
public interface LaborantRepository extends JpaRepository<Laborant,Long> {

    Laborant findByHospitalNumber(Long id);
}
