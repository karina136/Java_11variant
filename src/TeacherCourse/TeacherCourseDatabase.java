package TeacherCourse;

import DB.DatabaseConnector;
import Unit.TeacherCourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherCourseDatabase {

    private Connection connection;
    private List<TeacherCourse> programs;

    public TeacherCourseDatabase() {
        try {
            connection = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static final String SELECT_ALL_TEACHERSCOURSE = "SELECT * FROM teachercourse.public.teachercourse";
    private static final String INSERT_TEACHERCOURSE = "INSERT INTO teachercourse.public.teachercourse (teacher_name, age, course_name, hours) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_TEACHERCOURSE = "UPDATE teachercourse.public.teachercourse SET teacher_name = ?, age = ?, course_name = ?, hours = ? WHERE id = ?";
    private static final String DELETE_TEACHERCOURSE = "DELETE FROM teachercourse.public.teachercourse WHERE id = ?";

    private Connection getConnection() throws SQLException {
        return DatabaseConnector.getConnection();
    }
    public List<TeacherCourse> getAllTeacherCourse() {
        List<TeacherCourse> teacherCourses = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_TEACHERSCOURSE);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String teacher_name = resultSet.getString("teacher_name");
                Integer age = resultSet.getInt("age");
                String course_name = resultSet.getString("course_name");
                Integer hours = resultSet.getInt("hours");

                TeacherCourse film = new TeacherCourse(id, teacher_name, age, course_name, hours);
                teacherCourses.add(film);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacherCourses;
    }

    public void addTeacherCourse(TeacherCourse teacherCourse) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_TEACHERCOURSE)) {

            statement.setString(1, teacherCourse.getName_teacher());
            statement.setInt(2, teacherCourse.getAge());
            statement.setString(3, teacherCourse.getCourse_name());
            statement.setInt(4, teacherCourse.getHours());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTeacherCourse(TeacherCourse teacherCourse) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_TEACHERCOURSE)) {

            statement.setString(1, teacherCourse.getName_teacher());
            statement.setInt(2, teacherCourse.getAge());
            statement.setString(3, teacherCourse.getCourse_name());
            statement.setInt(4, teacherCourse.getHours());
            statement.setInt(5, teacherCourse.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTeacherCourse(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TEACHERCOURSE)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public TeacherCourse getTeacherCourse(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM teachercourse.public.teachercourse WHERE id = ?")) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    TeacherCourse teacherCourse = new TeacherCourse();
                    teacherCourse.setId(resultSet.getInt("id"));
                    teacherCourse.setTeacherName(resultSet.getString("teacher_name"));
                    teacherCourse.setAge(resultSet.getInt("age"));
                    teacherCourse.setCourseName(resultSet.getString("course_name"));
                    teacherCourse.setHours(resultSet.getInt("hours"));
                    return teacherCourse;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}