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

    public ArrayList<Subject> pagingSearchSubject(int index, String txt) {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            String sql = "SELECT subject_id, subject_code, subject_name, manager_id, expect_id, status \n"
                    + "FROM subject where subject_code like ? LIMIT ?,4";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + txt + "%");
            stm.setInt(2, (index - 1) * 4);
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

    public int totalSearchPage(String txt) {
        int total = 0;
        try {
            String sql = "select count(*) from subject where subject_code like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + txt + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }

        return 0;
    }

    public ArrayList<Subject> pagingSubject(int index) {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            String sql = "SELECT subject_id, subject_code, subject_name, manager_id, expect_id, status \n"
                    + "FROM subject LIMIT ?,5";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 5);
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

//    public static void main(String[] args) {
//        SubjectDBContext user = new SubjectDBContext();
//
//        System.out.println(user.pagingSearchSubject(1, "JPD"));
//    }
}
