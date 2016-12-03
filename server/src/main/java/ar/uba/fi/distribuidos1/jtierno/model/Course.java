package ar.uba.fi.distribuidos1.jtierno.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by jonathan on 29/11/16.
 */
@Entity
public class Course {

    @Id
    private String code;

    @OneToMany(mappedBy = "course")
    private List<Class> classes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;

    private Long vacancies;

    private String professors;


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

    public Long getVacancies() {
        return vacancies;
    }

    public void setVacancies(Long vacancies) {
        this.vacancies = vacancies;
    }

    public String getProfessors() {
        return professors;
    }

    public void setProfessors(String professors) {
        this.professors = professors;
    }

    public Registration register(User user) {
        if(vacancies > 0) {
            vacancies--;
            return new Registration(user, this, new Date());
        } else {
            throw new OutOfVacancyException();
        }
    }
    public void unregistration(User user){
        vacancies++;
    }

}
