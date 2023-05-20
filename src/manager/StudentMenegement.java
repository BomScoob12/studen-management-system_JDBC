package manager;

import object.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class StudentMenegement {

    private final Connection connection = DatabaseConnecter.connect();
    public boolean addStudent(Student student){
        Date date = Date.valueOf(LocalDate.now());
        try {
            String sql = "INSERT INTO students(stdID, stdFirstname, stdLastname, registerDate)" +
                    "VALUES( ?, ?, ?, ?)";
            String selectLast = "SELECT MAX(stdID) FROM students";
            ResultSet result = connection.createStatement().executeQuery(selectLast);
            int lastID = 0;
            if(result.next()) {
                lastID = result.getInt(1);
            }
            result.close();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ++lastID);
            preparedStatement.setString(2, student.getFirstname());
            preparedStatement.setString(3, student.getLastname());
            preparedStatement.setDate(4, date);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e){
            e.getStackTrace();
        }
        return false;
    }

    public List<String> listAllStudent(){
        try{
            String sql = "SELECT * FROM students";
            ResultSet result = connection.createStatement().executeQuery(sql);
            LinkedList<String> allStd = new LinkedList<>();
            while (result.next()){
                String str = String.format("%d %s %s %s", result.getInt(1), result.getString(2), result.getString(3), result.getDate(4));
                allStd.add(str);
            }
            return allStd;
        } catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    public String getStudentById(int id){
        try{
            String sql = "SELECT * FROM students WHERE stdID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return String.format("%d %s %s %s", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4));
            }
        } catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }
}
