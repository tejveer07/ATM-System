import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;  
import java.sql.Statement;  

public class db {  
    public static void main(String[] args) {  
        String url = "jdbc:mysql://localhost:3306/hospital";  
        String user = "root";  
        String password = "tejvr";  
        
        try {  
            Connection conn = DriverManager.getConnection(url, user, password);  
            Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT * FROM marks");  

            while (rs.next()) {  
                System.out.println(rs.getString("name"));  
            }  
            
            conn.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
} 
