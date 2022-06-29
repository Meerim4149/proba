package peaksoft.spring_res_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.spring_res_api.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
//    public Company findById(Long companyId) {
//    }
//
//    public Arrays findAll() {
//    }
//
//    public void save(Company company) {
//    }
}
