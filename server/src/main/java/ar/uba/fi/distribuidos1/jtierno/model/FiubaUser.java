package ar.uba.fi.distribuidos1.jtierno.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by jonathan on 29/11/16.
 */
@Entity
public class FiubaUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    @Transient
    private List<Career> carrers;
    @Transient
    private Set<Course> courses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<Career> getCarrers() {
        return carrers;
    }

    public void setCarrers(List<Career> carrers) {
        this.carrers = carrers;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
