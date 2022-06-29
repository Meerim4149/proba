package peaksoft.spring_res_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import peaksoft.spring_res_api.dto.request.TeacherRequest;
import peaksoft.spring_res_api.dto.response.TeacherResponse;
import peaksoft.spring_res_api.mapper.edit.TeacherMapperEdit;
import peaksoft.spring_res_api.mapper.view.TeacherMapperView;
import peaksoft.spring_res_api.model.Teacher;
import peaksoft.spring_res_api.repository.TeacherRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository repository;
    private final TeacherMapperEdit editMapper;
    private final TeacherMapperView viewMapper;

    public TeacherResponse create (TeacherRequest teacherRequest) {
        Teacher teacher = editMapper.create(teacherRequest);
        repository.save(teacher);
        return viewMapper.viewTeacher(teacher);
    }
    public TeacherResponse update(Long id, TeacherRequest teacherRequest) {
        Teacher teacher = repository.findById(id).get();
        editMapper.update(teacher, teacherRequest);
        return viewMapper.viewTeacher(repository.save(teacher));
    }

    public TeacherResponse findById(Long id) {
        Teacher teacher = repository.findById(id).get();
        return viewMapper.viewTeacher(teacher);
    }
    public TeacherResponse deleteById(Long id) {
        Teacher teacher = repository.getById(id);
        repository.delete(teacher);
        return viewMapper.viewTeacher(teacher);
    }

    public List<TeacherResponse> getAllTeachers() {
        return viewMapper.view(repository.findAll());
    }

//    public List<TeacherResponse> view(List<Teacher> teachers) {
//        List<TeacherResponse> responses = new ArrayList<>();
//        for (Teacher teacher:  teachers ) {
//            responses.add(viewMapper.viewTeacher(teacher));
//
//        }
//        return responses;
//    }
}
