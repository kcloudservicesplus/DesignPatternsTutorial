package com.kcloudservicesplus.designpattern.singleton;

public class DBSingletonDemo {

    public static void main(String[] args) {
        DBSingleton dbSingleton = DBSingleton.getInstance();
        System.out.println("dbSingleton = " + dbSingleton);
    }
}
