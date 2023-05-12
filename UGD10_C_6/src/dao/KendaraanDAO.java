/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import connection.DbConnection;
import model.Kendaraan;
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
public class KendaraanDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertData(Kendaraan k){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO kendaraan(id,merk,jenis,tahunPembuatan,noPlat,jumlah_penumpang,jenis_tak) VALUES ('"
                + k.getId() + "', '" + k.getMerk() + "', '" + k.getJenis() + "', " + k.getTahunPembuatan() + ", '" + k.getNoPlat()
                + "', " + k.getJumlah_penumpang() + ", '" + k.getJenis_tak() + "')";
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " kendaraan");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding data.....");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    public void updateData(Kendaraan k){
        con = dbCon.makeConnection();
        
        String sql ="UPDATE kendaraan SET merk= '" +k.getMerk()+ "',"
                + "jenis='" +k.getJenis()+"',"
                + "tahunPembuatan="+k.getTahunPembuatan()+","
                + "noPlat='"+k.getNoPlat()+"',"
                + "jumlah_penumpang="+k.getJumlah_penumpang()+","
                + "jenis_tak='"+k.getJenis_tak()+"'"
                + "WHERE id like '" +k.getId()+ "'";
        
        System.out.println("Editing Kendaraan...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Kendaraan " + k.getId());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Kendaraan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void deleteData(String id){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM kendaraan WHERE id = '" + id + "'";

        System.out.println("Deleting Kendaraan...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Kendaraan " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Kendaraan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Kendaraan> showData(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM kendaraan";

        System.out.println("Mengambil data kendaraan...");
        
        List<Kendaraan> list = new ArrayList<>();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null) {
                while (rs.next()) {
                    Kendaraan p = new Kendaraan(rs.getString("id"), rs.getString("merk"), rs.getString("jenis"), rs.getInt("tahunPembuatan"),
                                       rs.getString("noPlat"), rs.getInt("jumlah_penumpang"), rs.getString("jenis_tak"));
                    list.add(p);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return list;
    }
    
    public Kendaraan searchKendaraan(String id){
        String sql = "SELECT * FROM kendaraan WHERE id ='"+id+"' ";
        System.out.println("Searching Kendaraan...");
        Kendaraan k = null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs != null){
                while(rs.next()) {
                     k = new Kendaraan(rs.getString("id"), rs.getString("merk"), rs.getString("jenis"), rs.getInt("tahunPembuatan"),
                             rs.getString("noPlat"), rs.getInt("jumlah_penumpang"), rs.getString("jenis_tak"));
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return k;       
    }
}
