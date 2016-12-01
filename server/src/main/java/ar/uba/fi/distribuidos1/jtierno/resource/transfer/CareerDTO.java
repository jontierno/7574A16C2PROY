package ar.uba.fi.distribuidos1.jtierno.resource.transfer;

import java.util.List;

/**
 * Created by jonathan on 01/12/16.
 */
public class CareerDTO {
    private String code;
    private String name;
    private List<SubjectDTO> subjects;

    public CareerDTO(String code, String name, List<SubjectDTO> subjects) {
        this.code = code;
        this.name = name;
        this.subjects = subjects;
    }

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

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }
}
