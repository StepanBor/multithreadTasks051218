package com.gmail.stepan1983;

import java.util.ArrayList;
import java.util.List;

public class ThreadsProbe {
    public static void main(String[] args) {

        List<Thread> threadList = new ArrayList<Thread>();

        for (int i = 0; i < 20; i++) {

            if(i>=1){
                threadList.add(new Thread(new FactorialCalc(i, threadList.get(i - 1))));
            } else {
                threadList.add(new Thread(new FactorialCalc(i, null)));
            }

        }

        for (int i = 0; i < 20; i++) {
            threadList.get(i).start();

        }

        try {
            threadList.get(19).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main");
    }
}
