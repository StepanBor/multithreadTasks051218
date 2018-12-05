package com.gmail.stepan1983.EventSynchonization;

public class EventSyncMain {

    public static void main(String[] args) {
        Action action=new Action(0);

        Thread t1=new Thread(new Setter(action));
        Thread t2=new Thread(new Setter2(action));
        t1.start();
        t2.start();

    }

}
