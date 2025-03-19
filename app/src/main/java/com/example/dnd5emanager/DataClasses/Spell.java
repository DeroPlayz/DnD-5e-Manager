package com.example.dnd5emanager.DataClasses;

public class Spell {
    String CastTime;
    String[] Classes;
    boolean Verbal;
    boolean Somatic;
    boolean Material;
    String MaterialCost;
    String Description;
    String Duration;
    int Level;
    String Name;
    String Range;
    boolean Ritual;
    String School;

    public Spell(String CastTime, String[] Classes, boolean Verbal, boolean Somatic, boolean Material,
    String MaterialCost, String Description, String Duration, int Level, String Name, String Range,
    boolean Ritual, String School){
        this.CastTime = CastTime;
        this.Classes = Classes;
        this.Verbal = Verbal;
        this.Somatic = Somatic;
        this.Material = Material;
        this.MaterialCost = MaterialCost;
        this.Description = Description;
        this.Duration = Duration;
        this.Level = Level;
        this.Name = Name;
        this.Range = Range;
        this.Ritual = Ritual;
        this.School = School;
    }
}
