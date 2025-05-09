package com.example.dnd5emanager.DataClasses;

public class Spell {
    private String CastTime = "";
    public void setCastTime(String CastTime) {
        this.CastTime = CastTime;
    }
    public String getCastTime() {
        return CastTime;
    }

    private String[] Classes;
    public void setClasses(String[] Classes) {
        this.Classes = Classes;
    }
    public String[] getClasses() {
        return Classes;
    }

    private boolean Verbal;
    public void setVerbal(boolean Verbal) {
        this.Verbal = Verbal;
    }
    public boolean getVerbal() {
        return Verbal;
    }

    private boolean Somatic;
    public void setSomatic(boolean Somatic) {
        this.Somatic = Somatic;
    }
    public boolean getSomatic() {
        return Somatic;
    }

    private boolean Material;
    public void setMaterial(boolean Material) {
        this.Material = Material;
    }
    public boolean getMaterial() {
        return Material;
    }

    private String MaterialCost;

    public void setMaterialCost(String MaterialCost) {
        this.MaterialCost = MaterialCost;
    }
    public String getMaterialCost() {
        return MaterialCost;
    }

    private String Description;
    public void setDescription(String Description) {
        this.Description = Description;
    }
    public String getDescription() {
        return Description;
    }

    private String Duration;
    public void setDuration(String Duration) {
        this.Duration = Duration;
    }
    public String getDuration() {
        return Duration;
    }

    private int Level;
    public void setLevel(int Level) {
        this.Level = Level;
    }
    public int getLevel() {
        return Level;
    }

    private String Name;
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getName() {
        return Name;
    }

    private String Range;
    public void setRange(String Range) {
        this.Range = Range;
    }
    public String getRange() {
        return Range;
    }

    private boolean Ritual;
    public void setRitual(boolean Ritual) {
        this.Ritual = Ritual;
    }
    public boolean getRitual() {
        return Ritual;
    }

    private String School;
    public void setSchool(String School) {
        this.School = School;
    }
    public String getSchool() {
        return School;
    }

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
