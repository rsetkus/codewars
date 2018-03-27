package lt.setkus.codewars;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/anagram-detection
 */
public class Anagram {
    public boolean isAnagram(String test, String original) {
        char[] test1 = test.toLowerCase().toCharArray();
        char[] test2 = original.toLowerCase().toCharArray();

        Arrays.sort(test1);
        Arrays.sort(test2);

        return Arrays.equals(test1, test2);
    }
}
