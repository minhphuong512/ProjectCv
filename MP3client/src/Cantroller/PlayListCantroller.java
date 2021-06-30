/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cantroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Administrator
 */
public class PlayListCantroller {

    public void addPLST(String MaND,String MaBH) {
        try {
            String data = MaND+","+MaBH;
            toJson tJson = new toJson("addPLST", data);
            ObjectMapper mapper = new JsonMapper();
            String json = mapper.writeValueAsString(tJson);

            Socket socket = null;
            ObjectOutputStream oos = null;

            //establish socket connection to server
            socket = new Socket("localhost", 9876);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(json);
            //read the server response message

            oos.close();
            socket.close();
            Thread.sleep(100);

        } catch (Exception e) {

        }

    }
     public void RemovePLST(String MaND,String MaBH) {
        try {
            String data = MaND+","+MaBH;
            toJson tJson = new toJson("RemovePLST", data);
            ObjectMapper mapper = new JsonMapper();
            String json = mapper.writeValueAsString(tJson);

            Socket socket = null;
            ObjectOutputStream oos = null;

            //establish socket connection to server
            socket = new Socket("localhost", 9876);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(json);
            //read the server response message

            oos.close();
            socket.close();
            Thread.sleep(100);

        } catch (Exception e) {

        }

    }
     
     
    

}
