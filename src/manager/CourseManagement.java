package manager;

import object.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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

    public boolean updateCourse(int courseID, String desc){
        try{
            String sql = "UPDATE courses SET courseDesc = ? WHERE courseID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,desc);
            preparedStatement.setInt(2, courseID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e ){
            e.getStackTrace();
        }
        return false;
    }

    public List<Course> listAllCourse(){
        try{
            LinkedList<Course> allCourse = new LinkedList<>();
            String sql = "SELECT * FROM courses";
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                Course course = new Course(resultSet.getInt(1), resultSet.getString(2));
                allCourse.add(course);
            }
            return allCourse;
        } catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }
}
