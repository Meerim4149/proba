package peaksoft.spring_res_api.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TeacherResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String courseName;
    private LocalDate created;
}
