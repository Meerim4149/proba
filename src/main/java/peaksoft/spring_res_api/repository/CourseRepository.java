package peaksoft.spring_res_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.spring_res_api.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {


}
