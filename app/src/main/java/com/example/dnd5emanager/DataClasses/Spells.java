package com.example.dnd5emanager.DataClasses;

public class Spells {
    String Element;
    int Level;
    String School;
    String Description;

    public Spells(String Element, int Level, String School, String Description) {
        this.Element = Element;
        this.Level = Level;
        this.School = School;
        this.Description = Description;
    }
}
