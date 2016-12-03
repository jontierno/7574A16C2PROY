package ar.uba.fi.distribuidos1.jtierno.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jonathan on 01/12/16.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="No hay vacantes disponibles en el curso")
public class OutOfVacancyException extends RuntimeException {
}
