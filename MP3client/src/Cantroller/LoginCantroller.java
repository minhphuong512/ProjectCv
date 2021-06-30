/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cantroller;

import Shaer.TAIKHOANLOGIN;
import Shaer.TAIKHOANLOGIN;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.TaiKhoan;

/**
 *
 * @author Administrator
 */
public class LoginCantroller {
    
    public boolean Login(String accould , String Password){
        try {
             toJson tJson = new toJson("Login",accould);
            ObjectMapper mapper = new JsonMapper();
            String json = mapper.writeValueAsString(tJson);

            Socket socket = null;
            ObjectOutputStream oos = null;
            ObjectInputStream ois = null;
              socket = new Socket("localhost", 9876);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(json);
            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());
            String messeger = (String) ois.readObject();
            System.out.println(messeger);
            TaiKhoan tk2 = mapper.readValue(messeger,TaiKhoan.class);
            
            ois.close();
            oos.close();
            socket.close();
            if (tk2.getMatKhau().equalsIgnoreCase(Password)) {
                TAIKHOANLOGIN.OnTK(tk2);
                return true;
            }else{
                return false;
            }
             
            
            
        } catch (Exception e) {
            System.out.println("Exception in LoginCantroller");
            return false;
        }

    }
    public void signup(TaiKhoan tk){
        try {
             ObjectMapper mapper = new JsonMapper();
             
             toJson tJson = new toJson("signup", mapper.writeValueAsString(tk));
            
            String json = mapper.writeValueAsString(tJson);

            Socket socket = null;
            ObjectOutputStream oos = null;
          
              socket = new Socket("localhost", 9876);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(json);
            //read the server response message
            oos.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Exception in LoginCantroller");
          
        }

    }
    
    
    
}
