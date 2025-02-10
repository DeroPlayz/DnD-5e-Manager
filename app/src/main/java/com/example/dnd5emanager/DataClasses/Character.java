package com.example.dnd5emanager.DataClasses;

public class Character {
    private String Name;
    private int HP;

    private int Strength;
        private int Athletics;
            public void setAthletics(int Athletics){this.Athletics = Athletics;}
            public int getAthletics(){return Athletics;}
    
    private int Dexterity;
        private int Acrobatics;
            public void setAcrobatics(int Acrobatics){this.Acrobatics = Acrobatics;}
            public int getAcrobatics(){return Acrobatics;}
        private int SleightOfHand;
            public void setSleightOfHand(int SleightOfHand){this.SleightOfHand = SleightOfHand;}
            public int getSleightOfHand(){return SleightOfHand;}
        private int Stealth;
            public void setStealth(int Stealth){this.Stealth = Stealth;}
            public int getStealth(){return Stealth;}
    private int Constitution;
    
    private int Intelligence;
        private int Arcana;
            public void setArcana(int Arcana){this.Arcana = Arcana;}
            public int getArcana(){return Arcana;}
        private int History;
            public void setHistory(int History){this.History = History;}
            public int getHistory(){return History;}
        private int Investigation;
            public void setInvestigation(int Investigation){this.Investigation = Investigation;}
            public int getInvestigation(){return Investigation;}
        private int Nature;
            public void setNature(int Nature){this.Nature = Nature;}
            public int getNature(){return Nature;}
        private int Religion;
            public void setReligion(int Religion){this.Religion = Religion;}
            public int getReligion(){return Religion;}
    
    private int Wisdom;
        private int AnimalHandling;
            public void setAnimalHandling(int AnimalHandling){this.AnimalHandling = AnimalHandling;}
            public int getAnimalHandling(){return AnimalHandling;}
        private int Insight;
            public void setInsight(int Insight){this.Insight = Insight;}
            public int getInsight(){return Insight;}
        private int Medicine;
            public void setMedicine(int Medicine){this.Medicine = Medicine;}
            public int getMedicine(){return Medicine;}
        private int Perception;
            public void setPerception(int Perception){this.Perception = Perception;}
            public int getPerception(){return Perception;}
        private int Survival;
            public void setSurvival(int Survival){this.Survival = Survival;}
            public int getSurvival(){return Survival;}
    
    private int Charisma;
        private int Deception;
            public void setDeception(int Deception){this.Deception = Deception;}
            public int getDeception(){return Deception;}
        private int Intimidation;
            public void setIntimidation(int Intimidation){this.Intimidation = Intimidation;}
            public int getIntimidation(){return Intimidation;}
        private int Performance;
            public void setPerformance(int Performance){this.Performance = Performance;}
            public int getPerformance(){return Performance;}
        private int Persuasion;
            public void setPersuasion(int Persuasion){this.Persuasion = Persuasion;}
            public int getPersuasion(){return Persuasion;}

    private Race Race;
    private Map<CharacterClass, Integer> Classes;
    private int ArmorClass;

    public Character(String Name, Race Race, CharacterClass Class, int Level){
        this.Name = Name;
        this.Race = Race;
        Classes.put(Class, Level);
    }
}
