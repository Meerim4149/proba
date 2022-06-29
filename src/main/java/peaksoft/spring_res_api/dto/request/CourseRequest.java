package peaksoft.spring_res_api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CourseRequest {
    private String courseName;
    private long duration;
    private Long companyId;
}
