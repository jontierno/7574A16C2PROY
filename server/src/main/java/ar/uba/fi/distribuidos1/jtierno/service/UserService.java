package ar.uba.fi.distribuidos1.jtierno.service;

import ar.uba.fi.distribuidos1.jtierno.model.User;
import ar.uba.fi.distribuidos1.jtierno.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jonathan on 30/11/16.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User getUser(String userName) {
        return repository.getByUserName(userName);
    }
}
