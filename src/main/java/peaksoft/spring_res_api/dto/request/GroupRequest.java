package peaksoft.spring_res_api.dto.request;

import lombok.Getter;
import lombok.Setter;
import peaksoft.spring_res_api.model.Course;

import java.util.List;

@Getter
@Setter
public class GroupRequest {
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
    private List<Long> courseId;

    public List<Course> courses;

}
