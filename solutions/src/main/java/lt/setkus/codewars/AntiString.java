package lt.setkus.codewars;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/antistring
 */
public class AntiString {

    private static final int[] NUMBERS_MAP = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    private static final Map<Character, Character> LETTERS_MAP = new HashMap<>();

    static {
        // K L M N O P
        LETTERS_MAP.put('a', 'z');
        LETTERS_MAP.put('b', 'y');
        LETTERS_MAP.put('c', 'x');
        LETTERS_MAP.put('d', 'w');
        LETTERS_MAP.put('e', 'v');
        LETTERS_MAP.put('f', 'u');
        LETTERS_MAP.put('g', 't');
        LETTERS_MAP.put('h', 's');
        LETTERS_MAP.put('i', 'r');
        LETTERS_MAP.put('j', 'q');
        LETTERS_MAP.put('k', 'p');
        LETTERS_MAP.put('l', 'o');
        LETTERS_MAP.put('m', 'n');
        LETTERS_MAP.put('p', 'k');
        LETTERS_MAP.put('z', 'a');
        LETTERS_MAP.put('y', 'b');
        LETTERS_MAP.put('x', 'c');
        LETTERS_MAP.put('w', 'd');
        LETTERS_MAP.put('v', 'e');
        LETTERS_MAP.put('u', 'f');
        LETTERS_MAP.put('t', 'g');
        LETTERS_MAP.put('s', 'h');
        LETTERS_MAP.put('r', 'i');
        LETTERS_MAP.put('q', 'j');
        LETTERS_MAP.put('o', 'l');
        LETTERS_MAP.put('n', 'm');

    }

    public static String antiString(String str) {
        return new StringBuilder(str)
                .reverse()
                .chars()
                .map(i -> i >= 65 && i <= 90 ? mapUpperCase(i) : i >= 97 && i <= 122 ? mapLowerCase(i) : mapNumbers(i))
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.joining());
    }

    private static int mapUpperCase(int bigLetter) {
        return LETTERS_MAP.get((char) (bigLetter + 32));
    }

    private static int mapLowerCase(int smallLetter) {
        return LETTERS_MAP.get((char) smallLetter) - 32;
    }

    private static char mapNumbers(int number) {
        int integer = NUMBERS_MAP[Integer.parseInt(Character.toString((char) number))];
        return Character.forDigit(integer, 10);
    }
}
