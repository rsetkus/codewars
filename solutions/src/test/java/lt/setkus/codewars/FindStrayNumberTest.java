package lt.setkus.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindStrayNumberTest {

    @Test
    public void simpleArray1() {
        assertEquals(2, getActualFor(1, 1, 2));
        assertEquals(1, getActualFor(2, 2, 2, 1));
    }

    private int getActualFor(int... numbers) {
        return FindStrayNumber.stray(numbers);
    }
}