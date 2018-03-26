package lt.setkus.codewars;

/**
 * https://www.codewars.com/kata/convert-number-to-reversed-array-of-digits
 */
public class NumberToReversedArray {
    public static int[] digitize(long n) {
        return new StringBuilder(String.valueOf(n)).reverse().toString().chars()
                .map(c -> Integer.parseInt(Character.toString((char)c)))
                .toArray();
    }
}
