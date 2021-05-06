package models;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    @Test
    public void getId() {
        //Arrange
        AppUser appUser = new AppUser(6, "kalle123", "psw123");
        Person person = new Person(3, "kalle", "Karlsson", "kalle@lexicon.se", appUser);
        int result;

        //Act
        result = person.getId();

        //Assert
        Assert.assertEquals(3, result);
    }

    @Test
    public void setId() {
        //Arrange
        AppUser appUser = new AppUser(6, "kalle123", "psw123");
        Person person = new Person(3, "kalle", "Karlsson", "kalle@lexicon.se", appUser);
        int result;

        //Act
        person.setId(4);

        //Assert
        result = person.getId();
        Assert.assertEquals(4, result);
    }

    @Test
    public void getFirstName() {
        //Arrange
        AppUser appUser = new AppUser(6, "kalle123", "psw123");
        Person person = new Person(3, "Kalle", "Karlsson", "kalle@lexicon.se", appUser);
        String result;

        //Act
        result = person.getFirstName();

        //Assert
        Assert.assertEquals("Kalle", result);
    }

    @Test
    public void setFirstName() {
        //Arrange
        AppUser appUser = new AppUser(6, "kalle123", "psw123");
        Person person = new Person(3, "Kalle", "Karlsson", "kalle@lexicon.se", appUser);
        String result;

        //Act
        person.setFirstName("Oskar");

        //Assert
        result = person.getFirstName();
        Assert.assertEquals("Oskar", result);
    }

    @Test
    public void getLastName() {
        //Arrange
        AppUser appUser = new AppUser(6, "kalle123", "psw123");
        Person person = new Person(3, "Kalle", "Karlsson", "kalle@lexicon.se", appUser);
        String result;

        //Act
        result = person.getLastName();

        //Assert
        Assert.assertEquals("Karlsson", result);
    }

    @Test
    public void setLastName() {
        //Arrange
        AppUser appUser = new AppUser(6, "kalle123", "psw123");
        Person person = new Person(3, "Kalle", "Karlsson", "kalle@lexicon.se", appUser);
        String result;

        //Act
        person.setLastName("Larsson");

        //Assert
        result = person.getLastName();
        Assert.assertEquals("Larsson", result);
    }

    @Test
    public void getEmail() {
        //Arrange
        AppUser appUser = new AppUser(6, "kalle123", "psw123");
        Person person = new Person(3, "Kalle", "Karlsson", "kalle@lexicon.se", appUser);
        String result;

        //Act
        result = person.getEmail();

        //Assert
        Assert.assertEquals("kalle@lexicon.se", result);
    }

    @Test
    public void setEmail() {
        //Arrange
        AppUser appUser = new AppUser(6, "kalle123", "psw123");
        Person person = new Person(3, "Kalle", "Karlsson", "kalle@lexicon.se", appUser);
        String result;

        //Act
        person.setEmail("kalle.karlsson@lexicon.se");

        //Assert
        result = person.getEmail();
        Assert.assertEquals("kalle.karlsson@lexicon.se", result);
    }

    @Test
    public void getUserCredentials() {
        //Arrange
        AppUser appUser = new AppUser(6, "kalle123", "psw123");
        Person person = new Person(3, "kalle", "Karlsson", "kalle@lexicon.se", appUser);
        AppUser result;

        //Act
        result = person.getUserCredentials();

        //Assert
        Assert.assertEquals(appUser, result);
    }

    @Test
    public void setUserCredentials() {
        //Arrange
        AppUser appUser1 = new AppUser(6, "kalle123", "psw123");
        AppUser appUser2 = new AppUser(6, "kalle12345", "psw12345");
        Person person = new Person(3, "kalle", "Karlsson", "kalle@lexicon.se", appUser1);
        AppUser result;

        //Act
        person.setUserCredentials(appUser2);

        //Assert
        result = person.getUserCredentials();
        Assert.assertEquals(appUser2, result);
    }

}
