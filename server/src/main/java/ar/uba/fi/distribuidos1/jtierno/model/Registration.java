package ar.uba.fi.distribuidos1.jtierno.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jonathan on 01/12/16.
 */
@Entity
public class Registration {

    @Embeddable
    public static class RegistrationPK implements Serializable{

        @Column(name = "user_id")
        private Long userId;
        @Column(name = "course_code")
        private String courseCode;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof RegistrationPK)) return false;

            RegistrationPK that = (RegistrationPK) o;

            if (!userId.equals(that.userId)) return false;
            return courseCode.equals(that.courseCode);
        }

        @Override
        public int hashCode() {
            int result = userId.hashCode();
            result = 31 * result + courseCode.hashCode();
            return result;
        }
    }

    @EmbeddedId
    private RegistrationPK id;

    @MapsId("userId") //references EmbeddedId's property
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;

    @MapsId("courseCode") //references EmbeddedId's property
    @JoinColumn(name = "course_code", referencedColumnName = "code")
    @ManyToOne
    private Course course;

    public Registration(User user, Course course, Date registrationDate) {
        this.user = user;
        this.course = course;
        this.registrationDate = registrationDate;
        this.getId();
    }

    public Registration() {
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.getId().userId = user.getId();
    }

    public RegistrationPK getId() {
        if(this.id == null) {
            this.id = new RegistrationPK();
            if(this.user != null){
                this.id.userId = this.user.getId();
            }
            if(this.course != null){
                this.id.courseCode = this.course.getCode();
            }
        }
        return id;
    }

    public void setId(RegistrationPK id) {
        this.id = id;


    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
        this.getId().courseCode = this.course.getCode();
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Registration)) return false;

        Registration that = (Registration) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }
}
