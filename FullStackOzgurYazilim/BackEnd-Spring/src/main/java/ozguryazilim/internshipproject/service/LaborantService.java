package ozguryazilim.internshipproject.service;


import ozguryazilim.internshipproject.dto.LaborantDto;

import java.util.List;

public interface LaborantService {

    List<LaborantDto> getAll();

    LaborantDto save(LaborantDto laborantDto);

    LaborantDto getById(long id);

    Boolean delete(Long id);
}

