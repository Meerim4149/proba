package peaksoft.spring_res_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.spring_res_api.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
//    private final EntityManager entityManager;

//    public CourseRepository(EntityManagerFactory entityManagerFactory) {
//        this.entityManager = entityManagerFactory.createEntityManager();
//    }
//     public void save(Course course){
//        entityManager.getTransaction().begin();
//        entityManager.persist(course);
//        entityManager.getTransaction().commit();
//     }
//
//     public  Course findCourseById(Long courseId){
//        return entityManager.find(Course.class,courseId);
//
//     }
//
//     public List<Course> findAll(){
//        return entityManager.createQuery("select c from Course c", Course.class)
//                .getResultList();
//     }
//
//     public void updateCourse(Long courseId,Course newCourse){
//        Course course = findCourseById(courseId);
//        course.setCourseName(newCourse.getCourseName());
//        course.setDuration(newCourse.getDuration());
//        entityManager.persist(course);
//     }
//
//     public List<Course> findCompanyById(Long companyId){
//        return entityManager
//                .createQuery("select k from Course k where k.company.id = : companyId", Course.class)
//                .setParameter("companyId",companyId)
//                .getResultList();
//     }
//
//    public void deleteById(Long courseId){
//        EntityTransaction transaction =entityManager.getTransaction();
//        transaction.begin();
//
//        Course course = findCourseById(courseId);
//        entityManager.remove(entityManager.contains(course) ? course: entityManager.merge(course));
//
//        transaction.commit();
//    }

}
