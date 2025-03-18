package com.example.dnd5emanager.DataClasses;

public class Spell {
    String Element;
    int Level;
    String School;
    String Description;

    public Spell(String Element, int Level, String School, String Description) {
        this.Element = Element;
        this.Level = Level;
        this.School = School;
        this.Description = Description;
    }
}
