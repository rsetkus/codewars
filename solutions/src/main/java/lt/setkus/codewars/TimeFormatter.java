package lt.setkus.codewars;

/**
 * https://www.codewars.com/kata/human-readable-duration-format
 */
public class TimeFormatter {

    final static int SECONDS_IN_MINUTE  = 60;
    final static int SECONDS_IN_HOUR    = SECONDS_IN_MINUTE * 60;
    final static int SECONDS_IN_DAY     = SECONDS_IN_HOUR * 24;
    final static int SECONDS_IN_YEAR    = SECONDS_IN_DAY * 365;

    public static String formatDuration(int durationInSeconds) {
        int years = getYears(durationInSeconds);
        String y = "";
        if (years > 0) {
            y = String.format("%d %s", years, years > 1 ? "years" : "year");
        }

        int days = getDays(durationInSeconds);
        String d = "";
        if (days > 0) {
            d = String.format("%d %s", days, days > 1 ? "days" : "day");
        }

        int hours = getHours(durationInSeconds);
        String h = "";
        if (hours > 0) {
            h = String.format("%d %s", hours, hours > 1 ? "hours" : "hour");
        }

        return y + (!d.isEmpty() ? " and " + d : d) + h;
    }

    private static int getYears(int duration) {
        return duration / SECONDS_IN_YEAR;
    }

    private static int getDays(int duration) {
        return duration / SECONDS_IN_DAY - getYears(duration) * 365;
    }

    private static int getHours(int duration) {
        return duration / SECONDS_IN_HOUR - getDays(duration) * 60;
    }
}
