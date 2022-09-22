/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import com.sun.webkit.LoadListenerClient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Subject;
import model.User;

/**
 *
 * @author dell
 */
public class SubjectDBContext extends DBContext {

    public List<Subject> getStatusList() {
        List<Subject> list = new ArrayList<>();
        try {
            String sql = "select distinct status from subject";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Subject s = new Subject();
                s.setStatus(rs.getBoolean("status"));
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

//    public static void main(String[] args) {
//        SubjectDBContext user = new SubjectDBContext();
//        List<Subject> u = user.getStatusList();
//        for (Subject subject : u) {
//            System.out.println(subject.getStatus());
//        }
//    }
}
