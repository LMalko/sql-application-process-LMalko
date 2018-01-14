import java.sql.*;

public class JDBConnection{
    public static void main( String args[] ) {
        Connection connection = null;
        
        try {
           Class.forName("org.sqlite.JDBC");
           connection = DriverManager.getConnection("jdbc:sqlite:codecool.db");
        } catch ( Exception exception ) {
           System.err.println( exception.getClass().getName() + ": " + exception.getMessage() );
           System.exit(0);
        }
        System.out.println("Opened database successfully");
     }
}