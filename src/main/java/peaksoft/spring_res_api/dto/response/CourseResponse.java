package peaksoft.spring_res_api.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import peaksoft.spring_res_api.model.Group;
import peaksoft.spring_res_api.model.Teacher;

import java.time.LocalDate;
import java.util.List;

@Getter@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CourseResponse {
    private Long id;
    private String  courseName;
    private long duration ;
    private String companyName;
    private Teacher teacher;
    private LocalDate created;


    private List<Group> groups;
}
