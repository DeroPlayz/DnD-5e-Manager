package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Race {
    private String Name;
        public String getName(){return Name;}
    //Ability Score Bonuses
        private int StrengthBonus;
            public int getStrengthBonus(){return StrengthBonus;}
        private int DexterityBonus;
            public int getDexterityBonus(){return DexterityBonus;}
        private int ConstitutionBonus;
            public int getConstitutionBonus(){return ConstitutionBonus;}
        private int IntelligenceBonus;
            public int getIntelligenceBonus(){return IntelligenceBonus;}
        private int WisdomBonus;
            public int getWisdomBonus(){return WisdomBonus;}
        private int CharismaBonus;
            public int getCharismaBonus(){return CharismaBonus;}

    //Movement
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

    //Proficiencies
        private ArrayList<String> SkillProficiencies;
        private ArrayList<String> WeaponProficiencies;
        private ArrayList<String> ToolProficiencies;

    private int ArmorClass;
        public int getArmorClass(){return ArmorClass;}
    private ArrayList<String> RacialTraits;

    private ArrayList<Subrace> Subraces = new ArrayList<>();
        public void addSubrace(Subrace Subrace){
            Subraces.add(Subrace);
        }
        public ArrayList<Subrace> getSubraces(){
            return Subraces;
        }

    private boolean hasSubraces;
        public boolean getHasSubraces(){return hasSubraces;}

    public Race(String Name, int ArmorClass, int GroundSpeed, int AirSpeed, int ClimbSpeed,
        int SwimSpeed, int BurrowSpeed, int StrengthBonus, int DexterityBonus, int ConstitutionBonus,
        int IntelligenceBonus, int WisdomBonus, int CharismaBonus, boolean hasSubraces
        /*ArrayList<String> SkillProficiencies, ArrayList<String> WeaponProficiencies,
        ArrayList<String> ToolProficiencies, ArrayList<String> RacialTraits*/){
            this.Name = Name;
            this.ArmorClass = ArmorClass;
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
            this.hasSubraces = hasSubraces;
//            this.SkillProficiencies = SkillProficiencies;
//            this.WeaponProficiencies = WeaponProficiencies;
//            this.ToolProficiencies = ToolProficiencies;
//            this.RacialTraits = RacialTraits;
    }
}