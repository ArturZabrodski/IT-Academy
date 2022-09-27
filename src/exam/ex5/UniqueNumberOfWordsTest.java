package exam.ex5;

import static exam.ex5.UniqueNumberOfWords.*;
import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

public class UniqueNumberOfWordsTest {

    @Test
    public void testForCountingUniqueWords() {
        assertEquals(2, numberOfUniqueWords("Hello World!"));
        assertEquals(3, numberOfUniqueWords("Hello World! Hello Java!"));
        assertEquals(14, numberOfUniqueWords(
                "  Listen ^to// the news - from  #today  #and . read 4 the ,text< at> the- same "
                        + "%time.  Listen to the news,,, from... today-without ;reading: the text.  "));
    }

    @Test
    public void testForRemovingExtraCharacters() {
        assertEquals("Hello World ", removeExtraChar("Hello World!"));
        assertEquals("Hello World Hello Java ", removeExtraChar("Hello World! Hello Java!"));
        assertEquals("Listen to the news from today and read the text at "
                        + "the same time Listen to the news from today without reading the text ",
                removeExtraChar("  Listen ^to// the news - from  #today  #and . read 4 the ,text< at> "
                        + "the- same %time.  Listen to the news,,, from... today-without ;reading: the text.  "));
    }

    @Test
    public void testCountingUniqueWords() {
        assertEquals(2, countingUniqueWords("Hello World "));
        assertEquals(3, countingUniqueWords("Hello World Hello Java "));
        assertEquals(14, countingUniqueWords("Listen to the news from today and "
                + "read the text at the same time Listen to the news from today without reading the text "));
    }
}
