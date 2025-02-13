package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.DataConstants.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CharacterClass {
    private String Name;

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

//    private ArrayList<Subclass> Subclasses = new ArrayList<Subclass>(Armorer)

    private boolean StrengthSavingThrowProf;

    public void setStrengthSavingThrowProf(boolean StrengthSavingThrowProf) {
        this.StrengthSavingThrowProf = StrengthSavingThrowProf;
    }

    public boolean getStrengthSavingThrowProf() {
        return StrengthSavingThrowProf;
    }

    private boolean DexteritySavingThrowProf;

    public void setDexteritySavingThrowProf(boolean DexteritySavingThrowProf) {
        this.DexteritySavingThrowProf = DexteritySavingThrowProf;
    }

    public boolean getDexteritySavingThrowProf() {
        return DexteritySavingThrowProf;
    }

    private boolean ConstitutionSavingThrowProf;

    public void setConstitutionSavingThrowProf(boolean ConstitutionSavingThrowProf) {
        this.ConstitutionSavingThrowProf = ConstitutionSavingThrowProf;
    }

    public boolean getConstitutionSavingThrowProf() {
        return ConstitutionSavingThrowProf;
    }

    private boolean IntelligenceSavingThrowProf;

    public void setIntelligenceSavingThrowProf(boolean IntelligenceSavingThrowProf) {
        this.IntelligenceSavingThrowProf = IntelligenceSavingThrowProf;
    }

    public boolean getIntelligenceSavingThrowProf() {
        return IntelligenceSavingThrowProf;
    }

    private boolean WisdomSavingThrowProf;

    public void setWisdomSavingThrowProf(boolean WisdomSavingThrowProf) {
        this.WisdomSavingThrowProf = WisdomSavingThrowProf;
    }

    public boolean getWisdomSavingThrowProf() {
        return WisdomSavingThrowProf;
    }

    private boolean CharismaSavingThrowProf;

    public void setCharismaSavingThrowProf(boolean CharismaSavingThrowProf) {
        this.CharismaSavingThrowProf = CharismaSavingThrowProf;
    }

    public boolean getCharismaSavingThrowProf() {
        return CharismaSavingThrowProf;
    }

    private ArrayList<String> SkillProficiencyOptions;
        public ArrayList<String> getSkillProficiencyOptions(){return SkillProficiencyOptions;}
    private int SkillProfChoiceCount;
        public int getSkillProfChoiceCount(){return SkillProfChoiceCount;}

    private ArrayList<String> WeaponProficiencies;
        public ArrayList<String> getWeaponProficiencies(){return WeaponProficiencies;}
    private int WeaponProfChoiceCount;
        public int getWeaponProfChoiceCount(){return WeaponProfChoiceCount;}

    private ArrayList<String> ToolProficiencies;
        public ArrayList<String> getToolProficiencies(){return ToolProficiencies;}
    private int ToolProfChoiceCount;
        public int getToolProfChoiceCount(){return ToolProfChoiceCount;}

    private ArrayList<String> ArmorProficiencies;
        public ArrayList<String> getArmorProficiencies(){return ArmorProficiencies;}
    private int ArmorProfChoiceCount;
        public int getArmorProfChoiceCount(){return ArmorProfChoiceCount;}

    private int InitialHP;
        public void setInitialHP(int InitialHP) {
            this.InitialHP = InitialHP;
        }
        public int getInitialHP() {
        return InitialHP;
    }
    //Before adding Constitution modifier.


    private int AttacksPerAction;
        public int getAttacksPerAction(){return AttacksPerAction;}

    //Spellcasting Malarky
    private String SpellcastingAbility;
        public String getSpellcastingAbility(){return SpellcastingAbility;}

    private ArrayList<Feature> ClassFeatures;
        public ArrayList<Feature> getFeatures(){return ClassFeatures;}
    public CharacterClass(
            String Name,
            boolean StrengthSavingThrowProf,
            boolean DexteritySavingThrowProf,
            boolean ConstitutionSavingThrowProf,
            boolean IntelligenceSavingThrowProf,
            boolean WisdomSavingThrowProf,
            boolean CharismaSavingThrowProf,
            ArrayList<String> SkillProficiencyOptions,
            ArrayList<String> WeaponProficiencies,
            ArrayList<String> ToolProficiencies,
            ArrayList<String> ArmorProficiencies,
            int SkillProfChoiceCount,
            int WeaponProfChoiceCount,
            int ToolProfChoiceCount,
            int ArmorProfChoiceCount,
            ArrayList<Feature> ClassFeatures,
            int AttacksPerAction,
            String SpellcastingAbility,
            int InitialHP) {

        this.Name = Name;
        this.StrengthSavingThrowProf = StrengthSavingThrowProf;
        this.DexteritySavingThrowProf = DexteritySavingThrowProf;
        this.ConstitutionSavingThrowProf = ConstitutionSavingThrowProf;
        this.IntelligenceSavingThrowProf = IntelligenceSavingThrowProf;
        this.WisdomSavingThrowProf = WisdomSavingThrowProf;
        this.CharismaSavingThrowProf = CharismaSavingThrowProf;
        this.SkillProficiencyOptions = SkillProficiencyOptions;
        this.ToolProficiencies = ToolProficiencies;
        this.ArmorProficiencies = ArmorProficiencies;
        this.SkillProfChoiceCount = SkillProfChoiceCount;
        this.WeaponProfChoiceCount = WeaponProfChoiceCount;
        this.ToolProfChoiceCount = ToolProfChoiceCount;
        this.ArmorProfChoiceCount = ArmorProfChoiceCount;
        this.ClassFeatures = ClassFeatures;
        this.AttacksPerAction = AttacksPerAction;
        this.SpellcastingAbility = SpellcastingAbility;
        this.InitialHP = InitialHP;
    }

    public static final CharacterClass Artificer = new CharacterClass("Artificer",
            false, false, true,
            true, false, false,
            ArtificerSelectableSkillsProficiencies, ArtificerSelectableWeaponProficiencies, ArtificerSelectableToolProficiencies,
            ArtificerSelectableArmorProficiencies, 0, 0, 0,0, Feature.ArtificerFeatures, 1, Intelligence, 8);
    public static final CharacterClass Barbarian = new CharacterClass("Barbarian",
            true, false, true,
            false, false, false,
            BarbarianSelectableSkillsProficiencies, BarbarianSelectableWeaponProficiencies, BarbarianSelectableToolProficiencies,
            BarbarianSelectableArmorProficiencies, 0, 0, 0,0, Feature.BarbarianFeatures, 1, None, 12);
    public static final CharacterClass Bard = new CharacterClass("Bard",
            false, false, true,
            true, false, false,
            BardSelectableSkillsProficiencies, BardSelectableWeaponProficiencies, BardSelectableToolProficiencies,
            BardSelectableArmorProficiencies, 0, 0, 0,0, Feature.BardFeatures, 1, Charisma, 8);
    public static final CharacterClass Cleric = new CharacterClass("Cleric",
            false, false, true,
            true, false, false,
            ClericSelectableSkillsProficiencies, ClericSelectableWeaponProficiencies, ClericSelectableToolProficiencies,
            ClericSelectableArmorProficiencies, 0, 0, 0,0, Feature.ClericFeatures, 1, Wisdom, 8);
    public static final CharacterClass Druid = new CharacterClass("Druid",
            false, false, true,
            true, false, false,
            DruidSelectableSkillsProficiencies, DruidSelectableWeaponProficiencies, DruidSelectableToolProficiencies,
            DruidSelectableArmorProficiencies, 0, 0, 0,0, Feature.DruidFeatures, 1, Wisdom, 8);
    public static final CharacterClass Fighter = new CharacterClass("Fighter",
            false, false, true,
            true, false, false,
            FighterSelectableSkillsProficiencies, FighterSelectableWeaponProficiencies, FighterSelectableToolProficiencies,
            FighterSelectableArmorProficiencies, 0, 0, 0,0, Feature.FighterFeatures, 1, None, 10);
    public static final CharacterClass Monk = new CharacterClass("Monk",
            false, false, true,
            true, false, false,
            MonkSelectableSkillsProficiencies, MonkSelectableWeaponProficiencies, MonkSelectableToolProficiencies,
            MonkSelectableArmorProficiencies, 0, 0, 0,0, Feature.MonkFeatures, 1, None, 8);
    public static final CharacterClass Paladin = new CharacterClass("Paladin",
            false, false, true,
            true, false, false,
            PaladinSelectableSkillsProficiencies, PaladinSelectableWeaponProficiencies, PaladinSelectableToolProficiencies,
            PaladinSelectableArmorProficiencies, 0, 0, 0,0, Feature.PaladinFeatures, 1, Charisma, 10);
    public static final CharacterClass Ranger = new CharacterClass("Ranger",
            false, false, true,
            true, false, false,
            RangerSelectableSkillsProficiencies, RangerSelectableWeaponProficiencies, RangerSelectableToolProficiencies,
            RangerSelectableArmorProficiencies, 0, 0, 0,0, Feature.RangerFeatures, 1, Wisdom, 10);
    public static final CharacterClass Rogue = new CharacterClass("Rogue",
            false, false, true,
            true, false, false,
            RogueSelectableSkillsProficiencies, RogueSelectableWeaponProficiencies, RogueSelectableToolProficiencies,
            RogueSelectableArmorProficiencies, 0, 0, 0,0, Feature.RogueFeatures, 1, None, 8);
    public static final CharacterClass Sorcerer = new CharacterClass("Sorcerer",
            false, false, true,
            true, false, false,
            SorcererSelectableSkillsProficiencies, SorcererSelectableWeaponProficiencies, SorcererSelectableToolProficiencies,
            SorcererSelectableArmorProficiencies, 0, 0, 0,0, Feature.SorcererFeatures, 1, Charisma, 6);
    public static final CharacterClass Warlock = new CharacterClass("Warlock",
            false, false, true,
            true, false, false,
            WarlockSelectableSkillsProficiencies, WarlockSelectableWeaponProficiencies, WarlockSelectableToolProficiencies,
            WarlockSelectableArmorProficiencies, 0, 0, 0,0, Feature.WarlockFeatures, 1, Charisma, 8);
    public static final CharacterClass Wizard = new CharacterClass("Wizard",
            false, false, true,
            true, false, false,
            WizardSelectableSkillsProficiencies, WizardSelectableWeaponProficiencies, WizardSelectableToolProficiencies,
            WizardSelectableArmorProficiencies, 0, 0, 0,0, Feature.WizardFeatures, 1, Intelligence, 6);
}