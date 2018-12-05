package com.gmail.stepan1983.VolatileDemo;

public class ChangerVal implements Runnable {

    private SharedData sharedData;

    public ChangerVal(SharedData sharedData) {
        this.sharedData = sharedData;
    }



    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+" atomic integer "+(sharedData.integer.getAndAdd(1)));
            synchronized (sharedData){

                sharedData.setSynkInteger(sharedData.getSynkInteger()+1);
//                System.out.println(Thread.currentThread().getName()+" sync integer "+(sharedData.getSynkInteger()));
            }
        }
    }


}
