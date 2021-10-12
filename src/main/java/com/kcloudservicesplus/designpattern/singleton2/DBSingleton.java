package com.kcloudservicesplus.designpattern.singleton2;

import org.apache.derby.jdbc.EmbeddedDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Adding DB Instance
public class DBSingleton {
    private static volatile DBSingleton instance = null;
    private static volatile Connection conn = null;

    private DBSingleton() {
        try {
            DriverManager.registerDriver(new EmbeddedDriver());
        } catch (SQLException e) {
            System.exit(-1);
        }
        if (instance != null)
            throw new RuntimeException("Use getInstance() method to create");

        if (conn != null) {
            throw new RuntimeException("Use getConnection() method to create");
        }
    }

    public static DBSingleton getInstance() {
        if (instance == null) {
            synchronized (DBSingleton.class) {
                if (instance == null) {
                    instance = new DBSingleton();
                    System.out.println("Using Double Check");
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        if (conn == null) {
            synchronized (DBSingleton.class) {
                if (conn == null) {
                    try {
                        String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
                        conn = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return conn;
    }

}
