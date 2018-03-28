package lt.setkus.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AntiStringTest {

    @Test
    public void Basic1() {
        assertEquals("a0", AntiString.antiString("9Z"));
    }
    @Test
    public void Basic2() {
        assertEquals("aBc123", AntiString.antiString("678XyZ"));
    }
    @Test
    public void Basic3() {
        assertEquals("678bcdXYZ", AntiString.antiString("abcWXY123"));
    }
}