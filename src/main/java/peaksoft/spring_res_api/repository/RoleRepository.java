package peaksoft.spring_res_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.spring_res_api.model.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
