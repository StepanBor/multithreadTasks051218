package com.gmail.stepan1983.VolatileDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedData {

    public AtomicInteger integer;
    public volatile Integer volInteger;
    public Integer synkInteger;

    public SharedData(AtomicInteger integer, Integer volInteger, Integer synkInteger) {
        this.integer = integer;
        this.volInteger = volInteger;
        this.synkInteger = synkInteger;
    }



    public Integer getVolInteger() {
        return volInteger;
    }

    public void setVolInteger(Integer volInteger) {
        this.volInteger = volInteger;
    }

    public Integer getSynkInteger() {
        return synkInteger;
    }

    public void setSynkInteger(Integer synkInteger) {
        this.synkInteger = synkInteger;
    }
}
