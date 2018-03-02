package lt.setkus.codewars;

import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/square-every-digit/train/java
 */
public class SquareDigit {
    public int squareDigits(int i) {
        String result = String.valueOf(i).chars()
                .map(Character::getNumericValue)
                .map(x -> x * x)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
        return Integer.parseInt(result);
    }
}
