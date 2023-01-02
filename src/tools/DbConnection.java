package tools;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private Connection con;

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest?zeroDateTimeBehavior=convertToNull","root","pass");
            
        } catch (Exception e) {
            System.out.println("Error + "+ e.getMessage());
        }
        
        return con;
    }
}

