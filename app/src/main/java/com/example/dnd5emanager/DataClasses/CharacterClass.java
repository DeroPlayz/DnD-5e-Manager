package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.*;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CharacterClass {
    private String Name;
    public void setName(String Name) {
            this.Name = Name;
        }
        public String getName() {
            return Name;
        }

    private int Level = 1;
        public void setLevel(int Level){this.Level = Level;}
        public int getLevel(){return Level;}



//    private ArrayList<Subclass> Subclasses = new ArrayList<Subclass>(Armorer)

    private int StrengthSaveProf;
        public int getStrengthSaveProf(){return StrengthSaveProf;}
    private int DexteritySaveProf;
        public int getDexteritySaveProf(){return DexteritySaveProf;}
    private int ConstitutionSaveProf;
        public int getConstitutionSaveProf(){return ConstitutionSaveProf;}
    private int IntelligenceSaveProf;
        public int getIntelligenceSaveProf(){return IntelligenceSaveProf;}
    private int WisdomSaveProf;
        public int getWisdomSaveProf(){return WisdomSaveProf;}
    private int CharismaSaveProf;
        public int getCharismaSaveProf(){return CharismaSaveProf;}


    private ArrayList<String> SkillProficiencyOptions = new ArrayList<>();
        public ArrayList<String> getSkillProficiencyOptions(){return SkillProficiencyOptions;}
    private int SkillProfChoiceCount;
        public int getSkillProfChoiceCount(){return SkillProfChoiceCount;}

    private ArrayList<String> WeaponProficiencies = new ArrayList<>();
        public ArrayList<String> getWeaponProficiencies(){return WeaponProficiencies;}
    private int WeaponProfChoiceCount;
        public int getWeaponProfChoiceCount(){return WeaponProfChoiceCount;}

    private ArrayList<String> ToolProficiencies = new ArrayList<>();
        public ArrayList<String> getToolProficiencies(){return ToolProficiencies;}
    private int ToolProfChoiceCount;
        public int getToolProfChoiceCount(){return ToolProfChoiceCount;}

    private ArrayList<String> ArmorProficiencies = new ArrayList<>();
        public ArrayList<String> getArmorProficiencies(){return ArmorProficiencies;}
    private int ArmorProfChoiceCount;
        public int getArmorProfChoiceCount(){return ArmorProfChoiceCount;}

    private int HitDie;
        public int getHitDie(){return HitDie;}
        public int rollInitialHealth(){return (int) (Math.random() * HitDie) + 1;}
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
            int StrengthSaveProf,
            int DexteritySaveProf,
            int ConstitutionSaveProf,
            int IntelligenceSaveProf,
            int WisdomSaveProf,
            int CharismaSaveProf,
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
            int HitDie) {

        this.Name = Name;
        this.StrengthSaveProf = StrengthSaveProf;
        this.DexteritySaveProf = DexteritySaveProf;
        this.ConstitutionSaveProf = ConstitutionSaveProf;
        this.IntelligenceSaveProf = IntelligenceSaveProf;
        this.WisdomSaveProf = WisdomSaveProf;
        this.CharismaSaveProf = CharismaSaveProf;
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
        this.HitDie = HitDie;
    }

    @NonNull
    @Override
    public String toString(){
        return Name;
    }

    public static CharacterClass findClass(String Name) {
        for (int i = 0; i < CharacterClasses.size(); i++) {
            if (CharacterClasses.get(i).getName().equals(Name)) {
                return CharacterClasses.get(i);
            }
        }
        return null;
    }
}