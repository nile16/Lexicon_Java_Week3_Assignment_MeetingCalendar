package sequencers;

import org.junit.Assert;
import org.junit.Test;

public class AppUserSequencerTest {
    @Test
    public void reset() {
        //Arrange
        int result;
        AppUserSequencer.reset();
        AppUserSequencer.nextAppUserId();

        //Act
        AppUserSequencer.reset();

        //Assert
        result = AppUserSequencer.nextAppUserId();
        Assert.assertEquals(1, result);
    }

    @Test
    public void nextAppUserId() {
        //Arrange
        int result1, result2, result3;
        AppUserSequencer.reset();

        //Act
        result1 = AppUserSequencer.nextAppUserId();
        result2 = AppUserSequencer.nextAppUserId();
        result3 = AppUserSequencer.nextAppUserId();

        //Assert
        Assert.assertEquals(1, result1);
        Assert.assertEquals(2, result2);
        Assert.assertEquals(3, result3);
    }
}
