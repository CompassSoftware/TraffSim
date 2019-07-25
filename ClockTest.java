/**
 * JUnit test class.
 * @author Sam Howard
 * @version 7/24/2019
 **/

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ClockTest {

    static Clock clock;

    @BeforeEach
    void makeClock() {
        clock = new Clock();
    }

    @Test
    public void testClock() {
        clock.setSeconds(80);
        assertEquals("12:01:20", clock.toString());
    }
}
