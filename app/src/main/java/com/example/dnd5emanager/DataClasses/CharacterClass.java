package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;

public class CharacterClass {
    private String Name;
        public String getName(){return Name;}
    private String HitDie;
        public int getHitDieMaxValue(){return Integer.parseInt(HitDie.replace("D", ""));}
    private Armor[] ArmorProficiencies;
    private int AttacksByLevel;
    private int BaseAC;
    private String[] SelectableClassSkills;
    private int SelectableSkillCount;
    private int Level = 1;
        public void setLevel(int Level){this.Level = Level;}
        public int getLevel(){return Level;}

    private Subclass Subclass = new Subclass();
        public void setSubclass(Subclass Subclass){this.Subclass = Subclass;}
        public Subclass getSubclass(){return Subclass;}
    private ArrayList<Subclass> Subclasses = new ArrayList<>();
    public void addSubclass(Subclass Subclass){
        Subclasses.add(Subclass);
    }
    public ArrayList<Subclass> getSubclasses(){
        return Subclasses;
    }
    public boolean HasSubclasses(){
        if(Subclasses.size() > 1){
            return true;
        }
        else{
            return false;
        }
    }

    public CharacterClass(String name, String hitDie, Armor[] armorProficiencies,
        int attacksByLevel, int baseAC, String[] selectableClassSkills,
        int selectableSkillCount){
            Name = name;
            HitDie = hitDie;
            ArmorProficiencies = armorProficiencies;
            AttacksByLevel = attacksByLevel;
            BaseAC = baseAC;
            SelectableClassSkills = selectableClassSkills;
            SelectableSkillCount = selectableSkillCount;
    }

    public CharacterClass(){
        Name = " ";
        HitDie = "D10";
        ArmorProficiencies = new Armor[0];
        AttacksByLevel = 0;
        BaseAC = 0;
        SelectableClassSkills = new String[0];
        SelectableSkillCount = 0;
    }
}