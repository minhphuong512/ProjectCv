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
import mapper.userMapper;
import model.BaiHat;
import model.TaiKhoan;

/**
 *
 * @author Administrator
 */
public class LoginCantroller {
    void login (Socket socket , String tk){
        try {
            
             ObjectMapper mapper = new JsonMapper();
           TaiKhoan tk2 =  abstractDAO.query("select * from USERS where TaiKhoan = ?",new userMapper(),tk).get(0);
                  ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket
            String messeger = mapper.writeValueAsString(tk2);
            System.out.println(messeger);
            oos.writeObject(messeger);
              oos.close();  
        } catch (Exception e) {
            System.out.println("Exception in send tk");
        }
    }
    void signup (Socket socket ,String data){
        try {
             ObjectMapper mapper = new ObjectMapper();
            TaiKhoan tk =  mapper.readValue(data,TaiKhoan.class);
            abstractDAO.update("insert into USERS (TaiKhoan,matKhau,Email,gioiTinh,vaitro) values (?,?,?,?,0)",tk.getTaiKhoan(),tk.getMatKhau(),tk.getEmail(),tk.isGioiTinh());
        } catch (Exception e) {
            System.out.println("Exception in send signup");
        }
    }
    
    
}
