/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package table;

import java.util.*;
import javax.swing.table.AbstractTableModel;
import model.Penyewaan;

/**
 *
 * @author
 *
 * I Putu Trisna Budi Utama      | 210711438
 * Boniface Fredo Ronan Antolino | 210711446
 * 
 */
public class TablePenyewaan extends AbstractTableModel {
    
    private List<Penyewaan> list;
    
    public TablePenyewaan(List<Penyewaan> list){
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0:
                // Merk kendaraan
                return list.get(row).getKendaraan().getMerk();
            case 1:
                // Jenis kendaraan
                return list.get(row).getKendaraan().getJenis();
            case 2:
                // Nama customer
                return list.get(row).getCustomer().getNama();
            case 3:
                // Lama sewa
                return list.get(row).getLama_sewa();
            case 4:
                // Total harga
                return list.get(row).getTotal_harga();
            case 5:
                // Fasilitas
                return list.get(row).getFasilitas();
            case 6:
                // Jumlah penumpang
                return list.get(row).getKendaraan().getJumlah_penumpang();
            case 7:
                // Jenis tak
                return list.get(row).getKendaraan().getJenis_tak();
            default:
                return null;
        }
    }
    
    public String getColumnName(int col){
        switch(col){
            case 0:
                return "Merk Kendaraan";
            case 1:
                return "jenis Kendaraan";
            case 2:
                return "Nama Customer";
            case 3:
                return "Lama Sewa";
            case 4:
                return "Total Harga";
            case 5:
                return "Fasilitas";
            case 6:
                return "Jumlah Penumpang";
            case 7:
                return "Jenis Tak";
            default:
                return null;
        }
    }

}
