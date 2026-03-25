package dao;

import model.Student;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    //insert
    public void addStudent(Student s){
        String query = "Insert into students (name,marks) values(?,?)";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query)){

            pst.setString(1,s.getName());
            pst.setInt(2,s.getMarks());

            pst.executeUpdate();
            System.out.println("Student added");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public List<Student> getAllStudents(){
        List<Student>list = new ArrayList<>();
        String query = "SELECT * FROM students";

        try(Connection con = DBConnection.getConnection();
            Statement st = con.createStatement()){
            System.out.println("Connected for fetching");
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                System.out.println("Row Found!");

                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("marks")
                ));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public void updateStudent (int id, int marks){
        String query = "UPDATE students SET marks = ? WHERE id = ?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1,marks);
            pst.setInt(2,id);

            pst.executeUpdate();
            System.out.println("Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent(int id){
        String query = "DELETE from students WHERE id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query)){

            pst.setInt(1,id);
            pst.executeUpdate();
            System.out.println("Deleted ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
