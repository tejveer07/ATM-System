import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection con;
    Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "tejvr");
            s = con.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
