package ozguryazilim.internshipproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ozguryazilim.internshipproject.dao.entity.Laborant;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportDto {

    private Long id;
    private Long fileNo;
    private String name;
    private String surname;
    private Long nationalID;
    private String disease;
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    private String photoUrl;
    private Long laborantId;
    private String adminFirstName;
    private String adminLastName;
}
