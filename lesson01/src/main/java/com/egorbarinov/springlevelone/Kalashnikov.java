package com.egorbarinov.springlevelone;

public class Kalashnikov implements Weapon {
    private Magazine magazine;

    public Kalashnikov() {
    }

    public Kalashnikov(Magazine magazine) {
        this.magazine = magazine;
    }

    public void doSoldier() {
        System.out.println("tra-ta-ta");
        magazine.processing();

    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }
}
