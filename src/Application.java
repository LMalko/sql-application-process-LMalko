import java.sql.Connection;

public class Application{

    private View view = new View();
    private JDBConnection databaseConnection;
    private Connection connection;

    public void startApp(){
        view.displayUserMenu("txt/standardMenu.txt");
        databaseConnection = new JDBConnection("jdbc:sqlite:codecool.db");
        connection = databaseConnection.connectToDatabase();
        view.getUserInput("\n\n\n\n\nPress any key to continue");
    }
}