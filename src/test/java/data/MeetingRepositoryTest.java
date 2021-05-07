package data;

import models.AppUser;
import models.Meeting;
import models.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class MeetingRepositoryTest {
    AppUser user1, user2, user3, user4, user5;
    Person person1, person2, person3, person4, person5;
    Meeting meeting1, meeting2, meeting3, meeting4, meeting5;
    MeetingRepository meetingRepository;

    @Before
    public void init() {
        meetingRepository = MeetingRepository.getInstance();

        user1 = new AppUser(1, "kalle", "psw123");
        user2 = new AppUser(2, "lasse", "psw123");
        user3 = new AppUser(3, "gustav", "psw123");
        user4 = new AppUser(4, "kurt", "psw123");
        user5 = new AppUser(5, "burt", "psw123");

        person1 = new Person(1, "Kalle", "Andersson", "kalle@yahoo.com", user1);
        person2 = new Person(2, "Lasse", "Larsson", "lasse@yahoo.com", user2);
        person3 = new Person(3, "Gustav", "Gustavsson", "gustav@yahoo.com", user3);
        person4 = new Person(4, "Kurt", "Johansson", "johansson@yahoo.com", user4);
        person5 = new Person(5, "Burt", "Johansson", "burt@yahoo.com", user4);

        meeting1 = new Meeting(1, "Java Fundamentals", LocalDate.of(2021, 3, 11), LocalTime.of(9, 0, 0), LocalTime.of(12, 0, 0), person1);
        meeting2 = new Meeting(2, "Java Arrays", LocalDate.of(2021, 3, 12), LocalTime.of(9, 0, 0), LocalTime.of(12, 0, 0), person2);
        meeting3 = new Meeting(3, "Java Strings", LocalDate.of(2021, 4, 11), LocalTime.of(9, 0, 0), LocalTime.of(12, 0, 0), person4);
        meeting4 = new Meeting(4, "Java Loops", LocalDate.of(2021, 4, 11), LocalTime.of(9, 0, 0), LocalTime.of(12, 0, 0), person4);
        meeting5 = new Meeting(5, "Java Loops", LocalDate.of(2021, 6, 11), LocalTime.of(9, 0, 0), LocalTime.of(12, 0, 0), person5);

        meetingRepository.clear();

        meetingRepository.persist(meeting1);
        meetingRepository.persist(meeting2);
        meetingRepository.persist(meeting3);
        meetingRepository.persist(meeting4);
        meetingRepository.persist(meeting5);

    }

    @Test
    public void findAll() {
        //Arrange
        List<Meeting> result;

        //Act
        result = meetingRepository.findAll();

        //Assert
        Assert.assertEquals(5, result.size());
    }

    @Test
    public void findById() {
        //Arrange
        Meeting result;

        //Act
        result = meetingRepository.findById(3);

        //Assert
        Assert.assertEquals(3, result.getId());
    }

    @Test
    public void findByAttendeePersonId() {
        //Arrange
        List<Meeting> result;

        meeting1.addAttendant(person1);
        meeting1.addAttendant(person2);
        meeting1.addAttendant(person3);

        meeting3.addAttendant(person1);
        meeting3.addAttendant(person3);
        meeting3.addAttendant(person5);

        meeting5.addAttendant(person3);
        meeting5.addAttendant(person4);
        meeting5.addAttendant(person5);

        //Act
        result = meetingRepository.findByAttendeePersonId(5);

        //Assert
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(meeting3));
        Assert.assertTrue(result.contains(meeting5));
    }

    @Test
    public void findByMeetingDate() {
        //Arrange
        List<Meeting> result;

        //Act
        result = meetingRepository.findByMeetingDate(LocalDate.of(2021, 3, 11));

        //Assert
        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.contains(meeting1));
    }

    @Test
    public void findByMeetingsBetween() {
        //Arrange
        List<Meeting> result;

        //Act
        result = meetingRepository.findByMeetingsBetween(LocalDate.of(2021, 3, 11), LocalDate.of(2021, 5, 30));

        //Assert
        Assert.assertEquals(3, result.size());
        Assert.assertTrue(result.contains(meeting2));
        Assert.assertTrue(result.contains(meeting3));
        Assert.assertTrue(result.contains(meeting4));
    }

    @Test
    public void findByOrganizerPersonId() {
        //Arrange
        List<Meeting> result;

        //Act
        result = meetingRepository.findByOrganizerPersonId(4);

        //Assert
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(meeting3));
        Assert.assertTrue(result.contains(meeting4));
    }

    @Test
    public void findByTopic() {
        //Arrange
        List<Meeting> result;

        //Act
        result = meetingRepository.findByTopic("JAVA Loops");

        //Assert
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(meeting4));
        Assert.assertTrue(result.contains(meeting5));
    }

    @Test
    public void getMeetingCount() {
        //Arrange
        int result;

        //Act
        result = meetingRepository.getMeetingCount();

        //Assert
        Assert.assertEquals(5, result);
    }

    @Test
    public void persist() {
        //Arrange
        int result;
        meetingRepository.clear();

        //Act
        meetingRepository.persist(meeting1);
        meetingRepository.persist(meeting3);
        meetingRepository.persist(meeting5);

        //Assert
        result = meetingRepository.getMeetingCount();
        Assert.assertEquals(3, result);
    }

    @Test
    public void remove() {
        //Arrange
        List<Meeting> result;

        //Act
        meetingRepository.remove(2);
        meetingRepository.remove(3);
        meetingRepository.remove(5);

        //Assert
        result = meetingRepository.findAll();
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(meeting1));
        Assert.assertTrue(result.contains(meeting4));
    }

}
