package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;

public class Race {
    private String Name;
    //Ability Score Bonuses
        private int StrengthBonus;
        private int DexterityBonus;
        private int ConstitutionBonus;
        private int IntelligenceBonus;
        private int WisdomBonus;
        private int CharismaBonus;

    //Movement
        private int GroundSpeed;
        private int AirSpeed;
        private int ClimbSpeed;
        private int SwimSpeed;
        private int BurrowSpeed;

    //Proficiencies
        private ArrayList<String> SkillProficiencies;
        private ArrayList<String> WeaponProficiencies;
        private ArrayList<String> ToolProficiencies;

    private int BaseArmorClass;
    private ArrayList<String> RacialTraits;
}