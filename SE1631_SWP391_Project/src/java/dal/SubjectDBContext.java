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

    public ArrayList<Subject> pagingSearchSubject(int index, String txt) {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            String sql = "SELECT subject_id, subject_code, subject_name, manager_id, expect_id, status \n"
                    + "FROM subject where subject_code like ? or subject_name like ? LIMIT ?,4";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + txt + "%");
            stm.setString(2, "%" + txt + "%");
            stm.setInt(3, (index - 1) * 4);
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

    public int totalSearchPage(String txt) {
        int total = 0;
        try {
            String sql = "select count(*) from subject where subject_code like ? or subject_name like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + txt + "%");
            stm.setString(2, "%" + txt + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }

        return 0;
    }

    public ArrayList<Subject> Filter(int managerId, int expertId, int status, String txtSearch, int pageIndex) {
        ArrayList<Subject> list = new ArrayList<>();
//        String sql = "select * from(SELECT subject_id, subject_code, subject_name, manager_id, expect_id, status, \n"
//                + "ROW_NUMBER() OVER(order by subject_id asc) as row_index FROM subject where (1=1)";
        try {
//            HashMap<Integer, Object[]> parameters = new HashMap<>();
//            int paramIndex = 0;
//            if (managerId != -1) {
//                sql += "and manager_id = ?";
//                paramIndex++;
//                Object[] param = new Object[2];
//                param[0] = String.class.getTypeName();
//                param[1] = managerId;
//                parameters.put(paramIndex, param);
//            }
//            if (expertId != -1) {
//                sql += "and expect_id = ?";
//                paramIndex++;
//                Object[] param = new Object[2];
//                param[0] = String.class.getTypeName();
//                param[1] = expertId;
//                parameters.put(paramIndex, param);
//            }
            boolean bit = false;
            if (status == 1) {
                bit = true;
            }
//            if (status != null) {
//                sql += "and status = 1";
//                paramIndex++;
//                Object[] param = new Object[2];
//                param[0] = String.class.getTypeName();
//                param[1] = status;
//                parameters.put(paramIndex, param);
//            }
//            if (txtSearch != null) {
//                sql += "and  like '%vov%' or subject_name like '%vovinam%') ";
//                paramIndex++;
//                Object[] param = new Object[2];
//                param[0] = String.class.getTypeName();
//                param[1] = txtSearch;
//                parameters.put(paramIndex, param);
//            }
//            sql += "as subject where row_index between ? * 4 - 3 and ? * 4";
//
//            paramIndex++;
//            Object[] param = new Object[2];
//            param[0] = Integer.class.getTypeName();
//            param[1] = pageIndex;
//            parameters.put(paramIndex, param);
//            // dấu hỏi số 2 của where row_index >= ....
//            paramIndex++;
//            param = new Object[2];
//            param[0] = Integer.class.getTypeName();
//            param[1] = pageIndex;
//            parameters.put(paramIndex, param);

            String sql = "select * from(SELECT subject_id, subject_code, subject_name, manager_id, expect_id, status, \n"
                    + "ROW_NUMBER() OVER(order by subject_id asc) as row_index FROM subject where manager_id = " + managerId + " \n"
                    + "and expect_id = " + expertId + " and status = " + bit + " and (subject_code like '%" + txtSearch + "%' or subject_name like '%" + txtSearch + "%'))\n"
                    + "as subject where row_index between " + pageIndex + " * 4 - 3 and " + pageIndex + " * 4";
                       
            PreparedStatement stm = connection.prepareStatement(sql);
//            for (Map.Entry<Integer, Object[]> entry : parameters.entrySet()) {
//                Integer index = entry.getKey();
//                Object[] value = entry.getValue();
//                String type = value[0].toString();
//                
//                if (type.equals(Integer.class.getName())) {
//                    stm.setInt(index, Integer.parseInt(value[1].toString()));
//                } else if (type.equals(String.class.getName())) {
//                    stm.setString(index, value[1].toString());
//                } else if (type.equals(Boolean.class.getName())) {
//                    stm.setBoolean(index, Boolean.parseBoolean(value[1].toString()));
//                }
//            }

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
//            HashMap<Integer, Object[]> parameters = new HashMap<>();
//            int paramIndex = 0;
//            if (managerId != -1) {
//                sql += "and manager_id = ? ";
//                paramIndex++;
//                Object[] param = new Object[2];
//                param[0] = String.class.getTypeName();
//                param[1] = managerId;
//                parameters.put(paramIndex, param);
//            }
//            if (expertId != -1) {
//                sql += "and expect_id = ? ";
//                paramIndex++;
//                Object[] param = new Object[2];
//                param[0] = String.class.getTypeName();
//                param[1] = status;
//                parameters.put(paramIndex, param);
//            }
//            if (status != null) {
//                sql += " and status = ? ";
//                paramIndex++;
//                Object[] param = new Object[2];
//                param[0] = String.class.getTypeName();
//                param[1] = status;
//                parameters.put(paramIndex, param);
//            }
//            if (txtSearch != null) {
//                sql += "and subject_code like '%' ? '%'";
//                paramIndex++;
//                Object[] param = new Object[2];
//                param[0] = String.class.getTypeName();
//                param[1] = txtSearch;
//                parameters.put(paramIndex, param);
//            }
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
//        System.out.println("");
//        System.out.println(user.Filter(1, 2, true, "oop", 1));
//    }
}
