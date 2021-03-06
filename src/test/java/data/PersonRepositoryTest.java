package data;

import models.AppUser;
import models.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PersonRepositoryTest {

    PersonRepository personRepository;
    AppUser user1, user2, user3, user4, user5;
    Person person1, person2, person3, person4, person5;

    @Before
    public void init() {
        personRepository = PersonRepository.getInstance();

        user1 = new AppUser(1, "kalle", "psw123");
        user2 = new AppUser(2, "lasse", "psw123");
        user3 = new AppUser(3, "gustav", "psw123");
        user4 = new AppUser(4, "kurt", "psw123");
        user5 = new AppUser(5, "burt", "psw123");

        person1 = new Person(1, "Kalle", "Andersson", "kalle@yahoo.com", user1);
        person2 = new Person(2, "Lasse", "Larsson", "lasse@yahoo.com", user2);
        person3 = new Person(3, "Gustav", "Gustavsson", "gustav@yahoo.com", user3);
        person4 = new Person(4, "Kurt", "Johansson", "johansson@yahoo.com", user4);
        person5 = new Person(5, "Burt", "Johansson", "burt@yahoo.com", user5);

        personRepository.clear();

        personRepository.persist(person1);
        personRepository.persist(person2);
        personRepository.persist(person3);
        personRepository.persist(person4);
        personRepository.persist(person5);
    }

    @Test
    public void findAll() {
        //Arrange
        List<Person> result;

        //Act
        result = personRepository.findAll();

        //Assert
        Assert.assertEquals(5, result.size());
    }

    @Test
    public void findByEmail() {
        //Arrange
        Person result1, result2;

        //Act
        result1 = personRepository.findByEmail("johansson@yahoo.com");
        result2 = personRepository.findByEmail("kentsson@yahoo.com");

        //Assert
        Assert.assertEquals("johansson@yahoo.com", result1.getEmail());
        Assert.assertNull(result2);
    }

    @Test
    public void findByFirstname() {
        //Arrange
        List<Person> result;

        //Act
        result = personRepository.findByFirstname("Gustav");

        //Assert
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("Gustav", result.get(0).getFirstName());
    }

    @Test
    public void findById() {
        //Arrange
        Person result1, result2;

        //Act
        result1 = personRepository.findById(2);
        result2 = personRepository.findById(99);

        //Assert
        Assert.assertEquals(2, result1.getId());
        Assert.assertNull(result2);
    }

    @Test
    public void findByLastname() {
        //Arrange
        List<Person> result;

        //Act
        result = personRepository.findByLastname("Andersson");

        //Assert
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("Andersson", result.get(0).getLastName());
    }

    @Test
    public void findByUsername() {
        //Arrange
        Person result1, result2;

        //Act
        result1 = personRepository.findByUsername("burt");
        result2 = personRepository.findByUsername("bart");

        //Assert
        Assert.assertEquals("burt", result1.getUserCredentials().getUsername());
        Assert.assertNull(result2);
    }

    @Test
    public void getPeopleCount() {
        //Arrange
        int result;

        //Act
        result = personRepository.getPeopleCount();

        //Assert
        Assert.assertEquals(5, result);
    }

    @Test
    public void persist() {
        //Arrange
        List<Person> result;
        personRepository.clear();

        //Act
        personRepository.persist(person1);
        personRepository.persist(person2);
        personRepository.persist(person3);

        //Assert
        result = personRepository.findAll();
        Assert.assertTrue(result.contains(person1));
        Assert.assertTrue(result.contains(person2));
        Assert.assertTrue(result.contains(person3));
    }

    @Test
    public void remove() {
        //Arrange
        List<Person> result;

        //Act
        personRepository.remove(2);
        personRepository.remove(3);

        //Assert
        result = personRepository.findAll();
        Assert.assertFalse(result.contains(person2));
        Assert.assertFalse(result.contains(person3));
    }
}
