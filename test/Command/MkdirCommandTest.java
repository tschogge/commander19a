package Command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MkdirCommandTest {

    MkdirCommand mkdirCommand = new MkdirCommand();
    @Test
    void validateInput() {

        String illegalCharacters = "abcd%ç&";
        Boolean eIllegalChar = false;
        String legalCharacters = "abc";
        Boolean eLegalChar = true;


        assertEquals(eIllegalChar,mkdirCommand.validateInput(illegalCharacters) );
        assertEquals(eLegalChar, mkdirCommand.validateInput(legalCharacters));
    }

    @Test
    void checkForExistingDirectory() {
        String newNameNotF = "ThisIsATest";
        Boolean eNewNameNotF = false;

        String newNameF = "ThisExists";
        Boolean eNewNameF = true;



    }

    @Test
    void execute() {
    }
}