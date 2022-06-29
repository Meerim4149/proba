package peaksoft.spring_res_api.mapper.view;

import org.springframework.stereotype.Component;
import peaksoft.spring_res_api.dto.response.GroupResponse;
import peaksoft.spring_res_api.model.Group;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupMapperView {

    public GroupResponse viewGroup(Group group) {
        if(group==null) {
            return null;
        }
        GroupResponse response = new GroupResponse();
        response.setId(group.getId());
        response.setGroupName(group.getGroupName());
        response.setDateOfStart(group.getDateOfStart());
        response.setDateOfFinish(group.getDateOfFinish());
        response.setCourses(group.getCourses());
        response.setCreated(group.getCreated());
        return response;
    }

    public List<GroupResponse> view(List<Group> groups) {
        List<GroupResponse> responses = new ArrayList<>();
        for (Group group:  groups) {
            responses.add(viewGroup(group));
        }
        return responses;
    }


}
