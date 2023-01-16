package ozguryazilim.internshipproject;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InternShipProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternShipProjectApplication.class, args);
    }
    @Bean
    private static ModelMapper getModelMapper() {
        ModelMapper modelMapper= new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }
}
