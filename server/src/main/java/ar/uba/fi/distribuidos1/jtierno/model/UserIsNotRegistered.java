package ar.uba.fi.distribuidos1.jtierno.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jonathan on 01/12/16.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Usuario no registrado en el curso")
public class UserIsNotRegistered extends RuntimeException {
}
