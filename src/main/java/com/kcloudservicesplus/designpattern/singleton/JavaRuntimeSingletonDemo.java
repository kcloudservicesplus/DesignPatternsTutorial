package com.kcloudservicesplus.designpattern.singleton;

public class JavaRuntimeSingletonDemo {
    public static void main(String[] args) {
        Runtime runtime1 = Runtime.getRuntime();
        System.out.println("runtime1 = " + runtime1);

        Runtime runtime2 = Runtime.getRuntime();
        System.out.println("runtime2 = " + runtime2);

        if(runtime1==runtime2)
            System.out.println("Same Object");

    }
}
