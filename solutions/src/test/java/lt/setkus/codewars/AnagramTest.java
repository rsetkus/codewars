package lt.setkus.codewars;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AnagramTest {

    @Test
    public void exampleTests() {
        Anagram k = new Anagram();

        assertEquals(true, k.isAnagram("foefet", "toffee"));
        assertEquals(true, k.isAnagram("Buckethead", "DeathCubeK"));
        assertEquals(true, k.isAnagram("Twoo", "Woot"));
    }

}