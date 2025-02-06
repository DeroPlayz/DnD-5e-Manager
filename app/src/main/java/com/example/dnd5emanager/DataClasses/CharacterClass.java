package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;

public class CharacterClass {
    private String Name;

    //Ability Score SavingThrowProfes
        private boolean StrengthSavingThrowProf;
        private boolean DexteritySavingThrowProf;
        private boolean ConstitutionSavingThrowProf;
        private boolean IntelligenceSavingThrowProf;
        private boolean WisdomSavingThrowProf;
        private boolean CharismaSavingThrowProf;

    //Proficiencies
        private ArrayList<String> SavingThrowProficiencies;
        private ArrayList<String> SkillProficiencies;
        private ArrayList<String> ToolProficiencies;
        private ArrayList<String> ArmorProficiencies;

    private int AttacksPerAction;

    //Spellcasting Malarky
        private double EffectiveCasterLevel;
        private String SpellcastingAbility;

    private ArrayList<String> SelectableEquipment;

    private ArrayList<String> ClassFeatures;

    public CharacterClass(
            String Name,
            boolean StrengthSavingThrowProf,
            boolean DexteritySavingThrowProf,
            boolean ConstitutionSavingThrowProf,
            boolean IntelligenceSavingThrowProf,
            boolean WisdomSavingThrowProf,
            boolean CharismaSavingThrowProf,
            ArrayList<String> SavingThrowProficiencies,
            ArrayList<String> SkillProficiencies,
            ArrayList<String> ToolProficiencies,
            ArrayList<String> ArmorProficiencies,
            int AttacksPerAction,
            double EffectiveCasterLevel,
            String SpellcastingAbility,
            ArrayList<String> SelectableEquipment,
            ArrayList<String> ClassFeatures){

            this.Name = Name;
            this.StrengthSavingThrowProf = StrengthSavingThrowProf;
            this.DexteritySavingThrowProf = DexteritySavingThrowProf;
            this.ConstitutionSavingThrowProf = ConstitutionSavingThrowProf;
            this.IntelligenceSavingThrowProf = IntelligenceSavingThrowProf;
            this.WisdomSavingThrowProf = WisdomSavingThrowProf;
            this.CharismaSavingThrowProf = CharismaSavingThrowProf;
            this.SavingThrowProficiencies = SavingThrowProficiencies;
            this.SkillProficiencies = SkillProficiencies;
            this.ToolProficiencies = ToolProficiencies;
            this.ArmorProficiencies = ArmorProficiencies;
            this.AttacksPerAction = AttacksPerAction;
            this.EffectiveCasterLevel = EffectiveCasterLevel;
            this.SpellcastingAbility = SpellcastingAbility;
            this.SelectableEquipment = SelectableEquipment;
            this.ClassFeatures = ClassFeatures;
    }

//    public static final Artificer("Artificer", false, false, true, true, false, false);
}