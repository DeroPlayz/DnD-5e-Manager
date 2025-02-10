package com.example.dnd5emanager.DataClasses;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import DataClasses.DataConstants.*;

public class CharacterClass {
    private String Name;

    //Ability Score
        private boolean StrengthSavingThrowProf;
        private boolean DexteritySavingThrowProf;
        private boolean ConstitutionSavingThrowProf;
        private boolean IntelligenceSavingThrowProf;
        private boolean WisdomSavingThrowProf;
        private boolean CharismaSavingThrowProf;

    //Proficiencies
        private ArrayList<String> SavingThrowProficiencies;
        private ArrayList<String> SkillProficiencyOptions;
        private int SkillProfChoiceCount;

        private ArrayList<String> WeaponProficiencies;
        private int WeaponProfChoiceCount;

        private ArrayList<String> ToolProficiencies;
        private int ToolProfChoiceCount;
        private ArrayList<String> ArmorProficiencies;
        private int ArmorProfChoiceCount;


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
            ArrayList<Feature> ClassFeatures){

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
    }

    public static final CharacterClass Artificer = new CharacterClass("Artificer", false, false, true, true, false, false, ArtificerSelectableSkillsProficiencies, ArtificerSelectableWeaponProficiencies, ArtificerSelectableToolProficiencies, ArtificerSelectableArmorProficiencies, 1, Intelligence, Feature.ArtificerFeatures);
    public static final CharacterClass Barbarian = new CharacterClass("Barbarian", true, false, true, false, false, false, BarbarianSelectableSkillsProficiencies, BarbarianSelectableWeaponProficiencies, BarbarianSelectableToolProficiencies, BarbarianSelectableArmorProficiencies, 1, None, Feature.BarbarianFeatures);
    public static final CharacterClass Bard = new CharacterClass("Bard", false, false, true, true, false, false, BardSelectableSkillsProficiencies, BardSelectableWeaponProficiencies, BardSelectableToolProficiencies, BardSelectableArmorProficiencies, 1, Charisma, Feature.BardFeatures);
    public static final CharacterClass Cleric = new CharacterClass("Cleric", false, false, true, true, false, false, ClericSelectableSkillsProficiencies, ClericSelectableWeaponProficiencies, ClericSelectableToolProficiencies, ClericSelectableArmorProficiencies, 1, Wisdom, Feature.ClericFeatures);    
}