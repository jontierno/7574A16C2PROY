package ar.uba.fi.distribuidos1.jtierno.resource.transfer;

/**
 * Created by jonathan on 01/12/16.
 */
public class UserDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private String career;

    public UserDTO(String userName, String firstName, String lastName, String career) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.career = career;
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

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
