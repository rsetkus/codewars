package lt.setkus.codewars;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TimeFormatterTest {

    @Test
    public void testFormatDurationExamples() {
        // Example Test Cases
//        assertEquals("1 second", TimeFormatter.formatDuration(1));
//        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));

        assertEquals("1 year", TimeFormatter.formatDuration(1 * TimeFormatter.SECONDS_IN_YEAR));
        assertEquals("2 years and 1 day",
                TimeFormatter.formatDuration(2 * TimeFormatter.SECONDS_IN_YEAR + 1 * TimeFormatter.SECONDS_IN_DAY));

        int year  = 1 * TimeFormatter.SECONDS_IN_YEAR;
        int days  = 2 * TimeFormatter.SECONDS_IN_DAY;
        int hours = 3 * TimeFormatter.SECONDS_IN_HOUR;
        assertEquals("1 year, 2 days and 3 hours",
                TimeFormatter.formatDuration(year + days + hours));
    }
}