package com.ims.dao;

import com.ims.model.Sale;
import com.ims.util.DBConnection;
import java.sql.*;
import java.util.*;

public class SalesDAO {
    public static void addSale(Sale sale) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO sales(product_id, quantity, total) VALUES(?,?,?)"
            );
            ps.setInt(1, sale.getProductId());
            ps.setInt(2, sale.getQuantity());
            ps.setDouble(3, sale.getTotal());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Sale> getAllSales() {
        List<Sale> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM sales");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Sale(
                    rs.getInt("sale_id"),
                    rs.getInt("product_id"),
                    rs.getInt("quantity"),
                    rs.getDouble("total")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
