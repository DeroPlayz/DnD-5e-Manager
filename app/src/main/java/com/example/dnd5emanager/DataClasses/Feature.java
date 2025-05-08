package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;
import java.util.Map;

public class Feature {
    private final String Name;

    public String getName() {
        return Name;
    }

    private final Map<Integer, String> Description;

    public String getDescription(int Level) {
        return Description.get(Level);
    }

    public ArrayList<CharacterClass> SupportedClasses;

    public Feature(String Name, Map<Integer, String> Description) {
        this.Name = Name;
        this.Description = Description;
    }
}