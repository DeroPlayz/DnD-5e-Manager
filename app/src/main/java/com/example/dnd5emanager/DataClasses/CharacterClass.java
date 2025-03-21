package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.*;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CharacterClass {
    private String Name;
        public String getName(){return Name;}
    private String HitDice;
    private Armor[] ArmorProficiencies;
    private int AttacksByLevel;
    private int BaseAC;
    private String[] BaseClassSkills;
    private String[] SelectableClassSkills;
    private int SelectableSkillCount;
    private int Level = 0;
        public void setLevel(int Level){this.Level = Level;}
        public int getLevel(){return Level;}
    public CharacterClass(String name, String hitDice, Armor[] armorProficiencies,
        int attacksByLevel, int baseAC, String[] baseClassSkills, String[] selectableClassSkills,
        int selectableSkillCount){
            Name = name;
            HitDice = hitDice;
            ArmorProficiencies = armorProficiencies;
            AttacksByLevel = attacksByLevel;
            BaseAC = baseAC;
            BaseClassSkills = baseClassSkills;
            SelectableClassSkills = selectableClassSkills;
            SelectableSkillCount = selectableSkillCount;
    }

    public CharacterClass(){
        Name = "";
        HitDice = "";
        ArmorProficiencies = new Armor[0];
        AttacksByLevel = 0;
        BaseAC = 0;
        BaseClassSkills = new String[0];
        SelectableClassSkills = new String[0];
        SelectableSkillCount = 0;
    }
}