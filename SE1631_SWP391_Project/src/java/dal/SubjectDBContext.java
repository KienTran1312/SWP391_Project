/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import com.sun.webkit.LoadListenerClient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Subject;
import model.User;

/**
 *
 * @author dell
 */
public class SubjectDBContext extends DBContext {

    public ArrayList<Subject> getStatusList() {
        ArrayList<Subject> list = new ArrayList<>();
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

    public ArrayList<Subject> getSubjectList() {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            String sql = "select subject_id, subject_code, subject_name, manager_id, expect_id, status from subject";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Subject s = new Subject();
                s.setSubjectId(rs.getInt("subject_id"));
                s.setSubjectCode(rs.getString("subject_code"));
                s.setSubjectName(rs.getString("subject_name"));
                s.setManagerId(rs.getInt("manager_id"));
                s.setExpertId(rs.getInt("expect_id"));
                s.setStatus(rs.getBoolean("status"));
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;

    }

    //sô trang cua subject list
    public int totalPage() {
        int total = 0;
        try {
            String sql = "select count(*) from subject";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }

        return 0;
    }

    //phân trang cho subject list
    public ArrayList<Subject> pagingSubject(int index) {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            String sql = "select s.subject_id, s.subject_code, s.subject_name, u.full_name, u2.full_name, \n"
                    + "s.status, s.manager_id,s.expect_id FROM subject s inner join \n"
                    + "user u on u.user_id = s.manager_id inner join user u2 on u2.user_id = s.expect_id \n"
                    + "order by s.subject_id asc limit ?,5";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 5);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subject s = new Subject();
                s.setSubjectId(rs.getInt(1));
                s.setSubjectCode(rs.getString(2));
                s.setSubjectName(rs.getString(3));
                s.setManagerName(rs.getString(4));
                s.setExpertName(rs.getString(5));
                s.setStatus(rs.getBoolean(6));
                s.setManagerId(rs.getInt(7));
                s.setExpertId(rs.getInt(8));
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;

    }

    public ArrayList<Subject> Filter(int managerId, int expertId, int status, String txtSearch, int pageIndex) {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            boolean bit = false;
            if (status == 1) {
                bit = true;
            }
            String sql = "select * from(SELECT subject_id, subject_code, subject_name, manager_id, expect_id, status, \n"
                    + "ROW_NUMBER() OVER(order by subject_id asc) as row_index FROM subject where manager_id = " + managerId + " \n"
                    + "and expect_id = " + expertId + " and status = " + bit + " and (subject_code like '%" + txtSearch + "%' or subject_name like '%" + txtSearch + "%'))\n"
                    + "as subject where row_index between " + pageIndex + " * 4 - 3 and " + pageIndex + " * 4";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subject s = new Subject();
                s.setSubjectId(rs.getInt("subject_id"));
                s.setSubjectCode(rs.getString("subject_code"));
                s.setSubjectName(rs.getString("subject_name"));
                s.setManagerId(rs.getInt("manager_id"));
                s.setExpertId(rs.getInt("expect_id"));
                s.setStatus(rs.getBoolean("status"));
                list.add(s);
            }
        } catch (Exception ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int countFilter(int managerId, int expertId, int status, String txtSearch) {
        int total = 0;
        String sql;
        try {
            boolean bit = false;
            if (status == 1) {
                bit = true;
            }
            sql = "SELECT count(*)\n"
                    + " FROM subject where manager_id = " + managerId + " \n"
                    + "and expect_id = " + expertId + " and status = " + bit + " and \n"
                    + "subject_code like '%" + txtSearch + "%' or subject_name like '%" + txtSearch + "%'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

//    public static void main(String[] args) {
//        SubjectDBContext user = new SubjectDBContext();
//        ArrayList<User> list = new ArrayList<>();
//        for (User u : list) {
//            user.pagingSubject(1);
//        }
//    }
}
