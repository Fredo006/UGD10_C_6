/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import exception.*;

/**
 *
 * @author
 *
 * I Putu Trisna Budi Utama      | 210711438
 * Boniface Fredo Ronan Antolino | 210711446
 * 
 */
public class Kendaraan {
    private String id;
    private String merk;
    private String jenis;
    private int tahunPembuatan;
    private String noPlat;
    private int jumlah_penumpang;
    private String jenis_tak;

    public Kendaraan(String id, String merk, String jenis, int tahunPembuatan, String noPlat, int jumlah_penumpang, String jenis_tak) throws InvalidIDException{
        this.id = id;
        this.merk = merk;
        this.jenis = jenis;
        this.tahunPembuatan = tahunPembuatan;
        this.noPlat = noPlat;
        this.jumlah_penumpang = jumlah_penumpang;
        this.jenis_tak = jenis_tak;
    }

    public String getId() {
        return id;
    }

    public String getMerk() {
        return merk;
    }

    public String getJenis() {
        return jenis;
    }

    public int getTahunPembuatan() {
        return tahunPembuatan;
    }

    public String getNoPlat() {
        return noPlat;
    }

    public int getJumlah_penumpang() {
        return jumlah_penumpang;
    }

    public String getJenis_tak() {
        return jenis_tak;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String merk) {
        this.merk = merk;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setTahunPembuatan(int tahunPembuatan) {
        this.tahunPembuatan = tahunPembuatan;
    }

    public void setNoPlat(String noPlat) {
        this.noPlat = noPlat;
    }

    public void setJumlah_penumpang(int jumlah_penumpang) {
        this.jumlah_penumpang = jumlah_penumpang;
    }

    public void setJenis_tak(String jenis_tak) {
        this.jenis_tak = jenis_tak;
    }

    
    
    public String showData(){
        if(this.jenis.equalsIgnoreCase("Car")){
            return "ID\t : "+getId()+"\n"
                    + "Brand\t : "+getMerk()+"\n"
                    + "Production Year : "+getTahunPembuatan()+"\n"
                    + "Plat Number\t : "+getNoPlat()+"\n"
                    + "Total Passanger  : "+getJumlah_penumpang()+"\n "
                    + "=============================================";
        } else {
            return"ID\t : "+getId()+"\n"
                    + "Brand\t : "+getMerk()+"\n"
                    + "Production Year : "+getTahunPembuatan()+"\n"
                    + "Plat Number\t : "+getNoPlat()+"\n"
                    + "Stroke type\t : "+getJenis_tak()+"\n"
                    + "=============================================";
        }
    }
    
    @Override
    public String toString(){
        return merk;
    } 
}
