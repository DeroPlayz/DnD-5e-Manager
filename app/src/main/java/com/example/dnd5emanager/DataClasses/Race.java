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

    public Race(String Name, int BaseArmorClass, int GroundSpeed, int AirSpeed, int ClimbSpeed,
        int SwimSpeed, int BurrowSpeed, int StrengthBonus, int DexterityBonus, int ConstitutionBonus,
        int IntelligenceBonus, int WisdomBonus, int CharismaBonus
        /*ArrayList<String> SkillProficiencies, ArrayList<String> WeaponProficiencies,
        ArrayList<String> ToolProficiencies, ArrayList<String> RacialTraits*/){
            this.Name = Name;
            this.BaseArmorClass = BaseArmorClass;
            this.StrengthBonus = StrengthBonus;
            this.DexterityBonus = DexterityBonus;
            this.ConstitutionBonus = ConstitutionBonus;
            this.IntelligenceBonus = IntelligenceBonus;
            this.WisdomBonus = WisdomBonus;
            this.CharismaBonus = CharismaBonus;
            this.GroundSpeed = GroundSpeed;
            this.AirSpeed = AirSpeed;
            this.ClimbSpeed = ClimbSpeed;
            this.SwimSpeed = SwimSpeed;
            this.BurrowSpeed = BurrowSpeed;
//            this.SkillProficiencies = SkillProficiencies;
//            this.WeaponProficiencies = WeaponProficiencies;
//            this.ToolProficiencies = ToolProficiencies;
//            this.RacialTraits = RacialTraits;
    }
}