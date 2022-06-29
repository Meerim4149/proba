package peaksoft.spring_res_api.mapper.edit;

import org.springframework.stereotype.Component;
import peaksoft.spring_res_api.dto.request.StudentRequest;
import peaksoft.spring_res_api.model.Student;

import java.time.LocalDate;

@Component
public class StudentMapperEdit {
    public Student create(StudentRequest request) {
        if(request==null) {
            return null;
        }
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setEmail(request.getEmail());
        student.setLastName(request.getLastName());
        student.setStudyFormat(request.getStudyFormat());
        student.setGroupId(request.getGroupId());
        student.setCreated(LocalDate.now());
        return student;
    }

    public void update(Student student, StudentRequest request) {
        student.setFirstName(request.getFirstName());
        student.setEmail(request.getEmail());
        student.setLastName(request.getLastName());
        student.setStudyFormat(request.getStudyFormat());
        student.setGroupId(request.getGroupId());
        student.setCreated(LocalDate.now());
    }
}
