package ar.uba.fi.distribuidos1.jtierno.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jonathan on 29/11/16.
 */
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String code;

    @OneToMany(mappedBy = "course")
    private List<Class> classes;

    @ManyToOne(fetch=FetchType.LAZY)
    private Subject subject;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
