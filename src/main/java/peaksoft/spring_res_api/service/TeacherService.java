package peaksoft.spring_res_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import peaksoft.spring_res_api.dto.request.TeacherRequest;
import peaksoft.spring_res_api.dto.response.TeacherResponse;
import peaksoft.spring_res_api.exceptions.TeacherNotFoundException;
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
    private Teacher getTeacherById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new TeacherNotFoundException(
                        "Not Found with id " +id));
    }
    public TeacherResponse update(Long id, TeacherRequest teacherRequest) {
        Teacher teacher = getTeacherById(id);
        editMapper.update(teacher, teacherRequest);
        return viewMapper.viewTeacher(repository.save(teacher));
    }

    public TeacherResponse findById(Long id) {
        Teacher teacher = getTeacherById(id);
        return viewMapper.viewTeacher(teacher);
    }
    public TeacherResponse deleteById(Long id) {
        Teacher teacher = getTeacherById(id);
        repository.delete(teacher);
        return viewMapper.viewTeacher(teacher);
    }

    public List<TeacherResponse> getAllTeachers() {
        return viewMapper.view(repository.findAll());
    }


}
