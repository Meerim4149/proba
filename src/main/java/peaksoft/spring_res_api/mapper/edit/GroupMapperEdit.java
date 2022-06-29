package peaksoft.spring_res_api.mapper.edit;

import org.springframework.stereotype.Component;
import peaksoft.spring_res_api.dto.request.GroupRequest;
import peaksoft.spring_res_api.model.Group;
import peaksoft.spring_res_api.repository.GroupRepository;

import java.time.LocalDate;

@Component
public class GroupMapperEdit {

        private final GroupRepository groupRepository;

        public GroupMapperEdit(GroupRepository groupRepository) {
            this.groupRepository = groupRepository;
        }

        public Group create(GroupRequest request) {
            if (request == null) {
                return null;
            }
            Group group = new Group();
            group.setGroupName(request.getGroupName());
            group.setDateOfStart(request.getDateOfStart());
            group.setDateOfFinish(request.getDateOfFinish());
            group.setCourses(request.getCourses());
            return group;
        }

        public void update(Group group, GroupRequest request) {
            group.setGroupName(request.getGroupName());
            group.setDateOfStart(request.getDateOfStart());
            group.setDateOfFinish(request.getDateOfFinish());
            group.setCourses(request.getCourses());
            group.setCreated(LocalDate.now());
        }
}
