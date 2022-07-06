package peaksoft.spring_res_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="groups")
@Getter@Setter
@NoArgsConstructor
public class Group{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "group_gen", sequenceName = "group_seq", allocationSize = 1)
    private Long id;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;

    @ManyToMany(cascade= {CascadeType.MERGE, CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Course> courses= new ArrayList<>();

    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Student>students= new ArrayList<>();


    @CreatedDate
    private LocalDate created;

}








