package com.lpnu.iot.term2.lab2;

import java.util.ArrayList;

public class Division {
    public ArrayList<Solider> soliders;
    public DivisionType type;
    public int id_number;


    public Division() {
        this(0, DivisionType.Infantry);
    }

    public Division(int id, DivisionType type) {
        this.type = type;
        this.id_number = id;
        soliders = new ArrayList<>();
    }

    public void AddSolider(Solider newSolider) {

        if(newSolider.division != null)
            newSolider.division.RemoveSolider(newSolider);


        newSolider.division = this;
        soliders.add(newSolider);
    }

    public void RemoveSolider(Solider newSolider) {
        newSolider.division = null;
        soliders.remove(newSolider);
    }
}
