package peaksoft.spring_res_api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter@Setter
public class TeacherRequest {

    private String firstName;
    private String lastName;
    private String email;
    private Long courseId;
}
