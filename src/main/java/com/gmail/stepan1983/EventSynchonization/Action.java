package com.gmail.stepan1983.EventSynchonization;

public class Action {
    private int a;

    public synchronized int getA() {

        return a;
    }

    public synchronized void setA(int a) {


        this.a = a;
    }

    public Action(int a) {
        this.a = a;
    }


}
