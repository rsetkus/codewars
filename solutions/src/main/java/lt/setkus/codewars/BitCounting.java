package lt.setkus.codewars;

/**
 * https://www.codewars.com/kata/526571aae218b8ee490006f4/train/java
 */
public class BitCounting {
    public static long countBits(int input) {
        return Integer.toBinaryString(input).chars().filter(i -> i == 49).count();
    }
}
