package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Feature {
    private String Name;

    public String getName() {
        return Name;
    }

    private Map<Integer, String> Description;

    public String getDescription(int Level) {
        return Description.get(Level);
    }

    public Feature(String Name, Map<Integer, String> Description) {
        this.Name = Name;
        this.Description = Description;
    }
}