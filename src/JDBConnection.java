import java.sql.*;

public class JDBConnection{

    String filename;

    public JDBConnection(String filename){
        this.filename = filename;
    }

    public Connection connectToDatabase() {

        Connection connection = null;
        
        try {
            // Register JDBC driver.
            Class.forName("org.sqlite.JDBC");
            // Open a connection to database.
            connection = DriverManager.getConnection(filename);
        }catch ( Exception exception ) {
            System.err.println( exception.getClass().getName() + ": " + exception.getMessage() );
            System.exit(0);
        }
        System.out.println("Database has opened successfully");
        return connection;
    }

    public void executeStatementAgainstDatabase(String statement){
        connectToDatabase();
    }

}