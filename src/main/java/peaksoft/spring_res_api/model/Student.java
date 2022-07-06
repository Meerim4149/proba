package peaksoft.spring_res_api.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="students")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_gen",sequenceName = "student_seq",allocationSize = 1)
    private Long id;
    private String firstName;
    private String email;
    private StudyFormat studyFormat;
    private String lastName;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Group group;

    @Transient
    private Long groupId;

    @CreatedDate
    private LocalDate created;

//    public Group getGroup(){
//        return group;
//    }
//
//    public void  setGroup(Group group){
//        this.group =group;
//    }




//    public Student(String firstName, String email, StudyFormat studyFormat) {
//        this.firstName = firstName;
//        this.email = email;
//        this.studyFormat = studyFormat;
//    }
}
