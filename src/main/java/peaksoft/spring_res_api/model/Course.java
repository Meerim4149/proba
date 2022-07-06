package peaksoft.spring_res_api.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_id_generator",
            sequenceName = "course_seq", allocationSize = 1)
    private Long id;
    private String courseName;
    private long duration;

    @OneToOne(mappedBy = "course",orphanRemoval = true)
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses",cascade={ CascadeType.MERGE, CascadeType.PERSIST} ,fetch=FetchType.LAZY)
    private List<Group> groups = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH})
    private Company company;

    public void setGroup(Group group){
        this.groups.add(group);
    }

    public List<Group>getGroups(){
        return groups;
    }

    @CreatedDate
    private LocalDate created;

    @Transient
    private  Long companyId;

//    public void addGroup(Group group) {
//        this.groups.add(group);
//    }
}
