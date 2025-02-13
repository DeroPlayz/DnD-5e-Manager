package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;

public class Subclass{

    private CharacterClass Parent;

    private String Name;
        public void setName(String Name) {
            this.Name = Name;
        }
        public String getName() {
            return Name;
        }


    //Proficiencies
    private boolean StrengthSavingThrowProf;
        public boolean getStrengthSavingThrowProf() {
            return Parent.getStrengthSavingThrowProf();
        }

    private boolean DexteritySavingThrowProf;
        public boolean getDexteritySavingThrowProf() {
            return Parent.getDexteritySavingThrowProf();
        }

    private boolean ConstitutionSavingThrowProf;
        public boolean getConstitutionSavingThrowProf() {
            return Parent.getConstitutionSavingThrowProf();
        }

    private boolean IntelligenceSavingThrowProf;
        public boolean getIntelligenceSavingThrowProf() {
            return Parent.getIntelligenceSavingThrowProf();
        }

    private boolean WisdomSavingThrowProf;
        public boolean getWisdomSavingThrowProf() {
            return Parent.getWisdomSavingThrowProf();
        }

    private boolean CharismaSavingThrowProf;
        public boolean getCharismaSavingThrowProf() {
            return Parent.getCharismaSavingThrowProf();;
        }

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

    public Subclass(CharacterClass Parent){
        this.Parent = Parent;
        Name = Parent.getName();
        SkillProficiencyOptions = Parent.getSkillProficiencyOptions();
        SkillProfChoiceCount = Parent.getSkillProfChoiceCount();
        WeaponProficiencies = Parent.getWeaponProficiencies();
        WeaponProfChoiceCount = Parent.getWeaponProfChoiceCount();
        ToolProficiencies = Parent.getToolProficiencies();
        ToolProfChoiceCount = Parent.getToolProfChoiceCount();
        ArmorProficiencies = Parent.getArmorProficiencies();
        ArmorProfChoiceCount = Parent.getArmorProfChoiceCount();
        AttacksPerAction = Parent.getAttacksPerAction();
        SpellcastingAbility = Parent.getSpellcastingAbility();
    }

//    public final static Subclass Armorer = new Subclass()
}
