/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import static dal.DBContext.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author dell
 */
public class UserDBContext {
    
    public List<User> getManagerList() {
        List<User> list = new ArrayList<>();
        try {
            String sql = "select distinct u.full_name from subject s inner join user u on u.user_id = s.manager_id";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                User u = new User();
                u.setFullname(rs.getString("full_name"));
                
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
}
