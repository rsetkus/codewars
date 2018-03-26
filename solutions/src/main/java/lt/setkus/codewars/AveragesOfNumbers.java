package lt.setkus.codewars;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codewars.com/kata/averages-of-numbers/train/java
 */
public class AveragesOfNumbers {
    public static double[] averages(int[] numbers) {
        List<Double> result = new ArrayList<>();
        if(numbers != null && numbers.length > 1) {
            for (int i = 0; i < numbers.length - 1; i++) {
                double x = (numbers[i] + numbers[i + 1]) / 2.0;
                result.add(x);
            }
        }
        return result.stream().mapToDouble(Double::valueOf).toArray();
    }
}
