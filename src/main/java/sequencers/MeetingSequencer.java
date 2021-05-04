package sequencers;

public class MeetingSequencer {
    private static int meetingId = 0;

    public static int nextAppUserId() {
        return meetingId++;
    }

    public static void reset() {
        meetingId = 0;
    }
}
