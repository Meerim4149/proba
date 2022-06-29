package peaksoft.spring_res_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.spring_res_api.model.Group;

@Repository

public interface GroupRepository extends JpaRepository<Group, Long> {

//    @PersistenceContext
//    private final EntityManager entityManager;
//
//
//    public GroupRepository(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    public void saveGroup(Group group ){
//        entityManager.persist(group);
//    }
//
//    //@Transactional
//    public Group findGroupById(Long groupID) {
//        return entityManager.find(Group.class, groupID);
//    }
//
//    //@Transactional
//    public List<Group> findAllGroups() {
//        return entityManager.createQuery("select g from Group g", Group.class)
//                .getResultList();
//    }
//
//    public void removeGroupById(Long groupId) {
//        entityManager.remove(findGroupById(groupId));
//    }
//
//    public List<Group> findCourseById(Long courseId) {
//        return entityManager.createQuery("select g from Group g where (select c from Course c where c.id = ?1) member of g.courses", Group.class)
//                .setParameter(1, courseId).getResultList();
//    }
//
//    public void updateGroup(Long groupId, Group group) {
//        Group group1 = findGroupById(groupId);
//        group1.setGroupName(group.getGroupName());
//        group1.setDateOfStart(group.getDateOfStart());
//        group1.setDateOfFinish(group.getDateOfFinish());
//        entityManager.persist(group1);
//    }
}
