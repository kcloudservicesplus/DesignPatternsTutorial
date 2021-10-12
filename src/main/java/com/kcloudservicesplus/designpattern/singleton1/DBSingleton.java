package com.kcloudservicesplus.designpattern.singleton1;

//Double Check
public class DBSingleton {
    private static volatile DBSingleton instance = null;

    private DBSingleton() {
        if (instance != null)
            throw new RuntimeException();
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

}
