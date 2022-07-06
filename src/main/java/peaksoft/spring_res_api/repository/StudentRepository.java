package peaksoft.spring_res_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.spring_res_api.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {



}
