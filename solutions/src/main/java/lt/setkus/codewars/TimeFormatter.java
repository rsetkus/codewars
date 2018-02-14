package lt.setkus.codewars;

/**
 * https://www.codewars.com/kata/human-readable-duration-format
 */
public class TimeFormatter {

    public static String formatDuration(int durationInSeconds) {
        return durationInSeconds > 1 ? durationInSeconds + " seconds" : durationInSeconds == 0 ? "now" : "1 second";
    }
}
