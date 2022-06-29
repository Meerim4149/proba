package peaksoft.spring_res_api.model;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="teachers")
@Data
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "teacher_gen", sequenceName = "teacher_seq", allocationSize = 1)
        private Long id;
        private String firstName;
        private String email;
        private String lastName;

//        (mappedBy = "course", cascade = CascadeType.ALL,
//                fetch = FetchType.LAZY, optional = false)
        @OneToOne
        private Course course;

        public Course getCourse(){
                return course;
        }

        public void setCourse(Course course){
                this.course=course;
        }

        @Transient
        private Long courseId;

        @CreatedDate
        private LocalDate created;
}
