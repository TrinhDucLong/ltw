/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Context.DBContext;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author trinh
 */
public class LoginDao {
    Connection conn = null; // ket noi sql
    PreparedStatement ps = null; // nem cau lenh qua sql
    ResultSet rs =null; // nhan kq tra ve
    
    public Account checkLogin(String user, String pass){
        try {
            String query = "SELECT * FROM [Account] where [user] = ? and pass = ? ;";
            conn = new DBContext().getConnection(); // mo ket noi sql
            ps = conn.prepareStatement(query); // nem cau lenh vao sql
            ps.setString(1, user); // truyen tham so vao dau cham hoi 1
            ps.setString(2, pass);  // truyen tham so vao dau cham hoi 2
            rs = ps.executeQuery();// kq tra ve
            
            while (rs.next()) {                
               Account a = new Account(
                       rs.getInt(1), 
                       rs.getString(2), 
                       rs.getString(3),
                       rs.getInt(4),
                       rs.getInt(5)
               ) ; // 1 username 2 password
               return  a;
              
            }
        } catch (Exception e) {
            
        }
        return null;
        
    }
}
