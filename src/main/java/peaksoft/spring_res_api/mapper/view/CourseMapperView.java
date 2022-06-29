package peaksoft.spring_res_api.mapper.view;

import org.springframework.stereotype.Component;
import peaksoft.spring_res_api.dto.response.CourseResponse;
import peaksoft.spring_res_api.model.Course;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseMapperView {
        public CourseResponse viewCourse(Course course) {
            if (course == null) {
                return null;
            }
            CourseResponse response = new CourseResponse();
            response.setId(course.getId());
            response.setCourseName(course.getCourseName());
            response.setDuration(course.getDuration());
            response.setCompanyName(course.getCompany().getCompanyName());
            response.setGroups(course.getGroups());
            response.setTeacher(course.getTeacher());
            response.setCreated(course.getCreated());
            return response;
        }

        public List<CourseResponse> view(List<Course> courses) {
            List<CourseResponse> responses = new ArrayList<>();
            for (Course course : courses) {
                responses.add(viewCourse(course));
            }
            return responses;
        }


}
