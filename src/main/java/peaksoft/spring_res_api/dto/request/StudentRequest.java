package peaksoft.spring_res_api.dto.request;

import lombok.Getter;
import lombok.Setter;
import peaksoft.spring_res_api.model.StudyFormat;

@Getter @Setter
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private StudyFormat studyFormat;
    private Long groupId;
}
