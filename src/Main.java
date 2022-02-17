import Console.CommandInvoker;
import Console.Console;
import Filesystem.*;
import Services.PersistencyService;

import java.nio.file.FileSystem;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // ablauf methode von console aufrufen, siehe architekturbild im teams chat
        Console console = new Console();
        console.start();
        testSave();


    }
    static public void testSave() {

    }
}