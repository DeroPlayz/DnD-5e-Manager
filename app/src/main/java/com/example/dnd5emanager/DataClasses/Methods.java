package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Armor;
import static com.example.dnd5emanager.DataClasses.Constants.Characters;
import static com.example.dnd5emanager.DataClasses.Constants.Classes;
import static com.example.dnd5emanager.DataClasses.Constants.Features;
import static com.example.dnd5emanager.DataClasses.Constants.Items;
import static com.example.dnd5emanager.DataClasses.Constants.Races;
import static com.example.dnd5emanager.DataClasses.Constants.Spells;
import static com.example.dnd5emanager.DataClasses.Constants.Subclasses;
import static com.example.dnd5emanager.DataClasses.Constants.Subraces;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Methods {

    public static AssetManager AM;

    public static void Initialize(Context c){
        LoadFromInternalStorage(c);
        parseRaces(c, "races");
        parseSubraces(c, "subraces");
        parseClasses(c, "dndclasses");
        parseSubclasses(c, "subclasses");
        parseSpells(c, "spells");
        parseFeatures(c, "features");
        parseItems(c, "items");
        parseArmor(c, "armor");
    }
    public static void LoadFromInternalStorage(Context c){
        AssetManager AM = c.getAssets();
        Characters.clear();
        File[] files = iterateFiles(String.valueOf(c.getFilesDir()));
        for(int i = 0; i < Objects.requireNonNull(files).length - 1; i++){
            PlayerCharacter tempGuy = loadCharacter(c, files[i].getName());
            Characters.put(tempGuy.getName(), tempGuy);
        }
    }

    public static File[] iterateFiles(String directoryPath) {
        File directory = new File(directoryPath);
        ArrayList<File> FinalCharList = new ArrayList<>();
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Process the file (e.g., get name, path, read content)
                        if(!file.getName().equals("profileInstalled")){
                            Log.d("File: ", file.getName());
                            Log.d("Path: ", file.getAbsolutePath());
                            FinalCharList.add(file);
                        }
                        // You can add more file processing logic here
                    } else if (file.isDirectory()) {
                        // If you want to recursively iterate through subdirectories:
                        Log.d("Directory: ", file.getName());
                        iterateFiles(file.getAbsolutePath());
                    }
                }
                return FinalCharList.toArray(new File[0]);
            } else {
                Log.d("Error", "Empty directory or unable to list files.");
            }
        } else {
            Log.d("Error", "Invalid directory path");
        }
        return null;
    }

    public static void saveCharacter(Context context, PlayerCharacter character) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", character.getName());
            jsonObject.put("about", character.getAbout());
            jsonObject.put("personality", character.getPersonality());
            jsonObject.put("ideals", character.getIdeals());
            jsonObject.put("bonds", character.getBonds());
            jsonObject.put("flaws", character.getFlaws());

            // ... add other attributes ...

            String jsonString = jsonObject.toString();

            String filename = character.getName() + ".json"; // Or generate a unique filename
            File file = new File(context.getFilesDir(), filename);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(jsonString.getBytes());
            fos.close();
            Log.d("SaveCharacter", "Character saved to: " + file.getAbsolutePath());
        } catch (JSONException | IOException e) {
            Log.e("SaveCharacter", "Error saving character", e);
        }
    }

    public static PlayerCharacter loadCharacter(Context context, String filename) {
        File file = new File(context.getFilesDir(), filename);

        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder();
            int read;
            char[] buffer = new char[1024];
            while ((read = isr.read(buffer)) != -1) {
                sb.append(buffer, 0, read);
            }
            isr.close();

            JSONObject jsonObject = new JSONObject(sb.toString());

            PlayerCharacter character = new PlayerCharacter();
            character.setName(jsonObject.optString("name", ""));
            character.setAbout(jsonObject.optString("about", ""));
            character.setPersonality(jsonObject.optString("personality", ""));
            character.setBonds(jsonObject.optString("bonds", ""));
            character.setIdeals(jsonObject.optString("ideals", ""));
            character.setFlaws(jsonObject.optString("flaws", ""));

            Log.d("LoadCharacter", "Character loaded from: " + file.getAbsolutePath());
            return character;
        } catch (JSONException | IOException e) {
            Log.e("LoadCharacter", "Error loading character", e);
            return null; // Or handle the error as appropriate for your app
        }
    }

    public static void parseRaces(Context context, String dir) {
        Log.d("Jason", "He was just born in Race.");
        AM = context.getAssets();
        int RaceNumber = 0;
        try {
            String[] fileNames = AM.list(dir);
            if (fileNames != null) {
                for (String fileName : fileNames) {
                    String fullPath = dir + "/" + fileName;
                    InputStream inputStream = AM.open(fullPath);
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    inputStream.close();
                    String jsonString = new String(buffer, StandardCharsets.UTF_8);
                    JSONObject jsonObject = new JSONObject(jsonString);
                    boolean hasSubraces = AM.list(dir + "/" + fileName + "Subraces") != null;

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
                    RaceNumber++;
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "shot dead in Race.");
            throw new RuntimeException(e);
        }
    }

    public static void parseSubraces(Context context, String dir) {
        Log.d("Jason", "He was just born in Subrace.");
        AM = context.getAssets();
        int SubraceNumber = 0;
        try {
            String[] folderNames = AM.list(dir);
            if (folderNames != null) {
                for (String folderName : folderNames) {
                    String parentPath = dir + "/" + folderName;
                    String[] fileNames = AM.list(dir + "/" + folderName);
                    if(fileNames != null){
                        for(String fileName : fileNames){
                            String fullPath = parentPath + "/" + fileName;
//                            Log.d("Name of Folder/Parent Race", folderName);
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
//                            Subraces.put(jsonObject.getString("name"), TempSub);
                            String RaceName = folderName.replace("_Subraces", "");
                            RaceName = RaceName.replace("_", " ");
                            Objects.requireNonNull(Races.get(RaceName)).addSubrace(Subraces.get(jsonObject.getString("name")));
                            Log.d("Subrace #" + SubraceNumber, jsonObject.getString("name"));
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

    public static void parseClasses(Context context, String dir) {
        Log.d("Jason", "He was just born in Class.");
        AM = context.getAssets();
        int ClassNumber = 0;
        try {
            String[] fileNames = AM.list(dir);
            if (fileNames != null) {
                for (String fileName : fileNames) {
                    String fullPath = dir + "/" + fileName;
//                    Log.d("Class Path", fullPath);
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
                            toArmorArray(jsonObject.getJSONArray("armorProficiencies")),
                            jsonObject.getJSONArray("attacksByLevel").getJSONObject(0).getInt("amount"),
                            jsonObject.getInt("baseAc"),
                            toStringArray(jsonObject.getJSONArray("classSkills").getJSONObject(0).getJSONArray("skillsModels")),
                            jsonObject.getJSONArray("classSkills").getJSONObject(0).getInt("amountOfChoice")
                    ));
                    Log.d("Class #" + ClassNumber, jsonObject.getString("name"));
                    ClassNumber++;
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Class.");
            throw new RuntimeException(e);
        }
    }

    public static void parseSubclasses(Context context, String dir) {
        Log.d("Jason", "He was just born in Subclass.");
        AM = context.getAssets();
        int SubclassNumber = 0;
        try {
            String[] folderNames = AM.list(dir);
            if (folderNames != null) {
                for (String folderName : folderNames) {
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
                                    toArmorArray(jsonObject.getJSONArray("armorProficiencies")),
                                    jsonObject.getInt("baseAc"),
                                    ABL,
                                    ClassName
                            );
                            if(Subclasses.get(jsonObject.getString("name")) != null){
//                                Log.d("Already exists", jsonObject.getString("name"));
                                Subclasses.put(jsonObject.getString("name") + "(" + ClassName + ")", TempSub);
                            }
                            else{
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
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Subclass.");
            throw new RuntimeException(e);
        }
    }

    public static void parseSpells(Context context, String dir) {
        Log.d("Jason", "He was just born in Spell.");
        AM = context.getAssets();
        try {
            String[] fileNames = AM.list(dir);
            if (fileNames != null) {
                for (String fileName : fileNames) {
                    String fullPath = dir + "/" + fileName;
                    InputStream inputStream = AM.open(fullPath);
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    inputStream.close();
                    String jsonString = new String(buffer, StandardCharsets.UTF_8);
                    JSONObject jsonObject = new JSONObject(jsonString);
                    int level;
                    if(jsonObject.getString("level").equals("cantrip")){
                        level = 0;
                    }
                    else{
                        level = jsonObject.getInt("level");
                    }
                    String materialCost = "";
                    if(jsonObject.getJSONObject("components").getString("raw").contains("(")){
                        materialCost = jsonObject.getJSONObject("components").getString("raw").substring(jsonObject.getJSONObject("components").getString("raw").indexOf("("));
                    }

                    Spells.put(jsonObject.getString("name"), new Spell(
                            jsonObject.getString("casting_time"),
                            toStringArray(jsonObject.getJSONArray("classes")),
                            jsonObject.getJSONObject("components").getBoolean("verbal"),
                            jsonObject.getJSONObject("components").getBoolean("somatic"),
                            jsonObject.getJSONObject("components").getBoolean("material"),
                            materialCost,
                            jsonObject.getString("description"),
                            jsonObject.getString("duration"),
                            level,
                            jsonObject.getString("name"),
                            jsonObject.getString("range"),
                            jsonObject.getBoolean("ritual"),
                            jsonObject.getString("school")
                    ));
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Spell.");
            throw new RuntimeException(e);
        }
    }

    public static void parseFeatures(Context context, String dir) {
        Log.d("Jason", "He was just born in Feature.");
        AM = context.getAssets();
        try {
            String[] fileNames = AM.list(dir);
            if (fileNames != null) {
                for (String fileName : fileNames) {
                    String fullPath = dir + "/" + fileName;
                    InputStream inputStream = AM.open(fullPath);
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    inputStream.close();
                    String jsonString = new String(buffer, StandardCharsets.UTF_8);
                    JSONObject jsonObject = new JSONObject(jsonString);
                    Map<Integer, String> DescModels = new HashMap<>();

                    for(int i = 0; i < jsonObject.getJSONArray("descriptionModels").length(); i++){
                        DescModels.put(jsonObject.getJSONArray("descriptionModels").getJSONObject(i).getInt("level"), jsonObject.getJSONArray("descriptionModels").getString(i));
                    }

                    Features.put(jsonObject.getString("name"), new Feature(
                            jsonObject.getString("name"),
                            DescModels
                    ));
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Feature.");
            throw new RuntimeException(e);
        }
    }

    public static void parseItems(Context context, String dir) {
        Log.d("Jason", "He was just born in Item.");
        AM = context.getAssets();
        try {
            String[] fileNames = AM.list(dir);
            if (fileNames != null) {
                for (String fileName : fileNames) {
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
                            jsonObject.getString("valueCoin"),
                            jsonObject.getString("weightUnit")
                    ));
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Item.");
            throw new RuntimeException(e);
        }
    }

    public static void parseArmor(Context context, String dir) {
        Log.d("Jason", "He was just born in Armor.");
        AM = context.getAssets();
        try {
            String[] fileNames = AM.list(dir);
            if (fileNames != null) {
                for (String fileName : fileNames) {
                    String fullPath = dir + "/" + fileName;
                    InputStream inputStream = AM.open(fullPath);
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    inputStream.close();
                    String jsonString = new String(buffer, StandardCharsets.UTF_8);
//                    Log.d("How are you doing, Jason?", jsonString);
                    JSONObject jsonObject = new JSONObject(jsonString);
                    Armor.put(jsonObject.getString("name"), new Armor(
                            jsonObject.getString("name"),
                            jsonObject.getString("category"),
                            jsonObject.getString("cost"),
                            jsonObject.getString("description"),
                            jsonObject.getBoolean("isAttuned"),
                            jsonObject.getBoolean("isCustom"),
                            jsonObject.getBoolean("isProficient"),
                            jsonObject.optInt("maxModifierBonus", 0),
                            jsonObject.optString("modifierFormatted", "None"),
                            jsonObject.optBoolean("stealthDisadvantage", false),
                            jsonObject.optString("weight", "0 lbs.")
                    ));
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Armor.");
            throw new RuntimeException(e);
        }
    }

    private static String[] toStringArray(JSONArray array) {
        if(array==null)
            return null;
        String[] arr = new String[array.length()];
        for(int i=0; i<arr.length; i++) {
            arr[i]=array.optString(i);
        }
        return arr;
    }

    private static Armor[] toArmorArray(JSONArray array) throws JSONException {
        if (array == null)
            return null;
        Armor[] arr = new Armor[array.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Armor.get(array.optString(i));
        }
        return arr;
    }
}
