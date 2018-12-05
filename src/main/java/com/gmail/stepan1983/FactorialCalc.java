package com.gmail.stepan1983;

public class FactorialCalc implements Runnable{

    private int num;

    Thread threadToJoin;

    public FactorialCalc(int num, Thread threadToJoin) {
        this.num = num;
        this.threadToJoin = threadToJoin;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Thread getThreadToJoin() {
        return threadToJoin;
    }

    public void setThreadToJoin(Thread threadToJoin) {
        this.threadToJoin = threadToJoin;
    }

    public void run() {
        if(threadToJoin!=null){
            try {
//                System.out.println(threadToJoin.getState());
                threadToJoin.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" "+ factor(num));



    }

    public long factor(long num){
        if(num==1) return 1;
        if(num==0) return 0;
        return num*factor(num-1);
    }
}
