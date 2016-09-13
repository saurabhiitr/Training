package com.test;
import java.sql.*;
import java.util.ArrayList;
 
public class UserDAO {
public static ArrayList<CustomerBean> getCustomer() {
        try {
            Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from customer");
            ArrayList<CustomerBean> al = new ArrayList<CustomerBean>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
                CustomerBean e = new CustomerBean();
                e.setFirstname(rs.getString("firstname"));
                e.setLastname(rs.getString("lastname"));
                e.setAddress(rs.getString("address"));
                e.setEmail(rs.getString("email"));
                al.add(e);
                found = true;
            }
            rs.close();
            if (found) {
                return al;
            } else {
                return null; // no entires found
            }
        } catch (Exception e) {
            System.out.println("Error In getCustomer() -->" + e.getMessage());
            return (null);
        }
    }
}