package lt.setkus.codewars;

import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/find-divisors-of-a-number
 */
public class FindDivisor {
    public long numberOfDivisors(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).count();
    }
}
