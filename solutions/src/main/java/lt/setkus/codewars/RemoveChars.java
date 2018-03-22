package lt.setkus.codewars;

/**
 * https://www.codewars.com/kata/remove-first-and-last-character/
 */
public class RemoveChars {
    public static String remove(String input) {
        return input.substring(1, input.length() - 1);
    }
}
