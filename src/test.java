import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test {
    public static void main(String args[]) {
        test re = new test();
        re.createConnection();
    }

    void createConnection(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iaso_hospital_db_v06", "root", "password");
            System.out.println("Database Connection Success!");
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
