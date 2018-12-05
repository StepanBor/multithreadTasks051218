package com.gmail.stepan1983.VolatileDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemoMain {

    public static void main(String[] args) {
        SharedData sharedData=new SharedData(new AtomicInteger(1),1,1);
        Thread thread1=new Thread(new ChangerVal(sharedData));
        Thread thread2=new Thread(new ChangerVal(sharedData));
        Thread thread3=new Thread(new ChangerVal(sharedData));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
