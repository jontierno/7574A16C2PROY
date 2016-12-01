package ar.uba.fi.distribuidos1.jtierno.resource;

import ar.uba.fi.distribuidos1.jtierno.model.Career;
import ar.uba.fi.distribuidos1.jtierno.model.Course;
import ar.uba.fi.distribuidos1.jtierno.repository.CareerRepository;
import ar.uba.fi.distribuidos1.jtierno.resource.transfer.CareerDTO;
import ar.uba.fi.distribuidos1.jtierno.resource.transfer.ClassDTO;
import ar.uba.fi.distribuidos1.jtierno.resource.transfer.CourseDTO;
import ar.uba.fi.distribuidos1.jtierno.resource.transfer.SubjectDTO;
import ar.uba.fi.distribuidos1.jtierno.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jonathan on 30/11/16.
 */
@RestController
public class CareerResource {

    @Autowired
    private CareerRepository careerRepository;

    @Autowired
    private CourseService courseService;


    @GetMapping(path = "/career/{code}")
    public CareerDTO getCareer(@PathVariable String code) {
        Career c = careerRepository.getOne(code);
        return new CareerDTO(c.getCode(), c.getName(), c.getSubjects().stream().map((s) -> new SubjectDTO(s.getCode(), s.getName())).collect(Collectors.toList()));
    }

    @GetMapping(path = "/subject/{code}/courses")
    public List<CourseDTO> getCourses(@PathVariable String code) {
        List<Course> coursesBySubject = courseService.getCoursesBySubject(code);
        //que dios se apiade de mi alma por hacer esto
        return coursesBySubject.stream().map(
                (c) -> new CourseDTO(c.getCode(), c.getVacancies(), c.getProfessors().split("-"),
                    c.getClasses().stream().map((cl) -> new ClassDTO(cl.getStartingTime(),
                            cl.getEndingTime(), cl.getType(),
                            cl.getDay(), cl.getPlace()))
                            .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}
