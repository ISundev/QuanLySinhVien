    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.ass.service;

import TaoTK.bean.DBContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import poly.ass.model.Diem;
import poly.ass.model.SinhVien;

/**
 *
 * @author cungtiennga
 */
public class DiemService {

    public ArrayList<Diem> sapxeptheoDiemTB() {
        ArrayList<Diem> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select MASV,TENSV,JAVA3,CSDL,DUAN1,TIENGANH,(JAVA3 + CSDL + DUAN1 + TIENGANH) / 4 as 'DiemTB'\n"
                + "from BANGDIEM;";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Diem d = new Diem();
                d.setMasv(rs.getString("MASV"));
                d.setTensv(rs.getString("TENSV"));
                d.setJava(rs.getDouble("JAVA3"));
                d.setCsdl(rs.getDouble("CSDL"));
                d.setDuan(rs.getDouble("DUAN1"));
                d.setTienganh(rs.getDouble("TIENGANH"));
                list.add(d);
                Collections.sort(list, new Comparator<Diem>() {
                    @Override
                    public int compare(Diem sg1, Diem sg2) {
                        return Double.compare(sg2.getDiemTb(), sg1.getDiemTb());
                    }
                });

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Integer addDiem(Diem d) {
        Integer row = null;
        Connection con = DBContext.getConnection();
        String sql = "INSERT BANGDIEM(MASV,TENSV,JAVA3,CSDL,DUAN1,TIENGANH) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, d.getMasv());
            pstm.setString(2, d.getTensv());
            pstm.setDouble(3, d.getJava());
            pstm.setDouble(4, d.getCsdl());
            pstm.setDouble(5, d.getDuan());
            pstm.setDouble(6, d.getTienganh());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    public Integer updateDiem(Diem d) {
        Integer row = null;
        Connection con = DBContext.getConnection();
        String sql = "update BANGDIEM set TENSV = ?,JAVA3 = ?,CSDL = ?,DUAN1 = ?,TIENGANH = ? where  MASV = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, d.getTensv());
            pstm.setDouble(2, d.getJava());
            pstm.setDouble(3, d.getCsdl());
            pstm.setDouble(4, d.getDuan());
            pstm.setDouble(5, d.getTienganh());
            pstm.setString(6, d.getMasv());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    public Integer deleteDiem(String masv) {
        Integer row = null;
        Connection con = DBContext.getConnection();
        String sql = "delete BANGDIEM where Masv = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, masv);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    public ArrayList<Diem> sapxeptheoMa() {
        ArrayList<Diem> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select MASV,TENSV,JAVA3,CSDL,DUAN1,TIENGANH,(JAVA3 + CSDL + DUAN1 + TIENGANH) / 4 as 'DiemTB'\n"
                + "from BANGDIEM;";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Diem d = new Diem();
                d.setMasv(rs.getString("MASV"));
                d.setTensv(rs.getString("TENSV"));
                d.setJava(rs.getDouble("JAVA3"));
                d.setCsdl(rs.getDouble("CSDL"));
                d.setDuan(rs.getDouble("DUAN1"));
                d.setTienganh(rs.getDouble("TIENGANH"));
                list.add(d);
                Collections.sort(list, new Comparator<Diem>() {
                    @Override
                    public int compare(Diem sg1, Diem sg2) {
                        String masv1 = sg1.getMasv();
                        String masv2 = sg2.getMasv();

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
    
    public ArrayList<Diem> sapxeptheoTen() {
        ArrayList<Diem> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select MASV,TENSV,JAVA3,CSDL,DUAN1,TIENGANH,(JAVA3 + CSDL + DUAN1 + TIENGANH) / 4 as 'DiemTB'\n"
                + "from BANGDIEM;";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Diem d = new Diem();
                d.setMasv(rs.getString("MASV"));
                d.setTensv(rs.getString("TENSV"));
                d.setJava(rs.getDouble("JAVA3"));
                d.setCsdl(rs.getDouble("CSDL"));
                d.setDuan(rs.getDouble("DUAN1"));
                d.setTienganh(rs.getDouble("TIENGANH"));
                list.add(d);
                Collections.sort(list, new Comparator<Diem>() {
                    @Override
                    public int compare(Diem sg1, Diem sg2) {
                        String tensv1 = sg1.getTensv();
                        String tensv2 = sg2.getTensv();

                        // So sánh theo kí tự của chuỗi masv
                        return tensv1.compareTo(tensv2);
                    }
                });

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public ArrayList<Diem> getAllDiem() {
        ArrayList<Diem> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select MASV,TENSV,JAVA3,CSDL,DUAN1,TIENGANH,(JAVA3 + CSDL + DUAN1 + TIENGANH) / 4 as 'DiemTB'\n"
                + "from BANGDIEM;";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Diem d = new Diem();
                d.setMasv(rs.getString("MASV"));
                d.setTensv(rs.getString("TENSV"));
                d.setJava(rs.getDouble("JAVA3"));
                d.setCsdl(rs.getDouble("CSDL"));
                d.setDuan(rs.getDouble("DUAN1"));
                d.setTienganh(rs.getDouble("TIENGANH"));
                list.add(d);
               
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
     public ArrayList<Diem> sapxeptheoJava() {
        ArrayList<Diem> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select MASV,TENSV,JAVA3,CSDL,DUAN1,TIENGANH,(JAVA3 + CSDL + DUAN1 + TIENGANH) / 4 as 'DiemTB'\n"
                + "from BANGDIEM;";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Diem d = new Diem();
                d.setMasv(rs.getString("MASV"));
                d.setTensv(rs.getString("TENSV"));
                d.setJava(rs.getDouble("JAVA3"));
                d.setCsdl(rs.getDouble("CSDL"));
                d.setDuan(rs.getDouble("DUAN1"));
                d.setTienganh(rs.getDouble("TIENGANH"));
                list.add(d);
                Collections.sort(list, new Comparator<Diem>() {
                    @Override
                    public int compare(Diem jv1, Diem jv2) {
                        return Double.compare(jv2.getJava(), jv1.getJava());
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public ArrayList<Diem> sapxeptheoCosodulieu() {
        ArrayList<Diem> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select MASV,TENSV,JAVA3,CSDL,DUAN1,TIENGANH,(JAVA3 + CSDL + DUAN1 + TIENGANH) / 4 as 'DiemTB'\n"
                + "from BANGDIEM;";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Diem d = new Diem();
                d.setMasv(rs.getString("MASV"));
                d.setTensv(rs.getString("TENSV"));
                d.setJava(rs.getDouble("JAVA3"));
                d.setCsdl(rs.getDouble("CSDL"));
                d.setDuan(rs.getDouble("DUAN1"));
                d.setTienganh(rs.getDouble("TIENGANH"));
                list.add(d);
                Collections.sort(list, new Comparator<Diem>() {
                    @Override
                    public int compare(Diem csdl1, Diem csdl2) {
                        return Double.compare(csdl2.getCsdl(), csdl1.getCsdl());
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public ArrayList<Diem> sapxeptheoDuAn1() {
        ArrayList<Diem> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select MASV,TENSV,JAVA3,CSDL,DUAN1,TIENGANH,(JAVA3 + CSDL + DUAN1 + TIENGANH) / 4 as 'DiemTB'\n"
                + "from BANGDIEM;";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Diem d = new Diem();
                d.setMasv(rs.getString("MASV"));
                d.setTensv(rs.getString("TENSV"));
                d.setJava(rs.getDouble("JAVA3"));
                d.setCsdl(rs.getDouble("CSDL"));
                d.setDuan(rs.getDouble("DUAN1"));
                d.setTienganh(rs.getDouble("TIENGANH"));
                list.add(d);
                Collections.sort(list, new Comparator<Diem>() {
                    @Override
                    public int compare(Diem da1, Diem da2) {
                        return Double.compare(da2.getDuan(), da1.getDuan());
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public ArrayList<Diem> sapxeptheoTiengAnh() {
        ArrayList<Diem> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select MASV,TENSV,JAVA3,CSDL,DUAN1,TIENGANH,(JAVA3 + CSDL + DUAN1 + TIENGANH) / 4 as 'DiemTB'\n"
                + "from BANGDIEM;";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Diem d = new Diem();
                d.setMasv(rs.getString("MASV"));
                d.setTensv(rs.getString("TENSV"));
                d.setJava(rs.getDouble("JAVA3"));
                d.setCsdl(rs.getDouble("CSDL"));
                d.setDuan(rs.getDouble("DUAN1"));
                d.setTienganh(rs.getDouble("TIENGANH"));
                list.add(d);
                Collections.sort(list, new Comparator<Diem>() {
                    @Override
                    public int compare(Diem ta1, Diem ta2) {
                        return Double.compare(ta2.getTienganh(), ta1.getTienganh());
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public ArrayList<Diem> timTheoMaSV(String Masv){
        ArrayList<Diem> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "SELECT * FROM BANGDIEM WHERE MASV = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, Masv);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                Diem d = new Diem();
                d.setMasv(rs.getString("MASV"));
                d.setTensv(rs.getString("TENSV"));
                d.setJava(rs.getDouble("Java3"));
                d.setCsdl(rs.getDouble("CSDL"));
                d.setDuan(rs.getDouble("DUAN1"));
                d.setTienganh(rs.getDouble("TIENGANH"));
                list.add(d);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
