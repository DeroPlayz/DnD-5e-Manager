package com.example.dnd5emanager.DataClasses;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static PlayerCharacter CurrentCharacter = new PlayerCharacter();
    public static Map<String, PlayerCharacter> Characters = new HashMap<>();
    public static Map<String, Race> Races = new HashMap<>();
    public static Map<String, Subrace> Subraces = new HashMap<>();

//    public static Map<String, Monster> Monsters = new HashMap<>();

    public static Map<String, CharacterClass> Classes = new HashMap<>();
    public static Map<String, Subclass> Subclasses = new HashMap<>();

    public static Map<String, Spell> Spells = new HashMap<>();

    public static Map<String, Background> Backgrounds = new HashMap<>();
    public static Map<String, Feature> Features = new HashMap<>();
    public static Map<String, Feat> Feats = new HashMap<>();

    public static Map<String, Item> Items = new HashMap<>();
    public static Map<String, Weapon> Weapons = new HashMap<>();
    public static Map<String, Armor> Armor = new HashMap<>();

    //Abilities

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

    public static final Map<String, String> Skills = new HashMap<String, String>() {{
        put(Athletics, Strength);

        put(Acrobatics, Dexterity);
        put(SleightOfHand, Dexterity);
        put(Stealth, Dexterity);

        put(Arcana, Intelligence);
        put(History, Intelligence);
        put(Investigation, Intelligence);
        put(Nature, Intelligence);
        put(Religion, Intelligence);

        put(AnimalHandling, Wisdom);
        put(Insight, Wisdom);
        put(Medicine, Wisdom);
        put(Perception, Wisdom);
        put(Survival, Wisdom);

        put(Deception, Charisma);
        put(Intimidation, Charisma);
        put(Performance, Charisma);
        put(Persuasion, Charisma);
    }};

    public static final Map<Integer, Integer> EXPToLevel = new HashMap<Integer, Integer>() {{
        put(2, 300);
        put(3, 900);
        put(4, 2700);
        put(5, 6500);
        put(6, 14000);
        put(7, 23000);
        put(8, 34000);
        put(9, 48000);
        put(10, 64000);
        put(11, 85000);
        put(12, 100000);
        put(13, 120000);
        put(14, 140000);
        put(15, 165000);
        put(16, 195000);
        put(17, 225000);
        put(18, 265000);
        put(19, 305000);
        put(20, 355000);
    }};
}