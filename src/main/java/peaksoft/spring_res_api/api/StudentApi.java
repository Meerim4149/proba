package peaksoft.spring_res_api.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import peaksoft.spring_res_api.dto.request.StudentRequest;
import peaksoft.spring_res_api.dto.response.StudentResponse;

import peaksoft.spring_res_api.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/students")
@Tag(name = "Student API", description = "User with role admin can add, update, delete or get all students")
public class StudentApi  {

        private final StudentService service;
        @PostMapping
        @Operation(summary = "create student", description = "we can create student")
        public StudentResponse create(@RequestBody StudentRequest request) {
                return service.create(request.getGroupId(), request);
        }

        @PostMapping("{id}")
        @Operation(summary = "update student", description = "we can update student")
        public StudentResponse update(@PathVariable long id, @RequestBody StudentRequest request) {
                return service.update(id, request);
        }

        @GetMapping("{id}")
        @Operation(summary = "find student", description = "we can find student by id")
        public StudentResponse findById(@PathVariable long id) {
                return service.findById(id);
        }
        @DeleteMapping("{id}")
        @Operation(summary = "delete student", description = "we can delete student by id")
        public StudentResponse delete(@PathVariable long id) {
                return service.deleteById(id);
        }

        @GetMapping
        @Operation(summary = "get all students", description = "we can get all students")
        public List<StudentResponse> getAllStudents() {
                return service.getAllStudents();
        }
}
