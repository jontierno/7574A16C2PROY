package ar.uba.fi.distribuidos1.jtierno.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jonathan on 29/11/16.
 */
@Entity
public class Career {

    @Id
    private String code;
    private String name;

    @ManyToMany
    @JoinTable(name = "career_subject",
            joinColumns = @JoinColumn(name = "career_code", referencedColumnName = "code"),
            inverseJoinColumns = @JoinColumn(name = "subject_code", referencedColumnName = "code"))
    private List<Subject> subjects;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
