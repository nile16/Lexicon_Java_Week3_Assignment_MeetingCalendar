package sequencers;

import org.junit.Assert;
import org.junit.Test;

public class MeetingSequencerTest {
    @Test
    public void reset() {
        //Arrange
        int result;
        MeetingSequencer.reset();
        MeetingSequencer.nextMeetingId();

        //Act
        MeetingSequencer.reset();

        //Assert
        result = MeetingSequencer.nextMeetingId();
        Assert.assertEquals(1, result);
    }

    @Test
    public void nextAppUserId() {
        //Arrange
        int result1, result2, result3;
        MeetingSequencer.reset();

        //Act
        result1 = MeetingSequencer.nextMeetingId();
        result2 = MeetingSequencer.nextMeetingId();
        result3 = MeetingSequencer.nextMeetingId();

        //Assert
        Assert.assertEquals(1, result1);
        Assert.assertEquals(2, result2);
        Assert.assertEquals(3, result3);
    }
}

