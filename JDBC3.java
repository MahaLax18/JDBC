import java.sql.*; // Step 1: Import

public class JDBCExample {
    // Step 2: Define constants
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    static final String USERNAME = "root"; 
    static final String PASSWORD = "Mahesh3047@"; // CHANGE THIS to your MySQL password

    public static void main(String[] args) {
        
        // Step 4: DELETE query with ?
        String sql = "DELETE FROM users WHERE id = ?";

        // Step 3: try-with-resources block
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Step 5: Create PreparedStatement
            
            System.out.println("Connected to database successfully!");

            pstmt.setInt(1, 2); // Step 5: set id = 2

            int rowsAffected = pstmt.executeUpdate(); // Step 6: Execute DELETE

            // Step 7: Check result
            if (rowsAffected > 0) {
                System.out.println("Row deleted successfully.");
            } else {
                System.out.println("No rows were deleted.");
            }

        } catch (SQLException e) { // Step 8: Handle SQLException
            System.err.println("CONNECTION FAILED!");
            e.printStackTrace();
        }
    }
}
