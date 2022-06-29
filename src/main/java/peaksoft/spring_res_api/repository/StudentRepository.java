package peaksoft.spring_res_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.spring_res_api.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

//    private final EntityManager entityManager;
//
//    public StudentRepository(EntityManagerFactory entityManagerFactory) {
//        this.entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    public List<Student> findGroupById(Long groupId) {
//        return entityManager.createQuery("select  s from Student s where s.group.id=?1",Student.class)
//                .setParameter(1,groupId).getResultList();
//    }
//
//    public void updateStudent(Long studentId, Student student) {
//        Student student1 = findStudentById(studentId);
//        student1.setFirstName((student.getFirstName()));
//        student1.setEmail(student.getEmail());
//        student1.setLastName(student.getLastName());
//        student1.setStudyFormat(student.getStudyFormat());
//    }
//
//    public Student findStudentById(Long studentId) {
//        return  entityManager.find(Student.class, studentId);
//    }
//
//    public List<Student> findAllStudents() {
//        return entityManager.createQuery("select  s from Student s", Student.class)
//                .getResultList();
//    }
//
//    public void saveStudent(Student student) {
//        entityManager.persist(student);
//    }
//
//    public void deleteStudentById(UUID studentId){
//        entityManager.createQuery("delete from Student s where s.id=?1")
//                .setParameter(1,studentId).executeUpdate();
//    }
}
