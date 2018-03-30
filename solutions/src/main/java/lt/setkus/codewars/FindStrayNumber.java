package lt.setkus.codewars;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/find-the-stray-number
 */
public class FindStrayNumber {
    public static int stray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0] != numbers[1] ? numbers[0] : numbers[numbers.length - 1];
    }
}
