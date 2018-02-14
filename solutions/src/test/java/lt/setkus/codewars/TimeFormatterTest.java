package lt.setkus.codewars;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TimeFormatterTest {

    @Test
    public void testFormatDurationExamples() {
        // Example Test Cases
        assertEquals("1 second", TimeFormatter.formatDuration(1));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
    }
}