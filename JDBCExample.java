import java.sql.*;

public class JDBCExample {
    // CHANGE PASSWORD if yours is different
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    static final String USERNAME = "root"; 
    static final String PASSWORD = "Mahesh3047@"; // <-- Put your MySQL password here

    public static void main(String[] args) {
        System.out.println("Trying to connect to MySQL...");
        
        String sql = "SELECT * FROM users";

        try (
            Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {
            System.out.println("Connected to database successfully!\n");

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                System.out.printf("User ID: %d, Username: %s, Email: %s%n", id, username, email);
            }

        } catch (SQLException e) {
            System.err.println("CONNECTION FAILED!");
            System.err.println("Error: " + e.getMessage());
        }
    }
}