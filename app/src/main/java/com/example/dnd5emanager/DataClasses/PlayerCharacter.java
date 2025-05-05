package com.example.dnd5emanager.DataClasses;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class PlayerCharacter {
    private String Name;
        public void setName(String Name) {
            this.Name = Name;
        }
        public String getName() {
            return Name;
       }

    private int CurrentHealth;
        public void setCurrentHealth(int CurrentHealth) {
            this.CurrentHealth = CurrentHealth;
        }
        public int getCurrentHealth() {
            return CurrentHealth;
        }
    private int MaxHealth;
        public void setMaxHealth(int MaxHealth) {
            this.MaxHealth = MaxHealth;
        }
        public int getMaxHealth() {
            return MaxHealth;
        }

    private int InitiativeBonus;
        public void setInitiativeBonus() {
            InitiativeBonus = getDexterityBonus();
        }
        public int getInitiativeBonus(){return InitiativeBonus;}

    ArrayList<String, Integer> BaseAbilityScores = {{"Strength", 0}, {"Dexterity", 0}, {"Constitution", 0}, {"Intelligence", 0}, {"Wisdom", 0}, {"Charisma"}, 0};
    
    public void getAbilityMod(String Ability){
        int Value = BaseAbilityScores.
    }

    private ArrayList<Feature> PlayerFeatures;

    //Various races have different properties.
    private Race Race;
        public void setRace(Race Race){this.Race = Race;}
        public Race getRace(){return Race;}
    private Subrace Subrace;
        public void setSubrace(Subrace Subrace){this.Subrace = Subrace;}
        public Subrace getSubrace(){return Subrace;}

    private ArrayList<CharacterClass> PlayerClasses = new ArrayList<>(List.of(new CharacterClass()));

    public void clearClasses(){
        PlayerClasses = new ArrayList<>(List.of(new CharacterClass()));
    }

    public ArrayList<CharacterClass> getPlayerClasses(){return PlayerClasses;}
    public void setLevel(CharacterClass Class, int Level) {
        if(PlayerClasses.contains(Class)){
            PlayerClasses.get(PlayerClasses.indexOf(Class)).setLevel(Level);
        }
    }
    public void setPrimaryClass(CharacterClass Class) {
        if(PlayerClasses == null){
            PlayerClasses = new ArrayList<>(1);
        }
        PlayerClasses.set(0, Class);
    }

    public CharacterClass getPrimaryClass(){
        return PlayerClasses.get(0);
    }

    public int getLevel(){
        int Level = 0;
        for (int i = 0; i < PlayerClasses.size(); i++){
            Level += PlayerClasses.get(i).getLevel();
        }
        return Level;
    }

    int XP = 0;
    public void addXP(int XP){this.XP += XP; levelUpCheck();}
    public void setXP(int XP){this.XP = XP; levelUpCheck();}

    public void levelUpCheck(){
        if(getLevel() == 1 && XP >= 300)            {/*levelUp();*/}
        else if(getLevel() == 2 && XP >= 900)       {/*levelUp();*/}
        else if(getLevel() == 3 && XP >= 2700)      {/*levelUp();*/}
        else if(getLevel() == 4 && XP >= 6500)      {/*levelUp();*/}
        else if(getLevel() == 5 && XP >= 14000)     {/*levelUp();*/}
        else if(getLevel() == 6 && XP >= 23000)     {/*levelUp();*/}
        else if(getLevel() == 7 && XP >= 34000)     {/*levelUp();*/}
        else if(getLevel() == 8 && XP >= 48000)     {/*levelUp();*/}
        else if(getLevel() == 9 && XP >= 64000)     {/*levelUp();*/}
        else if(getLevel() == 10 && XP >= 85000)    {/*levelUp();*/}
        else if(getLevel() == 11 && XP >= 100000)   {/*levelUp();*/}
        else if(getLevel() == 12 && XP >= 120000)   {/*levelUp();*/}
        else if(getLevel() == 13 && XP >= 140000)   {/*levelUp();*/}
        else if(getLevel() == 14 && XP >= 165000)   {/*levelUp();*/}
        else if(getLevel() == 15 && XP >= 195000)   {/*levelUp();*/}
        else if(getLevel() == 16 && XP >= 225000)   {/*levelUp();*/}
        else if(getLevel() == 17 && XP >= 265000)   {/*levelUp();*/}
        else if(getLevel() == 18 && XP >= 305000)   {/*levelUp();*/}
        else if(getLevel() == 19 && XP >= 355000)   {/*levelUp();*/}
    }

    private String Personality = "";
    public void setPersonality(String Personality){this.Personality = Personality;}
    public String getPersonality(){return Personality;}

    private String Ideals = "";
    public void setIdeals(String Ideals){this.Ideals = Ideals;}
    public String getIdeals(){return Ideals;}

    private String Bonds = "";
    public void setBonds(String Bonds){this.Bonds = Bonds;}
    public String getBonds(){return Bonds;}
    private String Flaws = "";
    public void setFlaws(String Flaws){this.Flaws = Flaws;}
    public String getFlaws(){return Flaws;}

    private String About = "";
    public void setAbout(String About){this.About = About;}
    public String getAbout(){return About;}

    private String Background = "";
    public void setBackground(String Background){this.Background = Background;}
    public String getBackground(){return Background;}

    private String Alignment = "";
    public void setAlignment(String Alignment){this.Alignment = Alignment;}
    public String getAlignment(){return Alignment;}

    //Everything in D&D has an Armor Class. When you attack it, you roll to land the attack.
    //If your roll equals your target's Armor Class or is HIGHER than it, you hit.
    private int ArmorClass;

    //Builds the character (duh).
    public PlayerCharacter(){
        Name = "";
        Strength = StrengthBonus = Athletics =
        Dexterity = DexterityBonus = Acrobatics = SleightOfHand = Stealth =
        Constitution = ConstitutionBonus = MaxHealth = CurrentHealth =
        Intelligence = IntelligenceBonus = Arcana = History = Investigation = Nature = Religion =
        Wisdom = WisdomBonus = AnimalHandling = Insight = Medicine = Perception = Survival =
        Charisma = CharismaBonus = Deception = Intimidation = Performance = Persuasion = XP = 0;
    }

    public PlayerCharacter(String Name, int Strength, int Dexterity, int Constitution, int Intelligence, int Wisdom, int Charisma, Race Race, CharacterClass Class, int Level){
        this.Name = Name;
        this.Race = Race;

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
        MaxHealth = ConstitutionBonus;

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

    public void calibrate(){
        setStrengthBonus();
        setDexterityBonus();
        setConstitutionBonus();
        setIntelligenceBonus();
        setWisdomBonus();
        setCharismaBonus();
        setProficiencyBonus();
    }
}