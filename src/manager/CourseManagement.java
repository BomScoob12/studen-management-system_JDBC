package manager;

import object.Course;
import object.Instructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseManagement {

    private final Connection connection = DatabaseConnecter.connect();
    public boolean addCourse(Course course){
        try{
            String sql = "INSERT INTO courses(courseID, courseDesc) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, course.getCourseID());
            preparedStatement.setString(2, course.getCourseDesc());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e){
            e.getStackTrace();
        }
        return false;
    }

    public boolean addCourse(Course course, Instructor instructor){
        try{
            String sql = "INSERT INTO courses(courseID, courseDesc, instructorID) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, course.getCourseID());
            preparedStatement.setString(2, course.getCourseDesc());
            preparedStatement.setInt(2, instructor.getInstructorID());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e){
            e.getStackTrace();
        }
        return false;
    }

    public boolean deleteCourse(int courseID){
        try {
            String sql = "DELETE FROM courses WHERE courseID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, courseID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e){
            e.getStackTrace();
        }
        return false;
    }
}
