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

    private int Level;

    public void setLevel(int Level) {
        this.Level = Level;
    }

    public int getLevel() {
        return Level;
    }

    //Proficiencies
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
    private int SkillProfChoiceCount;

    private ArrayList<String> WeaponProficiencies;
    private int WeaponProfChoiceCount;

    private ArrayList<String> ToolProficiencies;
    private int ToolProfChoiceCount;
    private ArrayList<String> ArmorProficiencies;
    private int ArmorProfChoiceCount;

    private int InitialHP;

    public void setInitialHP(int InitialHP) {
        this.InitialHP = InitialHP;
    }

    public int getInitialHP() {
        return InitialHP;
    }
    //Before adding Constitution modifier.


    private int AttacksPerAction;

    //Spellcasting Malarky
    private String SpellcastingAbility;

    private ArrayList<Feature> ClassFeatures;

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
            int AttacksPerAction,
            String SpellcastingAbility,
            ArrayList<Feature> ClassFeatures,
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
        this.AttacksPerAction = AttacksPerAction;
        this.SpellcastingAbility = SpellcastingAbility;
        this.ClassFeatures = ClassFeatures;
        this.InitialHP = InitialHP;
    }

    public static final CharacterClass Artificer = new CharacterClass("Artificer", false, false,
            true, true, false, false, ArtificerSelectableSkillsProficiencies,
            ArtificerSelectableWeaponProficiencies, ArtificerSelectableToolProficiencies, ArtificerSelectableArmorProficiencies, 1, Intelligence,
            Feature.ArtificerFeatures, 8);
    public static final CharacterClass Barbarian = new CharacterClass("Barbarian", true, false,
            true, false, false, false, BarbarianSelectableSkillsProficiencies,
            BarbarianSelectableWeaponProficiencies, BarbarianSelectableToolProficiencies, BarbarianSelectableArmorProficiencies, 1, None,
            Feature.BarbarianFeatures, 12);
    public static final CharacterClass Bard = new CharacterClass("Bard", false, false, true,
            true, false, false, BardSelectableSkillsProficiencies, BardSelectableWeaponProficiencies,
            BardSelectableToolProficiencies, BardSelectableArmorProficiencies, 1, Charisma, Feature.BardFeatures, 8);
    public static final CharacterClass Cleric = new CharacterClass("Cleric", false, false, true,
            true, false, false, ClericSelectableSkillsProficiencies, ClericSelectableWeaponProficiencies,
            ClericSelectableToolProficiencies, ClericSelectableArmorProficiencies, 1, Wisdom, Feature.ClericFeatures, 8);
    public static final CharacterClass Druid = new CharacterClass("Druid", false, false, true,
            true, false, false, DruidSelectableSkillsProficiencies, DruidSelectableWeaponProficiencies,
            DruidSelectableToolProficiencies, DruidSelectableArmorProficiencies, 1, Wisdom, Feature.DruidFeatures, 8);
    public static final CharacterClass Fighter = new CharacterClass("Fighter", false, false, true,
            true, false, false, FighterSelectableSkillsProficiencies, FighterSelectableWeaponProficiencies,
            FighterSelectableToolProficiencies, FighterSelectableArmorProficiencies, 1, None, Feature.FighterFeatures, 10);
    public static final CharacterClass Monk = new CharacterClass("Monk", false, false, true,
            true, false, false, MonkSelectableSkillsProficiencies, MonkSelectableWeaponProficiencies,
            MonkSelectableToolProficiencies, MonkSelectableArmorProficiencies, 1, None, Feature.MonkFeatures, 8);
    public static final CharacterClass Paladin = new CharacterClass("Paladin", false, false, true,
            true, false, false, PaladinSelectableSkillsProficiencies, PaladinSelectableWeaponProficiencies,
            PaladinSelectableToolProficiencies, PaladinSelectableArmorProficiencies, 1, Charisma, Feature.PaladinFeatures, 10);
    public static final CharacterClass Ranger = new CharacterClass("Ranger", false, false, true,
            true, false, false, RangerSelectableSkillsProficiencies, RangerSelectableWeaponProficiencies,
            RangerSelectableToolProficiencies, RangerSelectableArmorProficiencies, 1, Wisdom, Feature.RangerFeatures, 10);
    public static final CharacterClass Rogue = new CharacterClass("Rogue", false, false, true,
            true, false, false, RogueSelectableSkillsProficiencies, RogueSelectableWeaponProficiencies,
            RogueSelectableToolProficiencies, RogueSelectableArmorProficiencies, 1, None, Feature.RogueFeatures, 8);
    public static final CharacterClass Sorcerer = new CharacterClass("Sorcerer", false, false, true,
            true, false, false, SorcererSelectableSkillsProficiencies, SorcererSelectableWeaponProficiencies,
            SorcererSelectableToolProficiencies, SorcererSelectableArmorProficiencies, 1, Charisma, Feature.SorcererFeatures, 6);
    public static final CharacterClass Warlock = new CharacterClass("Warlock", false, false, true,
            true, false, false, WarlockSelectableSkillsProficiencies, WarlockSelectableWeaponProficiencies,
            WarlockSelectableToolProficiencies, WarlockSelectableArmorProficiencies, 1, Charisma, Feature.WarlockFeatures, 8);
    public static final CharacterClass Wizard = new CharacterClass("Wizard", false, false, true,
            true, false, false, WizardSelectableSkillsProficiencies, WizardSelectableWeaponProficiencies,
            WizardSelectableToolProficiencies, WizardSelectableArmorProficiencies, 1, Intelligence, Feature.WizardFeatures, 6);
}