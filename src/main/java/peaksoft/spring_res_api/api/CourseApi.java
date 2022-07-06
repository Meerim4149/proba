package peaksoft.spring_res_api.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring_res_api.dto.request.CourseRequest;
import peaksoft.spring_res_api.dto.response.CourseResponse;
import peaksoft.spring_res_api.model.Course;
import peaksoft.spring_res_api.model.Group;
import peaksoft.spring_res_api.repository.CourseRepository;
import peaksoft.spring_res_api.repository.GroupRepository;
import peaksoft.spring_res_api.service.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
@PreAuthorize("hasAuthority(SUPER_ADMIN)")
@Tag(name = "Course API", description = "User with role admin can add, update, delete or get all courses")
public class CourseApi {

        private final CourseService service;

        @PostMapping
        @Operation(summary = "create course", description = "we can create course")
        public CourseResponse create(@RequestBody CourseRequest request) {
                return service.create(request);
        }

        @PutMapping("{id}")
        @Operation(summary = "update course", description = "we can update course")
        public CourseResponse update(@PathVariable long id, @RequestBody CourseRequest request) {
                return service.update(id, request);
        }

        @GetMapping("{id}")
        @Operation(summary = "find course", description = "we can find course by id")
        public CourseResponse findById(@PathVariable long id) {
                return service.findById(id);
        }
        @DeleteMapping("{id}")
        @Operation(summary = "delete course", description = "we can delete course by id")
        public CourseResponse delete(@PathVariable long id) {
                return service.deleteById(id);
        }

        @GetMapping
        @Operation(summary = "get all courses", description = "we can get all courses")
        public List<CourseResponse> getAllCourses() {
                return service.getAllCourses();
        }

}
