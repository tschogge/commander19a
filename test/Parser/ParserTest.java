package Parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class ParserTest {
    Parser parser = new Parser();

   /* @Test
    void checkEntity() {
        //Test false
        String testStringForCheck = "";
        assertFalse(parser.checkEntity(testStringForCheck));

        //Test true
        testStringForCheck = "dir";
        assertTrue(parser.checkEntity(testStringForCheck));
    }
    */
    // Dieser test testet ob die Methode "equals" funktioniert, habe nun die validierung geändert also die methode gibt es nicht mehr

    @Test
    void parseWhole() {
        //Test 1
        String testStringForParseWhole = "dir test";
        String[] expectedArray = {"dir", "test"};
        assertArrayEquals(expectedArray, parser.parseWhole(testStringForParseWhole).toArray());

        //Test 2
        testStringForParseWhole = "rm dir test";
        expectedArray = new String[]{"rm", "dir", "test"};
        assertArrayEquals(expectedArray, parser.parseWhole(testStringForParseWhole).toArray());

    }

    @Test
    void commandOnly() {
        //Test 1
        String testStringForCommand = "dir test";
        String expectedOutput = "dir";
        assertEquals(expectedOutput, parser.commandOnly(testStringForCommand));

        //Test 2
        testStringForCommand = "rm test -e";
        expectedOutput = "rm";
        assertEquals(expectedOutput, parser.commandOnly(testStringForCommand));
    }

    @Test
    void parseParameter() {
    }
}