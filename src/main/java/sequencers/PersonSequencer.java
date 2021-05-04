package sequencers;

public class PersonSequencer {
    private static int personId = 0;

    public static int nextAppUserId() {
        return personId++;
    }

    public static void reset() {
        personId = 0;
    }
}
