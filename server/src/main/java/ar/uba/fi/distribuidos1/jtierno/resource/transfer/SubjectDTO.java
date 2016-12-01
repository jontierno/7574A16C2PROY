package ar.uba.fi.distribuidos1.jtierno.resource.transfer;

/**
 * Created by jonathan on 01/12/16.
 */
public class SubjectDTO {
    private String code;
    private String description;


    public SubjectDTO(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
