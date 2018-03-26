package lt.setkus.codewars;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;

/**
 * https://www.codewars.com/kata/find-the-unique-number-1
 */
public class FindUniqueNumber {
    public static double findUniq(double[] arr) {
        Map<Double, Long> result = DoubleStream.of(arr)
                .boxed()
                .collect(Collectors.groupingBy(identity(), counting()));

        return result.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .mapToDouble(Map.Entry::getKey)
                .boxed()
                .collect(toList()).get(0);
    }
}
