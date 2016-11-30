package ar.uba.fi.distribuidos1.jtierno.repository;

import ar.uba.fi.distribuidos1.jtierno.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jonathan on 29/11/16.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User getByUserName(String userName);
}
