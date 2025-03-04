package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Feature.AlchemistFeatures;
import static com.example.dnd5emanager.DataClasses.Feature.ArtificerFeatures;
import static com.example.dnd5emanager.DataClasses.Feature.BarbarianFeatures;
import static com.example.dnd5emanager.DataClasses.Feature.BardFeatures;
import static com.example.dnd5emanager.DataClasses.Feature.ClericFeatures;
import static com.example.dnd5emanager.DataClasses.Feature.DruidFeatures;
import static com.example.dnd5emanager.DataClasses.Feature.FighterFeatures;
import static com.example.dnd5emanager.DataClasses.Feature.MonkFeatures;
import static com.example.dnd5emanager.DataClasses.Feature.PaladinFeatures;
import static com.example.dnd5emanager.DataClasses.Feature.RangerFeatures;
import static com.example.dnd5emanager.DataClasses.Feature.RogueFeatures;
import static com.example.dnd5emanager.DataClasses.Feature.SorcererFeatures;
import static com.example.dnd5emanager.DataClasses.Feature.WarlockFeatures;
import static com.example.dnd5emanager.DataClasses.Feature.WizardFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {
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
            AnimalHandling, Athletics, Insight, Investigation, Nature, Perception, Stealth, Survival));
    static final ArrayList<String> RogueSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
            Acrobatics, Athletics, Deception, Insight, Intimidation, Investigation, Perception, Performance, Persuasion, SleightOfHand, Stealth));
    static final ArrayList<String> SorcererSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
            Arcana, Deception, Insight, Intimidation, Persuasion, Religion));
    static final ArrayList<String> WarlockSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
            Arcana, Deception, History, Intimidation, Investigation, Nature, Religion));
    static final ArrayList<String> WizardSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList(
            Arcana, History, Insight, Investigation, Medicine, Religion));

    //Weapon Proficiency References
    static final ArrayList<String> ArtificerSelectableWeaponProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> BarbarianSelectableWeaponProficiencies = new ArrayList<String>(List.of(SimpleWeapon, MartialWeapon));
    static final ArrayList<String> BardSelectableWeaponProficiencies = new ArrayList<String>(List.of(SimpleWeapon/*, Hand crossbows, longswords, rapiers, shortswords*/));
    static final ArrayList<String> ClericSelectableWeaponProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> DruidSelectableWeaponProficiencies = new ArrayList<String>(List.of(/* Clubs, daggers, darts, javelins, maces, quarterstaffs, scimitars, sickles, slings, spears*/));
    static final ArrayList<String> FighterSelectableWeaponProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> MonkSelectableWeaponProficiencies = new ArrayList<String>(List.of(SimpleWeapon/*, shortswords*/));
    static final ArrayList<String> PaladinSelectableWeaponProficiencies = new ArrayList<String>(List.of(SimpleWeapon, MartialWeapon));
    static final ArrayList<String> RangerSelectableWeaponProficiencies = new ArrayList<String>(List.of(SimpleWeapon, MartialWeapon));
    static final ArrayList<String> RogueSelectableWeaponProficiencies = new ArrayList<String>(List.of(SimpleWeapon/*, hand crossbows, longswords, rapiers, shortswords*/));
    static final ArrayList<String> SorcererSelectableWeaponProficiencies = new ArrayList<String>(List.of(/*Daggers, darts, slings, quarterstaffs, light crossbows*/));
    static final ArrayList<String> WarlockSelectableWeaponProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> WizardSelectableWeaponProficiencies = new ArrayList<String>(List.of(/*Daggers, darts, slings, quarterstaffs, light crossbows*/));

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
    static final ArrayList<String> ArtificerSelectableArmorProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> BarbarianSelectableArmorProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> BardSelectableArmorProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> ClericSelectableArmorProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> DruidSelectableArmorProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> FighterSelectableArmorProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> MonkSelectableArmorProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> PaladinSelectableArmorProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> RangerSelectableArmorProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> RogueSelectableArmorProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> SorcererSelectableArmorProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> WarlockSelectableArmorProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
    static final ArrayList<String> WizardSelectableArmorProficiencies = new ArrayList<String>(List.of(SimpleWeapon));
        
        //Class Declarations
        public static final CharacterClass Artificer = new CharacterClass("Artificer",
        false, false, true,
            true, false, false,
        ArtificerSelectableSkillsProficiencies, ArtificerSelectableWeaponProficiencies, ArtificerSelectableToolProficiencies,
        ArtificerSelectableArmorProficiencies, 0, 0, 0, 0, ArtificerFeatures, 1, Intelligence, 8);
        public static final CharacterClass Barbarian = new CharacterClass("Barbarian",
        true, false, true,
                false, false, false,
        BarbarianSelectableSkillsProficiencies, BarbarianSelectableWeaponProficiencies, BarbarianSelectableToolProficiencies,
        BarbarianSelectableArmorProficiencies, 0, 0, 0, 0, BarbarianFeatures, 1, None, 12);
        public static final CharacterClass Bard = new CharacterClass("Bard",
        false, false, true,
        true, false, false,
        BardSelectableSkillsProficiencies, BardSelectableWeaponProficiencies, BardSelectableToolProficiencies,
        BardSelectableArmorProficiencies, 0, 0, 0, 0, BardFeatures, 1, Charisma, 8);
        public static final CharacterClass Cleric = new CharacterClass("Cleric",
        false, false, true,
        true, false, false,
        ClericSelectableSkillsProficiencies, ClericSelectableWeaponProficiencies, ClericSelectableToolProficiencies,
        ClericSelectableArmorProficiencies, 0, 0, 0, 0, ClericFeatures, 1, Wisdom, 8);
        public static final CharacterClass Druid = new CharacterClass("Druid",
        false, false, true,
        true, false, false,
        DruidSelectableSkillsProficiencies, DruidSelectableWeaponProficiencies, DruidSelectableToolProficiencies,
        DruidSelectableArmorProficiencies, 0, 0, 0, 0, DruidFeatures, 1, Wisdom, 8);
        public static final CharacterClass Fighter = new CharacterClass("Fighter",
        false, false, true,
        true, false, false,
        FighterSelectableSkillsProficiencies, FighterSelectableWeaponProficiencies, FighterSelectableToolProficiencies,
        FighterSelectableArmorProficiencies, 0, 0, 0, 0, FighterFeatures, 1, None, 10);
        public static final CharacterClass Monk = new CharacterClass("Monk",
        false, false, true,
        true, false, false,
        MonkSelectableSkillsProficiencies, MonkSelectableWeaponProficiencies, MonkSelectableToolProficiencies,
        MonkSelectableArmorProficiencies, 0, 0, 0, 0, MonkFeatures, 1, None, 8);
        public static final CharacterClass Paladin = new CharacterClass("Paladin",
        false, false, true,
        true, false, false,
        PaladinSelectableSkillsProficiencies, PaladinSelectableWeaponProficiencies, PaladinSelectableToolProficiencies,
        PaladinSelectableArmorProficiencies, 0, 0, 0, 0, PaladinFeatures, 1, Charisma, 10);
        public static final CharacterClass Ranger = new CharacterClass("Ranger",
        false, false, true,
        true, false, false,
        RangerSelectableSkillsProficiencies, RangerSelectableWeaponProficiencies, RangerSelectableToolProficiencies,
        RangerSelectableArmorProficiencies, 0, 0, 0, 0, RangerFeatures, 1, Wisdom, 10);
        public static final CharacterClass Rogue = new CharacterClass("Rogue",
        false, false, true,
        true, false, false,
        RogueSelectableSkillsProficiencies, RogueSelectableWeaponProficiencies, RogueSelectableToolProficiencies,
        RogueSelectableArmorProficiencies, 0, 0, 0, 0, RogueFeatures, 1, None, 8);
        public static final CharacterClass Sorcerer = new CharacterClass("Sorcerer",
        false, false, true,
        true, false, false,
        SorcererSelectableSkillsProficiencies, SorcererSelectableWeaponProficiencies, SorcererSelectableToolProficiencies,
        SorcererSelectableArmorProficiencies, 0, 0, 0, 0, SorcererFeatures, 1, Charisma, 6);
        public static final CharacterClass Warlock = new CharacterClass("Warlock",
        false, false, true,
        true, false, false,
        WarlockSelectableSkillsProficiencies, WarlockSelectableWeaponProficiencies, WarlockSelectableToolProficiencies,
        WarlockSelectableArmorProficiencies, 0, 0, 0, 0, WarlockFeatures, 1, Charisma, 8);
        public static final CharacterClass Wizard = new CharacterClass("Wizard",
        false, false, true,
            true, false, false,
            WizardSelectableSkillsProficiencies, WizardSelectableWeaponProficiencies, WizardSelectableToolProficiencies,
            WizardSelectableArmorProficiencies, 0, 0, 0, 0, WizardFeatures, 1, Intelligence, 6);

    public final static Subclass SubArtificer = new Subclass("Artificer", Artificer);
    public final static Subclass SubBarbarian = new Subclass("Barbarian", Barbarian);
    public final static Subclass SubBard = new Subclass("Bard", Bard);
    public final static Subclass SubCleric = new Subclass("Cleric", Cleric);
    public final static Subclass SubDruid = new Subclass("Druid", Druid);
    public final static Subclass SubFighter = new Subclass("Fighter", Fighter);
    public final static Subclass SubMonk = new Subclass("Monk", Monk);
    public final static Subclass SubPaladin = new Subclass("Paladin", Paladin);
    public final static Subclass SubRanger = new Subclass("Ranger", Ranger);
    public final static Subclass SubRogue = new Subclass("Rogue", Rogue);
    public final static Subclass SubSorcerer = new Subclass("Sorcerer", Sorcerer);
    public final static Subclass SubWarlock = new Subclass("Warlock", Warlock);
    public final static Subclass SubWizard = new Subclass("Wizard", Wizard);

    public final static Subclass Alchemist = new Subclass("Alchemist", Artificer, AlchemistFeatures);

    public static ArrayList<CharacterClass> GlobalClassList = new ArrayList<CharacterClass>(Arrays.asList(Artificer, Barbarian, Bard, Cleric, Druid, Monk, Fighter, Paladin, Ranger, Rogue, Sorcerer, Warlock, Wizard));
    public static ArrayList<Subclass> ClassesAsSubs = new ArrayList<Subclass>(Arrays.asList(SubArtificer, SubBarbarian, SubBard, SubCleric, SubDruid, SubFighter, SubMonk, SubPaladin, SubRanger, SubRogue, SubSorcerer, SubWarlock, SubWizard));

    public static Subclass findSub(String Name) {
        for (int i = 0; i < ClassesAsSubs.size(); i++) {
            if (ClassesAsSubs.get(i).getName().equals(Name)) {
                return ClassesAsSubs.get(i);
            }
        }
        return null;
    }

    public final static Race Aarakocra = new Race("Aarakocra", 10,
        25, 50, 0, 0, 0,
        0, 2, 0,
        0, 1, 0,
        false
    );
    
    public final static Race Aasimar = new Race("Aasimar", 10,
        30, 0, 0, 0, 0,
        0, 0, 0,
        0, 0, 2,
        true
    );
        public final static Subrace ProtectorAasimar = new Subrace("Protector Aasimar", Aasimar, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 1, 0
        );
        public final static Subrace ScourgeAasimar = new Subrace("Scourge Aasimar", Aasimar, 10,
            30, 0, 0, 0, 0,
            0, 0, 1,
            0, 0, 0
        );
        public final static Subrace FallenAasimar = new Subrace("Fallen Aasimar", Aasimar, 1,
            10, 0, 0, 0, 0,
            1, 0, 0,
            0, 0, 0
        );

    public final static Race Bugbear = new Race("Bugbear", 10,
        25, 0, 0, 0, 0,
        2, 1, 0,
        0, 0, 0,
        false
    );

    public final static Race Catfolk = new Race("Catfolk", 10,
        30, 0, 20, 0, 0,
        0, 1, 0,
        0, 0, 0,
        true
    );
        public final static Subrace OrdinaryBreedCatfolk = new Subrace("Ordinary-Breed Catfolk", Catfolk, 10,
            35, 0, 20, 0, 0,
            0, 0, 0,
            0, 0, 2
        );
        public final static Subrace LargeBreedCatfolk = new Subrace("Large-Breed Catfolk", Catfolk, 10,
            30, 0, 20, 0, 0,
            2, 0, 0,
            0, 0, 0
        );
        public final static Subrace MysticBreedCatfolk = new Subrace("Mystic-Breed Catfolk", Catfolk, 10,
            30, 0, 20, 0, 0,
            0, 0, 0,
            2, 0, 0
        );
    
    public final static Race Centaur = new Race("Centaur", 10,
        40, 0, 0, 0, 0,
        2, 0, 0,
        0, 1, 0,
        false
    );

    public final static Race Changeling = new Race("Changeling", 10,
        30, 0, 0, 0, 0,
        0, 0, 0,
        0, 0, 2,
        false
    );

    public final static Race Dragonborn = new Race("Dragonborn", 10,
        30, 0, 0, 0, 0,
        2, 0, 0,
        0, 0, 1,
        true
    );
        public final static Subrace BlackDragonborn = new Subrace("Black Dragonborn", Dragonborn, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 1
        );
        public final static Subrace BlueDragonborn = new Subrace("Blue Dragonborn", Dragonborn, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 0
        );
        public final static Subrace BrassDragonborn = new Subrace("Brass Dragonborn", Dragonborn, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 0
        );
        public final static Subrace BronzeDragonborn = new Subrace("Bronze Dragonborn", Dragonborn, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 0
        );
        public final static Subrace CopperDragonborn = new Subrace("Copper Dragonborn", Dragonborn, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 0
        );
        public final static Subrace GoldDragonborn = new Subrace("Gold Dragonborn", Dragonborn, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 0
        );
        public final static Subrace GreenDragonborn = new Subrace("Green Dragonborn", Dragonborn, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 0
        );
        public final static Subrace RedDragonborn = new Subrace("Red Dragonborn", Dragonborn, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 0
        );
        public final static Subrace SilverDragonborn = new Subrace("Silver Dragonborn", Dragonborn, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 0
        );
        public final static Subrace WhiteDragonborn = new Subrace("White Dragonborn", Dragonborn, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 0
        );

    public final static Race Dwarf = new Race("Dwarf", 0,
        25, 0, 0, 0, 0,
        0, 0, 2,
        0, 0, 0,
        true
    );
        public final static Subrace HillDwarf = new Subrace("Hill Dwarf", Dwarf, 10,
            25, 0, 0, 0, 0,
            0, 0, 0,
            0, 1, 0
        );
        public final static Subrace MountainDwarf = new Subrace("Mountain Dwarf", Dwarf, 10,
            25, 0, 0, 0, 0,
            2, 0, 0,
            0, 0, 0
        );
        public final static Subrace HouseKundarakDwarf = new Subrace("House Kundarak Dwarf", Dwarf, 10,
            25, 0, 0, 0, 0,
            0, 1, 0,
            1, 0, 0
        );
        public final static Subrace DuergarDwarf = new Subrace("Duergar Dwarf", Dwarf, 10,
            25, 0, 0, 0, 0,
            1, 0, 0,
            0, 0, 0
        );
        public final static Subrace MarkOfWardingDwarf = new Subrace("Mark of Warding Dwarf", Dwarf, 10,
            25, 0, 0, 0, 0,
            0, 0, 0,
            1, 0, 0
        );

    public final static Race Elf = new Race("Elf", 10,
        30, 0, 0, 0, 0,
        0, 2, 0,
        0, 0, 0,
        true
    );
        public final static Subrace HighElf = new Subrace("High Elf", Elf, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            1, 0, 0
        );
        public final static Subrace WoodElf = new Subrace("Wood Elf", Elf, 10,
            35, 0, 0, 0, 0,
            0, 0, 0,
            0, 1, 0
        );
        public final static Subrace SeaElf = new Subrace("Sea Elf", Elf, 10,
            30, 0, 0, 40, 0,
            0, 0, 0,
            0, 0, 1
        );
        public final static Subrace ShadarKai = new Subrace("Shadar-Kai Elf", Elf, 10,
            30, 0, 0, 0, 0,
            0, 0, 1,
            0, 0, 0
        );
        public final static Subrace HouseOfShadow = new Subrace("The House of Shadow Elf", Elf, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 1
        );
        public final static Subrace AerenalHighElf = new Subrace("Aerenal High Elf", Elf, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            1, 0, 0
        );
        public final static Subrace AerenalWoodElf = new Subrace("Aerenal Wood Elf", Elf, 10,
            35, 0, 0, 0, 0,
            0, 0, 0,
            0, 1, 0
        );
        public final static Subrace ValenarHighElf = new Subrace("Valenar High Elf", Elf, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            1, 0, 0
        );
        public final static Subrace ValenarWoodElf = new Subrace("Valenar Wood Elf", Elf, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            1, 0, 0
        );
        public final static Subrace DarkElf = new Subrace("Dark Elf (Drow)", Elf, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 1
        );
        public final static Subrace PalidElf = new Subrace("Palid Elf", Elf, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 1, 0
        );

    public final static Race Firbolg = new Race("Firbolg", 10,
        30, 0, 0, 0, 0,
        1, 0, 0,
        0, 0, 2,
        false
    );

    public final static Race Genasi = new Race("Genasi", 10,
        30, 0, 0, 0, 0,
        0, 0, 2,
        0, 0, 0,
        true
    );
        public final static Subrace AirGenasi = new Subrace("Air Genasi", Genasi, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 0
        );
        public final static Subrace EarthGenasi = new Subrace("Earth Genasi", Genasi, 10,
                30, 0, 0, 0, 0,
                1, 0, 2,
                0, 0, 0
        );
        public final static Subrace FireGenasi = new Subrace("Fire Genasi", Genasi, 10,
                30, 0, 0, 0, 0,
                0, 0, 0,
                1, 0, 0
        );
        public final static Subrace WaterGenasi = new Subrace("Water Genasi", Genasi, 10,
                30, 0, 0, 30, 0,
                0, 0, 0,
                0, 1, 0
        );

    public final static Race Gith = new Race("Gith", 10,
        30, 0, 0, 0, 0,
        0, 0, 0,
        1, 0, 0,
        true
    );
        public final static Subrace Githyanki = new Subrace("Githyanki", Gith, 10,
            30, 0, 0, 0, 0,
            2, 0, 0,
            0, 0, 0
        );
        public final static Subrace Githzerai = new Subrace("Githzerai", Gith, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 2, 0
        );

    public final static Race Gnome = new Race("Gnome", 10,
        25, 0, 0, 0, 0,
        0, 0, 0,
        2, 0, 0,
        true
    );
        public final static Subrace ForestGnome = new Subrace("Forest Gnome", Gnome, 10,
            25, 0, 0, 0, 0,
            0, 1, 0,
            0, 0, 0
        );
        public final static Subrace RockGnome = new Subrace("Rock Gnome", Gnome, 10,
            25, 0, 0, 0, 0,
            0, 0, 1,
            0, 0, 0
        );
        public final static Subrace DeepGnome = new Subrace("Deep Gnome (Svirfneblin)", Gnome, 10,
            25, 0, 0, 0, 0,
            0, 1, 0,
            0, 0, 0
        );
        public final static Subrace MarkOfScribingDwarf = new Subrace("Mark of Scribing Dwarf", Gnome, 10,
            25, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 1
        );

    public final static Race Goblin = new Race("Goblin", 10,
        25, 0, 0, 0, 0,
        0, 0, 0,
        0, 0, 0,
        true
    );
        public final static Subrace CommonGoblin = new Subrace("Common Goblin", Goblin, 10,
            30, 0, 0, 0, 0,
            0, 2, 1,
            0, 0, 0
        );
        public final static Subrace GrotagGoblin = new Subrace("Grotag", Goblin, 11,
            25, 0, 0, 0, 0,
            0, 0, 2,
            0, 0, 0
        );
        public final static Subrace IxalanGoblin = new Subrace("Ixalan Goblin", Goblin, 10,
            25, 0, 25, 0, 0,
            0, 2, 0,
            0, 0, 0
        );
        public final static Subrace LavastepGoblin = new Subrace("Lavastep Goblin", Goblin, 11,
            25, 0, 0, 0, 0,
            0, 0, 2,
            0, 0, 0
        );
        public final static Subrace TukTukGoblin = new Subrace("TukTuk Goblin", Goblin, 11,
            25, 0, 0, 0, 0,
            0, 0, 2,
            0, 0, 0
        );
        public final static Subrace GreenskinGoblin = new Subrace("Greenskin Goblin", Goblin, 10,
            30, 0, 0, 25, 0,
            0, 2, 0,
            0, 1, 0
        );
        public final static Subrace BoggartGoblin = new Subrace("Boggart Goblin", Goblin, 10,
            30, 0, 0, 0, 0,
            0, 2, 1,
            0, 0, 0
        );
        public final static Subrace Gremlin = new Subrace("Gremlin", Goblin, 10,
            30, 0, 0, 0, 0,
            0, 2, 0,
            1, 0, 0
        );

    public final static Race Goliath = new Race("Goliath", 10,
        30, 0, 0, 0, 0,
        2, 0, 1,
        0, 0, 0,
        false
    );

    public final static Race HalfElf = new Race("Half-Elf", 10,
        30, 0, 0, 0, 0,
        0, 0, 0,
        0, 0, 2,
        false
    );

    public final static Race HalfHag = new Race("Half-Hag", 10,
        30, 0, 0, 0, 0,
        0, 0, 0,
        0, 0, 2,
        true
    );
        public final static Subrace GreenHag = new Subrace("Green Hag", HalfHag, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 0
        );
        public final static Subrace NightHag = new Subrace("Night Hag", HalfHag, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 0
        );
        public final static Subrace SeaHag = new Subrace("Sea Hag", HalfHag, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 0, 0
        );

    public final static Race HalfOrc = new Race("Half-Orc", 10,
        30, 0, 0, 0, 0,
        2, 0, 1,
        0, 0, 0,
        false
    );

    public final static Race Halfling = new Race("Halfling", 10,
        25, 0, 0, 0, 0,
        0, 2, 0,
        0, 0, 0,
        true
    );
        public final static Subrace GhostwiseHalfling = new Subrace("Ghostwise Halfling", Halfling, 10,
            25, 0, 0, 0, 0,
            0, 2, 0,
            0, 0, 0
        );
        public final static Subrace LightfootHalfling = new Subrace("Lightfoot Halfling", Halfling, 10,
            25, 0, 0, 0, 0,
            0, 2, 0,
            0, 0, 1
        );
        public final static Subrace StoutHalfling = new Subrace("Stout Halfling", Halfling, 10,
            25, 0, 0, 0, 0,
            0, 0, 1,
            0, 0, 0
        );
    
    public final static Subrace MarkOfHealingHalfling = new Subrace("Mark of Healing Halfling", Halfling, 10,
            25, 0, 0, 0, 0,
            0, 0, 0,
            0, 1, 0
        );
    
    public final static Subrace MarkOfHospitalityHalfling = new Subrace("Mark of Hospitality Halfling", Halfling, 10,
            30, 0, 0, 0, 0,
            0, 2, 0,
            0, 0, 1
    );
    
    public final static Subrace LotusdenHalfling = new Subrace("Lotusden Halfling", Halfling, 10,
            25, 0, 0, 0, 0,
            0, 0, 0,
            0, 1, 0
    );

    public final static Race Hobgoblin = new Race("Hobgoblin", 10,
        30, 0, 0, 0, 0,
        0, 0, 2,
        1, 0, 0,
        false
    );

    public final static Race Human = new Race("Human", 10,
        30, 0, 0, 0, 0,
        1, 1, 1,
        1, 1, 1,
        false
    );
    
    public final static Race HumanRevenant = new Race("Human Revenant", 10,
        30, 0, 0, 0, 0,
        0, 0, 1,
        0, 0, 0,
        false
    );

    public final static Race Kalashtar = new Race("Kalashtar", 10,
        30, 0, 0, 0, 0,
        0, 0, 0,
        0, 1, 1,
        false
    );
    
    public final static Race Kenku = new Race("Kenku", 10,
        30, 0, 0, 0, 0,
        0, 2, 0,
        0, 1, 0,
        false
    );
    
    public final static Race Kobold = new Race("Kobold", 10,
        0, 0, 0, 0, 0,
        -2, 2, 0,
        0, 0, 0,
        false
    );
    
    public final static Race Leonin = new Race("Leonin", 10,
        35, 0, 0, 0, 0,
        1, 0, 2,
        0, 0, 0,
        false
    );
    
    public final static Race Lizardfolk = new Race("Lizardfolk", 13,
        30, 0, 0, 30, 0,
        0, 0, 2,
        0, 1, 0,
        false
    );
    
    public final static Race Loxodon = new Race("Loxodon", 10,
        25, 0, 0, 0, 0,
        1, 0, 0,
        0, 0, 0,
        true
    );
        public final static Subrace RavnicaLoxodon = new Subrace("Ravnica Loxodon", Loxodon, 12,
            25, 0, 0, 0, 0,
            1, 0, 0,
            0, 2, 0
        );
        public final static Subrace MirrodinLoxodon = new Subrace("Mirrodin Loxodon", Loxodon, 10,
            25, 0, 0, 0, 0,
            1, 0, 0,
            2, 0, 0
        );
        public final static Subrace TarkirLoxodon = new Subrace("Tarkir Loxodon", Loxodon, 10,
            25, 0, 0, 0, 0,
            1, 0, 2,
            0, 0, 0
        );

    public final static Race MarkOfDetectionHalfElf = new Race("Mark of Detection Half-Elf", 10,
        30, 0, 0, 0, 0,
        1, 0, 2,
        0, 0, 0,
        false
    );

    public final static Race MarkOfFindingHalfOrc = new Race("Mark of Finding Half-Orc", 10,
        30, 0, 0, 0, 0,
        1, 0, 0,
        0, 1, 0,
        false
    );
    
    public final static Race MarkOfHandlingHuman = new Race("Mark of Handling Human", 10,
        30, 0, 0, 0, 0,
        0, 1, 0,
        0, 1, 0,
        false
    );
    
    public final static Race MarkOfMakingHuman = new Race("Mark of Making Human", 10,
        30, 0, 0, 0, 0,
        0, 2, 0,
        1, 0, 0,
        false
    );
    
    public final static Race MarkOfPassageHuman = new Race("Mark of Passage Human", 10,
        40, 0, 0, 0, 0,
        0, 2, 0,
        0, 0, 0,
        false
    );
    
    public final static Race MarkOfSentinelHuman = new Race("Mark of Sentinel Human", 10,
        30, 0, 0, 0, 0,
        1, 0, 0,
        0, 1, 0,
        false
    );
    
    public final static Race MarkOfStormHalfElf = new Race("Mark of Storm Half-Elf", 10,
        30, 0, 0, 30, 0,
        0, 1, 0,
        0, 0, 1,
        false
    );
    
    public final static Race MindFlayer = new Race("Mind Flayer", 10,
        30, 0, 0, 0, 0,
        0, 0, 2,
        0, 0, 0,
        false
    );
    
    public final static Race Minotaur = new Race("Minotaur", 10,
        40, 0, 0, 0, 0,
        2, 0, 1,
        0, 0, 0,
        false
    );
    
    public final static Race Orc = new Race("Orc", 10,
        30, 0, 0, 0, 0,
        2, 0, 0,
        0, 0, 0,
        true
    );
        public final static Subrace NormalOrc = new Subrace("Normal Orc", Orc, 10,
            30, 0, 0, 0, 0,
            0, 0, 1,
            -2, 0, 0
        );
        public final static Subrace CommonOrc = new Subrace("Common Orc", Orc, 10,
            30, 0, 0, 0, 0,
            0, 0, 1,
            0, 0, 0
        );
        public final static Subrace MountainOrc = new Subrace("Mountain Orc", Halfling, 10,
            30, 0, 0, 0, 0,
            0, 0, 0,
            0, 1, 0
        );
        public final static Subrace Orog = new Subrace("Orog", Orc, 10,
            30, 0, 0, 0, 0,
            0, 0, 1,
            0, 0, 0
        );
        public final static Subrace WaterOrc = new Subrace("Water Orc", Orc, 10,
            25, 0, 0, 25, 0,
            0, 1, 0,
            0, 0, 0
        );

    public final static Race Satyr = new Race("Satyr", 10,
        35, 0, 0, 0, 0,
        0, 1, 0,
        0, 0, 2,
        false
    );
    
    public final static Race Shifter = new Race("Shifter", 10,
        30, 0, 0, 0, 0,
        0, 1, 0,
        0, 0, 0,
        true
    );
        public final static Subrace BeasthideShifter = new Subrace("Beasthide Shifter", Shifter, 10,
            30, 0, 0, 0, 0,
            0, 1, 0,
            0, 0, 0
        );
        public final static Subrace LongtoothShifter = new Subrace("Longtooth Shifter", Shifter, 10,
            30, 0, 0, 0, 0,
            2, 1, 0,
            0, 0, 0
        );
        public final static Subrace SwiftstrideShifter = new Subrace("Swiftstride Shifter", Halfling, 10,
            30, 0, 0, 0, 0,
            0, 2, 0,
            0, 0, 1
        );
        public final static Subrace WildhuntShifter = new Subrace("Wildhunt Shifter", Shifter, 10,
            30, 0, 0, 0, 0,
            0, 1, 0,
            0, 2, 0
        );

    public final static Race SimicHybrid = new Race("Simic Hybrid", 10,
        30, 0, 0, 0, 0,
        0, 0, 2,
        0, 0, 0,
        false
    );

    public final static Race Tabaxi = new Race("Tabaxi", 10,
        30, 0, 20, 0, 0,
        0, 2, 0,
        0, 0, 1,
        false
    );
    
    public final static Race Tiefling = new Race("Tiefling", 10,
        30, 0, 0, 0, 0,
        0, 0, 0,
        0, 0, 0,
        true
    );
    
    public final static Race Tortle = new Race("Tortle", 10,
        30, 0, 0, 0, 0,
        0, 0, 0,
        0, 0, 0,
        true
    );
    
    public final static Race Triton = new Race("Triton", 10,
        30, 0, 0, 30, 0,
        1, 0, 1,
        0, 0, 1,
        false
    );
    
    public final static Race Vampire = new Race("Vampire", 10,
        30, 0, 0, 0, 0,
        0, 0, 0,
        0, 0, 0,
        true
    );
    
    public final static Race VariantHuman = new Race("Variant Human", 10,
        30, 0, 0, 0, 0,
        0, 0, 0,
        0, 0, 0,
        false
    );
    
    public final static Race Vedalken = new Race("Vedalken", 10,
        30, 0, 0, 0, 0,
        0, 0, 2,
        0, 1, 0,
        true
    );
    
    public final static Race Viashino = new Race("Viashino", 10,
        30, 0, 0, 0, 0,
        1, 2, 0,
        0, 0, 0,
        false
    );
    
    public final static Race Warforged = new Race("Warforged", 10,
        30, 0, 0, 0, 0,
        0, 0, 1,
        0, 0, 0,
        true
    );
    
    public final static Race Wolfborn = new Race("Wolfborn", 10,
        30, 0, 0, 0, 0,
        0, 0, 0,
        1, 0, 0,
        false
    );
    
    public final static Race YuanTiPureblood = new Race("Yuan-Ti Pureblood", 10,
        30, 0, 0, 0, 0,
        0, 0, 0,
        1, 0, 2,
        false
    );

    public static ArrayList<PlayerCharacter> Characters = new ArrayList<PlayerCharacter>(List.of(new PlayerCharacter()));

    public static final ArrayList<Race> RacesInit = new ArrayList<Race>(List.of(Aarakocra,
            Aasimar, Bugbear, Catfolk, Centaur, Changeling, Dragonborn, Dwarf, Elf, Firbolg, Genasi,
            Gith, Gnome, Goblin, Goliath, HalfElf, HalfHag, HalfOrc, Halfling, Hobgoblin, Human,
            HumanRevenant, Kalashtar, Kenku, Kobold, Leonin, Lizardfolk, Loxodon, MarkOfDetectionHalfElf,
            MarkOfFindingHalfOrc, MarkOfHandlingHuman, MarkOfMakingHuman, MarkOfPassageHuman,
            MarkOfSentinelHuman, MarkOfStormHalfElf, MindFlayer, Minotaur, Orc, Satyr, Shifter, Tabaxi,
            Tiefling, Tortle, Triton, Vampire, VariantHuman, Vedalken, Viashino, Warforged, Wolfborn,
            YuanTiPureblood
    ));
    public static final ArrayList<Subrace> SubracesInit = new ArrayList<Subrace>(List.of(ProtectorAasimar,
            ScourgeAasimar, FallenAasimar, OrdinaryBreedCatfolk, LargeBreedCatfolk, MysticBreedCatfolk,
            BlackDragonborn, BlueDragonborn, BrassDragonborn, BronzeDragonborn, CopperDragonborn,
            GoldDragonborn, GreenDragonborn, RedDragonborn, SilverDragonborn, WhiteDragonborn,
            HillDwarf, MountainDwarf, HouseKundarakDwarf, DuergarDwarf, MarkOfWardingDwarf, HighElf,
            WoodElf, SeaElf, ShadarKai, HouseOfShadow, AerenalHighElf, AerenalWoodElf, ValenarHighElf,
            ValenarWoodElf, DarkElf, PalidElf, AirGenasi, EarthGenasi, FireGenasi, WaterGenasi, Githyanki,
            Githzerai, ForestGnome, RockGnome, DeepGnome, MarkOfScribingDwarf, CommonGoblin, GrotagGoblin,
            IxalanGoblin, LavastepGoblin, TukTukGoblin, GreenskinGoblin, BoggartGoblin, Gremlin, GreenHag,
            NightHag, SeaHag, GhostwiseHalfling, LightfootHalfling, StoutHalfling,
            MarkOfHealingHalfling, MarkOfHospitalityHalfling, LotusdenHalfling, RavnicaLoxodon,
            MirrodinLoxodon, TarkirLoxodon, NormalOrc, CommonOrc, MountainOrc, Orog, WaterOrc,
            BeasthideShifter, LongtoothShifter, SwiftstrideShifter, WildhuntShifter));
    public static final ArrayList<CharacterClass> CharacterClassesInit = new ArrayList<CharacterClass>
            (List.of(Artificer, Barbarian, Bard, Cleric, Druid, Fighter, Monk, Paladin, Ranger, Rogue,
                Sorcerer, Warlock, Wizard));

    public static ArrayList<Race> Races = RacesInit;
    public static ArrayList<Subrace> Subraces = SubracesInit;
    public static ArrayList<CharacterClass> CharacterClasses = CharacterClassesInit;

    public static PlayerCharacter CurrentCharacter = new PlayerCharacter();
}