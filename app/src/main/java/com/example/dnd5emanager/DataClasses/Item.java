package com.example.dnd5emanager.DataClasses;

public class Item extends Piece{
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
    double Value;
    String CoinType;
    String WeightUnit;

    public Item(String name, String description, boolean isAmmo, boolean isCursed, boolean isEquipment, boolean isMagic,
        boolean isSpellcastingFocus, boolean isTemplate, boolean isValueMultiplier,
        boolean isWeightMultiplier, String rarity, boolean requiresAttunement, String type,
        double value, String coinType, String weightUnit){
            super(name, description);
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
            this.Value = value;
            this.CoinType = coinType;
            this.WeightUnit = weightUnit;
    }
}