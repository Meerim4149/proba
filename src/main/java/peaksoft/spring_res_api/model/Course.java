package peaksoft.spring_res_api.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private long duration;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.REMOVE}, orphanRemoval = true)
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses",cascade={CascadeType.MERGE,CascadeType.REMOVE},
            fetch = FetchType.EAGER)
    private List<Group> groups;

    @ManyToOne
    private Company company;

    public void setGroup(Group group){
        this.groups.add(group);
    }
    public void addGroup(Group group){
        this.groups.add(group);
    }
    public List<Group>getGroups(){
        return groups;
    }

    @CreatedDate
    private LocalDate created;

    @Transient
    private  Long companyId;
}
