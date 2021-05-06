package models;

import org.junit.Assert;
import org.junit.Test;

public class AppUserTest {

    @Test
    public void getId() {
        //Arrange
        AppUser user = new AppUser(4, "kalle34", "psw1234");
        int result;

        //Act
        result = user.getId();

        //Assert
        Assert.assertEquals(4, result);
    }

    @Test
    public void getPassword() {
        //Arrange
        AppUser user = new AppUser(4, "kalle34", "psw1234");
        String result;

        //Act
        result = user.getPassword();

        //Assert
        Assert.assertEquals("psw1234", result);
    }

    @Test
    public void getUsername() {
        //Arrange
        AppUser user = new AppUser(4, "kalle34", "psw1234");
        String result;

        //Act
        result = user.getUsername();

        //Assert
        Assert.assertEquals("kalle34", result);
    }

    @Test
    public void setPassword() {
        //Arrange
        AppUser user = new AppUser(4, "kalle34", "psw1234");
        String result;

        //Act
        user.setPassword(" psw2345 ");
        user.setPassword("");
        user.setPassword(null);

        //Assert
        result = user.getPassword();
        Assert.assertEquals("psw2345", result);
    }

    @Test
    public void setUsername() {
        //Arrange
        AppUser user = new AppUser(4, "kalle34", "psw1234");
        String result;

        //Act
        user.setUsername(" kalle43 ");
        user.setUsername("");
        user.setUsername(null);

        //Assert
        result = user.getUsername();
        Assert.assertEquals("kalle43", result);
    }
}
