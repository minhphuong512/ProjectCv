package Shaer;


import model.TaiKhoan;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class TAIKHOANLOGIN {
    
    public static TaiKhoan taiKhoan = null;
    
    public static void OnTK(TaiKhoan tk){
        taiKhoan = tk; 
    }
    public static void OffTK(){
        taiKhoan = null; 
    }
    public static boolean ChekTk(){
        
        return taiKhoan==null;
    }
    
    
    
    
    
    
    
}
