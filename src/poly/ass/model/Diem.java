/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.ass.model;

/**
 *
 * @author cungtiennga
 */
public class Diem {
  private  String masv,tensv;
    private double Java,csdl,duan,tienganh;

    public Diem() {
    }

    public Diem(String masv, String tensv, double Java, double csdl, double duan, double tienganh) {
        this.masv = masv;
        this.tensv = tensv;
        this.Java = Java;
        this.csdl = csdl;
        this.duan = duan;
        this.tienganh = tienganh;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public double getJava() {
        return Java;
    }

    public void setJava(double Java) {
        this.Java = Java;
    }

    public double getCsdl() {
        return csdl;
    }

    public void setCsdl(double csdl) {
        this.csdl = csdl;
    }

    public double getDuan() {
        return duan;
    }

    public void setDuan(double duan) {
        this.duan = duan;
    }

    public double getTienganh() {
        return tienganh;
    }

    public void setTienganh(double tienganh) {
        this.tienganh = tienganh;
    }
    
    public double getDiemTb() {
        return (this.Java + this.csdl + this.duan + this.tienganh)/4;
    }
}
