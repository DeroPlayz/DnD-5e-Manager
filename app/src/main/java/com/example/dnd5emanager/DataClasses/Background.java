package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;

public class Background {
    private String Name;
    private ArrayList<Feature> Features;
    private int Gold;
//    private ArrayList<Equipment> Languages;

    public Background(String Name, ArrayList<Feature> Features, int Gold /*ArrayList<Equipment> Equipment*/){
        this.Name = Name;
        this.Features = Features;
        this.Gold = Gold;
//        this.Equipment = Equipment;;

    }

}
