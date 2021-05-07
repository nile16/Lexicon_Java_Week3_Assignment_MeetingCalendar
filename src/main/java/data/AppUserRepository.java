package data;

import models.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserRepository {
    private static final AppUserRepository INSTANCE;
    private final List<AppUser> appUserList;

    static {
        INSTANCE = new AppUserRepository();
    }

    public static AppUserRepository getInstance() {
        return INSTANCE;
    }

    private AppUserRepository() {
        appUserList = new ArrayList<>();
    }

    public void clear() {
        appUserList.clear();
    }

    public List<AppUser> findAll() {
        return appUserList;
    }

    public AppUser findById(int id) {
        for(AppUser appuser : appUserList) {
            if (appuser.getId() == id) {
                return appuser;
            }
        }
        return null;
    }

    public AppUser findByUsername(String userName) {
        for(AppUser appuser : appUserList) {
            if (appuser.getUsername().equals(userName)) {
                return appuser;
            }
        }
        return null;
    }

    public int getAppUserCount() {
        return appUserList.size();
    }

    public void persist(AppUser appUser) { // Return value never used so made it void
        if (!appUserList.contains(appUser)) {
            appUserList.add(appUser);
        }
    }

    public boolean remove(int id) {
        for(AppUser appuser : appUserList) {
            if (appuser.getId() == id) {
                appUserList.remove(appuser);
                return true;
            }
        }
        return false;
    }

}
