/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cantroller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import model.BaiHat;

/**
 *
 * @author Administrator
 */
public class getBaiHat {

    public List<BaiHat> getBH(String MaND) {

        try {
            toJson tJson = new toJson("getBaiHat",MaND);
            ObjectMapper mapper = new JsonMapper();
            String json = mapper.writeValueAsString(tJson);

            Socket socket = null;
            ObjectOutputStream oos = null;
            ObjectInputStream ois = null;

            //establish socket connection to server
            socket = new Socket("localhost", 9876);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(json);
            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());

            String messeger = (String) ois.readObject();
            JsonNode jsonNode = mapper.readTree(messeger);
            String data = jsonNode.get("data").asText();
            List<BaiHat> participantJsonList = mapper.readValue(data, new TypeReference<List<BaiHat>>() {
            });
            //close resources
            ois.close();
            oos.close();
            socket.close();
            Thread.sleep(100);
            return participantJsonList;

        } catch (Exception e) {
            return null;
        }

    }

    public List<BaiHat> getBHNS(String TenNS) {

        try {
            toJson tJson = new toJson("getBaiHatNS", TenNS);
            ObjectMapper mapper = new JsonMapper();
            String json = mapper.writeValueAsString(tJson);

            Socket socket = null;
            ObjectOutputStream oos = null;
            ObjectInputStream ois = null;

            //establish socket connection to server
            socket = new Socket("localhost", 9876);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(json);
            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());

            String messeger = (String) ois.readObject();
            JsonNode jsonNode = mapper.readTree(messeger);
            String data = jsonNode.get("data").asText();
            List<BaiHat> participantJsonList = mapper.readValue(data, new TypeReference<List<BaiHat>>() {
            });

            //close resources
            ois.close();
            oos.close();
            socket.close();
            Thread.sleep(100);
            return participantJsonList;

        } catch (Exception e) {
            return null;
        }

    }

}
