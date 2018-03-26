package lt.setkus.codewars;

import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/is-n-divisible-by-dot-dot-dot
 */
public class Divisible {
    public static boolean isDivisible(int... input) {
        return IntStream.range(0, input.length - 1).allMatch(i -> input[i + 1] > 0 && input[0] % input[i + 1] == 0);
    }
}
