package peaksoft.spring_res_api.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring_res_api.dto.request.GroupRequest;
import peaksoft.spring_res_api.dto.response.GroupResponse;
import peaksoft.spring_res_api.service.GroupService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/groups")
@Tag(name = "Group API", description = "User with role admin can add, update, delete or get all groups")
public class GroupApi {

        private final GroupService service;

        @PostMapping
        @Operation(summary = "create group", description = "we can create group")
        public GroupResponse create(@RequestBody GroupRequest request) {
                return service.create(request);
        }

        @PostMapping("{id}")
        @Operation(summary = "update group", description = "we can update group")
        public GroupResponse update(@PathVariable long id, @RequestBody GroupRequest request) {
                return service.update(id, request);
        }

        @GetMapping("{id}")
        @Operation(summary = "find group", description = "we can find group by id")
        public GroupResponse findById(@PathVariable long id) {
                return service.findById(id);
        }

        @DeleteMapping("{id}")
        @Operation(summary = "delete group", description = "we can delete group by id")
        public GroupResponse delete(@PathVariable long id) {
                return service.deleteById(id);
        }

        @GetMapping
        @Operation(summary = "get all groups", description = "we can get all groups")
        public List<GroupResponse> getAllGroups() {
                return service.getAllGroups();
        }
}