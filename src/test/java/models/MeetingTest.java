package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class MeetingTest {
    LocalDate startDate;
    LocalTime startTime, endTime;
    AppUser organizerAppUser, attendee1AppUser, attendee2AppUser, attendee3AppUser;
    Person organizer, attendee1, attendee2, attendee3;
    Meeting meeting;

    @Before
    public void init() {
        startDate = LocalDate.of(2020,9,11);
        startTime = LocalTime.of(12, 0, 0);
        endTime = LocalTime.of(12, 30, 0);

        organizerAppUser = new AppUser(6, "kalle123", "psw123");
        attendee1AppUser = new AppUser(7, "kalle123", "psw123");
        attendee2AppUser = new AppUser(8, "kalle123", "psw123");
        attendee3AppUser = new AppUser(9, "kalle123", "psw123");

        organizer = new Person(3, "Kalle", "Andersson", "kalle@yahoo.com", organizerAppUser);
        attendee1 = new Person(4, "Lasse", "Larsson", "lasse@yahoo.com", attendee1AppUser);
        attendee2 = new Person(5, "Gustav", "Gustavsson", "gustav@yahoo.com", attendee2AppUser);
        attendee3 = new Person(6, "Kurt", "Johansson", "johansson@yahoo.com", attendee3AppUser);

        meeting = new Meeting(1, "Java OOP", startDate, startTime, endTime, organizer);
    }

    @Test
    public void addAttendant() {
        //Arrange
        List<Person> result;

        //Act
        meeting.addAttendant(attendee1);

        //Assert
        result = meeting.getAttendants();
        Assert.assertEquals(attendee1, result.get(0));
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void getAttendants() {
        //Arrange
        List<Person> result;

        meeting.addAttendant(attendee1);
        meeting.addAttendant(attendee2);
        meeting.addAttendant(attendee3);

        //Act
        result = meeting.getAttendants();

        //Assert
        Assert.assertTrue(result.contains(attendee1));
        Assert.assertTrue(result.contains(attendee2));
        Assert.assertTrue(result.contains(attendee3));
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void getEnd() {
        //Arrange
        LocalTime result;

        //Act
        result = meeting.getEnd();

        //Assert
        Assert.assertEquals("12:30:00", result.format(DateTimeFormatter.ISO_LOCAL_TIME));
    }

    @Test
    public void getId() {
        //Arrange
        int result;

        //Act
        result = meeting.getId();

        //Assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void getMeetingDate() {
        //Arrange
        LocalDate result;

        //Act
        result = meeting.getMeetingDate();

        //Assert
        Assert.assertEquals("2020-09-11", result.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    public void getOrganizer() {
        //Arrange
        Person result;

        //Act
        result = meeting.getOrganizer();

        //Assert
        Assert.assertEquals(organizer, result);
    }

    @Test
    public void getStart() {
        //Arrange
        LocalTime result;

        //Act
        result = meeting.getStart();

        //Assert
        Assert.assertEquals("12:00:00", result.format(DateTimeFormatter.ISO_LOCAL_TIME));
    }

    @Test
    public void getTopic() {
        //Arrange
        String result;

        //Act
        result = meeting.getTopic();

        //Assert
        Assert.assertEquals("Java OOP", result);
    }

    @Test
    public void removeAttendant() {
        //Arrange
        List<Person> result;

        meeting.addAttendant(attendee1);
        meeting.addAttendant(attendee2);
        meeting.addAttendant(attendee3);

        //Act
        meeting.removeAttendant(attendee2);

        //Assert
        result = meeting.getAttendants();
        Assert.assertTrue(result.contains(attendee1));
        Assert.assertFalse(result.contains(attendee2));
        Assert.assertTrue(result.contains(attendee3));
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void setAttendants() {
        //Arrange
        List<Person> result;

        meeting.addAttendant(attendee1);
        meeting.setAttendants(Arrays.asList(attendee2, attendee3));

        //Act
        result = meeting.getAttendants();

        //Assert
        Assert.assertFalse(result.contains(attendee1));
        Assert.assertTrue(result.contains(attendee2));
        Assert.assertTrue(result.contains(attendee3));
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void setEnd() {
        //Arrange
        LocalTime result;

        //Act
        meeting.setEnd(LocalTime.of(13, 0));

        //Assert
        result = meeting.getEnd();
        Assert.assertEquals("13:00:00", result.format(DateTimeFormatter.ISO_LOCAL_TIME));
    }

    @Test
    public void setMeetingDate() {
        //Arrange
        LocalDate result;

        //Act
        meeting.setMeetingDate(LocalDate.of(2020, 12, 24));

        //Assert
        result = meeting.getMeetingDate();
        Assert.assertEquals("2020-12-24", result.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    public void setOrganizer() {
        //Arrange
        Person result;

        //Act
        meeting.setOrganizer(attendee2);

        //Assert
        result = meeting.getOrganizer();
        Assert.assertEquals(attendee2, result);
    }

    @Test
    public void setStart() {
        //Arrange
        LocalTime result;

        //Act
        meeting.setStart(LocalTime.of(11, 0));

        //Assert
        result = meeting.getStart();
        Assert.assertEquals("11:00:00", result.format(DateTimeFormatter.ISO_LOCAL_TIME));
    }

    @Test
    public void setTopic() {
        //Arrange
        String result;

        //Act
        meeting.setTopic("C++ OOP");

        //Assert
        result = meeting.getTopic();
        Assert.assertEquals("C++ OOP", result);
    }
}
