package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;

public class Subrace {
    private String Name;
        public String getName(){return Name;}
    private int BaseArmorClass;

    private int GroundSpeed;
        public int getGroundSpeed(){return GroundSpeed;}
    private int AirSpeed;
        public int getAirSpeed(){return AirSpeed;}
    private int ClimbSpeed;
        public int getClimbSpeed(){return ClimbSpeed;}
    private int SwimSpeed;
        public int getSwimSpeed(){return SwimSpeed;}
    private int BurrowSpeed;
        public int getBurrowSpeed(){return BurrowSpeed;}

    private int StrengthBonus;
    private int DexterityBonus;
    private int ConstitutionBonus;
    private int IntelligenceBonus;
    private int WisdomBonus;
    private int CharismaBonus;

    private String SpellcastingAbility;

    private ArrayList<String> SkillProficiencies;
    private ArrayList<String> WeaponProficiencies;
    private ArrayList<String> ToolProficiencies;


    public Subrace(String Name, int BaseArmorClass, int GroundSpeed, int AirSpeed,
       int ClimbSpeed, int SwimSpeed, int BurrowSpeed, int StrengthBonus, int DexterityBonus, int ConstitutionBonus, int IntelligenceBonus, int WisdomBonus, int CharismaBonus){
        this.Name = Name;
        this.BaseArmorClass = BaseArmorClass;
        this.GroundSpeed = GroundSpeed;
        this.AirSpeed = AirSpeed;
        this.ClimbSpeed = ClimbSpeed;
        this.SwimSpeed = SwimSpeed;
        this.BurrowSpeed = BurrowSpeed;
        this.StrengthBonus = StrengthBonus;
        this.DexterityBonus = DexterityBonus;
        this.ConstitutionBonus = ConstitutionBonus;
        this.IntelligenceBonus = IntelligenceBonus;
        this.WisdomBonus = WisdomBonus;
        this.CharismaBonus = CharismaBonus;
    }
}