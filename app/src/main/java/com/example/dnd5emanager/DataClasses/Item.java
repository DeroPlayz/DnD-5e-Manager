package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Items;

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

public class Item extends Piece{
    public boolean isAmmo() {
        return isAmmo;
    }

    public boolean isCursed() {
        return isCursed;
    }

    public boolean isEquipment() {
        return isEquipment;
    }

    public boolean isMagic() {
        return isMagic;
    }

    public boolean isSpellcastingFocus() {
        return isSpellcastingFocus;
    }

    public boolean isTemplate() {
        return isTemplate;
    }

    public boolean isValueMultiplier() {
        return isValueMultiplier;
    }

    public boolean isWeightMultiplier() {
        return isWeightMultiplier;
    }

    public String getRarity() {
        return Rarity;
    }

    public boolean isRequiresAttunement() {
        return requiresAttunement;
    }

    public String getType() {
        return Type.charAt(0) + Type.substring(1).toLowerCase();
    }

    public int getValue() {
        return Value;
    }

    public String getCoinType() {
        return CoinType.charAt(0) + CoinType.substring(1).toLowerCase();
    }

    public double getWeight(){
        return Weight;
    }

    public String getWeightUnit() {
        return WeightUnit.toLowerCase();
    }

    boolean isAmmo;
    boolean isCursed;
    boolean isEquipment;
    boolean isMagic;
    boolean isSpellcastingFocus;
    boolean isTemplate;
    boolean isValueMultiplier;
    boolean isWeightMultiplier;
    String Rarity;
    boolean requiresAttunement;
    String Type;
    int Value;
    String CoinType;
    double Weight;
    String WeightUnit;

    public Item(String name, String description, boolean isAmmo, boolean isCursed, boolean isEquipment, boolean isMagic,
        boolean isSpellcastingFocus, boolean isTemplate, boolean isValueMultiplier,
        boolean isWeightMultiplier, String rarity, boolean requiresAttunement, String type,
        int value, String coinType, double Weight, String weightUnit){
            super(name, description);
            this.isAmmo = isAmmo;
            this.isCursed = isCursed;
            this.isEquipment = isEquipment;
            this.isMagic = isMagic;
            this.isSpellcastingFocus = isSpellcastingFocus;
            this.isTemplate = isTemplate;
            this.isValueMultiplier = isValueMultiplier;
            this.isWeightMultiplier = isWeightMultiplier;
            this.Rarity = rarity;
            this.requiresAttunement = requiresAttunement;
            this.Type = type;
            this.Value = value;
            this.CoinType = coinType;
            this.Weight = Weight;
            this.WeightUnit = weightUnit;
    }

    public static void parseItems(Context context, String dir, String s) {
        AssetManager AM;

        Log.d("Jason", "He was just born in Item.");
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
                        Items.put(jsonObject.getString("name"), new Item(
                                jsonObject.getString("name"),
                                jsonObject.getString("description"),
                                jsonObject.getBoolean("isAmmunition"),
                                jsonObject.getBoolean("isCursed"),
                                jsonObject.getBoolean("isEquipment"),
                                jsonObject.getBoolean("isMagic"),
                                jsonObject.getBoolean("isSpellcastingFocus"),
                                jsonObject.getBoolean("isTemplate"),
                                jsonObject.getBoolean("isValueMultiplier"),
                                jsonObject.getBoolean("isWeightMultiplier"),
                                jsonObject.getString("rarity"),
                                jsonObject.getBoolean("requiresAttunement"),
                                jsonObject.getString("type"),
                                jsonObject.optInt("value", 0),
                                jsonObject.getString("valueCoin"),
                                jsonObject.optDouble("weight", 0.0),
                                jsonObject.getString("weightUnit")
                        ));
                        Log.d("Item #" + i, jsonObject.getString("name"));
                    }
                    i++;
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Item.");
            throw new RuntimeException(e);
        }
    }

    public static void initializeItems(Context context){
        Handler mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService executorService = Executors.newFixedThreadPool(26);
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "A");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "B");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "C");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "D");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "E");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "F");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "G");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "H");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "I");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "J");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "K");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "L");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "M");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "N");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "O");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "P");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "Q");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "R");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "S");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "T");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "U");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "V");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "W");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "X");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "Y");}});
        executorService.execute(new Runnable(){@Override public void run(){parseItems(context, "items", "Z");}});
    }
}