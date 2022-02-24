package Command;

import Filesystem.Drive;
import Filesystem.FilesystemItem;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MkdirCommand extends Command{
    public MkdirCommand(){

    }



    public static int requiredArguments = 1;
    //only name of directory is needed


    private String givenOverParameterName;
    private String currentDirectoryPath;
    private int counterForLoop = 0;
    private String selfcreatedPath;

    private ArrayList<String> filesystemItemNames;
    private int arrayListOfNamesAmount;

    private String errNotViableName = "The given name is not viable, please make it longer than 0 characters and without special characters";
    private String errDirFound = "The given name has already been found, please choose a new name and try again";

    /***
     * @filesystemItemNames in dieser ArrayList werden alle Namen der FilesystemItems gespeichert
     * @givenOverParamterName is to be filled with the given parameter in Command Line within the app
     * @currentDirectoryPath is used to find all directories within the current directories
     * @wishedNameIsViableLength is a boolean to check if the name which was given is viable
     */

    public Boolean validateInput(String nameOfToBeCreatedDirectory){
        if(nameOfToBeCreatedDirectory.length() > 0){


            Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(nameOfToBeCreatedDirectory);
            boolean wishedNameHasSpecialCharacters = m.find();

            if(wishedNameHasSpecialCharacters){
                outputWriter.println(errNotViableName);
                return false;

            }

            return true;

        }else{
            //give error for no given Name

            outputWriter.println(errNotViableName);

            return false;
        }

    }

    public boolean checkForExistingDirectory(String nameOfToBeCreatedDirectory){


        Drive drive = new Drive();

        currentDirectoryPath = drive.getCurrentDirectory().getPath();

        for(FilesystemItem filesystemItem : drive.getCurrentDirectory().getFilesystemItems()){

            filesystemItemNames.add(filesystemItem.getName());
            counterForLoop++;
        }

        arrayListOfNamesAmount = filesystemItemNames.size();

        for(int counter = 0; counter < arrayListOfNamesAmount; counter++){


            // if existing filesname matches with the wished directory name --> set true
            if(nameOfToBeCreatedDirectory.equals(filesystemItemNames.get(counter))){
                outputWriter.println(errDirFound);
                return true;
            }
        }


        return false;



    }

    public void createNewDirectory(String givenOverParameterName){


        if(checkForExistingDirectory(givenOverParameterName) == false && validateInput(givenOverParameterName) == true){
            //create new Directory

            selfcreatedPath = givenOverParameterName + "//";
            FilesystemItem filesystemItem = new FilesystemItem(givenOverParameterName, selfcreatedPath);



            Drive drive = new Drive();



        }
    }

}
