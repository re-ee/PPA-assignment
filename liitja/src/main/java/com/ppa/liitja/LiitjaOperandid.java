package com.ppa.liitja;

public class LiitjaOperandid {
    private int arv1;
    private int arv2;
    private int summa;

    public LiitjaOperandid() {
        // Vaikimisi konstruktor
    }

    public LiitjaOperandid(int arv1, int arv2, int summa) {
        this.arv1 = arv1;
        this.arv2 = arv2;
        this.summa = summa;
    }

    public int getArv1() {
        return arv1;
    }

    public void setArv1(int arv1) {
        this.arv1 = arv1;
    }

    public int getArv2() {
        return arv2;
    }

    public void setArv2(int arv2) {
        this.arv2 = arv2;
    }

    public int getSumma() {
        return summa;
    }

    public void setSumma(int summa) {
        this.summa = summa;
    }
}
