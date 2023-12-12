package TeacherCourse;

import DB.DatabaseConnector;
import Unit.TeacherCourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherCourseUpdater {
    private Connection connection;
    private static final String UPDATE_TEACHERCOURSE = "UPDATE teachercourse.public.teachercourse SET teacher_name = ?, age = ?, course_name = ?, hours = ? WHERE id = ?";

    public TeacherCourseUpdater() {
        try {
            connection = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTeacherCourse(TeacherCourse teacherCourse) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_TEACHERCOURSE)) {

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
