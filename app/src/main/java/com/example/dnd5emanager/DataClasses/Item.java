package com.example.dnd5emanager.DataClasses;

public class Item {
    String Name;
    String Description;
    boolean isAmmo;
    boolean isCursed;
    boolean isEquipment;
    boolean isMagic;
    boolean isSpellcastingFocus;
    boolean isTemplate;
    boolean isValueMultiplier;
    boolean isWeightMultiplier;
    String Rarity;
    boolean requiresAttunement;
    String Type;
    String CoinType;
    String WeightUnit;

    public Item(String name, String description, boolean isAmmo, boolean isCursed, boolean isEquipment, boolean isMagic,
        boolean isSpellcastingFocus, boolean isTemplate, boolean isValueMultiplier,
        boolean isWeightMultiplier, String rarity, boolean requiresAttunement, String type,
        String coinType, String weightUnit){
            this.Name = name;
            this.Description = description;
            this.isAmmo = isAmmo;
            this.isCursed = isCursed;
            this.isEquipment = isEquipment;
            this.isMagic = isMagic;
            this.isSpellcastingFocus = isSpellcastingFocus;
            this.isTemplate = isTemplate;
            this.isValueMultiplier = isValueMultiplier;
            this.isWeightMultiplier = isWeightMultiplier;
            this.Rarity = rarity;
            this.requiresAttunement = requiresAttunement;
            this.Type = type;
            this.CoinType = coinType;
            this.WeightUnit = weightUnit;
    }
}