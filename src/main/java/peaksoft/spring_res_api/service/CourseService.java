package peaksoft.spring_res_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.spring_res_api.dto.request.CourseRequest;
import peaksoft.spring_res_api.dto.response.CourseResponse;
import peaksoft.spring_res_api.mapper.edit.CourseMapperEdit;
import peaksoft.spring_res_api.mapper.view.CourseMapperView;
import peaksoft.spring_res_api.model.Company;
import peaksoft.spring_res_api.model.Course;
import peaksoft.spring_res_api.repository.CompanyRepository;
import peaksoft.spring_res_api.repository.CourseRepository;
import peaksoft.spring_res_api.exceptions.CompanyNotFoundException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseService {

    private final CompanyRepository companyRepository;
    private final CourseRepository repository;
    private final CourseMapperEdit editMapper;
    private final CourseMapperView viewMapper;

    public CourseResponse create (Long id, CourseRequest courseRequest) {
        Company company = companyRepository.findById(id).orElseThrow(()->new CompanyNotFoundException(
                "Company with id " + id + " not found!"
        ));

        Course course = editMapper.create(courseRequest);

        company.addCourse(course);
        course.setCompany(company);
        repository.save(course);
        return viewMapper.viewCourse(course);
    }
    public CourseResponse update(Long id, CourseRequest courseRequest) {
        Course course = repository.findById(id).get();
        editMapper.update(course, courseRequest);
        return viewMapper.viewCourse(repository.save(course));
    }

    public CourseResponse findById(Long id) {
        Course course = repository.findById(id).get();
        return viewMapper.viewCourse(course);
    }
    public CourseResponse deleteById(Long id) {
        Course course = repository.getById(id);
        repository.delete(course);
        return viewMapper.viewCourse(course);
    }

    public List<CourseResponse> getAllCourses() {
        return viewMapper.view(repository.findAll());
    }

//    public List<CourseResponse> view(List<Course> courses) {
//        List<CourseResponse> responses = new ArrayList<>();
//        for (Course course:  courses ) {
//            responses.add(viewMapper.viewCourse(course));
//
//        }
//        return responses;
//    }
}
