package com.lpnu.iot.term2.lab2;

import java.util.ArrayList;

public class Division {
    public ArrayList<Solider> soliders;
    public DivisionType type;
    public int idNumber;


    public Division() {
        this(0, DivisionType.Infantry);
    }

    public Division(int id, DivisionType type) {
        this.type = type;
        this.idNumber = id;
        soliders = new ArrayList<>();
    }

    public void addSolider(Solider newSolider) {

        if (newSolider.division != null) {
            newSolider.division.removeSolider(newSolider);
        }

        newSolider.division = this;
        soliders.add(newSolider);
    }

    public void removeSolider(Solider newSolider) {
        newSolider.division = null;
        soliders.remove(newSolider);
    }
}
