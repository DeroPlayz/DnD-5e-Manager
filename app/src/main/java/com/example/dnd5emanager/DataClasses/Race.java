package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Charisma;
import static com.example.dnd5emanager.DataClasses.Constants.Constitution;
import static com.example.dnd5emanager.DataClasses.Constants.Dexterity;
import static com.example.dnd5emanager.DataClasses.Constants.Intelligence;
import static com.example.dnd5emanager.DataClasses.Constants.Races;
import static com.example.dnd5emanager.DataClasses.Constants.Strength;
import static com.example.dnd5emanager.DataClasses.Constants.Wisdom;
import static com.example.dnd5emanager.DataClasses.Subrace.initializeSubraces;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Race {
    private final String Name;
        public String getName(){return Name;}
    //Ability Score Bonuses
    private final Map<String, Integer> AbilityBonuses = new HashMap<String, Integer>() {{
        put(Strength, 0);
        put(Dexterity, 0);
        put(Constitution, 0);
        put(Intelligence, 0);
        put(Wisdom, 0);
        put(Charisma, 0);
    }};

    /** @noinspection DataFlowIssue*/
    public int getAbilityBonus(String Ability){
        return AbilityBonuses.get(Ability);
    }

    //Movement
        private final int GroundSpeed;
            public int getGroundSpeed(){return GroundSpeed;}
        private final int AirSpeed;
            public int getAirSpeed(){return AirSpeed;}
        private final int ClimbSpeed;
            public int getClimbSpeed(){return ClimbSpeed;}
        private final int SwimSpeed;
            public int getSwimSpeed(){return SwimSpeed;}
        private final int BurrowSpeed;
            public int getBurrowSpeed(){return BurrowSpeed;}

    //Proficiencies
        private ArrayList<String> SkillProficiencies;
        private ArrayList<String> WeaponProficiencies;
        private ArrayList<String> ToolProficiencies;

    private final int ArmorClass;
        public int getArmorClass(){return ArmorClass;}
    private ArrayList<String> RacialTraits;

    private final ArrayList<Subrace> Subraces = new ArrayList<>();
        public void addSubrace(Subrace Subrace){
            Subraces.add(Subrace);
        }
        public ArrayList<Subrace> getSubraces(){
            return Subraces;
        }

    public boolean hasSubraces(){
        return Subraces.size() > 1;
    }

    public Race(String Name, int ArmorClass, int GroundSpeed, int AirSpeed, int ClimbSpeed,
        int SwimSpeed, int BurrowSpeed, int StrengthBonus, int DexterityBonus, int ConstitutionBonus,
        int IntelligenceBonus, int WisdomBonus, int CharismaBonus
        /*ArrayList<String> SkillProficiencies, ArrayList<String> WeaponProficiencies,
        ArrayList<String> ToolProficiencies, ArrayList<String> RacialTraits*/){
            this.Name = Name;
            this.ArmorClass = ArmorClass;
            AbilityBonuses.put(Strength, StrengthBonus);
            AbilityBonuses.put(Dexterity, DexterityBonus);
            AbilityBonuses.put(Constitution, ConstitutionBonus);
            AbilityBonuses.put(Intelligence, IntelligenceBonus);
            AbilityBonuses.put(Wisdom, WisdomBonus);
            AbilityBonuses.put(Charisma, CharismaBonus);
            this.GroundSpeed = GroundSpeed;
            this.AirSpeed = AirSpeed;
            this.ClimbSpeed = ClimbSpeed;
            this.SwimSpeed = SwimSpeed;
            this.BurrowSpeed = BurrowSpeed;
//            this.SkillProficiencies = SkillProficiencies;
//            this.WeaponProficiencies = WeaponProficiencies;
//            this.ToolProficiencies = ToolProficiencies;
//            this.RacialTraits = RacialTraits;
    }


    public static void parseRaces(Context context, String dir, String S) {
        AssetManager AM;

        Log.d("Jason", "He was just born in Race.");
        AM = context.getAssets();
        int RaceNumber = 0;
        char Letter = S.toLowerCase().charAt(0);
        try {
            String[] fileNames = AM.list(dir);
            if (fileNames != null) {
                for (String fileName : fileNames) {
                    if(Letter == fileName.toLowerCase().charAt(0) || Letter == ' '){
                        String fullPath = dir + "/" + fileName;
                        InputStream inputStream = AM.open(fullPath);
                        int size = inputStream.available();
                        byte[] buffer = new byte[size];
                        inputStream.read(buffer);
                        inputStream.close();
                        String jsonString = new String(buffer, StandardCharsets.UTF_8);
                        JSONObject jsonObject = new JSONObject(jsonString);
                        Races.put(jsonObject.getString("name"), new Race(
                                jsonObject.getString("name"),
                                jsonObject.getInt("ac"),
                                jsonObject.getJSONObject("speed").getInt("normal"),
                                jsonObject.getJSONObject("speed").getInt("fly"),
                                jsonObject.getJSONObject("speed").getInt("climb"),
                                jsonObject.getJSONObject("speed").getInt("swim"),
                                jsonObject.getJSONObject("speed").getInt("burrow"),
                                jsonObject.getJSONObject("abilityScores").getInt("str"),
                                jsonObject.getJSONObject("abilityScores").getInt("dex"),
                                jsonObject.getJSONObject("abilityScores").getInt("con"),
                                jsonObject.getJSONObject("abilityScores").getInt("intelligence"),
                                jsonObject.getJSONObject("abilityScores").getInt("wis"),
                                jsonObject.getJSONObject("abilityScores").getInt("cha")
                        ));
                        Log.d("Race #" + RaceNumber, jsonObject.getString("name"));
                    }
                    RaceNumber++;
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "shot dead in Race.");
            throw new RuntimeException(e);
        }
    }


    public static void initializeRaces(Context context){
        Handler mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService executorService = Executors.newFixedThreadPool(26);
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "A");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "B");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "C");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "D");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "E");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "F");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "G");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "H");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "I");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "J");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "K");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "L");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "M");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "N");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "O");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "P");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "Q");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "R");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "S");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "T");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "U");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "V");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "W");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "X");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "Y");}});
        executorService.execute(new Runnable(){@Override public void run(){parseRaces(context, "races", "Z");}});
        executorService.execute(new Runnable(){@Override public void run(){
            try {
                executorService.awaitTermination(60, TimeUnit.SECONDS);
                initializeSubraces(context);
                executorService.shutdown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }});
    }
}