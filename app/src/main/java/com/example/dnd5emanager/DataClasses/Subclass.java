package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;

public class Subclass extends CharacterClass{
    public Subclass(String Name, boolean StrengthSavingThrowProf, boolean DexteritySavingThrowProf, boolean ConstitutionSavingThrowProf, boolean IntelligenceSavingThrowProf, boolean WisdomSavingThrowProf, boolean CharismaSavingThrowProf, ArrayList<String> SkillProficiencyOptions, ArrayList<String> WeaponProficiencies, ArrayList<String> ToolProficiencies, ArrayList<String> ArmorProficiencies, int AttacksPerAction, String SpellcastingAbility, ArrayList<Feature> ClassFeatures, int InitialHP) {
        super(Name, StrengthSavingThrowProf, DexteritySavingThrowProf, ConstitutionSavingThrowProf, IntelligenceSavingThrowProf, WisdomSavingThrowProf, CharismaSavingThrowProf, SkillProficiencyOptions, WeaponProficiencies, ToolProficiencies, ArmorProficiencies, AttacksPerAction, SpellcastingAbility, ClassFeatures, InitialHP);
    }
}
