package bank.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn{
    public Connection c;
    public Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/bankmanagementsystem", "root", "yvk@1234");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
