package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Armor;
import static com.example.dnd5emanager.DataClasses.Constants.Characters;
import static com.example.dnd5emanager.DataClasses.Constants.Classes;
import static com.example.dnd5emanager.DataClasses.Constants.Feats;
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
        for(int i = 0; i < Objects.requireNonNull(files).length; i++){
            PlayerCharacter tempGuy = loadCharacter(c, files[i].getName());
            Log.d("Temp Guy", tempGuy.getName());
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
            Log.d("Saved Name", String.valueOf(character.getName()));

            jsonObject.put("race", character.getRace().getName());
            Log.d("Saved Race", String.valueOf(character.getRace().getName()));

            if(character.getRace().HasSubraces()){
                jsonObject.put("subrace", character.getSubrace().getName());
                Log.d("Saved Subrace", String.valueOf(character.getSubrace().getName()));
            }

            JSONArray Classes = new JSONArray();
            for(int i = 0; i < character.getPlayerClasses().size(); i++){
                CharacterClass currentClass = character.getPlayerClasses().get(i);
                JSONObject Class = new JSONObject();
                Class.put("name", currentClass.getName());
                Log.d("Saved Player Class #" + i + " Name", character.getPlayerClasses().get(i).getName());
                Class.put("level", currentClass.getLevel());
                Log.d("Saved Player Class #" + i + " Level", String.valueOf(character.getPlayerClasses().get(i).getLevel()));
                if(currentClass.HasSubclasses()){
                    Class.put("subclass", currentClass.getSubclass().getName());
                    Log.d("Saved Player Class #" + i + " Subclass", character.getPlayerClasses().get(i).getSubclass().getName());
                }
//                Class.put("hit_die", currentClass.getHitDie());
                Classes.put(Class);
                Log.d("Saved Player Class #" + i, character.getPlayerClasses().get(i).getName());
            }
            jsonObject.put("class_count", character.getPlayerClasses().size());
            Log.d("Saved Player Class Count", String.valueOf(character.getPlayerClasses().size()));

            jsonObject.put("strength", character.getBaseStrength());
            Log.d("Saved Strength", String.valueOf(character.getBaseStrength()));

            jsonObject.put("dexterity", character.getBaseDexterity());
            Log.d("Saved Dexterity", String.valueOf(character.getBaseDexterity()));

            jsonObject.put("constitution", character.getBaseConstitution());
            Log.d("Saved Constitution", String.valueOf(character.getBaseConstitution()));

            jsonObject.put("intelligence", character.getBaseIntelligence());
            Log.d("Saved Intelligence", String.valueOf(character.getBaseIntelligence()));

            jsonObject.put("wisdom", character.getBaseWisdom());
            Log.d("Saved Wisdom", String.valueOf(character.getBaseWisdom()));

            jsonObject.put("charisma", character.getBaseCharisma());
            Log.d("Saved Charisma", String.valueOf(character.getBaseCharisma()));

            jsonObject.put("alignment", character.getAlignment());
            Log.d("Saved Alignment", String.valueOf(character.getAlignment()));

            jsonObject.put("about", character.getAbout());
            Log.d("Saved About", String.valueOf(character.getAbout()));

            jsonObject.put("personality", character.getPersonality());
            Log.d("Saved Personality", String.valueOf(character.getPersonality()));

            jsonObject.put("ideals", character.getIdeals());
            Log.d("Saved Ideals", String.valueOf(character.getIdeals()));

            jsonObject.put("bonds", character.getBonds());
            Log.d("Saved Bonds", String.valueOf(character.getBonds()));

            jsonObject.put("flaws", character.getFlaws());
            Log.d("Saved Flaws", String.valueOf(character.getFlaws()));

            String jsonString = jsonObject.toString();

            String filename = character.getName() + ".json"; // Or generate a unique filename
            File file = new File(context.getFilesDir(), filename);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(jsonString.getBytes());
            fos.close();
            Log.d("Saving Character", "Character saved to: " + file.getAbsolutePath());
        } catch (JSONException | IOException e) {
            Log.e("Saving Character", "Error saving character", e);
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
            Log.d("Loaded Name", jsonObject.optString("name", ""));

            character.setRace(Races.get(jsonObject.optString("race", "")));
            Log.d("Loaded Race", jsonObject.optString("race", ""));

            if(Races.get(jsonObject.optString("race", "")).HasSubraces()){
                character.setSubrace(Subraces.get(jsonObject.optString("subrace", "")));
                Log.d("Loaded Subrace", jsonObject.optString("subrace", ""));
            }

            int classCount = jsonObject.optInt("class_count", 1);
            for(int i = 0; i < classCount; i++){
                JSONObject Class = (JSONObject) jsonObject.getJSONArray("classes").get(i);
                character.getPlayerClasses().add(Classes.get(Class.getString("name")));
                character.getPlayerClasses().get(i).setLevel(Class.getInt("level"));
                if(character.getPlayerClasses().get(i).HasSubclasses()) {
                    character.getPlayerClasses().get(i).setSubclass(Subclasses.get(Class.getString("subclass")));
                }
            }

            character.setBaseStrength(jsonObject.optInt("strength", 0));
            Log.d("Loaded Strength", String.valueOf((jsonObject.optInt("strength", 0))));

            character.setBaseDexterity(jsonObject.optInt("dexterity", 0));
            Log.d("Loaded Dexterity", String.valueOf((jsonObject.optInt("dexterity", 0))));

            character.setBaseConstitution(jsonObject.optInt("constitution", 0));
            Log.d("Loaded Constitution", String.valueOf((jsonObject.optInt("constitution", 0))));

            character.setBaseIntelligence(jsonObject.optInt("intelligence", 0));
            Log.d("Loaded Intelligence", String.valueOf((jsonObject.optInt("intelligence", 0))));

            character.setBaseWisdom(jsonObject.optInt("wisdom", 0));
            Log.d("Loaded Wisdom", String.valueOf((jsonObject.optInt("wisdom", 0))));

            character.setBaseCharisma(jsonObject.optInt("charisma", 0));
            Log.d("Loaded Charisma", String.valueOf((jsonObject.optInt("charisma", 0))));

            character.setAlignment(jsonObject.optString("alignment", ""));
            Log.d("Loaded Alignment", jsonObject.optString("alignment", ""));

            character.setAbout(jsonObject.optString("about", ""));
            Log.d("Loaded About", jsonObject.optString("about", ""));

            character.setPersonality(jsonObject.optString("personality", ""));
            Log.d("Loaded Personality", jsonObject.optString("personality", ""));

            character.setIdeals(jsonObject.optString("ideals", ""));
            Log.d("Loaded Ideals", jsonObject.optString("ideals", ""));

            character.setBonds(jsonObject.optString("bonds", ""));
            Log.d("Loaded Bonds", jsonObject.optString("bonds", ""));

            character.setFlaws(jsonObject.optString("flaws", ""));
            Log.d("Loaded Flaws", jsonObject.optString("flaws", ""));

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
                int i = 0;
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
                    Log.d("Spell #" + i, jsonObject.getString("name"));
                    i++;
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
                int j = 0;
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

                    Log.d("Feature #" + j, jsonObject.getString("name"));
                    j++;
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Feature.");
            throw new RuntimeException(e);
        }
    }

    public static void parseFeats(Context context, String dir) {
        Log.d("Jason", "He was just born in Feat.");
        AM = context.getAssets();
        try {
            String[] fileNames = AM.list(dir);
            if (fileNames != null) {
                int j = 0;
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

                    Feats.put(jsonObject.getString("name"), new Feat(
                            jsonObject.getString("name"),
                            DescModels,
                            jsonObject.getInt("level")
                    ));

                    Log.d("Feat #" + j, jsonObject.getString("name"));
                    j++;
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Feat.");
            throw new RuntimeException(e);
        }
    }

    public static void parseItems(Context context, String dir) {
        Log.d("Jason", "He was just born in Item.");
        AM = context.getAssets();
        try {
            String[] fileNames = AM.list(dir);
            if (fileNames != null) {
                int i = 0;
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
                    Log.d("Item #" + i, jsonObject.getString("name"));
                    i++;
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
                int i = 0;
                for (String fileName : fileNames) {
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
                    Log.d("Armor #" + i, jsonObject.getString("name"));
                    i++;
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
