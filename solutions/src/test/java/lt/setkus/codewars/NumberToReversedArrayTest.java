package lt.setkus.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberToReversedArrayTest {

    @Test
    public void tests() {
        assertArrayEquals(new int[] {1, 3, 2, 5, 3}, NumberToReversedArray.digitize(35231));
    }

}