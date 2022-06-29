package peaksoft.spring_res_api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import peaksoft.spring_res_api.model.Course;
import peaksoft.spring_res_api.model.Student;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GroupResponse {
    private Long id ;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
    private LocalDate created;
    private List<String> coursesName;
    @JsonIgnore
    private List<Course>courses;
    private List<Student> students;





    }
