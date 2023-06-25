/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import Model.User;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Acer
 */
public class UserDao {
    public static void save(User user){
        String query = "Insert into user (name,email,mobile,address,password,status) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','false') ";
        DbOperations.setDataOrDelete(query, "Registered Successfully");
    }
    public static User login(String email,String password){
        User user = null;
        try{
            ResultSet rs = DbOperations.getData("Select * from user where email = '"+email+"'and password = '"+password+"'");
            while (rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        return user;
    }
    
}
