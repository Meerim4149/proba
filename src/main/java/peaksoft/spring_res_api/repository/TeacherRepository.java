package peaksoft.spring_res_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.spring_res_api.model.Teacher;

@Repository

public interface TeacherRepository extends JpaRepository<Teacher,Long> {


}


