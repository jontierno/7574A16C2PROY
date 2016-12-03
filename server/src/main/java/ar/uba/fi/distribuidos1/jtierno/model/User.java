package ar.uba.fi.distribuidos1.jtierno.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by jonathan on 29/11/16.
 */
@Entity
@Table(name= "SYSTEM_USER")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

    private String firstName;
    private String lastName;

    @ManyToOne
    private Career career;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Registration> registrations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public Set<Registration> getRegistrations() {
        if(registrations == null){
            registrations = new HashSet<Registration>();
        }
        return registrations;
    }

    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }


    public void register(Course course) {
        Registration registration = course.register(this);
        Set<Registration> registrations = this.getRegistrations();
        if(registrations.contains(registration)) {
            course.unregistration(this);
            throw new UserAlreadyRegistered();
        } else {
            registrations.add(registration);
        }

    }

    public void unregister(Course course) {
        Set<Registration> registrations = this.getRegistrations();
        Optional<Registration> first = registrations.stream().filter((s) -> s.getCourse().equals(course)).findFirst();
        if(first.isPresent()) {
            registrations.remove(first.get());
            course.unregistration(this);
        } else {
            throw new UserIsNotRegistered();
        }
    }
}
