package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Weapons;

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
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Weapon extends Piece{
    private String Type;
    public void setType(String Type){
        this.Type = Type;
    }
    public String getType() {
        return Type;
    }

    private String Rarity;
    public void setRarity(String Rarity){
        this.Rarity = Rarity;
    }
    public String getRarity() {
        return Rarity;
    }

    private int AttackBonus;
    public void setAttackBonus(int AttackBonus){
        this.AttackBonus = AttackBonus;
    }
    public int getAttackBonus() {
        return AttackBonus;
    }

    private int DamageDice;
    public void setDamageDice(int DamageDice){
        this.DamageDice = DamageDice;
    }
    public int getDamageDice() {
        return DamageDice;
    }

    private int DiceCount;
    public void setDiceCount(int DiceCount){
        this.DiceCount = DiceCount;
    }
    public int getDiceCount() {
        return DiceCount;
    }

    private String DamageType;
    public void setDamageType(String DamageType){
        this.DamageType = DamageType;
    }
    public String getDamageType() {
        return DamageType;
    }

    private final Map<String, Integer> ExtraDamageDice = new HashMap<>(){{
        this.put("d4", 0);
        this.put("d6", 0);
        this.put("d8", 0);
        this.put("d10", 0);
        this.put("d20", 0);
    }};

    private boolean isSimple;
    public void setSimple(boolean isSimple){
        this.isSimple = isSimple;
    }
    public boolean getSimple() {
        return isSimple;
    }
    private boolean isFinesse;
    public void setFinesse(boolean isFinesse){
        this.isFinesse = isFinesse;
    }
    public boolean getFinesse() {
        return isFinesse;
    }

    private boolean isVersatile;
    public void setVersatile(boolean isVersatile){
        this.isVersatile = isVersatile;
    }
    public boolean getVersatile() {
        return isVersatile;
    }
    private int versatileDiceFace;
    public void setVersatileDiceFace(int versatileDiceFace){
        this.versatileDiceFace = versatileDiceFace;
    }
    public int getVersatileDiceFace() {
        return versatileDiceFace;
    }
    private int versatileDiceCount;
    public void setVersatileDiceCount(int versatileDiceCount){
        this.versatileDiceCount = versatileDiceCount;
    }
    public int getVersatileDiceCount() {
        return versatileDiceCount;
    }

    private boolean isLight;
    public void setLight(boolean isLight){
        this.isLight = isLight;
    }
    public boolean getLight() {
        return isLight;
    }
    private boolean isHeavy;
    public void setHeavy(boolean isHeavy){
        this.isHeavy = isHeavy;
    }
    public boolean getHeavy() {
        return isHeavy;
    }

    private boolean isSilver;
    public void setSilver(boolean isSilver){
        this.isSilver = isSilver;
    }
    public boolean getSilver() {
        return isSilver;
    }

    private boolean isTwoHanded;
    public void setTwoHanded(boolean isTwoHanded){
        this.isTwoHanded = isTwoHanded;
    }
    public boolean getTwoHanded() {
        return isTwoHanded;
    }

    private boolean requiresAttunement;
    public void setRequiresAttunement(boolean requiresAttunement){
        this.requiresAttunement = requiresAttunement;
    }
    public boolean getRequiresAttunement() {
        return requiresAttunement;
    }
    private boolean isAttuned;
    public void setAttuned(boolean isAttuned){
        this.isAttuned = isAttuned;
    }
    public boolean getAttuned() {
        return isAttuned;
    }

    private boolean isSpecial;
    public void setSpecial(boolean isSpecial){
        this.isSpecial = isSpecial;
    }
    public boolean getSpecial() {
        return isSpecial;
    }
    private boolean isCustom;
    public void setCustom(boolean isCustom){
        this.isCustom = isCustom;
    }
    public boolean getCustom() {
        return isCustom;
    }
    private boolean isImprovised;
    public void setImprovised(boolean isImprovised){
        this.isImprovised = isImprovised;
    }
    public boolean getImprovised() {
        return isImprovised;
    }

    private boolean hasReach;
    public void setHasReach(boolean hasReach){
        this.hasReach = hasReach;
    }
    public boolean getHasReach() {
        return hasReach;
    }
    private boolean isRanged;
    public void setRanged(boolean isRanged){
        this.isRanged = isRanged;
    }
    public boolean getRanged() {
        return isRanged;
    }
    private boolean isLoading;
    public void setLoading(boolean isLoading){
        this.isLoading = isLoading;
    }
    public boolean getLoading() {
        return isLoading;
    }
    private boolean isThrown;
    public void setThrown(boolean isThrown){
        this.isThrown = isThrown;
    }
    public boolean getThrown() {
        return isThrown;
    }
    private String AmmunitionType;
    public void setAmmunitionType(String AmmunitionType){
        this.AmmunitionType = AmmunitionType;
    }
    public String getAmmunitionType() {
        return AmmunitionType;
    }
    private int normalRange;
    public void setNormalRange(int normalRange){
        this.normalRange = normalRange;
    }
    public int getNormalRange() {
        return normalRange;
    }
    private int maxRange;
    public void setMaxRange(int maxRange){
        this.maxRange = maxRange;
    }
    public int getMaxRange() {
        return maxRange;
    }
    
    public Weapon(String Name, String Description, String Type, String Rarity,
        int AttackBonus,
        int DamageDice, int DiceCount, String DamageType,
        boolean isSimple, boolean isFinesse,
        boolean isVersatile, int versatileDiceFace, int versatileDiceCount,
        boolean isLight, boolean isHeavy,
        boolean isSilver, boolean isTwoHanded,
        boolean requiresAttunement, boolean isAttuned,
        boolean isSpecial, boolean isCustom, boolean isImprovised,
        boolean hasReach, boolean isRanged, boolean isLoading, boolean isThrown, String AmmunitionType,
        int normalRange, int maxRange
    ){
        super(Name, Description);
        this.Type = Type;
        this.Rarity = Rarity;

        this.AttackBonus = AttackBonus;

        this.DamageDice = DamageDice;
        this.DiceCount = DiceCount;
        this.DamageType = DamageType;

        this.isSimple = isSimple;
        this.isFinesse = isFinesse;

        this.isVersatile = isVersatile;
        this.versatileDiceFace = versatileDiceFace;
        this.versatileDiceCount = versatileDiceCount;

        this.isLight = isLight;
        this.isHeavy = isHeavy;

        this.isSilver = isSilver;
        this.isTwoHanded = isTwoHanded;

        this.requiresAttunement = requiresAttunement;
        this.isAttuned = isAttuned;

        this.isSpecial = isSpecial;
        this.isCustom = isCustom;
        this.isImprovised = isImprovised;

        this.hasReach = hasReach;
        this.isRanged = isRanged;
        this.isLoading = isLoading;
        this.isThrown = isThrown;
        this.AmmunitionType = AmmunitionType;

        this.normalRange = normalRange;
        this.maxRange = maxRange;
    }

    public String getDamage(){
        return DiceCount + "d" + DamageDice + " " + DamageType + " damage";
    }

    public static void parseWeapons(Context context, String dir, String s) {
        AssetManager AM;

        Log.d("Jason", "He was just born in Weapon.");
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
                        int DamageDiceName = 0;
                        Log.d("DDN #1", jsonObject.getString("damageDiceName"));
                        Log.d("DDN #2", jsonObject.getString("damageDiceName").replace("d", ""));
                        Log.d("DDN #3", String.valueOf(Integer.parseInt(jsonObject.getString("damageDiceName").replace("d", ""))));
                        DamageDiceName = Integer.parseInt(jsonObject.getString("damageDiceName").replace("d", ""));
                        Log.d("DDN #4", String.valueOf(DamageDiceName));
                        Weapons.put(jsonObject.getString("name"), new Weapon(
                                jsonObject.getString("name"),
                                jsonObject.getString("description"),
                                jsonObject.getString("type"),
                                jsonObject.getString("rarity"),
                                jsonObject.getInt("extraAttackBonus"),
                                DamageDiceName,
                                jsonObject.getInt("damageDiceAmount"),
                                jsonObject.getString("damageTypeName"),
                                jsonObject.getBoolean("isSimple"),
                                jsonObject.getBoolean("isFinesse"),
                                jsonObject.getBoolean("isVersatile"),
                                Integer.parseInt(jsonObject.optString("versatileDamageDie", "0").replace("D", "")),
                                jsonObject.optInt("versatileDamageDiceAmount", 0),
                                jsonObject.getBoolean("isLight"),
                                jsonObject.getBoolean("isHeavy"),
                                jsonObject.getBoolean("isSilver"),
                                jsonObject.getBoolean("twoHanded"),
                                jsonObject.getBoolean("requiresAttunement"),
                                jsonObject.getBoolean("isAttuned"),
                                jsonObject.getBoolean("isSpecial"),
                                jsonObject.getBoolean("isCustom"),
                                jsonObject.getBoolean("isImprovised"),
                                jsonObject.getBoolean("hasReach"),
                                jsonObject.getBoolean("isRanged"),
                                jsonObject.getBoolean("isThrown"),
                                jsonObject.getBoolean("isLoading"),
                                jsonObject.getString("ammunitionType"),
                                jsonObject.optInt("normalRange", 0),
                                jsonObject.optInt("maxRange", 0)
                        ));
                        Log.d("Weapon #" + i, jsonObject.getString("name"));
                        i++;
                    }
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Weapon.");
            throw new RuntimeException(e);
        }
    }

    public static void initializeWeapons(Context context){
        Handler mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService executorService = Executors.newFixedThreadPool(26);
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "A");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "B");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "C");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "D");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "E");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "F");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "G");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "H");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "I");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "J");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "K");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "L");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "M");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "N");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "O");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "P");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "Q");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "R");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "S");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "T");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "U");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "V");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "W");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "X");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "Y");}});
        executorService.execute(new Runnable(){@Override public void run(){parseWeapons(context, "weapons", "Z");}});
    }
}