package lt.setkus.codewars;

import java.util.ArrayList;

/**
 * https://www.codewars.com/kata/number-of-people-in-the-bus
 */
public class Metro {

    public int countPassengers(ArrayList<int[]> passengersInAndOut) {
        int passengersInBus = 0;
        return passengersInAndOut.stream().mapToInt(data -> passengersInBus + data[0] - data[1]).sum();
    }
}
