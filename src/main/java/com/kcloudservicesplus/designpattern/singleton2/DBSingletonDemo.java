package com.kcloudservicesplus.designpattern.singleton2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSingletonDemo {

    public static void main(String[] args) {
        DBSingleton instance = DBSingleton.getInstance();
        long timetaken = -System.currentTimeMillis();
        Connection conn = instance.getConnection();
        timetaken += System.currentTimeMillis();

        System.out.println("timetaken = " + timetaken);
        try {
            Statement stat = conn.createStatement();
            int count = stat.executeUpdate("CREATE TABLE Address(Id int, StreetName varchar (20))");
            System.out.println("Table Created");
            stat.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        timetaken = -System.currentTimeMillis();
        conn = instance.getConnection();
        timetaken += System.currentTimeMillis();


        System.out.println("timetaken = " + timetaken);


    }
}
