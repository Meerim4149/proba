package peaksoft.spring_res_api.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import peaksoft.spring_res_api.model.StudyFormat;

import java.time.LocalDate;

@Getter@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private StudyFormat studyFormat;
    private String groupName;
    private LocalDate created;




}
