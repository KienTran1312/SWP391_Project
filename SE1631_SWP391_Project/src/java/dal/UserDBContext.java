/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Subject;
import model.User;

/**
 *
 * @author dell
 */
public class UserDBContext extends DBContext {

    public ArrayList<User> getManagerList() {
        ArrayList<User> list = new ArrayList<>();
        try {
            String sql = "select distinct u.user_id, u.full_name from subject s inner join user u on u.user_id = s.manager_id";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
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
            String sql = "select distinct u.user_id, u.full_name from subject s inner join user u on u.user_id = s.expect_id";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setFullname(rs.getString("full_name"));
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public User getUserDetails(User entity) {
        try {
            String sql = "select * from user where user_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, entity.getUserId());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setFullname(rs.getString("full_name"));
                u.setEmail(rs.getString("email"));
                u.setMobile(rs.getString("mobile"));
                u.setPassword(rs.getString("password"));
                u.setAvatarURL(rs.getString("avatar_url"));
                u.setStatus(rs.getBoolean("status"));
                u.setNote(rs.getString("note"));
                return u;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public void updateSubjectDetails(User entity) {
        try {
            String sql = "update user\n"
                    + "set full_name = ?, email= ?, mobile = ?,\n"
                    + "status = ?, note = ? where user_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, entity.getFullname());
            stm.setString(2, entity.getEmail());
            stm.setString(3, entity.getMobile());
            stm.setBoolean(4, entity.getStatus());
            stm.setString(5, entity.getNote());
            stm.setInt(6, entity.getUserId());
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void main(String[] args) {
//        UserDBContext user = new UserDBContext();
//        User u = new User(1, "Tran Trung Kien", "tkien2911@gmai.com", "0838776396", true, "nothing");
//        user.updateSubjectDetails(u);
//    }
}
