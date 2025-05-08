package com.example.dnd5emanager.DataClasses;

import java.util.HashMap;
import java.util.Map;

public class Weapon {
    private String Name;
    private String AmmunitionType;
    private int DamageDice;
    private int DiceCount;
    private String DamageType;
    private String Description;
    private int ExtraAttackBonus;
    private int ExtraDamageBonus;
    private final Map<String, Integer> ExtraDamageDice = new HashMap<>();

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
}
