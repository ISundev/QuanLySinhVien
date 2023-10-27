/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.ass.model;

/**
 *
 * @author cungtiennga
 */
public class SinhVien {
    private String maSV,tenSV,Email,SoDT,gioiTinh,diaChi,anh,User;

    public SinhVien(){
    }

    public SinhVien(String maSV, String tenSV, String Email, String SoDT, String gioiTinh, String diaChi, String anh, String User) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.Email = Email;
        this.SoDT = SoDT;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.anh = anh;
        this.User = User;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    
    
}
