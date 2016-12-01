package ar.uba.fi.distribuidos1.jtierno.resource;

import ar.uba.fi.distribuidos1.jtierno.model.Career;
import ar.uba.fi.distribuidos1.jtierno.repository.CareerRepository;
import ar.uba.fi.distribuidos1.jtierno.resource.transfer.CareerDTO;
import ar.uba.fi.distribuidos1.jtierno.resource.transfer.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * Created by jonathan on 30/11/16.
 */
@RestController
@RequestMapping(value = "/career")
public class CareerResource {

    @Autowired
    private CareerRepository careerRepository;

    @GetMapping(path = "/{code}")
    public CareerDTO getCareer(@PathVariable String code) {
        Career c = careerRepository.getOne(code);
        return new CareerDTO(c.getCode(), c.getName(), c.getSubjects().stream().map((s) -> new SubjectDTO(s.getCode(), s.getName())).collect(Collectors.toList()));
    }
}
