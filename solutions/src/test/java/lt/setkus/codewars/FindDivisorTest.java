package lt.setkus.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindDivisorTest {

    @Test
    public void testNumberOfDivisors() {
        FindDivisor findDivisor = new FindDivisor();
        assertEquals(3, findDivisor.numberOfDivisors(4));
        assertEquals(2, findDivisor.numberOfDivisors(5));
        assertEquals(6, findDivisor.numberOfDivisors(12));
        assertEquals(8, findDivisor.numberOfDivisors(30));
    }
}