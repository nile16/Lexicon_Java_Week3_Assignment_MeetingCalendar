package sequencers;

import org.junit.Assert;
import org.junit.Test;

public class PersonSequencerTest {
    @Test
    public void reset() {
        //Arrange
        int result;
        PersonSequencer.reset();
        PersonSequencer.nextPersonId();

        //Act
        PersonSequencer.reset();

        //Assert
        result = PersonSequencer.nextPersonId();
        Assert.assertEquals(1, result);
    }

    @Test
    public void nextAppUserId() {
        //Arrange
        int result1, result2, result3;
        PersonSequencer.reset();

        //Act
        result1 = PersonSequencer.nextPersonId();
        result2 = PersonSequencer.nextPersonId();
        result3 = PersonSequencer.nextPersonId();

        //Assert
        Assert.assertEquals(1, result1);
        Assert.assertEquals(2, result2);
        Assert.assertEquals(3, result3);
    }
}
