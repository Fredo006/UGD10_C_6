/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import connection.DbConnection;
import model.*;
import java.sql.*;
import java.util.*;


/**
 *
 * @author
 *
 * I Putu Trisna Budi Utama      | 210711438
 * Boniface Fredo Ronan Antolino | 210711446
 * 
 */
public class PenyewaanDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertDataPenyewaan(Penyewaan p){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO penyewaan (id_kendaraan, id_customer, lama_sewa, total_harga, fasilitas) " +
                "VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, p.getKendaraan().getId());
            statement.setInt(2, p.getCustomer().getId());
            statement.setString(3, p.getLama_sewa());
            statement.setFloat(4, p.getTotal_harga());
            statement.setString(5, p.getFasilitas());
            
            int result = statement.executeUpdate();
            
            System.out.println("Berhasil menambah " + result + " data......");
            
        }catch(Exception e){
            System.out.println("Error adding penyewaan............");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
    }
    
    public void updateDataPenyewaan(Penyewaan p){
        con = dbcon.makeConnection();
        
        String sql = "UPDATE penyewaan SET id_kendaraan = ?, id_customer = ?, lama_sewa = ?, total_harga = ?, fasilitas = ?" +
                "WHERE id = ?";
        
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, p.getKendaraan().getId());
            statement.setInt(2, p.getCustomer().getId());
            statement.setString(3, p.getLama_sewa());
            statement.setFloat(4, p.getTotal_harga());
            statement.setString(5, p.getFasilitas());
            
            int result = statement.executeUpdate();
            
            System.out.println("Berhasil edit " + result + " data dengan id_kendaraan = " + p.getKendaraan().getId());
        }catch(Exception e){
            System.out.println("Error editing penyewaan.......");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
    }
    
    public void deleteDataPenyewaan(int id){
        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM penyewaan WHERE id = ?";
        
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, id);
            
            int result = statement.executeUpdate();
            
            System.out.println("Berhasil delete " + result + " data penyewaan.....");
        }catch(Exception e){
            System.out.println("Error deleting penyewaan.........");
            System.out.println(e);
        }
    }
    
    public List<Penyewaan> showPenyewaan(String query){
        con = dbcon.makeConnection();
        
        String sql = "SELECT p.*, k.*, c.* FROM penyewaan p JOIN kendaraan k ON p.id_kendaraan=k.id JOIN customer c ON p.id_customer=c.id " +
                "WHERE (c.nama LIKE ? OR ktp LIKE ? OR no_telepon LIKE ?)";
        
        System.out.println("Mengambil data penyewaan....");
        
        List<Penyewaan> list = new ArrayList<>();
        
        String tempQuery = "%" + query + "%";
        query = tempQuery;
        
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, query);
            statement.setString(2, query);
            statement.setString(3, query);
            
            ResultSet rs = statement.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Kendaraan k = new Kendaraan(rs.getString("id_kendaraan"), rs.getString("merk"), rs.getString("jenis"),
                                      rs.getInt("tahunPembuatan"), rs.getString("noPlat"), rs.getInt("jumlah_penumpang"),
                                      rs.getString("jenis_tak"));
                    
                    Customer c = new Customer(rs.getInt("id_customer"), rs.getString("nama"), rs.getString("ktp"), rs.getString("no_telepon"));
                    
                    Penyewaan p = new Penyewaan(rs.getInt("id"), rs.getString("lama_sewa"), rs.getFloat("total_harga"),
                                      rs.getString("fasilitas"), k, c);
                    list.add(p);
                }
                rs.close();
                statement.close();
            }
        }catch(Exception e){
            System.out.println("Error reading database.....");
            System.out.println(e);
        }
        
        return list;
    }
}
