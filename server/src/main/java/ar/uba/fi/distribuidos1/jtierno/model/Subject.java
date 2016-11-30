package ar.uba.fi.distribuidos1.jtierno.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jonathan on 29/11/16.
 */
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String code;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subject")
    private List<Course> courses;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
