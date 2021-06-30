/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.abstractDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import mapper.BaiHatMapper;
import model.BaiHat;

/**
 *
 * @author Administrator
 */
public class PlayListCantroller {
    
    public void addPLST (Socket socket , String MaND , String MaBH){
        try {
             
        abstractDAO.update("insert into PLAYLIST(MaND,MaBH) values(?,?)",MaND,MaBH);
            
        } catch (Exception e) {
            System.out.println("Exception in sendbh");
        }   
    }
    public void RemovePLST (Socket socket , String MaND , String MaBH){
        try {
             
        abstractDAO.update("delete PLAYLIST where MaND = ? and MaBH = ?",MaND,MaBH);
            
        } catch (Exception e) {
            System.out.println("Exception in sendbh");
        }   
    }
    
    
    
    
    
}
