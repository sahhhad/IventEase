package com.ims.dao;

import com.ims.model.Supplier;
import com.ims.util.DBConnection;
import java.sql.*;
import java.util.*;

public class SupplierDAO {
    public static void addSupplier(Supplier s) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO suppliers(name, contact) VALUES(?,?)"
            );
            ps.setString(1, s.getName());
            ps.setString(2, s.getContact());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Supplier> getAllSuppliers() {
        List<Supplier> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM suppliers");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Supplier(
                    rs.getInt("supplier_id"),
                    rs.getString("name"),
                    rs.getString("contact")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
