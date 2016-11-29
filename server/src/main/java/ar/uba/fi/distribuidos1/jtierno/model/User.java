package ar.uba.fi.distribuidos1.jtierno.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by jonathan on 29/11/16.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String userName;
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
