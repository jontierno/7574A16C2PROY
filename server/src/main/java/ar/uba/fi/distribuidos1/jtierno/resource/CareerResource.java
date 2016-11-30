package ar.uba.fi.distribuidos1.jtierno.resource;

import ar.uba.fi.distribuidos1.jtierno.model.Career;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonathan on 30/11/16.
 */
@RestController
@RequestMapping(value = "/career")
public class CareerResource {

    @GetMapping(path = "/{code}")
    public Career getCareer(@PathVariable String code) {
        Career career = new Career();
        career.setCode(code);
        return career;
    }
}
