/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaoTK.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sontr
 */
public class TKDAO {
    public List<UserBean> getTKList(){
        try {
            Connection conn = ConnectionProvider.getConnection();
            Statement stm = conn.createStatement();
            String sql = "SELECT MAGV, TENGV, EMAIL, SODT, GIOITINH, DIACHI FROM TTGV";
            ResultSet rs = stm.executeQuery(sql);

            List<UserBean> userList = new ArrayList<>();
            while (rs.next()) {
                String maGV = rs.getString(1);
                String tenGV = rs.getString(2);
                String email = rs.getString(3);
                String soDT = rs.getString(4);
                String gioiTinh = rs.getString(5);
                String diaChi = rs.getString(6);

                UserBean userBean = new UserBean();
                userBean.setMaGV(maGV);
                userBean.setTenGV(tenGV);
                userBean.setEmail(email);
                userBean.setSoDT(soDT);
                userBean.setGioiTinh(gioiTinh);
                userBean.setDiaChi(diaChi);

                userList.add(userBean);
            }
            return userList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<UserBean>();
        }
    }
      public boolean createUser(UserBean userBean) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            String sql = "INSERT INTO USERS(USERNAME, PASSWORD, ROLE) VALUES(?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, userBean.getMaGV());
            stm.setString(2, userBean.getTenGV());
            stm.setString(3, userBean.getEmail());
            stm.setString(4, userBean.getSoDT());
            stm.setString(5, userBean.getGioiTinh());
            stm.setString(6, userBean.getDiaChi());
            return stm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
}
