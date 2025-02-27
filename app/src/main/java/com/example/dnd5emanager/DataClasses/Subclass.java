package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;

public class Subclass{

    private CharacterClass Parent;
        public CharacterClass getParent(){return Parent;}

    private String Name = "";
        public String getName() {
            if (Name == null){
                return Name;
            }
            return Parent.getName();
        }

    private ArrayList<Feature> SubclassFeatures = null;
        public ArrayList<Feature> getFeatures(){return SubclassFeatures;}

    public Subclass(String Name, CharacterClass Parent){
        this.Name = Name;
        this.Parent = Parent;
    }

    public Subclass(String Name, CharacterClass Parent, ArrayList<Feature> SubclassFeatures){
        this.Name = Name;
        this.Parent = Parent;
        this.SubclassFeatures = SubclassFeatures;
    }
    public Subclass(){}
}
