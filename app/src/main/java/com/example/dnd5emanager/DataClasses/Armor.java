package com.example.dnd5emanager.DataClasses;

public class Armor{
    private String Name;
    public void setName(String name){
        this.Name = name;
    }
    public String getName(){
        return this.Name;
    }

    private int ArmorClass;
    public void setArmorClass(int armorClass){
        this.ArmorClass = armorClass;
    }
    public int getArmorClass() {
        return this.ArmorClass;
    }

    private String ArmorType;
    public void setArmorType(String armorType){
        this.ArmorType = armorType;
    }
    public String getArmorType(){
        return this.ArmorType;
    }

    private String Cost;
    public void setCost(String cost){
        this.Cost = cost;
    }
    public String getCost() {
        return this.Cost;
    }

    private String Description;
    public void setDescription(String description){
        this.Description = description;
    }
    public String getDescription(){
        return this.Description;
    }

    private boolean isAttuned;
    public void setIsAttuned(boolean isAttuned){
        this.isAttuned = isAttuned;
    }
    public boolean getIsAttuned() {
        return this.isAttuned;
    }

    private boolean isCustom;
    public void setIsCustom(boolean isCustom){
        this.isCustom = isCustom;
    }
    public boolean getIsCustom() {
        return this.isCustom;
    }

    private boolean isProficient;
    public void setIsProficient(boolean isProficient){
        this.isProficient = isProficient;
    }
    public boolean getIsProficient() {
        return this.isProficient;
    }

    private int MaxModBonus;
    public void setMaxModBonus(int maxModBonus){
        this.MaxModBonus = maxModBonus;
    }
    public int getMaxModBonus() {
        return this.MaxModBonus;
    }

    private String ModifierFormatted;
    public void setModifierFormatted(String modifierFormatted){
        this.ModifierFormatted = modifierFormatted;
    }
    public String getModifierFormatted() {
        return this.ModifierFormatted;
    }

    private boolean StealthDisadvantage;
    public void setStealthDisadvantage(boolean stealthDisadvantage){
        this.StealthDisadvantage = stealthDisadvantage;
    }
    public boolean getStealthDisadvantage() {
        return this.StealthDisadvantage;
    }

    private String Weight;
    public void setWeight(String weight){
        this.Weight = weight;
    }
    public String getWeight() {
        return this.Weight;
    }

    public Armor(String name, int ArmorClass, String armorType, String cost, String description, boolean isAttuned,
         boolean isCustom, boolean isProficient, int maxModBonus, String modifierFormatted,
         boolean stealthDisadvantage, String weight){
            this.Name = name;
            this.ArmorClass = ArmorClass;
            this.ArmorType = armorType;
            this.Cost = cost;
            this.Description = description;
            this.isAttuned = isAttuned;
            this.isCustom = isCustom;
            this.isProficient = isProficient;
            this.MaxModBonus = maxModBonus;
            this.ModifierFormatted = modifierFormatted;
            this.StealthDisadvantage = stealthDisadvantage;
            this.Weight = weight;
    }
}
