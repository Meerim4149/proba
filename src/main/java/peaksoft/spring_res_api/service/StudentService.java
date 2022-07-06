package peaksoft.spring_res_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import peaksoft.spring_res_api.dto.request.StudentRequest;
import peaksoft.spring_res_api.dto.response.StudentResponse;
import peaksoft.spring_res_api.exceptions.GroupNotFoundException;
import peaksoft.spring_res_api.exceptions.StudentNotFoundException;
import peaksoft.spring_res_api.mapper.edit.StudentMapperEdit;
import peaksoft.spring_res_api.mapper.view.StudentMapperView;
import peaksoft.spring_res_api.model.Group;
import peaksoft.spring_res_api.model.Student;
import peaksoft.spring_res_api.repository.GroupRepository;
import peaksoft.spring_res_api.repository.StudentRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapperEdit editMapper;
    private final StudentMapperView viewMapper;

    public StudentResponse create (StudentRequest studentRequest) {
        Student student = editMapper.create(studentRequest);
        repository.save(student);
        return viewMapper.viewStudent(student);
    }
    private Student getStudentById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new StudentNotFoundException(
                        "Not Found with id " +id));
    }
    public StudentResponse update(Long id, StudentRequest studentRequest) {
        Student student = getStudentById(id);
        editMapper.update(student, studentRequest);
        return viewMapper.viewStudent(repository.save(student));
    }

    public StudentResponse findById(Long id) {
        Student student = getStudentById(id);
        return viewMapper.viewStudent(student);
    }
    public StudentResponse deleteById(Long id) {
        Student student = getStudentById(id);
        repository.delete(student);
        return viewMapper.viewStudent(student);
    }

    public List<StudentResponse> getAllStudents() {
        return viewMapper.view(repository.findAll());
    }

}
