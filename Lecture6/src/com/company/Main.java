package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        // write your code here

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "1234");
            //here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select Name from people");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
