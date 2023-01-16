package ozguryazilim.internshipproject.dao.entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "laborant")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Laborant {

    @Id
    @SequenceGenerator(name = "lab_id_creator",allocationSize = 2,initialValue = 100000)
    @GeneratedValue(generator = "lab_id_creator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "hospital_number")
    private Long hospitalNumber;

    @OneToMany(mappedBy = "laborant",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Report> report = new ArrayList<>();
}
