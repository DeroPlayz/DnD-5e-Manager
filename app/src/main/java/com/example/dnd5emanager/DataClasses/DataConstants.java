package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataConstants{
    //Abilities
        public static final String Strength = "Strength";
        public static final String Dexterity = "Dexterity";
        public static final String Constitution = "Constitution";
        public static final String Intelligence = "Intelligence";
        public static final String Wisdom = "Wisdom";
        public static final String Charisma = "Charisma";
        public static final String None = " ";
    //Skills
        //Strength
            public static final String Athletics = "Athletics";
        //Dexterity
            public static final String Acrobatics = "Acrobatics";
            public static final String SleightOfHand = "Sleight of Hand";
            public static final String Stealth = "Stealth";
        //Intelligence
            public static final String Arcana = "Arcana";
            public static final String History = "History";
            public static final String Investigation = "Investigation";
            public static final String Nature = "Nature";
            public static final String Religion = "Religion";
        //Wisdom
            public static final String AnimalHandling = "Animal Handling";
            public static final String Insight = "Insight";
            public static final String Medicine = "Medicine";
            public static final String Perception = "Perception";
            public static final String Survival = "Survival";
        //Charisma
            public static final String Deception = "Deception";
            public static final String Intimidation = "Intimidation";
            public static final String Performance = "Performance";
            public static final String Persuasion = "Persuasion";

    //Weapon Properties
        //Range
            public static final String MeleeWeapon = "Melee";
            public static final String RangedWeapon = "Ranged";
        //Type
            public static final String SimpleWeapon = "Simple";
            public static final String Twohanded = "Two-handed";
            public static final String MartialWeapon = "Martial";
            public static final String VersatileWeapon = "Versatile";
            public static final String FinesseWeapon = "Finesse";
            public static final String ReachWeapon = "Reach";
            public static final String ThrownWeapon = "Thrown";
            public static final String SpecialWeapon = "Special";
        //Weight
            public static final String LightWeapon = "Light";
            public static final String HeavyWeapon = "Heavy";
        //Ranged-Specific
            public static final String WeaponAmmo = "Ammunition";
            public static final String LoadingWeapon = "Loading";

    //Skill Proficiency References
        static final ArrayList<String> ArtificerSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
            Arcana, History, Investigation, Medicine, Nature, Perception, SleightOfHand));
        static final ArrayList<String> BarbarianSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
            AnimalHandling, Athletics, Intimidation, Nature, Perception, Survival));
        static final ArrayList<String> BardSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
            Athletics, Acrobatics, SleightOfHand, Stealth, Arcana, History, Investigation, Nature,
            Religion, AnimalHandling, Insight, Medicine, Perception, Survival, Deception, Intimidation,
            Performance, Persuasion));
        static final ArrayList<String> ClericSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
            History, Insight, Medicine, Persuasion, Religion));
        static final ArrayList<String> DruidSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
            Arcana, AnimalHandling, Insight, Medicine, Nature, Perception, Religion, Survival));
        static final ArrayList<String> FighterSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
            Acrobatics, AnimalHandling, Athletics, History, Insight, Intimidation, Perception, Survival));
        static final ArrayList<String> MonkSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
            Acrobatics, Athletics, History, Insight, Religion, Stealth));
        static final ArrayList<String> PaladinSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
            Athletics, Insight, Intimidation, Medicine, Persuasion, Religion));
        static final ArrayList<String> RangerSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
                AnimalHandling, Athletics, Intimidation, Nature, Perception, Survival));
        static final ArrayList<String> RogueSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
                AnimalHandling, Athletics, Intimidation, Nature, Perception, Survival));
        static final ArrayList<String> SorcererSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
                AnimalHandling, Athletics, Intimidation, Nature, Perception, Survival));
        static final ArrayList<String> WarlockSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
                AnimalHandling, Athletics, Intimidation, Nature, Perception, Survival));
        static final ArrayList<String> WizardSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
                AnimalHandling, Athletics, Intimidation, Nature, Perception, Survival));

    //Weapon Proficiency References
        static final ArrayList<String> ArtificerSelectableWeaponProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> BarbarianSelectableWeaponProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> BardSelectableWeaponProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> ClericSelectableWeaponProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> DruidSelectableWeaponProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> FighterSelectableWeaponProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> MonkSelectableWeaponProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> PaladinSelectableWeaponProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> RangerSelectableWeaponProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> RogueSelectableWeaponProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> SorcererSelectableWeaponProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> WarlockSelectableWeaponProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> WizardSelectableWeaponProficiencies = new ArrayList<String>(List.of("Simple"));

    //Tool Proficiency References
        static final ArrayList<String> ArtificerSelectableToolProficiencies = new ArrayList<String>(List.of("Light", "Medium", "Shield"));
        static final ArrayList<String> BarbarianSelectableToolProficiencies = new ArrayList<String>(List.of("Light", "Medium", "Shield"));
        static final ArrayList<String> BardSelectableToolProficiencies = new ArrayList<String>(List.of("Light", "Medium", "Shield"));
        static final ArrayList<String> ClericSelectableToolProficiencies = new ArrayList<String>(List.of("Light", "Medium", "Shield"));
        static final ArrayList<String> DruidSelectableToolProficiencies = new ArrayList<String>(List.of("Light", "Medium", "Shield"));
        static final ArrayList<String> FighterSelectableToolProficiencies = new ArrayList<String>(List.of("Light", "Medium", "Shield"));
        static final ArrayList<String> MonkSelectableToolProficiencies = new ArrayList<String>(List.of("Light", "Medium", "Shield"));
        static final ArrayList<String> PaladinSelectableToolProficiencies = new ArrayList<String>(List.of("Light", "Medium", "Shield"));
        static final ArrayList<String> RangerSelectableToolProficiencies = new ArrayList<String>(List.of("Light", "Medium", "Shield"));
        static final ArrayList<String> RogueSelectableToolProficiencies = new ArrayList<String>(List.of("Light", "Medium", "Shield"));
        static final ArrayList<String> SorcererSelectableToolProficiencies = new ArrayList<String>(List.of("Light", "Medium", "Shield"));
        static final ArrayList<String> WarlockSelectableToolProficiencies = new ArrayList<String>(List.of("Light", "Medium", "Shield"));
        static final ArrayList<String> WizardSelectableToolProficiencies = new ArrayList<String>(List.of("Light", "Medium", "Shield"));

    //Armor Proficiency References
        static final ArrayList<String> ArtificerSelectableArmorProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> BarbarianSelectableArmorProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> BardSelectableArmorProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> ClericSelectableArmorProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> DruidSelectableArmorProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> FighterSelectableArmorProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> MonkSelectableArmorProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> PaladinSelectableArmorProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> RangerSelectableArmorProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> RogueSelectableArmorProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> SorcererSelectableArmorProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> WarlockSelectableArmorProficiencies = new ArrayList<String>(List.of("Simple"));
        static final ArrayList<String> WizardSelectableArmorProficiencies = new ArrayList<String>(List.of("Simple"));


}