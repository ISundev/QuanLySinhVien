/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.ass.service;

import TaoTK.bean.DBContext;
import java.util.ArrayList;
import poly.ass.model.SinhVien;
import java.sql.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import poly.ass.model.Diem;

/**
 *
 * @author cungtiennga
 */
public class SInhVienService {

    Connection cn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    public List<SinhVien> getAll() {
        List<SinhVien> ls = new ArrayList<>();
        try {
            cn = DBContext.getConnection();
            String sql = "SELECT * FROM SINHVIEN";
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                SinhVien s = new SinhVien();
                s.setMaSV(rs.getString(1));
                s.setTenSV(rs.getString(2));
                s.setEmail(rs.getString(3));
                s.setSoDT(rs.getString(4));
                s.setGioiTinh(rs.getString(5));
                s.setDiaChi(rs.getString(6));
                s.setAnh(rs.getString(7));
                s.setUser(rs.getString(8));
                ls.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstm.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ls;
    }

    public Integer insert(SinhVien s) {
        Integer row = null;
        try {
            cn = DBContext.getConnection();
            String sql = "INSERT USERS(USERNAME,PASSWORD,ROLE) values(?,'1',N'Sinh viên')"
                    + "INSERT SINHVIEN(MASV,TENSV,EMAIL,SODT,GIOITINH,DIACHI,ANH,USERNAME) VALUES(?,?,?,?,?,?,?,?)";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, s.getUser());
            pstm.setString(2, s.getMaSV());
            pstm.setString(3, s.getTenSV());
            pstm.setString(4, s.getEmail());
            pstm.setString(5, s.getSoDT());
            pstm.setString(6, s.getGioiTinh());
            pstm.setString(7, s.getDiaChi());
            pstm.setString(8, s.getAnh());
            pstm.setString(9, s.getUser());
            row = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstm.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;
    }

    public Integer update(SinhVien s) {
        Integer row = null;
        try {
            cn = DBContext.getConnection();
            String sql = "UPDATE SINHVIEN SET TENSV=?,EMAIL=?,SODT=?,GIOITINH=?,DIACHI=?,ANH=? WHERE MASV=?";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, s.getTenSV());
            pstm.setString(2, s.getEmail());
            pstm.setString(3, s.getSoDT());
            pstm.setString(4, s.getGioiTinh());
            pstm.setString(5, s.getDiaChi());
            pstm.setString(6, s.getAnh());
            pstm.setString(7, s.getMaSV());
            pstm.executeUpdate();
            row = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstm.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;
    }

    public Integer delete(String MASV) {
        Integer row = null;
        try {
            cn = DBContext.getConnection();
            String sql = "delete GRADE where MASV = ?\n"
                    + "delete STUDENTS where MASV = ?";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, MASV);
            pstm.setString(2, MASV);
            row = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstm.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;
    }

    public ArrayList<SinhVien> timTheoMaSV(String Masv) {
        ArrayList<SinhVien> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select MASV, TENSV, EMAIL, SODT, GIOITINH, DIACHI, ANH,USERNAME from SINHVIEN where MASV = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, Masv);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString("MASV"));
                sv.setTenSV(rs.getString("TENSV"));
                sv.setEmail(rs.getString("EMAIL"));
                sv.setSoDT(rs.getString("SODT"));
                sv.setGioiTinh(rs.getString("GIOITINH"));
                sv.setDiaChi(rs.getString("DIACHI"));
                sv.setUser(rs.getString("USERNAME"));
                list.add(sv);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<SinhVien> sapxeptheoMa() {
        ArrayList<SinhVien> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select *\n"
                + "from SINHVIEN";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString("MASV"));
                sv.setTenSV(rs.getString("TENSV"));
                sv.setEmail(rs.getString("EMAIL"));
                sv.setSoDT(rs.getString("SODT"));
                sv.setGioiTinh(rs.getString("GIOITINH"));
                sv.setDiaChi(rs.getString("DIACHI"));
                sv.setUser(rs.getString("USERNAME"));
                list.add(sv);
                Collections.sort(list, new Comparator<SinhVien>() {
                    @Override
                    public int compare(SinhVien sg1, SinhVien sg2) {
                        String masv1 = sg1.getMaSV();
                        String masv2 = sg2.getMaSV();

                        // So sánh theo kí tự của chuỗi masv
                        return masv1.compareTo(masv2);
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<SinhVien> sapxeptheoTen() {
        ArrayList<SinhVien> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select *\n"
                + "from SINHVIEN";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString("MASV"));
                sv.setTenSV(rs.getString("TENSV"));
                sv.setEmail(rs.getString("EMAIL"));
                sv.setSoDT(rs.getString("SODT"));
                sv.setGioiTinh(rs.getString("GIOITINH"));
                sv.setDiaChi(rs.getString("DIACHI"));
                sv.setUser(rs.getString("USERNAME"));
                list.add(sv);
                Collections.sort(list, new Comparator<SinhVien>() {
                    @Override
                    public int compare(SinhVien o1, SinhVien o2) {
                        String tensv1 = o1.getTenSV();
                        String tensv2 = o2.getTenSV();
                        return tensv1.compareTo(tensv2);
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
