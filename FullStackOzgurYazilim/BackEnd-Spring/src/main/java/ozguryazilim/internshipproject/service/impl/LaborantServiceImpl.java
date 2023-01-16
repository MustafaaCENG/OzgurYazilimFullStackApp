package ozguryazilim.internshipproject.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ozguryazilim.internshipproject.dao.LaborantRepository;
import ozguryazilim.internshipproject.dao.entity.Laborant;
import ozguryazilim.internshipproject.dto.LaborantDto;
import ozguryazilim.internshipproject.service.LaborantService;

import java.util.Arrays;
import java.util.List;


@Service
public class LaborantServiceImpl implements LaborantService {

    @Autowired
    private LaborantRepository laborantRepository;
    @Autowired
    private ModelMapper modelMapper;

    public LaborantServiceImpl(LaborantRepository laborantRepository, ModelMapper modelMapper) {
        this.laborantRepository = laborantRepository;
        this.modelMapper = modelMapper;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public List<LaborantDto> getAll() {
        return Arrays.asList(modelMapper.map(laborantRepository.findAll(), LaborantDto[].class));
    }


    @Override
    public LaborantDto save(LaborantDto laborantDto) {
        //Project checkProject= projectRepository.getOne(projectDto.getId());
        //if(checkProject!=null)
        //	throw new  IllegalArgumentException("Project Code Already Exist");
        Laborant laborant = modelMapper.map(laborantDto, Laborant.class);
        laborant = laborantRepository.save(laborant);
        laborantDto.setId(laborant.getId());

        return laborantDto;
    }

    @Override
    public LaborantDto getById(long id) {
        Laborant laborant = laborantRepository.getOne(id);
        return modelMapper.map(laborant, LaborantDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        laborantRepository.deleteById(id);
        return Boolean.TRUE;
    }

}
