package ar.uba.fi.distribuidos1.jtierno.service;

import ar.uba.fi.distribuidos1.jtierno.model.Course;
import ar.uba.fi.distribuidos1.jtierno.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jonathan on 01/12/16.
 */
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCoursesBySubject(String subject){
            return courseRepository.findBySubjectCode(subject);
    }
}
