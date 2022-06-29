package peaksoft.spring_res_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.spring_res_api.dto.request.GroupRequest;
import peaksoft.spring_res_api.dto.response.GroupResponse;
import peaksoft.spring_res_api.mapper.edit.GroupMapperEdit;
import peaksoft.spring_res_api.mapper.view.GroupMapperView;
import peaksoft.spring_res_api.model.Group;;
import peaksoft.spring_res_api.repository.GroupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository repository;
    private final GroupMapperEdit editMapper;
    private final GroupMapperView viewMapper;

    public GroupResponse create (GroupRequest groupRequest) {
        Group group = editMapper.create(groupRequest);
        repository.save(group);
        return viewMapper.viewGroup(group);
    }

    public GroupResponse update(Long id, GroupRequest groupRequest) {
        Group group = repository.findById(id).get();
        editMapper.update(group, groupRequest);
        return viewMapper.viewGroup(repository.save(group));
    }

    public GroupResponse findById(Long id) {
        Group group = repository.findById(id).get();
        return viewMapper.viewGroup(group);
    }
    public GroupResponse deleteById(Long id) {
        Group group = repository.getById(id);
        repository.delete(group);
        return viewMapper.viewGroup(group);
    }

    public List<GroupResponse> getAllGroups() {
        return viewMapper.view(repository.findAll());
    }

//    public List<GroupResponse> view(List<Group> groups) {
//        List<GroupResponse> responses = new ArrayList<>();
//        for (Group group:  groups ) {
//            responses.add(viewMapper.viewGroup(group));
//
//        }
//        return responses;
//    }
}
