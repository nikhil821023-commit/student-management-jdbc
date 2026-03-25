import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoJdbc {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "Nikhil@86";

        try {
            Connection con = DriverManager.getConnection(url, uname, pass);

            if (con != null && !con.isClosed()) {
                System.out.println("✅ Connected!");

                // Execute query
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM students");

                // Print data
                while (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " | " +
                                    rs.getString("name") + " | " +
                                    rs.getInt("marks")
                    );
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}