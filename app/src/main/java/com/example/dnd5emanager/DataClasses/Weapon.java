package com.example.dnd5emanager.DataClasses;

import java.util.HashMap;
import java.util.Map;

public class Weapon {
    private String Name;
    private String Description;

    private int AttackBonus;

    private int DamageDice;
    private int DiceCount;
    private String DamageType;
    private final Map<String, Integer> ExtraDamageDice = new HashMap<>(){{
        this.put("D4", 0);
        this.put("D6", 0);
        this.put("D8", 0);
        this.put("D10", 0);
        this.put("D20", 0);
    }};

    private boolean IsSimple;
    private boolean IsVersatile;
    private boolean IsFinesse;

    private boolean IsLight;
    private boolean IsHeavy;

    private boolean IsSilver;

    private boolean IsTwoHanded;

    private boolean IsAttuned;
    private boolean IsSpecial;
    private boolean IsCustom;
    private boolean IsImprovised;

    private boolean HasReach;
    private boolean IsRanged;
    private boolean IsLoading;
    private boolean IsThrown;
    private String AmmunitionType;
    
    public Weapon(String Name, String Description,
        int AttackBonus,
        int DamageDice, int DiceCount, String DamageType,
        boolean isSimple, boolean IsVersatile, boolean isFinesse,
        boolean isLight, boolean isHeavy,
        boolean isSilver, boolean isTwoHanded,
        boolean isAttuned, boolean isSpecial, boolean isCustom, boolean IsImprovised,
        boolean hasReach, boolean isRanged, boolean isLoading, boolean IsThrown, String AmmunitionType
    ){
        this.Name = Name;
        this.Description = Description;
        this.AttackBonus = AttackBonus;
        this.DamageDice = DamageDice;
        this.DiceCount = DiceCount;
        this.DamageType = DamageType;
        this.isSimple = isSimple;
        this.isVersatile = isVersatile;
        this.isFinesse = isFinesse;
        this.isLight = isLight;
        this.isHeavy = isHeavy;
        this.isSilver = isSilver;
        this.isTwoHanded = isTwoHanded;
        this.isAttuned = isAttuned;
        this.isSpecial = isSpecial;
        this.isCustom = isCustom;
        this.IsImprovised = isImprovised;
        this.hasReach = hasReach;
        this.isRanged = isRanged;
        this.isLoading = IsLoading;
        this.IsThrown = isThrown;
        this.AmmunitionType = AmmunitionType;
    }
}