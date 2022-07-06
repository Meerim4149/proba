package peaksoft.spring_res_api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="teachers")
@Data
@Getter@Setter
@NoArgsConstructor
public class Teacher {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "teacher_gen", sequenceName = "teacher_seq", allocationSize = 1)
        private Long id;
        private String firstName;
        private String email;
        private String lastName;
        @OneToOne(cascade={CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
        @JsonIgnore
        private Course course;

        @Transient
        private Long courseId;


        @CreatedDate
        private LocalDate created;
}
