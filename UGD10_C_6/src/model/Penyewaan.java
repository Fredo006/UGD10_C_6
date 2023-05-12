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
public class Penyewaan {
    private int id;
    private String lama_sewa;
    private float total_harga;
    private String fasilitas;
    private Kendaraan kendaraan;
    private Customer customer;

    public Penyewaan(int id, String lama_sewa, float total_harga, String fasilitas, Kendaraan kendaraan, Customer customer) {
        this.id = id;
        this.lama_sewa = lama_sewa;
        this.total_harga = total_harga;
        this.fasilitas = fasilitas;
        this.kendaraan = kendaraan;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public String getLama_sewa() {
        return lama_sewa;
    }

    public float getTotal_harga() {
        return total_harga;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLama_sewa(String lama_sewa) {
        this.lama_sewa = lama_sewa;
    }

    public void setTotal_harga(float total_harga) {
        this.total_harga = total_harga;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
