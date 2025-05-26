package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Armor;

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

public class Armor extends Piece{
    private int ArmorClass;
    public void setArmorClass(int armorClass){
        this.ArmorClass = armorClass;
    }
    public int getArmorClass() {
        return this.ArmorClass;
    }

    private String ArmorType;
    public void setArmorType(String armorType){
        this.ArmorType = armorType;
    }
    public String getArmorType(){
        return this.ArmorType;
    }

    private String Cost;
    public void setCost(String cost){
        this.Cost = cost;
    }
    public String getCost() {
        return this.Cost;
    }

    private boolean isAttuned;
    public void setIsAttuned(boolean isAttuned){
        this.isAttuned = isAttuned;
    }
    public boolean getIsAttuned() {
        return this.isAttuned;
    }

    private boolean isCustom;
    public void setIsCustom(boolean isCustom){
        this.isCustom = isCustom;
    }
    public boolean getIsCustom() {
        return this.isCustom;
    }

    private boolean isProficient;
    public void setIsProficient(boolean isProficient){
        this.isProficient = isProficient;
    }
    public boolean getIsProficient() {
        return this.isProficient;
    }

    private int MaxModBonus;
    public void setMaxModBonus(int maxModBonus){
        this.MaxModBonus = maxModBonus;
    }
    public int getMaxModBonus() {
        return this.MaxModBonus;
    }

    private String ModifierFormatted;
    public void setModifierFormatted(String modifierFormatted){
        this.ModifierFormatted = modifierFormatted;
    }
    public String getModifierFormatted() {
        return this.ModifierFormatted;
    }

    private boolean StealthDisadvantage;
    public void setStealthDisadvantage(boolean stealthDisadvantage){
        this.StealthDisadvantage = stealthDisadvantage;
    }
    public boolean getStealthDisadvantage() {
        return this.StealthDisadvantage;
    }

    private String Weight;
    public void setWeight(String weight){
        this.Weight = weight;
    }
    public String getWeight() {
        return this.Weight;
    }

    public Armor(String name, String description,
         int ArmorClass, String armorType, String cost,
         boolean isAttuned, boolean isCustom, boolean isProficient, int maxModBonus, String modifierFormatted,
         boolean stealthDisadvantage, String weight){
            super(name, description);
            this.ArmorClass = ArmorClass;
            this.ArmorType = armorType;
            this.Cost = cost;
            this.isAttuned = isAttuned;
            this.isCustom = isCustom;
            this.isProficient = isProficient;
            this.MaxModBonus = maxModBonus;
            this.ModifierFormatted = modifierFormatted;
            this.StealthDisadvantage = stealthDisadvantage;
            this.Weight = weight;
    }

    public static void parseArmor(Context context, String dir, String s) {
        AssetManager AM;

        Log.d("Jason", "He was just born in Armor.");
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
                        Armor.put(jsonObject.getString("name"), new Armor(
                                jsonObject.getString("name"),
                                jsonObject.getString("description"),
                                jsonObject.getInt("armor"),
                                jsonObject.getString("category"),
                                jsonObject.getString("cost"),
                                jsonObject.getBoolean("isAttuned"),
                                jsonObject.getBoolean("isCustom"),
                                jsonObject.getBoolean("isProficient"),
                                jsonObject.optInt("maxModifierBonus", 0),
                                jsonObject.optString("modifierFormatted", "None"),
                                jsonObject.optBoolean("stealthDisadvantage", false),
                                jsonObject.optString("weight", "0 lbs.")
                        ));
                        Log.d("Armor #" + i, jsonObject.getString("name"));
                        i++;
                    }
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Armor.");
            throw new RuntimeException(e);
        }
    }

    public static void initializeArmor(Context context){
        Handler mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService executorService = Executors.newFixedThreadPool(26);
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "A");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "B");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "C");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "D");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "E");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "F");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "G");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "H");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "I");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "J");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "K");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "L");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "M");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "N");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "O");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "P");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "Q");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "R");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "S");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "T");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "U");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "V");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "W");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "X");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "Y");}});
        executorService.execute(new Runnable(){@Override public void run(){parseArmor(context, "armor", "Z");}});
    }
}