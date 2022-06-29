package peaksoft.spring_res_api.model;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="companies")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "company_gen", sequenceName = "company_seq", allocationSize = 1)
    private Long id;
    private String CompanyName;
    private String locatedCountry;

    @OneToMany(mappedBy = "company",cascade={CascadeType.MERGE,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Course> courses;

    @CreatedDate
    private LocalDate created;

    public void addCourse(Course course) {
        this.courses.add(course);
    }

//    public Company() {
//    }
//

//    public Company(String companyName, String locatedCountry) {
//        CompanyName = companyName;
//        this.locatedCountry = locatedCountry;
//    }
}
