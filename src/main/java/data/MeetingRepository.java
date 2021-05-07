package data;

import models.Meeting;
import models.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MeetingRepository {
    private static final MeetingRepository INSTANCE;
    private final List<Meeting> meetingList;

    static {
        INSTANCE = new MeetingRepository();
    }

    public static MeetingRepository getInstance() {
        return INSTANCE;
    }

    private MeetingRepository() {
        meetingList = new ArrayList<>();
    }

    public void clear() {
        meetingList.clear();
    }

    public List<Meeting> findAll() {
        return meetingList;
    }

    public List<Meeting> findByAttendeePersonId(int id) {
        List<Meeting> meetings = new ArrayList<>();

        for (Meeting meeting : meetingList) {
            for (Person attendee : meeting.getAttendants()) {
                if (attendee.getId() == id) {
                    meetings.add(meeting);
                    break;
                }
            }
        }
        return meetings;
    }

    public Meeting findById(int id) {
        for (Meeting meeting : meetingList) {
            if (meeting.getId() == id) {
                return meeting;
            }
        }
        return null;
    }

    public List<Meeting> findByMeetingDate(LocalDate date) {
        List<Meeting> meetings = new ArrayList<>();

        for (Meeting meeting : meetingList) {
            if (meeting.getMeetingDate().equals(date)) {
                meetings.add(meeting);
            }
        }
        return meetings;
    }

    public List<Meeting> findByMeetingsBetween(LocalDate date1, LocalDate date2) {
        List<Meeting> meetings = new ArrayList<>();

        for (Meeting meeting : meetingList) {
            if (meeting.getMeetingDate().isAfter(date1) && meeting.getMeetingDate().isBefore(date2)) {
                meetings.add(meeting);
            }
        }
        return meetings;
    }

    public List<Meeting> findByOrganizerPersonId(int id) {
        List<Meeting> meetings = new ArrayList<>();

        for (Meeting meeting : meetingList) {
            if (meeting.getOrganizer().getId() == id) {
                meetings.add(meeting);
            }
        }
        return meetings;
    }

    public List<Meeting> findByTopic(String topic) {
        List<Meeting> meetings = new ArrayList<>();

        for (Meeting meeting : meetingList) {
            if (meeting.getTopic().equalsIgnoreCase(topic)) {
                meetings.add(meeting);
            }
        }
        return meetings;
    }

    public int getMeetingCount() {
        return meetingList.size();
    }

    public void persist(Meeting meeting) { // Return value never used so made it void
        if (!meetingList.contains(meeting)) {
            meetingList.add(meeting);
        }
    }

    public boolean remove(int id) {
        for (Meeting meeting : meetingList) {
            if (meeting.getId() == id) {
                meetingList.remove(meeting);
                return true;
            }
        }
        return false;
    }

}
