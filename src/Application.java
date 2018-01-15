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
            if(userChoice.equals("0")){
                databaseConnection.closeDatabase();
                System.exit(0);
            }else if(userChoice.equals("1")){
                databaseConnection.executeQueryAgainstDatabase("SELECT first_name, last_name FROM mentors;");
            }else if(userChoice.equals("2")){
                databaseConnection.executeQueryAgainstDatabase("SELECT nick_name FROM mentors WHERE city='Miskolc';");
            }else if(userChoice.equals("3")){
                databaseConnection.executeQueryAgainstDatabase("SELECT first_name || ' ' || last_name AS full_name, phone_number FROM applicants WHERE first_name='Carol';");
            }else if(userChoice.equals("4")){
                databaseConnection.executeQueryAgainstDatabase("SELECT first_name || ' ' || last_name AS full_name, phone_number FROM applicants WHERE email LIKE '%@adipiscingenimmi.edu';");
            }else if(userChoice.equals("5")){
                databaseConnection.executeUpdateAgainstDatabase("INSERT INTO applicants (first_name, last_name, phone_number, email, application_code) VALUES ('Markus', 'Schaffarzyk', '003620/725-2666', 'djnovus@groovecoverage.com', 54823);");
                databaseConnection.executeQueryAgainstDatabase("SELECT * FROM applicants WHERE application_code=54823;");
            }else if(userChoice.equals("6")){
                databaseConnection.executeUpdateAgainstDatabase("UPDATE applicants SET phone_number='003670/223-7459' WHERE first_name='Jemima' AND last_name='Foreman';");
                databaseConnection.executeQueryAgainstDatabase("SELECT first_name, last_name, phone_number FROM applicants WHERE first_name='Jemima' AND last_name='Foreman';");
            }else if(userChoice.equals("7")){
                databaseConnection.executeUpdateAgainstDatabase("DELETE FROM applicants WHERE email LIKE '%@mauriseu.net';");
            }else if(userChoice.equals("8")){
                String userStatement = view.getUserInput("\n\n\nYour statement: ");
                databaseConnection.executeQueryAgainstDatabase(userStatement);
            }
            view.clearScreen();
        }
    }
}