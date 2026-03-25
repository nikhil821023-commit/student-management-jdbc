import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/demo"; // change DB name
        String user = "postgres";
        String password = "Nikhil@86";

        Scanner sc = new Scanner(System.in);

        try {
            // 1. Connect
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to database");

            // 2. Take input
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            int marks = sc.nextInt();

            // 3. SQL Query
            String query = "INSERT INTO students(name, marks) VALUES (?, ?)";

            // 4. Prepare statement
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, name);
            pst.setInt(2, marks);

            // 5. Execute
            int rows = pst.executeUpdate();

            // 6. Check result
            if (rows > 0) {
                System.out.println("✅ Data inserted successfully!");
            } else {
                System.out.println("❌ Insert failed!");
            }

            // 7. Close
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}