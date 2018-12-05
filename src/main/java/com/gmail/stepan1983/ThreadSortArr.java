package com.gmail.stepan1983;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSortArr {

    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) (Math.random() * 100.0D);
            System.out.print(arr[i] + ", ");
        }

        Queue<Integer[]> arrQueue=new ConcurrentLinkedQueue<Integer[]>();

        List<Thread> threadList=new ArrayList<Thread>();


        for (int i = 0; i < arr.length; i++) {
            Integer[] temp={arr[i]};
            arrQueue.add(temp);

        }

        for (int i = 0; i < 4; i++) {
            threadList.add(new Thread(new MergeSort(arrQueue)));
        }

        for (Thread thread : threadList) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        for (int i = 0; i < arrQueue.peek().length; ++i) {
            System.out.print(arrQueue.peek()[i] + ", ");
        }

    }
}
