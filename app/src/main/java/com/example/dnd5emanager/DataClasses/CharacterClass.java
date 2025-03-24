package com.example.dnd5emanager.DataClasses;

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
    private int Level = 0;
        public void setLevel(int Level){this.Level = Level;}
        public int getLevel(){return Level;}
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
        Name = "";
        HitDie = "D10";
        ArmorProficiencies = new Armor[0];
        AttacksByLevel = 0;
        BaseAC = 0;
        SelectableClassSkills = new String[0];
        SelectableSkillCount = 0;
    }
}