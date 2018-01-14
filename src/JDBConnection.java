import java.sql.*;

public class JDBConnection{

    String filename;

    public JDBC(String filename){
        this.filename = filename;
        connect_to_database();
    }

    private void connect_to_database() {
        Connection connection = null;
        
        try {
           Class.forName("org.sqlite.JDBC");
           connection = DriverManager.getConnection(filename);
        } catch ( Exception exception ) {
           System.err.println( exception.getClass().getName() + ": " + exception.getMessage() );
           System.exit(0);
        }
        System.out.println("Database has opened successfully");
     }
}