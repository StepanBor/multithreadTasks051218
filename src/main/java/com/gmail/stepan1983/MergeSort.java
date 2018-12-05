package com.gmail.stepan1983;

import java.util.Queue;
import java.util.concurrent.Callable;

public class MergeSort implements Runnable {




    Queue<Integer[]> arrQueue;

    public MergeSort(Queue<Integer[]> arrQueue) {
        this.arrQueue = arrQueue;
    }

    public Queue<Integer[]> getArrQueue() {
        return arrQueue;
    }

    public void setArrQueue(Queue<Integer[]> arrQueue) {
        this.arrQueue = arrQueue;
    }

    public void run() {

        while (arrQueue.size()>1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrQueue.add(mergeArrays(arrQueue.poll(),arrQueue.poll()));
        }

    }

    public Integer[] mergeArrays(Integer[] arr1, Integer[] arr2) {
        if(arr1==null) return arr2;
        if(arr2==null) return arr1;
        Integer[] greaterArr = arr1.length < arr2.length ? arr2 : arr1;
        Integer[] mergedArr = new Integer[arr1.length + arr2.length];
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < mergedArr.length; i++) {
            if (arr1.length <= greaterArr.length & count1 >= arr1.length) {
                mergedArr[i] = arr2[i - arr1.length];
            } else if (arr2.length <= greaterArr.length & count2 >= arr2.length) {
                mergedArr[i] = arr1[i - arr2.length];
            } else if (arr1[count1] < arr2[count2]) {
                mergedArr[i] = arr1[count1++];
//                count1++;
            } else if (arr2[count2] <= arr1[count1]) {
                mergedArr[i] = arr2[count2++];
//                count2++;
            }
        }
        return mergedArr;
    }
}
