package ar.uba.fi.distribuidos1.jtierno.security.repository;

import ar.uba.fi.distribuidos1.jtierno.security.model.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by stephan on 20.03.16.
 */
public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long> {
    SecurityUser findByUsername(String username);
}
