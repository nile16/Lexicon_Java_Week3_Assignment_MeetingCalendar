package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Meeting {
    private int id;
    private String topic;
    private LocalDate meetingDate;
    private LocalTime start;
    private LocalTime end;
    private Person organizer;
    private List<Person> attendants;

    public Meeting(int id, String topic, LocalDate meetingDate, LocalTime start, LocalTime end, Person organizer) {
        this.id = id;
        this.topic = topic;
        this.meetingDate = meetingDate;
        this.start = start;
        this.end = end;
        this.organizer = organizer;
    }

    public void addAttendant(Person person) {

    }

    public int compareTo(Meeting meeting) {
        return 0;
    }

    public List<Person> getAttendants() {
        return attendants;
    }

    public LocalTime getEnd() {
        return end;
    }

    public int getId() {
        return id;
    }

    public LocalDate getMeetingDate() {
        return meetingDate;
    }

    public Person getOrganizer() {
        return organizer;
    }

    public LocalTime getStart() {
        return start;
    }

    public String getTopic() {
        return topic;
    }

    public void removeAttendant(Person person) {

    }

    public void setAttendants(List<Person> attendants) {
        this.attendants = attendants;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public void setMeetingDate(LocalDate meetingDate) {
        this.meetingDate = meetingDate;
    }

    public void setOrganizer(Person organizer) {
        this.organizer = organizer;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
