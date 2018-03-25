package lt.setkus.codewars;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * https://www.codewars.com/kata/the-freeway-game/
 */
public class FreewayGame {

    public static int freewayGame(double distanceInKm, double speedKph, double[][] otherCars) {
        System.out.println("My distance " + distanceInKm + ", speed " + speedKph);
        double myMinutesToExit = calculateTimeWhenWillExit(distanceInKm, speedKph) / 60;
        System.out.println("My car time " + myMinutesToExit);
        return Stream.of(otherCars)
                .peek(data -> System.out.println(Arrays.toString(data)))
                .filter(data -> speedKph != data[1] && canCarOvertakeMe(data, speedKph))
                .peek(d -> System.out.println(Arrays.toString(d)))
                .mapToInt(data -> {
                    double otherCarTime = (calculateTimeWhenWillExit(distanceInKm, data[1]) / 60) + data[0];
                    System.out.println("Other car time " + otherCarTime);
                    if (otherCarTime < myMinutesToExit) {
                        return -1;
                    } else {
                        return 1;
                    }
                })
                .sum();
    }

    /**
     * Check whether car can overtake me.
     *
     * @param data car data
     * @param speedKph my speed
     * @return result
     */
    private static boolean canCarOvertakeMe(double[] data, double speedKph) {
        return !(isCarAheadAndGoingFaster(data[0], data[1], speedKph) ||
                isCarBehindAndGoingSlower(data[0], data[1], speedKph));
    }

    /**
     * Check if other car is behind me and runs slower then me.
     *
     * @param timeWhenPassEntry time when other car passed entry to free way
     * @param otherCarSpeedKph  other car speed kph
     * @param speedKph          my speed
     * @return
     */
    private static boolean isCarBehindAndGoingSlower(double timeWhenPassEntry, double otherCarSpeedKph, double speedKph) {
        return Math.signum(timeWhenPassEntry) > 0 && otherCarSpeedKph < speedKph;
    }

    /**
     * Check if orther car is ahead from me and runs faster then me.
     *
     * @param timeWhenPassEntry time when other car passed entry to free way
     * @param otherCarSpeedKph  other car speed kph
     * @param speedKph          my speed
     * @return
     */
    private static boolean isCarAheadAndGoingFaster(double timeWhenPassEntry, double otherCarSpeedKph, double speedKph) {
        return Math.signum(timeWhenPassEntry) < 0 && otherCarSpeedKph > speedKph;
    }

    /**
     * Method calculates time when car will leave freeway.
     *
     * @param distance  in km
     * @param speed     kmph
     * @return time in seconds when will exit freeway
     */
    private static double calculateTimeWhenWillExit(double distance, double speed) {
        // before calculating convert all variables to SI standards
        double mps = convertToMps(speed);
        double distanceInMeters = distance * 1000;
        return distanceInMeters / mps;
    }

    /**
     * Converts speed from kph to mps
     *
     * @param kph speed in kph
     * @return speed in mps
     */
    private static double convertToMps(double kph) {
        return kph / 3.6;
    }
}
