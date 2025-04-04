package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;

public class Subclass{
    String Name;

    public void setName(String Name){this.Name = Name;}
        public String getName(){return Name;}
    String ParentClass;
        public void setParentClass(String ParentClass){this.ParentClass = ParentClass;}
        public String getParentClass(){return ParentClass;}
    private Armor[] ArmorProficiencies;
    private int AttacksByLevel;
    private int BaseAC;
    private int Level = 1;
    public void setLevel(int Level){this.Level = Level;}
    public int getLevel(){return Level;}

    public Subclass(String Name, Armor[] ArmorProficiencies, int AttacksByLevel, int BaseAC, String ParentClass){
        this.Name = Name;
        this.ArmorProficiencies = ArmorProficiencies;
        this.AttacksByLevel = AttacksByLevel;
        this.BaseAC = BaseAC;
        this.ParentClass = ParentClass;
    }

    public Subclass() {
        this.Name = "";
        this.ArmorProficiencies = new Armor[0];
        this.AttacksByLevel = 0;
        this.BaseAC = 0;
        this.ParentClass = "";
    }

}