import java.sql.*; // Step 1: Import

public class JDBCExample {
    // Step 2: Define constants
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    static final String USERNAME = "root"; 
    static final String PASSWORD = "Mahesh3047@"; // <-- CHANGE THIS

    public static void main(String[] args) {
        
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                "name VARCHAR(100), " +
                                "email VARCHAR(100))";

        String insertSQL = "INSERT INTO users (name, email) VALUES (?, ?)";

        // Step 3: try-with-resources
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) { 
            
            System.out.println("Connected to database successfully!");

            // Step 4: Create table
            stmt.execute(createTableSQL);

            // Step 5,6,7: Insert 1st record
            pstmt.setString(1, "John Doe"); 
            pstmt.setString(2, "john.doe@example.com");
            pstmt.executeUpdate();

            // Insert 2nd record
            pstmt.setString(1, "Jane Doe"); 
            pstmt.setString(2, "jane.doe@example.com");
            pstmt.executeUpdate();

            // Step 8: Success message
            System.out.println("Data inserted successfully.");

        } catch (SQLException e) { // Step 9: Handle Exception
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
