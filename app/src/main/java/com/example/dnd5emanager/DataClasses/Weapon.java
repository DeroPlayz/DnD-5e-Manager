package com.example.dnd5emanager.DataClasses;

import java.util.HashMap;
import java.util.Map;

public class Weapon {
    private final String Name;
    private final String Description;
    private final String Type;
    private final String Rarity;

    private final int AttackBonus;

    private final int DamageDice;
    private final int DiceCount;
    private final String DamageType;
    private final Map<String, Integer> ExtraDamageDice = new HashMap<>(){{
        this.put("D4", 0);
        this.put("D6", 0);
        this.put("D8", 0);
        this.put("D10", 0);
        this.put("D20", 0);
    }};

    private final boolean isSimple;
    private final boolean isFinesse;


    private final boolean isVersatile;
    private final int versatileDiceFace;
    private final int versatileDiceCount;

    private final boolean isLight;
    private final boolean isHeavy;

    private final boolean isSilver;

    private final boolean isTwoHanded;

    private final boolean requiresAttunement;
    private final boolean isAttuned;

    private final boolean isSpecial;
    private final boolean isCustom;
    private final boolean isImprovised;

    private final boolean hasReach;
    private final boolean isRanged;
    private final boolean isLoading;
    private final boolean isThrown;
    private final String AmmunitionType;
    
    public Weapon(String Name, String Description, String Type, String Rarity,
        int AttackBonus,
        int DamageDice, int DiceCount, String DamageType,
        boolean isSimple, boolean isFinesse,
        boolean isVersatile, int versatileDiceFace, int versatileDiceCount,
        boolean isLight, boolean isHeavy,
        boolean isSilver, boolean isTwoHanded,
        boolean requiresAttunement, boolean isAttuned,
        boolean isSpecial, boolean isCustom, boolean isImprovised,
        boolean hasReach, boolean isRanged, boolean isLoading, boolean isThrown, String AmmunitionType
    ){
        this.Name = Name;
        this.Description = Description;
        this.Type = Type;
        this.Rarity = Rarity;

        this.AttackBonus = AttackBonus;

        this.DamageDice = DamageDice;
        this.DiceCount = DiceCount;
        this.DamageType = DamageType;

        this.isSimple = isSimple;
        this.isFinesse = isFinesse;

        this.isVersatile = isVersatile;
        this.versatileDiceFace = versatileDiceFace;
        this.versatileDiceCount = versatileDiceCount;

        this.isLight = isLight;
        this.isHeavy = isHeavy;

        this.isSilver = isSilver;
        this.isTwoHanded = isTwoHanded;

        this.requiresAttunement = requiresAttunement;
        this.isAttuned = isAttuned;

        this.isSpecial = isSpecial;
        this.isCustom = isCustom;
        this.isImprovised = isImprovised;

        this.hasReach = hasReach;
        this.isRanged = isRanged;
        this.isLoading = isLoading;
        this.isThrown = isThrown;
        this.AmmunitionType = AmmunitionType;
    }
}