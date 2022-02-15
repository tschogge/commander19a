package Command;

public class VerCommand extends Command{

    public static int requiredArguments = 0;

    private String versionName;
    private String versionDisplayText = "System is running on:";
    private String versionNumber;


    //Display from OS-System
    //Display Console-App-Version
    //Look if linux easily done





    public String versionName(){

        return System.getProperty("os.name");


    }

    public String versionNumber(){

        return System.getProperty(versionName);
    }

    public void displayAll(){

        versionName = versionName();
        versionNumber = versionNumber();


        System.out.println(versionDisplayText + " " + versionName + " " + versionNumber );
    }







}
