package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Acrobatics;
import static com.example.dnd5emanager.DataClasses.Constants.AnimalHandling;
import static com.example.dnd5emanager.DataClasses.Constants.Arcana;
import static com.example.dnd5emanager.DataClasses.Constants.Athletics;
import static com.example.dnd5emanager.DataClasses.Constants.Charisma;
import static com.example.dnd5emanager.DataClasses.Constants.Constitution;
import static com.example.dnd5emanager.DataClasses.Constants.Deception;
import static com.example.dnd5emanager.DataClasses.Constants.Dexterity;
import static com.example.dnd5emanager.DataClasses.Constants.History;
import static com.example.dnd5emanager.DataClasses.Constants.Insight;
import static com.example.dnd5emanager.DataClasses.Constants.Intelligence;
import static com.example.dnd5emanager.DataClasses.Constants.Intimidation;
import static com.example.dnd5emanager.DataClasses.Constants.Investigation;
import static com.example.dnd5emanager.DataClasses.Constants.Medicine;
import static com.example.dnd5emanager.DataClasses.Constants.Nature;
import static com.example.dnd5emanager.DataClasses.Constants.Perception;
import static com.example.dnd5emanager.DataClasses.Constants.Performance;
import static com.example.dnd5emanager.DataClasses.Constants.Persuasion;
import static com.example.dnd5emanager.DataClasses.Constants.Religion;
import static com.example.dnd5emanager.DataClasses.Constants.SleightOfHand;
import static com.example.dnd5emanager.DataClasses.Constants.Stealth;
import static com.example.dnd5emanager.DataClasses.Constants.Strength;
import static com.example.dnd5emanager.DataClasses.Constants.Survival;
import static com.example.dnd5emanager.DataClasses.Constants.Wisdom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private final Map<String, Integer> BaseAbilityScores = new HashMap<String, Integer>() {{
        put(Strength, 0);
        put(Dexterity, 0);
        put(Constitution, 0);
        put(Intelligence, 0);
        put(Wisdom, 0);
        put(Charisma, 0);
    }};
    public Map<String, Integer> getBaseAbilityScores(){return BaseAbilityScores;}

    /** @noinspection DataFlowIssue*/
    public int getAbilityScore(String Ability){
        return BaseAbilityScores.get(Ability) + Race.getAbilityBonus(Ability);
    }

    public int getAbilityMod(String Ability){
        int Value = getAbilityScore(Ability);
        if((Value - 10) % 2 == 0){
            return (Value - 10) /2;
        }
        else{
            double temp = (double) (Value - 10) / 2;
            return (int) (temp - 0.5);
        }
    }

    Map<String, Integer> Proficiencies = new HashMap<String, Integer>() {{
        put(Strength, 0);
        put(Athletics, 0);

        put(Dexterity, 0);
        put(Acrobatics, 0);
        put(SleightOfHand, 0);
        put(Stealth, 0);

        put(Constitution, 0);

        put(Intelligence, 0);
        put(Arcana, 0);
        put(History, 0);
        put(Investigation, 0);
        put(Nature, 0);
        put(Religion, 0);

        put(Wisdom, 0);
        put(AnimalHandling, 0);
        put(Insight, 0);
        put(Medicine, 0);
        put(Perception, 0);
        put(Survival, 0);

        put(Charisma, 0);
        put(Deception, 0);
        put(Intimidation, 0);
        put(Performance, 0);
        put(Persuasion, 0);
    }};

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

    private final Map<Piece, Integer> Inventory = new HashMap<Piece, Integer>();
    public void addToInventory(Piece piece){
        Inventory.put(piece, 1);
    }
    public void addToInventory(Piece piece, int count){
        Inventory.put(piece, count);
    }

    public void removeFromInventory(Piece piece){
        if(Inventory.get(piece) < 2){
            Inventory.remove(piece);
        }
        else{
            Inventory.put(piece, Inventory.get(piece) - 1);
        }
    }
    public void removeFromInventory(Piece piece, int count){
        if(Inventory.get(piece) < count){
            Inventory.put(piece, count);
        }
        else{
            Inventory.remove(piece);
        }
    }

    int XP = 0;
    public void addXP(int XP){this.XP += XP; levelUpCheck();}

    public void levelUpCheck(){
        if(getLevel() == 1 && XP >= 300)            {/*levelUp(2)*/}
        else if(getLevel() == 2 && XP >= 900)       {/*levelUp(3)*/}
        else if(getLevel() == 3 && XP >= 2700)      {/*levelUp(4)*/}
        else if(getLevel() == 4 && XP >= 6500)      {/*levelUp(5)*/}
        else if(getLevel() == 5 && XP >= 14000)     {/*levelUp(6)*/}
        else if(getLevel() == 6 && XP >= 23000)     {/*levelUp(7)*/}
        else if(getLevel() == 7 && XP >= 34000)     {/*levelUp(8)*/}
        else if(getLevel() == 8 && XP >= 48000)     {/*levelUp(9)*/}
        else if(getLevel() == 9 && XP >= 64000)     {/*levelUp(10)*/}
        else if(getLevel() == 10 && XP >= 85000)    {/*levelUp(11)*/}
        else if(getLevel() == 11 && XP >= 100000)   {/*levelUp(12)*/}
        else if(getLevel() == 12 && XP >= 120000)   {/*levelUp(13)*/}
        else if(getLevel() == 13 && XP >= 140000)   {/*levelUp(14)*/}
        else if(getLevel() == 14 && XP >= 165000)   {/*levelUp(15)*/}
        else if(getLevel() == 15 && XP >= 195000)   {/*levelUp(16)*/}
        else if(getLevel() == 16 && XP >= 225000)   {/*levelUp(17)*/}
        else if(getLevel() == 17 && XP >= 265000)   {/*levelUp(18)*/}
        else if(getLevel() == 18 && XP >= 305000)   {/*levelUp(19)*/}
        else if(getLevel() == 19 && XP >= 355000)   {/*levelUp(20)*/}
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
        XP = 0;
        BaseAbilityScores.put(Strength, 0);
        BaseAbilityScores.put(Dexterity, 0);
        BaseAbilityScores.put(Constitution, 0);
        BaseAbilityScores.put(Intelligence, 0);
        BaseAbilityScores.put(Wisdom, 0);
        BaseAbilityScores.put(Charisma, 0);
    }

    public PlayerCharacter(String Name, int Strength, int Dexterity, int Constitution, int Intelligence, int Wisdom, int Charisma, Race Race, CharacterClass Class, int Level){
        this.Name = Name;
        this.Race = Race;

        BaseAbilityScores.put(Constants.Strength, Strength);
        //Every ability has a numerical score, and every character has a score for each ability, and that dictates the bonus you get when you roll this stat.
        //As an example, say you have a Strength score of 10. After this equation, you end up with a bonus of 0, meaning you don't add or subtract anything from your roll.

        //Say you have a Dexterity score of 15. 15-10 = 5, 5/2 = 2.5, and 2.5 rounded down is 2. Therefore, any time you roll your Dexterity stat, you add 2.
        //So if you rolled an 8, the actual value would be 10.
        BaseAbilityScores.put(Constants.Dexterity, Dexterity);

        //The same applies to values below 10. If you have a Constitution score of 8, 8-10 is -2, -2 divided by 2 is -1. So for any Constitution roll you make.
        //Your level 1 Health Points are determined by adding your Constitution bonus to a predetermined number based on your class. Since as you level up, you can have multiple classes,
        //the equation below gets the initial number from your first class, then adds your Constitution bonus.
        BaseAbilityScores.put(Constants.Constitution, Constitution);

        //These ability bonuses also apply to "skills"; those are the variables declared indented from the abilities.
        //Any skill under that ability gets that bonus applied. So if your Intelligence bonus is 3,
        //then any time you roll a Arcana, History, Investigation, Nature, or Religion check, you get that +3 added to your roll.
        BaseAbilityScores.put(Constants.Intelligence, Intelligence);

        BaseAbilityScores.put(Constants.Wisdom, Wisdom);

        BaseAbilityScores.put(Constants.Charisma, Charisma);
    }
}