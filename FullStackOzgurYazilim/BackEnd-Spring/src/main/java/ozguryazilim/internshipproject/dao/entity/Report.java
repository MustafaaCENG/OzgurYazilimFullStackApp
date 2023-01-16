package ozguryazilim.internshipproject.dao.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "report")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Report {

    @Id
    @SequenceGenerator(name = "rep_id_creator",allocationSize = 2,initialValue = 100000)
    @GeneratedValue(generator = "rep_id_creator")
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "fileno", unique = true)
    private Long fileNo;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "nationalid")
    private Long nationalID;

    @Column(name = "disease")
    private String disease;

    @Column(name = "description")
    private String description;


    @Column(name = "createddate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    @Column(name = "photourl")
    private String photoUrl;

    @ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @JoinColumn(name = "laborant_id")
    private Laborant laborant;


    @Column(name = "adminFirstName")
    private String adminFirstName;

    @Column(name = "adminLastName")
    private String adminLastName;

    public int compareTo(Report report) {
        if (getCreatedDate() == null || report.getCreatedDate() == null)
            return 0;
        return getCreatedDate().compareTo(report.getCreatedDate());
    }


}
