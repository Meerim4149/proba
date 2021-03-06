package peaksoft.spring_res_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Repository;
import peaksoft.spring_res_api.model.User;

import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

        Optional<User> findByEmail(String email);
}
