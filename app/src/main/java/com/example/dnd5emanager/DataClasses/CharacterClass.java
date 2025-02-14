package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.*;
import static com.example.dnd5emanager.DataClasses.Feature.*;

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

    private int Level;
        public int getLevel(){return Level;}
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

    private final ArrayList<String> SkillProficiencyOptions;
        public ArrayList<String> getSkillProficiencyOptions(){return SkillProficiencyOptions;}
    private int SkillProfChoiceCount;
        public int getSkillProfChoiceCount(){return SkillProfChoiceCount;}

    private final ArrayList<String> WeaponProficiencies;
        public ArrayList<String> getWeaponProficiencies(){return WeaponProficiencies;}
    private int WeaponProfChoiceCount;
        public int getWeaponProfChoiceCount(){return WeaponProfChoiceCount;}

    private final ArrayList<String> ToolProficiencies;
        public ArrayList<String> getToolProficiencies(){return ToolProficiencies;}
    private int ToolProfChoiceCount;
        public int getToolProfChoiceCount(){return ToolProfChoiceCount;}

    private final ArrayList<String> ArmorProficiencies;
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
        this.WeaponProficiencies = WeaponProficiencies;
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
}