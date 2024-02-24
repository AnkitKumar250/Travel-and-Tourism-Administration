import java.sql.*;


public class Conn {
    /* 5 steps for JDBC Connectivity - 1. Register the driver class. 2. Creating connection string 3. Creating the statement
       4. Executing mySQL queries */

    Connection c;
    Statement s;
    public Conn() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem", "root", "gtv001230");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
