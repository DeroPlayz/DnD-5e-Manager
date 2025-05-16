package com.example.dnd5emanager.DataClasses;

public class Item extends Piece{
    public boolean isAmmo() {
        return isAmmo;
    }

    public boolean isCursed() {
        return isCursed;
    }

    public boolean isEquipment() {
        return isEquipment;
    }

    public boolean isMagic() {
        return isMagic;
    }

    public boolean isSpellcastingFocus() {
        return isSpellcastingFocus;
    }

    public boolean isTemplate() {
        return isTemplate;
    }

    public boolean isValueMultiplier() {
        return isValueMultiplier;
    }

    public boolean isWeightMultiplier() {
        return isWeightMultiplier;
    }

    public String getRarity() {
        return Rarity;
    }

    public boolean isRequiresAttunement() {
        return requiresAttunement;
    }

    public String getType() {
        return Type.charAt(0) + Type.substring(1).toLowerCase();
    }

    public int getValue() {
        return Value;
    }

    public String getCoinType() {
        return CoinType.charAt(0) + CoinType.substring(1).toLowerCase();
    }

    public double getWeight(){
        return Weight;
    }

    public String getWeightUnit() {
        return WeightUnit.toLowerCase();
    }

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
    int Value;
    String CoinType;
    double Weight;
    String WeightUnit;

    public Item(String name, String description, boolean isAmmo, boolean isCursed, boolean isEquipment, boolean isMagic,
        boolean isSpellcastingFocus, boolean isTemplate, boolean isValueMultiplier,
        boolean isWeightMultiplier, String rarity, boolean requiresAttunement, String type,
        int value, String coinType, double Weight, String weightUnit){
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
            this.Weight = Weight;
            this.WeightUnit = weightUnit;
    }
}