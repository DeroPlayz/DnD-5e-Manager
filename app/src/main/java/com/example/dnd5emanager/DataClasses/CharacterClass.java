package com.example.dnd5emanager.DataClasses;

import com.example.dnd5emanager.DiceRoller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CharacterClass {
    private final String Name;
        public String getName(){return Name;}
    private final String HitDie;
        public int getHitDie(){return Integer.parseInt(HitDie.replace("D", ""));}
        public int getHitDieCount(){return Level;}
        public int rollHitDie(){return DiceRoller.rollDice(Level, getHitDie());}
    private final Armor[] ArmorProficiencies;
    private final int AttacksByLevel;
    private final int BaseAC;
    private final String[] SelectableClassSkills;
    private final int SelectableSkillCount;
    private int Level = 1;
        public void setLevel(int Level){this.Level = Level;}
        public int getLevel(){return Level;}

    private Map<String, Integer> SaveProfs = new HashMap<>() {{
        put("Strength",1);
        put("Dexterity",1);
        put("Constitution",1);
        put("Intelligence",1);
        put("Wisdom",1);
        put("Charisma",1);
    }};

    private ArrayList<Feature> ClassFeatures;
        public void addFeature(Feature Feature){
            ClassFeatures.add(Feature);
        }
        public ArrayList<Feature> getClassFeatures(){
            return ClassFeatures;
        }

    private Subclass Subclass = new Subclass();
        public void setSubclass(Subclass Subclass){this.Subclass = Subclass;}
        public Subclass getSubclass(){return Subclass;}
    private final ArrayList<Subclass> Subclasses = new ArrayList<>();
    public void addSubclass(Subclass Subclass){
        Subclasses.add(Subclass);
    }
    public ArrayList<Subclass> getSubclasses(){
        return Subclasses;
    }
    public boolean HasSubclasses(){
        return Subclasses.size() > 1;
    }

    public CharacterClass(String name, String hitDie, Armor[] armorProficiencies,
        int attacksByLevel, int baseAC, String[] selectableClassSkills,
        int selectableSkillCount/*,
        int StrProf, int DexProf, int ConProf, int IntProf, int WisProf, int ChaProf
        /*, ArrayList<Feature> ClassFeatures*/){
            Name = name;
            HitDie = hitDie;
            ArmorProficiencies = armorProficiencies;
            AttacksByLevel = attacksByLevel;
            BaseAC = baseAC;
            SelectableClassSkills = selectableClassSkills;
            SelectableSkillCount = selectableSkillCount;
//            SaveProfs.put("Strength",StrProf);
//            SaveProfs.put("Dexterity",DexProf);
//            SaveProfs.put("Constitution",ConProf);
//            SaveProfs.put("Intelligence",IntProf);
//            SaveProfs.put("Wisdom",WisProf);
//            SaveProfs.put("Charisma",ChaProf);
        
//            this.ClassFeatures = ClassFeatures;
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