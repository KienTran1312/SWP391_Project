/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author dell
 */
public class UserDBContext extends DBContext {
    
    public ArrayList<User> getManagerList() {
        ArrayList<User> list = new ArrayList<>();
        try {
            String sql = "select distinct u.full_name from subject s inner join user u on u.user_id = s.manager_id";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                User u = new User();
                u.setFullname(rs.getString("full_name"));
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public ArrayList<User> getExpertList() {
        ArrayList<User> list = new ArrayList<>();
        try {
            String sql = "select distinct u.full_name from subject s inner join user u on u.user_id = s.expect_id";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                User u = new User();
                u.setFullname(rs.getString("full_name"));
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    
    
//    public static void main(String[] args) {
//        UserDBContext user = new UserDBContext();
//        List<User> u = user.getManagerList();
//        for (User user1 : u) {
//            System.out.println(user1.getFullname());
//        }
//    }
}
