package data;

import models.AppUser;
import org.junit.Before;
import org.junit.Test;

public class AppUserRepositoryTest {

    AppUserRepository repo;

    @Before
    public void init() {
        repo = AppUserRepository.getInstance();
        repo.clear();
        repo.persist(new AppUser(1, "kalle", "psw123"));
        repo.persist(new AppUser(2, "kent", "psw123"));
        repo.persist(new AppUser(3, "kurt", "psw123"));
    }

    @Test
    public void Constructor() {
    }
}
