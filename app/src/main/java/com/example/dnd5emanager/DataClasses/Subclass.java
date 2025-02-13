package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.CharacterClass.*;
import static com.example.dnd5emanager.DataClasses.Feature.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Subclass{

    private final CharacterClass Parent;

    private final String Name;
        public String getName() {
            return Name;
        }

    private final ArrayList<Feature> SubclassFeatures;


    public Subclass(String Name, CharacterClass Parent, ArrayList<Feature> SubclassFeatures){
        this.Name = Name;
        this.Parent = Parent;
        this.SubclassFeatures = SubclassFeatures;
    }

    public final static Subclass Alchemist = new Subclass("Alchemist", Artificer, AlchemistFeatures);
}
