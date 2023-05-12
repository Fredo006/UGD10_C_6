/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author
 *
 * I Putu Trisna Budi Utama      | 210711438
 * Boniface Fredo Ronan Antolino | 210711446
 * 
 */
public class Customer {
    private int id;
    private String nama;
    private String ktp;
    private String no_telepon;

    public Customer(int id, String nama, String ktp, String no_telepon) {
        this.id = id;
        this.nama = nama;
        this.ktp = ktp;
        this.no_telepon = no_telepon;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getKtp() {
        return ktp;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }
    
    @Override
    public String toString(){
        return nama;
    }
}
