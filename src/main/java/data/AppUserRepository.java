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

    public static AppUserRepository getInstance(){
        return INSTANCE;
    }

    private AppUserRepository() {
        appUserList = new ArrayList<>();
    }

    public void clear(){
        appUserList.clear();
    }

    public AppUser persist(AppUser appUser){
        if(!appUserList.contains(appUser)){
            appUserList.add(appUser);
        }
        return appUser;
    }
}
