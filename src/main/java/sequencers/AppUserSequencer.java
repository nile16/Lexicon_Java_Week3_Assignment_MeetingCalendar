package sequencers;

public class AppUserSequencer {
    private static int appUserId = 0;

    public static int nextAppUserId() {
        return appUserId++;
    }

    public static void reset() {
        appUserId = 0;
    }
}
