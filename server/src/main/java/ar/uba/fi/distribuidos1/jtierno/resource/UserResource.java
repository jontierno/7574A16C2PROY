package ar.uba.fi.distribuidos1.jtierno.resource;

import ar.uba.fi.distribuidos1.jtierno.model.User;
import ar.uba.fi.distribuidos1.jtierno.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jonathan on 29/11/16.
 */
@RestController
public class UserResource {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping("/greeting")
    public User greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setId(counter.incrementAndGet());
        user.setFirstName(String.format(template, name));
        return user;

    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(name);
        return user;
    }
}
