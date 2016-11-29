package ar.uba.fi.distribuidos1.jtierno.repository;

import ar.uba.fi.distribuidos1.jtierno.model.FiubaUser;

import java.util.List;

/**
 * Created by jonathan on 29/11/16.
 */
public interface UserRepository {

    List<FiubaUser> findByUserName(String userName);
}
