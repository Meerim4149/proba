package peaksoft.spring_res_api.mapper.edit;

import org.springframework.stereotype.Component;
import peaksoft.spring_res_api.dto.request.TeacherRequest;
import peaksoft.spring_res_api.model.Teacher;

import java.time.LocalDate;

@Component
public class TeacherMapperEdit {
    public Teacher create(TeacherRequest request) {
        if(request==null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setFirstName(request.getFirstName());
        teacher.setEmail(request.getEmail());
        teacher.setLastName(request.getLastName());
        teacher.setCourseId(request.getCourseId());
        teacher.setCreated(LocalDate.now());
        return teacher;
    }

    public void update(Teacher teacher, TeacherRequest request) {
        teacher.setFirstName(request.getFirstName());
        teacher.setEmail(request.getEmail());
        teacher.setLastName(request.getLastName());
        teacher.setCourseId(request.getCourseId());
        teacher.setCreated(LocalDate.now());
    }

}
