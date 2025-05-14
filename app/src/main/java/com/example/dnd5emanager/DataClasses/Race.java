package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Race {
    private final String Name;
        public String getName(){return Name;}
    //Ability Score Bonuses
    private final Map<String, Integer> AbilityBonuses = new HashMap<String, Integer>() {{
        put(Strength, 0);
        put(Dexterity, 0);
        put(Constitution, 0);
        put(Intelligence, 0);
        put(Wisdom, 0);
        put(Charisma, 0);
    }};

    /** @noinspection DataFlowIssue*/
    public int getAbilityBonus(String Ability){
        return AbilityBonuses.get(Ability);
    }

    //Movement
        private final int GroundSpeed;
            public int getGroundSpeed(){return GroundSpeed;}
        private final int AirSpeed;
            public int getAirSpeed(){return AirSpeed;}
        private final int ClimbSpeed;
            public int getClimbSpeed(){return ClimbSpeed;}
        private final int SwimSpeed;
            public int getSwimSpeed(){return SwimSpeed;}
        private final int BurrowSpeed;
            public int getBurrowSpeed(){return BurrowSpeed;}

    //Proficiencies
        private ArrayList<String> SkillProficiencies;
        private ArrayList<String> WeaponProficiencies;
        private ArrayList<String> ToolProficiencies;

    private final int ArmorClass;
        public int getArmorClass(){return ArmorClass;}
    private ArrayList<String> RacialTraits;

    private final ArrayList<Subrace> Subraces = new ArrayList<>();
        public void addSubrace(Subrace Subrace){
            Subraces.add(Subrace);
        }
        public ArrayList<Subrace> getSubraces(){
            return Subraces;
        }

    public boolean hasSubraces(){
        return Subraces.size() > 1;
    }

    public Race(String Name, int ArmorClass, int GroundSpeed, int AirSpeed, int ClimbSpeed,
        int SwimSpeed, int BurrowSpeed, int StrengthBonus, int DexterityBonus, int ConstitutionBonus,
        int IntelligenceBonus, int WisdomBonus, int CharismaBonus
        /*ArrayList<String> SkillProficiencies, ArrayList<String> WeaponProficiencies,
        ArrayList<String> ToolProficiencies, ArrayList<String> RacialTraits*/){
            this.Name = Name;
            this.ArmorClass = ArmorClass;
            AbilityBonuses.put(Strength, StrengthBonus);
            AbilityBonuses.put(Dexterity, DexterityBonus);
            AbilityBonuses.put(Constitution, ConstitutionBonus);
            AbilityBonuses.put(Intelligence, IntelligenceBonus);
            AbilityBonuses.put(Wisdom, WisdomBonus);
            AbilityBonuses.put(Charisma, CharismaBonus);
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