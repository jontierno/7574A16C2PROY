package ar.uba.fi.distribuidos1.jtierno.service;

import ar.uba.fi.distribuidos1.jtierno.model.Course;
import ar.uba.fi.distribuidos1.jtierno.model.User;
import ar.uba.fi.distribuidos1.jtierno.repository.CourseRepository;
import ar.uba.fi.distribuidos1.jtierno.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by jonathan on 30/11/16.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public User getUser(String userName) {
        return userRepository.getByUserName(userName);
    }

    @Transactional
    public void register(String username, String courseCode) {

        User user = userRepository.getByUserName(username);
        Course course = courseRepository.getOne(courseCode);
        user.register(course);
        //userRepository.saveAndFlush(user);
        //courseRepository.saveAndFlush(course);

    }

    public void unregister(String username, String courseCode) {
        User user = userRepository.getByUserName(username);
        Course course = courseRepository.getOne(courseCode);
        user.unregister(course);
        userRepository.saveAndFlush(user);
        courseRepository.saveAndFlush(course);
    }
}
