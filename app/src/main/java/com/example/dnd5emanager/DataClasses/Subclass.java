package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;

public class Subclass{
    private String Name;
        public void setName(String Name) {
            this.Name = Name;
        }
        public String getName() {
            return Name;
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

    private int AttacksPerAction;

    //Spellcasting Malarky
    private String SpellcastingAbility;

    public Subclass(CharacterClass Parent){
        Name = Parent.getName();
        StrengthSavingThrowProf = Parent.getStrengthSavingThrowProf();
        DexteritySavingThrowProf = Parent.getDexteritySavingThrowProf();
        ConstitutionSavingThrowProf = Parent.getConstitutionSavingThrowProf();
        IntelligenceSavingThrowProf = Parent.getIntelligenceSavingThrowProf();
        WisdomSavingThrowProf = Parent.getWisdomSavingThrowProf();
        CharismaSavingThrowProf = Parent.getCharismaSavingThrowProf();
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

    public final static Subclass Armorer = new Subclass()
}
