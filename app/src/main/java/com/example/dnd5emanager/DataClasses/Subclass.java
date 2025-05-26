package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Classes;
import static com.example.dnd5emanager.DataClasses.Constants.Subclasses;

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

public class Subclass{
    String Name;

    public void setName(String Name){this.Name = Name;}
        public String getName(){return Name;}
    String ParentClass;
        public void setParentClass(String ParentClass){this.ParentClass = ParentClass;}
        public String getParentClass(){return ParentClass;}
    private Armor[] ArmorProficiencies;
    private int AttacksByLevel;
    private int BaseAC;
    private int Level = 1;
    public void setLevel(int Level){this.Level = Level;}
    public int getLevel(){return Level;}

    public Subclass(String Name, Armor[] ArmorProficiencies, int AttacksByLevel, int BaseAC, String ParentClass){
        this.Name = Name;
        this.ArmorProficiencies = ArmorProficiencies;
        this.AttacksByLevel = AttacksByLevel;
        this.BaseAC = BaseAC;
        this.ParentClass = ParentClass;
    }

    public Subclass() {
        this.Name = "";
        this.ArmorProficiencies = new Armor[0];
        this.AttacksByLevel = 0;
        this.BaseAC = 0;
        this.ParentClass = "";
    }

    public static void parseSubclasses(Context context, String dir, String s) {
        AssetManager AM;

        Log.d("Jason", "He was just born in Subclass.");
        AM = context.getAssets();
        char Letter = s.toLowerCase().charAt(0);
        int SubclassNumber = 0;
        try {
            String[] folderNames = AM.list(dir);
            if (folderNames != null) {
                for (String folderName : folderNames) {
                    if (Letter == folderName.toLowerCase().charAt(0) || Letter == ' ') {
                        String ClassName = folderName.replace("_", " ");
                        String parentPath = dir + "/" + folderName;
                        String[] fileNames = AM.list(dir + "/" + folderName);
                        if (fileNames != null) {
                            for (String fileName : fileNames) {
                                String fullPath = parentPath + "/" + fileName;
                                //                            Log.d("Subclass Path", fullPath);
                                InputStream inputStream = AM.open(fullPath);
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                String jsonString = new String(buffer, StandardCharsets.UTF_8);
                                JSONObject jsonObject = new JSONObject(jsonString);
                                int ABL = 1;
                                if (jsonObject.getJSONArray("attacksByLevel").length() != 0) {
                                    ABL = jsonObject.getJSONArray("attacksByLevel").getJSONObject(0).getInt("amount");
                                }
                                Subclass TempSub = new Subclass(
                                        jsonObject.getString("name"),
                                        Methods.toArmorArray(jsonObject.getJSONArray("armorProficiencies")),
                                        jsonObject.getInt("baseAc"),
                                        ABL,
                                        ClassName
                                );
                                if (Subclasses.get(jsonObject.getString("name")) != null) {
                                    //                                Log.d("Already exists", jsonObject.getString("name"));
                                    Subclasses.put(jsonObject.getString("name") + "(" + ClassName + ")", TempSub);
                                } else {
                                    //                                Log.d("New subclass!", jsonObject.getString("name"));
                                    Subclasses.put(jsonObject.getString("name"), TempSub);
                                }
                                Classes.get(ClassName).addSubclass(Subclasses.get(TempSub.getName()));
                                Log.d("Subclass #" + SubclassNumber, jsonObject.getString("name"));
                                SubclassNumber++;
                            }
                        }
                    }
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Subclass.");
            throw new RuntimeException(e);
        }
    }

    public static void initializeSubclasses(Context context){
        Handler mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService executorService = Executors.newFixedThreadPool(26);
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "A");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "B");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "C");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "D");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "E");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "F");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "G");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "H");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "I");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "J");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "K");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "L");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "M");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "N");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "O");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "P");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "Q");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "R");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "S");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "T");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "U");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "V");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "W");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "X");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "Y");}});
        executorService.execute(new Runnable(){@Override public void run(){parseSubclasses(context, "subclasses", "Z");}});
    }
}