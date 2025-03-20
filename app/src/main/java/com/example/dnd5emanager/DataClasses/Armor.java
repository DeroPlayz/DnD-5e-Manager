package com.example.dnd5emanager.DataClasses;

public class Armor{
    private String Name;
    private String ArmorType;
    private int Cost;
    private String Description;
    private boolean isAttuned;
    private boolean isCustom;
    private boolean isProficient;
    private int MaxModBonus;
    private String ModifierFormatted;
    private boolean StealthDisadvantage;
    private int Weight; //In imperial pounds.

    public Armor(String name, String armorType, int cost, String description, boolean isAttuned,
         boolean isCustom, boolean isProficient, int maxModBonus, String modifierFormatted,
         boolean stealthDisadvantage, int weight){
            this.Name = name;
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
