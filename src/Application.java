import java.sql.Connection;

public class Application{

    private View view = new View();
    private JDBConnection databaseConnection;

    public void startApp(){
        view.displayUserMenu("txt/standardMenu.txt");
        databaseConnection = new JDBConnection("jdbc:sqlite:codecool.db");
        databaseConnection.connectToDatabase();
        view.getUserInput("\n\n\n\n\nPress any key to continue");
        selectResultViaUserChoice();
    }

    private void selectResultViaUserChoice(){
        while(true){
            view.displayUserMenu("txt/standardMenu.txt");
            String userChoice = view.getUserInput("\n\n\nChoose option: ");
            if(userChoice == "0"){
                databaseConnection.closeDatabase();
                System.exit(0);
            }else if(userChoice == "1"){
                databaseConnection.executeQueryAgainstDatabase("SELECT first_name, last_name FROM mentors;");
            }else if(userChoice == "2"){
                databaseConnection.executeQueryAgainstDatabase("");
            }else if(userChoice == "3"){
                databaseConnection.executeQueryAgainstDatabase("");
            }else if(userChoice == "4"){
                databaseConnection.executeQueryAgainstDatabase("");
            }else if(userChoice == "5"){
                databaseConnection.executeQueryAgainstDatabase("");
            }else if(userChoice == "6"){
                databaseConnection.executeQueryAgainstDatabase("");
            }else if(userChoice == "7"){
                databaseConnection.executeQueryAgainstDatabase("");
            }else if(userChoice.equals("8")){
                String userStatement = view.getUserInput("\n\n\nYour statement: ");
                databaseConnection.executeQueryAgainstDatabase(userStatement);
            }
            view.clearScreen();
        }
    }
}