package com.gmail.stepan1983.shipUnloading;

import java.util.ArrayList;
import java.util.List;

public class Dock {

    private List<Integer> pears=new ArrayList<Integer>();

    public Dock(List<Integer> pears) {
        this.pears = pears;
    }

    public synchronized List<Integer> getPears() {
        return pears;
    }

    public synchronized void setPears(List<Integer> pears) {
        this.pears = pears;
    }


}
