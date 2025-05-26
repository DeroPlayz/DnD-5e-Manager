package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Spells;

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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Spell {
    private String CastTime = "";
    public void setCastTime(String CastTime) {
        this.CastTime = CastTime;
    }
    public String getCastTime() {
        return CastTime;
    }

    private String[] Classes;
    public void setClasses(String[] Classes) {
        this.Classes = Classes;
    }
    public String[] getClasses() {
        return Classes;
    }

    private boolean Verbal;
    public void setVerbal(boolean Verbal) {
        this.Verbal = Verbal;
    }
    public boolean getVerbal() {
        return Verbal;
    }

    private boolean Somatic;
    public void setSomatic(boolean Somatic) {
        this.Somatic = Somatic;
    }
    public boolean getSomatic() {
        return Somatic;
    }

    private boolean Material;
    public void setMaterial(boolean Material) {
        this.Material = Material;
    }
    public boolean getMaterial() {
        return Material;
    }

    private String MaterialCost;

    public void setMaterialCost(String MaterialCost) {
        this.MaterialCost = MaterialCost;
    }
    public String getMaterialCost() {
        return MaterialCost;
    }

    private String Description;
    public void setDescription(String Description) {
        this.Description = Description;
    }
    public String getDescription() {
        return Description;
    }

    private String HigherLevels;
    public void setHigherLevels(String HigherLevels) {
        this.HigherLevels = HigherLevels;
    }

    private String Duration;
    public void setDuration(String Duration) {
        this.Duration = Duration;
    }
    public String getDuration() {
        return Duration;
    }

    private int Level;
    public void setLevel(int Level) {
        this.Level = Level;
    }
    public int getLevel() {
        return Level;
    }

    private String Name;
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getName() {
        return Name;
    }

    private String Range;
    public void setRange(String Range) {
        this.Range = Range;
    }
    public String getRange() {
        return Range;
    }

    private boolean Ritual;
    public void setRitual(boolean Ritual) {
        this.Ritual = Ritual;
    }
    public boolean getRitual() {
        return Ritual;
    }

    private String School;
    public void setSchool(String School) {
        this.School = School;
    }
    public String getSchool() {
        return School;
    }

    public Spell(String CastTime, String[] Classes, boolean Verbal, boolean Somatic, boolean Material,
    String MaterialCost, String Description, String HigherLevels, String Duration, int Level, String Name, String Range,
    boolean Ritual, String School){
        this.CastTime = CastTime;
        this.Classes = Classes;
        this.Verbal = Verbal;
        this.Somatic = Somatic;
        this.Material = Material;
        this.MaterialCost = MaterialCost;
        this.Description = Description;
        if(HigherLevels != null){
            this.Description += "\n\n" + HigherLevels;
        }
        this.Duration = Duration;
        this.Level = Level;
        this.Name = Name;
        this.Range = Range;
        this.Ritual = Ritual;
        this.School = School;
    }

    public static void parseSpells(Context context, String dir, String s) {
        AssetManager AM;

        Log.d("Jason", "He was just born in Spell.");
        AM = context.getAssets();
        char Letter = s.toLowerCase().charAt(0);
        try {
            String[] fileNames = AM.list(dir);
            if (fileNames != null) {
                int i = 0;
                for (String fileName : fileNames) {
                    if (Letter == fileName.toLowerCase().charAt(0) || Letter == ' ') {
                        String fullPath = dir + "/" + fileName;
                        InputStream inputStream = AM.open(fullPath);
                        int size = inputStream.available();
                        byte[] buffer = new byte[size];
                        inputStream.read(buffer);
                        inputStream.close();
                        String jsonString = new String(buffer, StandardCharsets.UTF_8);
                        JSONObject jsonObject = new JSONObject(jsonString);
                        int level;
                        if (jsonObject.getString("level").equals("cantrip")) {
                            level = 0;
                        } else {
                            level = jsonObject.getInt("level");
                        }
                        String materialCost = "";
                        if (jsonObject.getJSONObject("components").getString("raw").contains("(")) {
                            materialCost = jsonObject.getJSONObject("components").getString("raw").substring(jsonObject.getJSONObject("components").getString("raw").indexOf("("));
                        }

                        Spells.put(jsonObject.getString("name"), new Spell(
                                jsonObject.getString("casting_time"),
                                Methods.toStringArray(jsonObject.getJSONArray("classes")),
                                jsonObject.getJSONObject("components").getBoolean("verbal"),
                                jsonObject.getJSONObject("components").getBoolean("somatic"),
                                jsonObject.getJSONObject("components").getBoolean("material"),
                                materialCost,
                                jsonObject.getString("description"),
                                jsonObject.optString("higher_levels", null),
                                jsonObject.getString("duration"),
                                level,
                                jsonObject.getString("name"),
                                jsonObject.getString("range"),
                                jsonObject.getBoolean("ritual"),
                                jsonObject.getString("school")
                        ));
                        Log.d("Spell #" + i, jsonObject.getString("name"));
                        i++;
                    }
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Spell.");
            throw new RuntimeException(e);
        }
    }

    public static void initializeSpells(Context context){
        Handler mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService executorService = Executors.newFixedThreadPool(26);
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "A");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "B");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "C");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "D");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "E");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "F");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "G");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "H");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "I");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "J");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "K");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "L");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "M");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "N");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "O");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "P");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "Q");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "R");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "S");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "T");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "U");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "V");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "W");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "X");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "Y");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSpells(context, "spells", "Z");}});
    }
}