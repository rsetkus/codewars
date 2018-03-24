package lt.setkus.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * https://www.codewars.com/kata/the-freeway-game/
 */
public class FreewayGame {

    public static int freewayGame(double distanceInKm, double speedKph, double[][] otherCars) {
        double minutesToExit = calculateTimeWhenWillExit(distanceInKm, speedKph) / 60;
        List<Double> otherCarDistanceAccordingTheirSpeed =
                calculateOtherCarsDistanceWhichTheyCanRunBySpeed(speedKph, otherCars, minutesToExit);

        int counter = 0;
        for (double otherCarDistance : otherCarDistanceAccordingTheirSpeed) {
            if (otherCarDistance < distanceInKm) {
                counter++;
            } else {
                counter--;
            }
        }

        return counter;
    }

    private static List<Double> calculateOtherCarsDistanceWhichTheyCanRunBySpeed(double speedKph, double[][] otherCars,
                                                                                 double minutesToExit) {
        List<Double> otherCarDistanceAccordingTheirSpeed = new ArrayList<>();

        for (double[] data : otherCars) {
            double timeWhenPassEntry = data[0];
            double otherCarSpeedKph = data[1];

            if (isCarAheadAndGoingFaster(timeWhenPassEntry, otherCarSpeedKph, speedKph) ||
                    isCarBehindAndGoingSlower(timeWhenPassEntry, otherCarSpeedKph, speedKph)) {
                continue;
            }

            double relativeTimeFromMeToExit = minutesToExit + timeWhenPassEntry;

            double otherCarDistance = convertToMps(otherCarSpeedKph) * (relativeTimeFromMeToExit * 60);
            otherCarDistanceAccordingTheirSpeed.add(otherCarDistance / 1000);
        }
        return otherCarDistanceAccordingTheirSpeed;
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
