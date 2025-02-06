package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;

public class CharacterClass {
    private String Name;

    //Ability Score Bonuses
        private int StrengthBonus;
        private int DexterityBonus;
        private int ConstitutionBonus;
        private int IntelligenceBonus;
        private int WisdomBonus;
        private int CharismaBonus;

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
            int StrengthBonus ,
            int DexterityBonus,
            int ConstitutionBonus,
            int IntelligenceBonus,
            int WisdomBonus,
            int CharismaBonus,
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
            this.StrengthBonus = StrengthBonus;
            this.DexterityBonus = DexterityBonus;
            this.ConstitutionBonus = ConstitutionBonus;
            this.IntelligenceBonus = IntelligenceBonus;
            this.WisdomBonus = WisdomBonus;
            this.CharismaBonus = CharismaBonus;
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

    public static final Artificer
}