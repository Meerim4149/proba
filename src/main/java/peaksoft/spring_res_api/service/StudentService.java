package peaksoft.spring_res_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.spring_res_api.dto.request.StudentRequest;
import peaksoft.spring_res_api.dto.response.StudentResponse;
import peaksoft.spring_res_api.exceptions.GroupNotFoundException;
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
    private final GroupRepository groupRepository;
    private final StudentMapperEdit editMapper;
    private final StudentMapperView viewMapper;

    public StudentResponse create (Long id, StudentRequest studentRequest) {
        Group group = groupRepository.findById(id).orElseThrow(()->new GroupNotFoundException(
                "Group with id " + id + " not found!"
        ));

        Student student = editMapper.create(studentRequest);

        group.addStudent(student);
        student.setGroup(group);
        repository.save(student);
        return viewMapper.viewStudent(student);
    }
    public StudentResponse update(Long id, StudentRequest studentRequest) {
        Student student = repository.findById(id).get();
        editMapper.update(student, studentRequest);
        return viewMapper.viewStudent(repository.save(student));
    }

    public StudentResponse findById(Long id) {
        Student student = repository.findById(id).get();
        return viewMapper.viewStudent(student);
    }
    public StudentResponse deleteById(Long id) {
        Student student = repository.getById(id);
        repository.delete(student);
        return viewMapper.viewStudent(student);
    }
    //    public List<StudentResponse> view(List<Student> students) {
//        List<StudentResponse> responses = new ArrayList<>();
//        for (Student student:  students ) {
//            responses.add(viewMapper.viewStudent(student));
//
//        }
//        return responses;
//    }
    public List<StudentResponse> getAllStudents() {
        return viewMapper.view(repository.findAll());
    }

//    private List<Student> search(String name, Pageable pageable) {
//        String text = name==null? "": name;
//        return repository.searchAndPagination(text.toUpperCase(), pageable);
//    }
//    public StudentResponseView getAllStudentsPagination(String text, int page, int size) {
//        StudentResponseView responseView = new StudentResponseView();
//        Pageable pageable = PageRequest.of(page-1, size);
//        responseView.setResponses(view(search(text, pageable)));
//        return responseView;
//
//   }
}
