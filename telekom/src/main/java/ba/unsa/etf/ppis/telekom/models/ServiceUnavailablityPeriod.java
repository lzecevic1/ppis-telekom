package ba.unsa.etf.ppis.telekom.models;

import javax.persistence.*;

@Entity
public class ServiceUnavailablityPeriod {

    public enum DayOfWeek {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private DayOfWeek startDay;
    private DayOfWeek endDay;
    private Integer startHour;
    private Integer endHour;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    public ServiceUnavailablityPeriod() { }

    public ServiceUnavailablityPeriod(DayOfWeek startDay, DayOfWeek endDay, Integer startHour, Integer endHour,
                                      Service service) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.startHour = startHour;
        this.endHour = endHour;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getStartDay() {
        return startDay;
    }

    public void setStartDay(DayOfWeek startDay) {
        this.startDay = startDay;
    }

    public DayOfWeek getEndDay() {
        return endDay;
    }

    public void setEndDay(DayOfWeek endDay) {
        this.endDay = endDay;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

}
