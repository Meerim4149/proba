package peaksoft.spring_res_api.mapper.edit;

import org.springframework.stereotype.Component;
import peaksoft.spring_res_api.dto.request.CourseRequest;
import peaksoft.spring_res_api.model.Course;

import java.time.LocalDate;

@Component
public class CourseMapperEdit {
    public Course create(CourseRequest request) {
        if(request==null) {
            return null;
        }
        Course course = new Course();
        course.setCourseName(request.getCourseName());
        course.setDuration(request.getDuration());
        course.setCompanyId(request.getCompanyId());
        course.setCreated(LocalDate.now());
        return course;
    }

    public void update(Course course, CourseRequest request) {
        course.setCourseName(request.getCourseName());
        course.setDuration(request.getDuration());
        course.setCompanyId(request.getCompanyId());
        course.setCreated(LocalDate.now());
    }
}
