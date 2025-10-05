package com.ims.dao;

import com.ims.model.User;
import com.ims.util.DBConnection;
import java.sql.*;

public class UserDAO {
    public static User validate(String username, String password) {
        try {
            Connection con = DBConnection.getConnection();
            if(con==null){
                System.out.println("DB connection failed!");
                return null;
            }else{
                System.out.println("DB connected successfully!");
            }
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?"
            );
            ps.setString(1, username.trim());
            ps.setString(2, password.trim());
            System.out.println("checking username:"+username+", password:"+password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("user found:"+rs.getString("username"));
                return new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                );
            }else{
                System.out.println("no user found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
