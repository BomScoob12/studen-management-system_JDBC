package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Enrollment {
    static Connection connection = DatabaseConnecter.connect();

    public boolean enrollStudentToCourse(int stdID, int [] courseID){
        try{
            String sql = "INSERT INTO enrollment values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int j : courseID) {
                preparedStatement.setInt(1, stdID);
                preparedStatement.setInt(2, j);
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
            return true;
        } catch (SQLException e){
            e.getStackTrace();
        }
        return false;
    }

    public List<String> listStudentEnroll(){
        try{
            String sql = "select stdID, stdFirstname, stdLastname, courseID, courseDesc\n" +
                    " from enrollment natural join courses natural join students;";
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            LinkedList<String> strList = new LinkedList<>();
            while (resultSet.next()){
                strList.add(String.format("%d %s %s %d %s",
                        resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4),
                        resultSet.getString(5)));
            }
            return strList;
        } catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }
}
