package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Races;
import static com.example.dnd5emanager.DataClasses.Constants.Subraces;

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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Subrace {
    private String Name;
        public String getName(){return Name;}
    private String ParentRace;
        public String getParentRace(){return ParentRace;}

    private int BaseArmorClass;

    private int GroundSpeed;
        public int getGroundSpeed(){return GroundSpeed;}
    private int AirSpeed;
        public int getAirSpeed(){return AirSpeed;}
    private int ClimbSpeed;
        public int getClimbSpeed(){return ClimbSpeed;}
    private int SwimSpeed;
        public int getSwimSpeed(){return SwimSpeed;}
    private int BurrowSpeed;
        public int getBurrowSpeed(){return BurrowSpeed;}

    private int StrengthBonus;
    private int DexterityBonus;
    private int ConstitutionBonus;
    private int IntelligenceBonus;
    private int WisdomBonus;
    private int CharismaBonus;

    private String SpellcastingAbility;

    private ArrayList<String> SkillProficiencies;
    private ArrayList<String> WeaponProficiencies;
    private ArrayList<String> ToolProficiencies;


    public Subrace(String Name, String ParentRace, int BaseArmorClass, int GroundSpeed, int AirSpeed,
       int ClimbSpeed, int SwimSpeed, int BurrowSpeed, int StrengthBonus, int DexterityBonus, int ConstitutionBonus, int IntelligenceBonus, int WisdomBonus, int CharismaBonus){
        this.Name = Name;
        this.ParentRace = ParentRace;
        this.BaseArmorClass = BaseArmorClass;
        this.GroundSpeed = GroundSpeed;
        this.AirSpeed = AirSpeed;
        this.ClimbSpeed = ClimbSpeed;
        this.SwimSpeed = SwimSpeed;
        this.BurrowSpeed = BurrowSpeed;
        this.StrengthBonus = StrengthBonus;
        this.DexterityBonus = DexterityBonus;
        this.ConstitutionBonus = ConstitutionBonus;
        this.IntelligenceBonus = IntelligenceBonus;
        this.WisdomBonus = WisdomBonus;
        this.CharismaBonus = CharismaBonus;
    }

    public static void parseSubraces(Context context, String dir, String s) {
        AssetManager AM;

        Log.d("Jason", "He was just born in Subrace.");
        AM = context.getAssets();
        int SubraceNumber = 0;
        char Letter = s.toLowerCase().charAt(0);
        try {
            String[] folderNames = AM.list(dir);
            if (folderNames != null) {
                for (String folderName : folderNames) {
                    String parentPath = dir + "/" + folderName;
                    String[] fileNames = AM.list(dir + "/" + folderName);
                    if(fileNames != null){
                        for(String fileName : fileNames) {
                            if (Letter == fileName.toLowerCase().charAt(0) || Letter == ' ') {
                                String fullPath = parentPath + "/" + fileName;
                                InputStream inputStream = AM.open(fullPath);
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                String jsonString = new String(buffer, StandardCharsets.UTF_8);
                                JSONObject jsonObject = new JSONObject(jsonString);
                                Subraces.put(jsonObject.getString("name"), new Subrace(
                                        jsonObject.getString("name"),
                                        folderName.replace("_Subraces", ""),
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
                                        jsonObject.getJSONObject("abilityScores").getInt("cha"))
                                );
                                String RaceName = folderName.replace("_Subraces", "");
                                RaceName = RaceName.replace("_", " ");
                                Races.get(RaceName).addSubrace(Subraces.get(jsonObject.getString("name")));
                                Log.d("Subrace #" + SubraceNumber, jsonObject.getString("name"));
                            }
                            SubraceNumber++;
                        }
                    }
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Subrace.");
            throw new RuntimeException(e);
        }
    }

    public static void initializeSubraces(Context context){
        Handler mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService executorService = Executors.newFixedThreadPool(26);
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "A");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "B");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "C");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "D");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "E");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "F");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "G");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "H");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "I");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "J");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "K");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "L");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "M");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "N");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "O");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "P");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "Q");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "R");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "S");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "T");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "U");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "V");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "W");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "X");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "Y");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubraces(context, "subraces", "Z");}});
    }
}