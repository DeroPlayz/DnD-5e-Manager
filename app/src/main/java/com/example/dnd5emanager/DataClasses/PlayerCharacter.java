package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;

public class PlayerCharacter {
    private String Name;
        public void setName(String Name){this.Name = Name;}
        public String getName(){return Name;}

    public void setLevel(int Level){
        Classes.get(Classes.size()-1).setLevel(Level);
    }
    public int getLevel(){
        if(Classes.size() > 1) {
            int Level = 0;
            for (int i = 0; i < Classes.size(); i++) {
                Level += Classes.get(i).getLevel();
            }
            return Level;
        }
        return Classes.get(0).getLevel();
    }

    public void setCharClass(CharacterClass CharClass){
        Classes.get(0).setCharClass(CharClass);
    }
    public void setCharClass(CharacterClass CharClass, int Level){
        Classes.get(0).setCharClass(CharClass);
        Classes.get(0).setLevel(Level);
    }

    public ArrayList<ClassAndLevel> getClasses(){
        return Classes;
    }

    private int HP;
        public void setHP(int HP){this.HP = HP;}
        public int getHP(){return HP;}

    //Strength is obviously used for demonstrations of, ya know, strength, or other physical power.
    private int Strength;
        private int StrengthBonus;
            private int Athletics;  public void setAthletics(int Athletics){this.Athletics = Athletics;}    public int getAthletics(){return Athletics;}

    //Dexterity is used for maneuvering or other more coordination-based actions.
    private int Dexterity;
        private int DexterityBonus;
            private int Acrobatics;
                public void setAcrobatics(int Acrobatics){this.Acrobatics = Acrobatics;}
                public int getAcrobatics(){return Acrobatics;}
            private int SleightOfHand;
                public void setSleightOfHand(int SleightOfHand){this.SleightOfHand = SleightOfHand;}
                public int getSleightOfHand(){return SleightOfHand;}
            private int Stealth;
                public void setStealth(int Stealth){this.Stealth = Stealth;}
                public int getStealth(){return Stealth;}

    //Constitution determines your ability to take a blow or deal with anything else without
    //faltering; playing an in-game drinking game and trying not to pass out?
    //Roll Constitution! Trying to maintain a spell's effect every turn? Roll Constitution!
    private int Constitution;
        private int ConstitutionBonus;

    //Intelligence is exactly what you think it is; academic or academic-adjacent knowledge.
    private int Intelligence;
        private int IntelligenceBonus;
            private int Arcana;         public void setArcana(int Arcana){this.Arcana = Arcana;}                                public int getArcana(){return Arcana;}
            private int History;        public void setHistory(int History){this.History = History;}                            public int getHistory(){return History;}
            private int Investigation;  public void setInvestigation(int Investigation){this.Investigation = Investigation;}    public int getInvestigation(){return Investigation;}
            private int Nature;         public void setNature(int Nature){this.Nature = Nature;}                                public int getNature(){return Nature;}
            private int Religion;       public void setReligion(int Religion){this.Religion = Religion;}                        public int getReligion(){return Religion;}

    //Wisdom is common sense or instinct, or street smart plainly put.
    private int Wisdom;
        private int WisdomBonus;
            private int AnimalHandling; public void setAnimalHandling(int AnimalHandling){this.AnimalHandling = AnimalHandling;}    public int getAnimalHandling(){return AnimalHandling;}
            private int Insight;        public void setInsight(int Insight){this.Insight = Insight;}                                public int getInsight(){return Insight;}
            private int Medicine;       public void setMedicine(int Medicine){this.Medicine = Medicine;}                            public int getMedicine(){return Medicine;}
            private int Perception;     public void setPerception(int Perception){this.Perception = Perception;}                    public int getPerception(){return Perception;}
            private int Survival;       public void setSurvival(int Survival){this.Survival = Survival;}                            public int getSurvival(){return Survival;}

    //Charisma is exactly what you think; how seriously people take your self-image;
    //how charming you are, how threatening you are,
    //how believable you are when you lie, etc.
    private int Charisma;
        private int CharismaBonus;
            private int Deception;      public void setDeception(int Deception){this.Deception = Deception;}                public int getDeception(){return Deception;}
            private int Intimidation;   public void setIntimidation(int Intimidation){this.Intimidation = Intimidation;}    public int getIntimidation(){return Intimidation;}
            private int Performance;    public void setPerformance(int Performance){this.Performance = Performance;}        public int getPerformance(){return Performance;}
            private int Persuasion;     public void setPersuasion(int Persuasion){this.Persuasion = Persuasion;}            public int getPersuasion(){return Persuasion;}

    private ArrayList<Feature> PlayerFeatures;

    //Various races have different properties.
    private Race Race;

    //Stores character classes as well as their levels, since, ya know, you can multiclass.
    ArrayList<ClassAndLevel> Classes = new ArrayList<ClassAndLevel>();
    int Level = 0;
        public int updLevel(){
            for(int i = 0; i < Classes.size(); i++){
                Level += Classes.get(i).getLevel();
            }
            return Level;
        }
        int XP;
            public void setXP(int XP){this.XP = XP; levelUpCheck();}
            public void addXP(int XPDiff){XP += XPDiff; levelUpCheck();}
            public void removeXP(int XPDiff){XP -= XPDiff;}
            public int getXP(){return XP;}

        public void levelUpCheck(){
            if(Level == 1 && XP >= 300){levelUp();}
            else if(Level == 2 && XP >= 900){levelUp();}
            else if(Level == 3 && XP >= 2700){levelUp();}
            else if(Level == 4 && XP >= 6500){levelUp();}
            else if(Level == 5 && XP >= 14000){levelUp();}
            else if(Level == 6 && XP >= 23000){levelUp();}
            else if(Level == 7 && XP >= 34000){levelUp();}
            else if(Level == 8 && XP >= 48000){levelUp();}
            else if(Level == 9 && XP >= 64000){levelUp();}
            else if(Level == 10 && XP >= 85000){levelUp();}
            else if(Level == 11 && XP >= 100000){levelUp();}
            else if(Level == 12 && XP >= 120000){levelUp();}
            else if(Level == 13 && XP >= 140000){levelUp();}
            else if(Level == 14 && XP >= 165000){levelUp();}
            else if(Level == 15 && XP >= 195000){levelUp();}
            else if(Level == 16 && XP >= 225000){levelUp();}
            else if(Level == 17 && XP >= 265000){levelUp();}
            else if(Level == 18 && XP >= 305000){levelUp();}
            else if(Level == 19 && XP >= 355000){levelUp();}
        }
        public void levelUp(/*Class chosenClass*/){
            CharacterClass chosenClass = Constants.Fighter;
            Classes.get(ClassAndLevel.findClass(Classes, chosenClass)).levelUp();
            int target = ClassAndLevel.findClass(Classes, chosenClass);
            for(int i = 0; i < Classes.get(target).CharClass.getFeatures().size(); i++){
                if(Classes.get(target).CharClass.getFeatures().get(i).getLevel() <= Classes.get(target).CharClass.getLevel() &&
                !PlayerFeatures.contains(Classes.get(target).CharClass.getFeatures().get(i))){
                    PlayerFeatures.add(Classes.get(target).CharClass.getFeatures().get(i));
                }
            }
            if(Classes.get(target).Subclass != null) {
                for (int i = 0; i < Classes.get(target).Subclass.getFeatures().size(); i++) {
                    if (Classes.get(target).Subclass.getFeatures().get(i).getLevel() <= Classes.get(target).CharClass.getLevel() &&
                            !PlayerFeatures.contains(Classes.get(target).Subclass.getFeatures().get(i))) {
                        PlayerFeatures.add(Classes.get(target).Subclass.getFeatures().get(i));
                    }
                }
            }
            if(ClassAndLevel.findClass(Classes, chosenClass) == 0){
                Classes.add(new ClassAndLevel(Constants.Fighter, 10));
            }
            Level = 0;
            for(int i = 0; i<Classes.size()-1; i++){
                Level += Classes.get(i).getLevel();
            }
        }

    //Everything in D&D has an Armor Class. When you attack it, you roll to land the attack.
    //If your roll equals your target's Armor Class or is HIGHER than it, you hit.
    private int ArmorClass;

    //Builds the character (duh).
    public PlayerCharacter(){
        Name = "";
        Level = Strength = StrengthBonus = Athletics = Dexterity = DexterityBonus = Acrobatics = SleightOfHand = Stealth = Constitution = ConstitutionBonus = HP = Intelligence = IntelligenceBonus = Arcana = History = Investigation = Nature = Religion = Wisdom = WisdomBonus = AnimalHandling = Insight = Medicine = Perception = Survival = Charisma = CharismaBonus = Deception = Intimidation = Performance = Persuasion = XP = 0;
    }
    public PlayerCharacter(String Name, int Strength, int Dexterity, int Constitution, int Intelligence, int Wisdom, int Charisma, Race Race, CharacterClass Class, int Level){
        this.Name = Name;
        this.Race = Race;

        Classes.add(new ClassAndLevel(Class, Level));

        this.Strength = Strength;
        //Every ability has a numerical score, and every character has a score for each ability, and that dictates the bonus you get when you roll this stat.
        //As an example, say you have a Strength score of 10. After this equation, you end up with a bonus of 0, meaning you don't add or subtract anything from your roll.
        StrengthBonus = (int) Math.nextDown(((float) (Strength - 10) /2));

        //Say you have a Dexterity score of 15. 15-10 = 5, 5/2 = 2.5, and 2.5 rounded down is 2. Therefore, any time you roll your Dexterity stat, you add 2.
        //So if you rolled an 8, the actual value would be 10.
        this.Dexterity = Dexterity;
        DexterityBonus = (int) Math.nextDown(((float) (Dexterity - 10) /2));

        //The same applies to values below 10. If you have a Constitution score of 8, 8-10 is -2, -2 divided by 2 is -1. So for any Constitution roll you make
        this.Constitution = Constitution;
        ConstitutionBonus = (int) Math.nextDown(((float) (Constitution - 10) /2));
        //Your level 1 Health Points are determined by adding your Constitution bonus to a predetermined number based on your class. Since as you level up, you can have multiple classes,
        //the equation below gets the initial number from your first class, then adds your Constitution bonus.
        HP = Classes.get(0).CharClass.getInitialHP() + ConstitutionBonus;

        this.Intelligence = Intelligence;
        //These ability bonuses also apply to "skills"; those are the variables declared indented from the abilities.
        //Any skill under that ability gets that bonus applied. So if your Intelligence bonus is 3,
        //then any time you roll a Arcana, History, Investigation, Nature, or Religion check, you get that +3 added to your roll.
        IntelligenceBonus = (int) Math.nextDown(((float) (Intelligence - 10) /2));

        this.Wisdom = Wisdom;
        WisdomBonus = (int) Math.nextDown(((float) (Wisdom - 10) /2));

        this.Charisma = Charisma;
        CharismaBonus = (int) Math.nextDown(((float) (Charisma - 10) /2));
    }
}