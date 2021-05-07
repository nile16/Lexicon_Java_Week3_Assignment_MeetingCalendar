package data;

import models.AppUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AppUserRepositoryTest {

    AppUserRepository appUserRepository;

    @Before
    public void init() {
        appUserRepository = AppUserRepository.getInstance();
        appUserRepository.clear();
        appUserRepository.persist(new AppUser(1, "kalle", "psw123"));
        appUserRepository.persist(new AppUser(2, "kent", "psw123"));
        appUserRepository.persist(new AppUser(3, "kurt", "psw123"));
    }

    @Test
    public void Clear() {
        //Arrange
        int result;

        //Act
        appUserRepository.clear();

        //Assert
        result = appUserRepository.getAppUserCount();
        Assert.assertEquals(0, result);
    }

    @Test
    public void findAll() {
        //Arrange
        List<AppUser> appUsers;

        //Act
        appUsers = appUserRepository.findAll();

        //Assert
        Assert.assertEquals(3, appUsers.size());
    }

    @Test
    public void findById() {
        //Arrange
        AppUser result1, result2;

        //Act
        result1 = appUserRepository.findById(2);
        result2 = appUserRepository.findById(4);

        //Assert
        Assert.assertEquals(2, result1.getId());
        Assert.assertNull(result2);
    }

    @Test
    public void findByUsername() {
        //Arrange
        AppUser result1, result2;

        //Act
        result1 = appUserRepository.findByUsername("kent");
        result2 = appUserRepository.findByUsername("krull");

        //Assert
        Assert.assertEquals("kent", result1.getUsername());
        Assert.assertNull(result2);
    }

    @Test
    public void getAppUserCount() {
        //Arrange
        int result;

        //Act
        result = appUserRepository.getAppUserCount();

        //Assert
        Assert.assertEquals(3, result);
    }

    @Test
    public void persist() {
        //Arrange
        AppUser addedAppUser = new AppUser(7, "ove", "1234");
        List<AppUser> allAppUsers;

        //Act
        appUserRepository.persist(addedAppUser);

        //Assert
        allAppUsers = appUserRepository.findAll();
        Assert.assertTrue(allAppUsers.contains(addedAppUser));
    }

    @Test
    public void remove() {
        //Arrange
        AppUser removedAppUser = appUserRepository.findById(2);
        List<AppUser> allAppUsers;

        //Act
        appUserRepository.remove(2);

        //Assert
        allAppUsers = appUserRepository.findAll();
        Assert.assertFalse(allAppUsers.contains(removedAppUser));
    }
}
