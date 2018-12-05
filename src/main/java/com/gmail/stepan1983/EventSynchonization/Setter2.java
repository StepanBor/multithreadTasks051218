package com.gmail.stepan1983.EventSynchonization;

public class Setter2 implements Runnable {

    Action act;

    public Setter2(Action act) {
        this.act = act;
    }

    public void run() {
        setNonEven();
    }



    public void setNonEven() {
        synchronized (act) {
            while (act.getA()<=100){
                while (act.getA() % 2 == 0) {
                    try {
                        act.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int temp = act.getA();
                act.setA(temp += 1);
                System.out.println(Thread.currentThread().getName()+"- add "+ act.getA());
                act.notify();
            }

        }
    }

}
