package ar.uba.fi.distribuidos1.jtierno.model;

import javax.persistence.*;

/**
 * Created by jonathan on 30/11/16.
 */
@Entity
@Table(indexes = @Index(name="idx_class_course", columnList = "course_code"))
public class Class {

    @Id
    private Long id;
    private String type;
    private String day;
    private String startingTime;
    private String endingTime;
    private String place;
    @ManyToOne(fetch=FetchType.LAZY)
    private Course course;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
