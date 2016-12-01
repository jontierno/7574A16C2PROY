package ar.uba.fi.distribuidos1.jtierno.resource.transfer;

/**
 * Created by jonathan on 01/12/16.
 */
public class ClassDTO {
    private String from;
    private String to;
    private String type;
    private String day;
    private String place;

    public ClassDTO(String from, String to, String type, String day, String place) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.day = day;
        this.place = place;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
