package peaksoft.spring_res_api.model;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="companies")
@Getter@Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "company_gen", sequenceName = "company_seq", allocationSize = 1)
    private Long id;
    private String CompanyName;
    private String locatedCountry;

    @OneToMany(mappedBy = "company",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<Course> courses = new ArrayList<>();

    @CreatedDate
    private LocalDate created;


}
