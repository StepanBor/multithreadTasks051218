package com.gmail.stepan1983.shipUnloading;

import java.util.ArrayList;
import java.util.List;

public class ShipUnloadMain {

    public static void main(String[] args) {
        Dock dock=new Dock(new ArrayList<Integer>());
        List<Thread> threadList=new ArrayList<Thread>();

        for (int i = 0; i < 3; i++) {
            Thread tempThread=new Thread(new Ship(dock,i));
            threadList.add(tempThread);
            tempThread.start();

        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
