package Parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;



class ParserTest {
    Parser parser = new Parser();

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

        //Test 1

        String testStringForParameter = "dir test please";
        String[] expectedArray = {"test", "please"};

        assertArrayEquals(expectedArray, parser.parseParameter(testStringForParameter).toArray());

        //Test 2
        testStringForParameter = "dir thank you";
        String[] expectedArrayOut = {"thank", "you"};
        assertArrayEquals(expectedArrayOut, parser.parseParameter(testStringForParameter).toArray());
    }

    @Test
    void commandOnlySensitiveTest(){

        //Test 1
        String testStringForCommand = "dir test";
        String expectedOutput = "dir";
        assertEquals(expectedOutput, parser.commandOnly(testStringForCommand));

        //Test 2
        testStringForCommand = "RM test -e";
        expectedOutput = "rm";
        assertEquals(expectedOutput, parser.commandOnly(testStringForCommand));

    }


    @Test
    void parameterSensitiveTest(){
        //Test 1

        String testStringForParameter = "dir test please";
        String[] expectedArray = {"test", "please"};

        assertArrayEquals(expectedArray, parser.parseParameter(testStringForParameter).toArray());

        //Test 2
        testStringForParameter = "DIR Thank you";
        String[] expectedArrayOut = {"Thank", "you"};
        assertArrayEquals(expectedArrayOut, parser.parseParameter(testStringForParameter).toArray());
    }
}