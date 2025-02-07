package com.example.dnd5emanager.DataClasses;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
            ArrayList<String> SkillProficiencyOptions,
            ArrayList<String> WeaponProficiencies,
            ArrayList<String> ToolProficiencies,
            ArrayList<String> ArmorProficiencies,
            int AttacksPerAction,
            String SpellcastingAbility,
            ArrayList<String> ClassFeatures){

            this.Name = Name;
            this.StrengthSavingThrowProf = StrengthSavingThrowProf;
            this.DexteritySavingThrowProf = DexteritySavingThrowProf;
            this.ConstitutionSavingThrowProf = ConstitutionSavingThrowProf;
            this.IntelligenceSavingThrowProf = IntelligenceSavingThrowProf;
            this.WisdomSavingThrowProf = WisdomSavingThrowProf;
            this.CharismaSavingThrowProf = CharismaSavingThrowProf;
            this.SavingThrowProficiencies = SavingThrowProficiencies;
            this.SkillProficiencyOptions = SkillProficiencyOptions;
            this.ToolProficiencies = ToolProficiencies;
            this.ArmorProficiencies = ArmorProficiencies;
            this.AttacksPerAction = AttacksPerAction;
            this.SpellcastingAbility = SpellcastingAbility;
            this.ClassFeatures = ClassFeatures;
    }

    private static final ArrayList<String> ArtificerSelectableSkillsProficiencies = new ArrayList<String>(Arrays.asList("Animal Handling", "Athletics", "Intimidation", "Nature", "Perception", "Survival"));
    private static final ArrayList<String> ArtificerSelectableWeaponProficiencies = new ArrayList<String>(List.of("Simple"));
    private static final ArrayList<String> ArtificerSelectableToolProficiencies = new ArrayList<String>(List.of("Light", "Medium", "Shield"));
    private static final ArrayList<String> ArtificerSelectableArmorProficiencies = new ArrayList<String>(List.of("Simple"));
    private static final ArrayList<String> ArtificerClassFeatures = new ArrayList<String>(List.of("Simple"));

    public static final Artificer("Artificer", false, false, true, true, false, false, ArtificerSelectableSkillsProficiencies, ArtificerSelectableWeaponProficiencies, ArtificerSelectableToolProficiencies, ArtificerSelectableArmorProficiencies, 1, "Intelligence", );
}