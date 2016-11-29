package ar.uba.fi.distribuidos1.jtierno.resource;

import ar.uba.fi.distribuidos1.jtierno.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jonathan on 29/11/16.
 */
@RestController
public class UserResource {
        private static final String template = "Hello, %s!";
        private final AtomicLong counter = new AtomicLong();

        @RequestMapping("/greeting")
        public User greeting(@RequestParam(value="name", defaultValue="World") String name) {
            User user = new User();
            user.setId(counter.incrementAndGet());
            user.setFirstName(String.format(template, name));
            return user;

    }
}
