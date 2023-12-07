
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class StudentDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private String jdbcUser = "root";
    private String jdbcPassword = "22012001Quan";

    private static final String SELECT_BY_ID = "SELECT * FROM test.student WHERE id LIKE ?";
    private static final String SELECT_BY_NAME = "SELECT * FROM test.student WHERE name LIKE ?";
    private static final String SELECT_BY_DOB = "SELECT * FROM test.student WHERE dob LIKE ?";
    private static final String SELECT_BY_DEPARTMENT = "SELECT * FROM test.student WHERE department LIKE ?";
    private static final String SELECT_ALL_STUDENTS = "select * from test.student";
    private static final String UPDATE_SELECTED = "update test.student set selected = ? where id = ?";

    public StudentDAO() {
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public List<Student> getStudentsByString(String id, String name, String dob, String department) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection()) {

            String statement = new String();
            boolean idEmpty;
            boolean nameEmpty;
            boolean dobEmpty;
            boolean departmentEmpty;

            if (!id.isEmpty()) {
                statement = SELECT_BY_ID;
                idEmpty = true;
            } else if (!name.isEmpty()) {
                statement = SELECT_BY_NAME;
                nameEmpty = true;
            } else if (!dob.isEmpty()) {
                statement = SELECT_BY_DOB;
            } else if (!department.isEmpty()) {
                statement = SELECT_BY_DEPARTMENT;
            }

            PreparedStatement preparedStatement = connection.prepareStatement(statement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id1 = rs.getString("id");
                String name1 = rs.getString("name");
                String dob1 = rs.getString("dob");
                String department1 = rs.getString("department");
                int select = rs.getInt("selected");

                students.add(new Student(id1, name1, dob1, department1, select));
            }
            connection.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String dob = rs.getString("dob");
                String department = rs.getString("department");
                int select = rs.getInt("selected");

                students.add(new Student(id, name, dob, department, select));
            }
            connection.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public void updateStudent(String id) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SELECTED);

            preparedStatement.setString(2, id);
            preparedStatement.setInt(1, 1);

            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
