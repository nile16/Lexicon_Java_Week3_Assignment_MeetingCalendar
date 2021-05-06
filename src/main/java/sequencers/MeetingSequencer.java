package sequencers;

public class MeetingSequencer {
    private static int meetingId = 0;

    public static int nextMeetingId() {
        return ++meetingId;
    }

    public static void reset() {
        meetingId = 0;
    }
}
