/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.*;
import model.*;
import java.util.*;
import table.*;

/**
 *
 * @author
 *
 * I Putu Trisna Budi Utama      | 210711438
 * Boniface Fredo Ronan Antolino | 210711446
 * 
 */
public class PenyewaanControl {
    private PenyewaanDAO pDao = new PenyewaanDAO();
    
    public void insertDataPenyewaan(Penyewaan p){
        pDao.insertDataPenyewaan(p);
    }
    
    public void updateDataPenyewaan(Penyewaan p){
        pDao.updateDataPenyewaan(p);
    }
    
    public void deleteDataPenyewaan(int id){
        pDao.deleteDataPenyewaan(id);
    }
    
    public TablePenyewaan showPenyewaan(String query){
        List<Penyewaan> dataPenyewaan = pDao.showPenyewaan(query);
        TablePenyewaan tablePenyewaan = new TablePenyewaan(dataPenyewaan);
        
        return tablePenyewaan;
    }
}
