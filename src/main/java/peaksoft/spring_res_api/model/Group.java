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
@AllArgsConstructor
public class Group{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "group_gen", sequenceName = "group_seq", allocationSize = 1)
    private Long id;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Course> courses;

    @JsonIgnore
    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Student>students;

    @ManyToOne
    private Company company;

    @CreatedDate
    private LocalDate created;

    public void addStudent(Student student) {
        this.students.add(student);
    }

//    public Group(String groupName, Date dateOfStart, Date dateOfFinish) {
//        this.groupName = groupName;
//        this.dateOfStart = dateOfStart;
//        this.dateOfFinish = dateOfFinish;
//    }

//    public void setCourse(Course course) {
//        this.courses.add(course);
//    }
//    public void setStudents(Student student){
//        this.students.add(student);
//    }
}








