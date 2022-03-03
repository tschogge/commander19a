package Command;

import Filesystem.Drive;
import Filesystem.File;
import Filesystem.FilesystemItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MkdirCommandTest {

    MkdirCommand mkdirCommand = new MkdirCommand();

    ArrayList<FilesystemItem> testItems;

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
        int answerNameNotFound = 1;

        String newNameF = "ThisExists";
        Boolean eNewNameF = true;
        int answerNewNameFound = 0;


        assertEquals(eNewNameNotF,mkdirCommand.checkForExistingDirectory(newNameNotF));
        assertEquals(eNewNameF, mkdirCommand.checkForExistingDirectory(newNameF));





    }

    @Test
    void execute() {


    }
}