import java.sql.*;

public class StudentDAO {

    public void addStudent(Student s) {
        String query = "INSERT INTO students VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, s.getId());
            pst.setString(2, s.getName());
            pst.setString(3, s.getCourse());
            pst.setDouble(4, s.getMarks());

            int rows = pst.executeUpdate();
            System.out.println(rows + " student inserted successfully.");

        } catch (SQLException e) {
            System.out.println("Insert Error: " + e.getMessage());
        }
    }

    public void viewStudents() {
        String query = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("course") + " " +
                        rs.getDouble("marks")
                );
            }

        } catch (SQLException e) {
            System.out.println("View Error: " + e.getMessage());
        }
    }

    public void searchStudent(int id) {
        String query = "SELECT * FROM students WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Marks: " + rs.getDouble("marks"));
            } else {
                System.out.println("Student Not Found");
            }

        } catch (SQLException e) {
            System.out.println("Search Error: " + e.getMessage());
        }
    }

    public void updateStudent(int id, String name, String course, double marks) {
        String query = "UPDATE students SET name=?, course=?, marks=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, name);
            pst.setString(2, course);
            pst.setDouble(3, marks);
            pst.setInt(4, id);

            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("Student Updated Successfully");
            else
                System.out.println("Student Not Found");

        } catch (SQLException e) {
            System.out.println("Update Error: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("Student Deleted Successfully");
            else
                System.out.println("Student Not Found");

        } catch (SQLException e) {
            System.out.println("Delete Error: " + e.getMessage());
        }
    }
}