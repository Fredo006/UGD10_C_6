/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.*;
import model.*;
import java.util.*;

/**
 *
 * @author
 *
 * I Putu Trisna Budi Utama      | 210711438
 * Boniface Fredo Ronan Antolino | 210711446
 * 
 */
public class KendaraanControl {
    private KendaraanDAO kDao = new KendaraanDAO();
    
    public void insertDataKendaraan(Kendaraan k){
        kDao.insertData(k);
    }
    
    public void updateDataKendaraan(Kendaraan k){
        kDao.updateData(k);
    }
    
    public void deleteDataKendaraan(String id){
        kDao.deleteData(id);
    }
    
    public Kendaraan searchDataKendaraan(String id){
        List<Kendaraan> dataKendaraan = kDao.showData();
        
        for(int i=0; i < dataKendaraan.size(); i++){
            if(dataKendaraan.get(i).getId().equals(id)){
                return dataKendaraan.get(i);
            }
        }
        return null;
    }
    
    public String showDataMobil(){
        List<Kendaraan> dataKendaraan = kDao.showData();
        String tempKendaraan="";
        
        for (int i = 0; i<dataKendaraan.size(); i++){
            if(dataKendaraan.get(i).getJenis().equalsIgnoreCase("Car"))
                tempKendaraan = tempKendaraan + dataKendaraan.get(i).showData() + "\n";
        }
        return tempKendaraan;
    }
    
    public String showDataMotor(){
        List<Kendaraan> dataKendaraan = kDao.showData();
        String tempKendaraan="";
        
        for (int i = 0; i<dataKendaraan.size(); i++){
            if(dataKendaraan.get(i).getJenis().equalsIgnoreCase("Motorcycle"))
                tempKendaraan = tempKendaraan + dataKendaraan.get(i).showData() + "\n";
        }
        return tempKendaraan;
    }
    
 
    public int getLastIdMobil(){
        List<Kendaraan> dataKendaraan = kDao.showData();
        int lastIdMobil = -1;
        String lastIdMobilStr = "";
        String first, last;
        
        for(int i = 0; i<dataKendaraan.size(); i++){
            if(dataKendaraan.get(i).getJenis().equalsIgnoreCase("Car")){
                first = dataKendaraan.get(i).getId();
                for(int j = 0; j<dataKendaraan.size(); j++){
                    if(dataKendaraan.get(j).getJenis().equalsIgnoreCase("Car")){
                        last = dataKendaraan.get(j).getId();
                        if(!compareString(first, last, "Car").equalsIgnoreCase("")){
                            lastIdMobilStr = compareString(first, last, "Car");
                            first = last;
                        }
                    }
                }
                break;
            }
        }

        // MBL-1
        // 01234

        if(!lastIdMobilStr.equals("")){
            ArrayList<Character> strId = new ArrayList();

            getId(strId, lastIdMobilStr);
            
            StringBuffer sb = new StringBuffer();
            
            for(Character c : strId){
                sb.append(c);
            }

            String finalIdMobil = sb.toString();
            lastIdMobil = Integer.parseInt(finalIdMobil);
        }

        return lastIdMobil;
    }
    
    public int getLastIdMotor(){
        List<Kendaraan> dataKendaraan = kDao.showData();
        int lastIdMotor = -1;
        String lastIdMotorStr = "";
        String first, last;
        
        for(int i = 0; i<dataKendaraan.size(); i++){
            if(dataKendaraan.get(i).getJenis().equalsIgnoreCase("Motorcycle")){
                first = dataKendaraan.get(i).getId();
                for(int j = 0; j<dataKendaraan.size(); j++){
                    if(dataKendaraan.get(j).getJenis().equalsIgnoreCase("Motorcycle")){
                        last = dataKendaraan.get(j).getId();
                        if(!compareString(first, last, "Motorcycle").equalsIgnoreCase("")){
                            lastIdMotorStr = dataKendaraan.get(j).getId();
                            first = last;
                        }
                    }
                }
                break;
            }
        }

        // MBL-1
        // 01234

        if(!lastIdMotorStr.equals("")){
            ArrayList<Character> strId = new ArrayList();

            getId(strId, lastIdMotorStr);
            
            StringBuffer sb = new StringBuffer();
            
            for(Character c : strId){
                sb.append(c);
            }

            String finalIdMotor = sb.toString();
            lastIdMotor = Integer.parseInt(finalIdMotor);
        }

        return lastIdMotor;
    }
    
    public void getId(ArrayList destination, String id){
        for(int i = 4; i<id.length(); i++){
            destination.add(id.charAt(i));
        }
    }
    
    public String compareString(String idFirst, String idSecond, String jenis){
        int defaultMobil = 264;
        int defaultMotor = 243;
        int tempFirst = 0;
        int tempSecond = 0;
        
        if(jenis.equalsIgnoreCase("Car")){
            for(int i = 4; i<idFirst.length(); i++){
                tempFirst = tempFirst + idFirst.charAt(i);
            }
            
            tempFirst = tempFirst + defaultMobil;
            
            for(int i = 4; i<idSecond.length(); i++){
                tempSecond = tempSecond + idSecond.charAt(i);
            }
            
            tempSecond = tempSecond + defaultMobil;
            
            if(tempSecond > tempFirst){
                return idSecond;
            } else if(tempSecond < tempFirst){
                return idFirst;
            } else {
                if(idSecond.charAt(idSecond.length() - 1) < idSecond.charAt(idSecond.length() - 2)){
                    return idSecond;
                } else {
                    return idFirst;
                }
            }
        } else if(jenis.equalsIgnoreCase("Motorcycle")){
            for(int i = 4; i<idFirst.length(); i++){
                tempFirst = tempFirst + idFirst.charAt(i);
            }
            
            tempFirst = tempFirst + defaultMotor;
            
            for(int i = 4; i<idSecond.length(); i++){
                tempSecond = tempSecond + idSecond.charAt(i);
            }
            
            tempSecond = tempSecond + defaultMotor;
            
            if(tempSecond > tempFirst){
                return idSecond;
            } else if(tempSecond < tempFirst){
                return idFirst;
            } else {
                if(idSecond.charAt(idSecond.length() - 1) < idSecond.charAt(idSecond.length() - 2)){
                    return idSecond;
                } else {
                    return idFirst;
                }
            }
        }
        
        return "";
    }
}
