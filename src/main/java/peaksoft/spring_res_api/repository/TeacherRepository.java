package peaksoft.spring_res_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.spring_res_api.model.Teacher;

@Repository

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

//    private final EntityManager entityManager;
//
//    public TeacherRepository(EntityManagerFactory entityManagerFactory) {
//        this.entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    public void save(Teacher teacher) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(teacher);
//        entityManager.getTransaction().commit();
//    }
//
//    public Teacher fidById(Long teacherId) {
//        return entityManager.find(Teacher.class, teacherId);
//    }
//
//    public List<Teacher> findAll() {
//        return entityManager
//                .createQuery("select t from Teacher t", Teacher.class)
//                .getResultList();
//    }
//
//    public void update(Long id, Teacher teacher) {
//        Teacher teacher1 = fidById(id);
//        teacher1.setFirstName(teacher.getFirstName());
//        teacher1.setEmail(teacher.getEmail());
//        teacher1.setLastName(teacher.getLastName());
//        entityManager.persist(teacher1);
//    }
//
//    public void deleteById(Long teacherId) {
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        entityManager.remove(entityManager.find(Teacher.class, teacherId));
//        transaction.commit();
//    }
////        entityManager.createQuery("delete from Teacher t where t.id= ?1")
////                .setParameter(1, teacherId)
////                .executeUpdate();
//
//    public List<Teacher> findAllTeacherById(UUID id) {
//        List<Teacher> teachers = entityManager.createQuery("select t from Teacher t where t.course.id=?1",
//                Teacher.class).setParameter(1,id).getResultList();
//        return teachers;
//    }

}


