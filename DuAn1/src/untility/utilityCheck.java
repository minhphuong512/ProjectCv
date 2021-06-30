/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untility;

import DAO.abstractDAO;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sieu Nhan Bay
 */
public class utilityCheck {

    //gồm các ký tự chữ đấu cách
    //từ 3-25 kí tự
    public static boolean checkName(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]{3,25}$";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải là tên tiếng việt hoặc không đấu\ntừ 3-25 kí tự");
            return false;
        }
    }

    //bất kì kí tự nào
    //từ 3-50 kí tự
    public static boolean checkTen(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = ".{3,50}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải từ 3-50 kí tự.");
            return false;
        }
    }

    //bất kì kí tự nào
    //từ 3-255 kí tự
    public static boolean checkMoTa(JTextArea txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = ".{3,255}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải từ 3-255 kí tự.");
            return false;
        }
    }

    public static boolean checkEmail(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "^[a-zA-Z][a-zA-Z0-9_\\.]{2,32}@[a-zA-Z0-9]{2,10}(\\.[a-zA-Z0-9]{2,4}){1,2}$";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " không đúng định dạng");
            return false;
        }
    }

    //gio là int >0
    public static boolean checkThoiLuong(JTextField txt) {
        txt.setBackground(white);
        try {
            int hour = Integer.parseInt(txt.getText());
            if (hour >= 0) {
                return true;
            } else {
                txt.setBackground(pink);
                JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải lớn hơn bằng 0.");
                return false;
            }
        } catch (NumberFormatException e) {
            txt.setBackground(pink);
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải là số nguyên.");
            return false;
        }
    }
    
    public static boolean checkNullText(JTextField txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            JOptionPane.showMessageDialog(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }

    public static boolean checkNullText(JTextArea txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            JOptionPane.showMessageDialog(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }

    public static boolean checkNullPass(JPasswordField txt) {
        txt.setBackground(white);
        if (txt.getPassword().length > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            JOptionPane.showMessageDialog(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }
    
}
