package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {
    //Elements
    public static final String Piercing = "Piercing";
    public static final String Bludgeoning = "Bludgeoning";
    public static final String Slashing = "Slashing";
    public static final String Fire = "Fire";
    public static final String Cold = "Cold";
    public static final String Lightning = "Lightning";
    public static final String Thunder = "Thunder";
    public static final String Poison = "Poison";
    public static final String Acid = "Acid";
    public static final String Necrotic = "Necrotic";
    public static final String Radiant = "Radiant";
    public static final String Force = "Force";
    public static final String Psychic = "Psychic";

    //Schools of Magic
    public static final String Abjuration = "Abjuration";
    public static final String Conjuration = "Conjuration";
    public static final String Divination = "Divination";
    public static final String Enchantment = "Enchantment";
    public static final String Evocation = "Evocation";
    public static final String Illusion = "Illusion";
    public static final String Necromancy = "Necromancy";
    public static final String Transmutation = "Transmutation";

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

//    public static Subclass findSub(String Name) {
//        for (int i = 0; i < Subclasses.size(); i++) {
//            if (Subclasses.get(i).getName().equals(Name)) {
//                return Subclasses.get(i);
//            }
//        }
//        return null;
//    }

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


}