package com.gmail.stepan1983.shipUnloading;

import java.util.ArrayList;
import java.util.List;

public class Ship implements Runnable {

    private Dock dock;

    private List<Integer> cargo;

    private int id;

    public Ship(Dock dock, int id) {
        this.dock = dock;
        this.cargo = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            cargo.add(i);
        }

        this.id = id;
    }

    public Ship() {
    }

    public void run() {

        this.unloadShip();

    }

    public void unloadShip() {
        synchronized (dock) {
            while (dock.getPears().size() >= 2) {
                try {
                    dock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            dock.getPears().add(id);
        }


        for (Integer integer : cargo) {
            System.out.println("Ship" + id + " Box" + integer);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (dock){
            dock.getPears().remove(dock.getPears().lastIndexOf(id));
            dock.notifyAll();
        }


    }

    public List<Integer> getCargo() {
        return cargo;
    }

    public void setCargo(List<Integer> cargo) {
        this.cargo = cargo;
    }

    public Dock getDock() {
        return dock;
    }

    public void setDock(Dock dock) {
        this.dock = dock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
