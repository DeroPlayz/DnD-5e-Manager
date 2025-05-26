package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Classes;
import static com.example.dnd5emanager.DataClasses.Subclass.initializeSubclasses;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.dnd5emanager.DiceRoller;

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

    public static void parseClasses(Context context, String dir, String s) {
        AssetManager AM;

        Log.d("Jason", "He was just born in Class.");
        AM = context.getAssets();
        char Letter = s.toLowerCase().charAt(0);
        int ClassNumber = 0;
        try {
            String[] fileNames = AM.list(dir);
            if (fileNames != null) {
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
                        Classes.put(jsonObject.getString("name"), new CharacterClass(
                                jsonObject.getString("name"),
                                jsonObject.getString("hitDie"),
                                Methods.toArmorArray(jsonObject.getJSONArray("armorProficiencies")),
                                jsonObject.getJSONArray("attacksByLevel").getJSONObject(0).getInt("amount"),
                                jsonObject.getInt("baseAc"),
                                Methods.toStringArray(jsonObject.getJSONArray("classSkills").getJSONObject(0).getJSONArray("skillsModels")),
                                jsonObject.getJSONArray("classSkills").getJSONObject(0).getInt("amountOfChoice")
                        ));
                        Log.d("Class #" + ClassNumber, jsonObject.getString("name"));
                    }
                    ClassNumber++;
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Class.");
            throw new RuntimeException(e);
        }
    }

    public static void initializeClasses(Context context){
        Handler mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService executorService = Executors.newFixedThreadPool(26);
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "A");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "B");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "C");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "D");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "E");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "F");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "G");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "H");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "I");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "J");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "K");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "L");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "M");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "N");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "O");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "P");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "Q");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "R");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "S");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "T");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "U");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "V");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "W");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "X");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "Y");}});
        executorService.execute(new Runnable(){@Override public void run(){parseClasses(context, "dndclasses", "Z");}});
        try {
            //noinspection ResultOfMethodCallIgnored
            executorService.awaitTermination(1, TimeUnit.SECONDS);
            initializeSubclasses(context);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}