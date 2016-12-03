package ar.uba.fi.distribuidos1.jtierno.resource;

import ar.uba.fi.distribuidos1.jtierno.model.Registration;
import ar.uba.fi.distribuidos1.jtierno.model.User;
import ar.uba.fi.distribuidos1.jtierno.resource.transfer.RegistrationRequest;
import ar.uba.fi.distribuidos1.jtierno.resource.transfer.UserDTO;
import ar.uba.fi.distribuidos1.jtierno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Created by jonathan on 29/11/16.
 */
@RestController
public class UserResource {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private UserService userService;


    @RequestMapping(value = "user", method = RequestMethod.GET)
    public UserDTO getAuthenticatedUser(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User user=userService.getUser(name);
        return new UserDTO(user.getUserName(),user.getFirstName(), user.getLastName(),user.getCareer().getCode());
    }

    @PutMapping(value = "registration")
    public void registration(@RequestBody RegistrationRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        userService.register(name, request.getCode());
    }


    @DeleteMapping(value = "registration")
    public void unregistration(@RequestBody RegistrationRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        userService.unregister(name, request.getCode());
    }

    @GetMapping(value = "registration")
    public List<String> registrations (){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user=userService.getUser(name);
        Set<Registration> registrations = user.getRegistrations();
        return registrations.stream().map((s)-> s.getCourse().getCode()).collect(Collectors.toList());
    }
}
