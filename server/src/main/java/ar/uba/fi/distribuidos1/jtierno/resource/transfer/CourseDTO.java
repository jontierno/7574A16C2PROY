package ar.uba.fi.distribuidos1.jtierno.resource.transfer;

import java.util.List;

/**
 * Created by jonathan on 01/12/16.
 */
public class CourseDTO {
    private String code;
    private Long vacancies;
    private String[] professors;
    private List<ClassDTO> classes;

    public CourseDTO(String code, Long vacancies, String[] professor, List<ClassDTO> classes) {
        this.code = code;
        this.vacancies = vacancies;
        this.professors = professor;
        this.classes = classes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getVacancies() {
        return vacancies;
    }

    public void setVacancies(Long vacancies) {
        this.vacancies = vacancies;
    }

    public String[] getProfessors() {
        return professors;
    }

    public void setProfessors(String[] professors) {
        this.professors = professors;
    }

    public List<ClassDTO> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassDTO> classes) {
        this.classes = classes;
    }
}
