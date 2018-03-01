package lt.setkus.codewars;

/**
 * https://www.codewars.com/kata/5412509bd436bd33920011bc/train/java
 */
public class Maskify {
    private static final int VISIBLE_LENGTH = 4;

    public static String maskify(String input) {
        if (input != null && input.length() < VISIBLE_LENGTH) {
            return input;
        } else {
            return makeMask(input.length() - VISIBLE_LENGTH) +
                    input.substring(input.length() - VISIBLE_LENGTH, input.length());
        }
    }

    private static String makeMask(int length) {
        return new String(new char[length]).replace("\0", "#");
    }
}
