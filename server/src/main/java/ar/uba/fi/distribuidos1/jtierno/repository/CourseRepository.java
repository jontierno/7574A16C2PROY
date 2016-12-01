package ar.uba.fi.distribuidos1.jtierno.repository;

import ar.uba.fi.distribuidos1.jtierno.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jonathan on 01/12/16.
 */
public interface CourseRepository extends JpaRepository<Course,String>{

    List<Course> findBySubjectCode(String subjectCode);
}
