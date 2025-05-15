package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Armor;
import static com.example.dnd5emanager.DataClasses.Constants.Backgrounds;
import static com.example.dnd5emanager.DataClasses.Constants.Characters;
import static com.example.dnd5emanager.DataClasses.Constants.Charisma;
import static com.example.dnd5emanager.DataClasses.Constants.Classes;
import static com.example.dnd5emanager.DataClasses.Constants.Constitution;
import static com.example.dnd5emanager.DataClasses.Constants.Dexterity;
import static com.example.dnd5emanager.DataClasses.Constants.Feats;
import static com.example.dnd5emanager.DataClasses.Constants.Features;
import static com.example.dnd5emanager.DataClasses.Constants.Intelligence;
import static com.example.dnd5emanager.DataClasses.Constants.Items;
import static com.example.dnd5emanager.DataClasses.Constants.Races;
import static com.example.dnd5emanager.DataClasses.Constants.Spells;
import static com.example.dnd5emanager.DataClasses.Constants.Strength;
import static com.example.dnd5emanager.DataClasses.Constants.Subclasses;
import static com.example.dnd5emanager.DataClasses.Constants.Subraces;
import static com.example.dnd5emanager.DataClasses.Constants.Weapons;
import static com.example.dnd5emanager.DataClasses.Constants.Wisdom;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Looper;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Methods {

    public static AssetManager AM;
    private static Handler mainHandler;
    private static ExecutorService executorService;

    public static void Initialize(Context c){
        mainHandler = new Handler(Looper.getMainLooper());
        executorService = Executors.newFixedThreadPool(18);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                parseRaces(c, "races");
                parseSubraces(c, "subraces");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                parseClasses(c, "dndclasses");
                parseSubclasses(c, "subclasses");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run(){
                parseSpells(c, "spells");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run(){
                parseFeatures(c, "features");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run(){
                parseFeats(c, "feats");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run(){
                parseBackgrounds(c, "backgrounds");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run(){
                parseItems(c, "items");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run(){
                parseWeapons(c, "weapons");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run(){
                parseArmor(c, "armor");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run(){
                try {
                    executorService.awaitTermination(60, TimeUnit.SECONDS);
                    LoadFromInternalStorage(c);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public static void LoadFromInternalStorage(Context c){
        AssetManager AM = c.getAssets();
        Characters.clear();
        File[] files = iterateFiles(String.valueOf(c.getFilesDir()));
        if(files != null) {
            for(int i = 0; i < files.length; i++) {
                if(files[i] != null){
                    PlayerCharacter tempGuy = loadCharacter(c, files[i].getName());
                    Log.d("Is temp guy null?", String.valueOf(tempGuy == null));
                    if(tempGuy != null){
                        Log.d("Temp Guy", tempGuy.getName());
                        Characters.put(tempGuy.getName(), tempGuy);
                    }
                }
            }
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

            jsonObject.put("current_health", character.getCurrentHealth());
            Log.d("Saved Current Health", String.valueOf(character.getCurrentHealth()));
            jsonObject.put("max_health", character.getMaxHealth());
            Log.d("Saved Max Health", String.valueOf(character.getMaxHealth()));

            jsonObject.put("race", character.getRace().getName());
            Log.d("Saved Race", String.valueOf(character.getRace().getName()));

            if(character.getRace().hasSubraces()){
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
            jsonObject.put("classes", Classes);
            Log.d("Saved Player Classes", "Saved all " + character.getPlayerClasses().size() + " of them.");


            jsonObject.put("class_count", character.getPlayerClasses().size());
            Log.d("Saved Player Class Count", String.valueOf(character.getPlayerClasses().size()));

            jsonObject.put("strength", character.getBaseAbilityScores().get(Strength));
            Log.d("Saved Strength", String.valueOf(character.getBaseAbilityScores().get(Strength)));

            jsonObject.put("dexterity", character.getBaseAbilityScores().get(Dexterity));
            Log.d("Saved Dexterity", String.valueOf(character.getBaseAbilityScores().get(Dexterity)));

            jsonObject.put("constitution", character.getBaseAbilityScores().get(Constitution));
            Log.d("Saved Constitution", String.valueOf(character.getBaseAbilityScores().get(Constitution)));

            jsonObject.put("intelligence", character.getBaseAbilityScores().get(Intelligence));
            Log.d("Saved Intelligence", String.valueOf(character.getBaseAbilityScores().get(Intelligence)));

            jsonObject.put("wisdom", character.getBaseAbilityScores().get(Wisdom));
            Log.d("Saved Wisdom", String.valueOf(character.getBaseAbilityScores().get(Wisdom)));

            jsonObject.put("charisma", character.getBaseAbilityScores().get(Charisma));
            Log.d("Saved Charisma", String.valueOf(character.getBaseAbilityScores().get(Charisma)));

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

            for(int i = 0; i < character.Notes.size(); i++){
                if(!character.Notes.get(i).isEmpty()){
                    jsonObject.put("note" + i, character.Notes.get(i));
                    Log.d("Saved Note #" + i, character.Notes.get(i));
                }
            }
            jsonObject.put("note_count", character.Notes.size());
            Log.d("Saved Note Count", String.valueOf(character.Notes.size()));

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

    /** @noinspection unchecked*/
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

            character.setCurrentHealth(jsonObject.optInt("current_health", 1));
            Log.d("Loaded Current Health", String.valueOf(jsonObject.optInt("current_health", 1)));
            character.setMaxHealth(jsonObject.optInt("max_health", 1));
            Log.d("Loaded Max Health", String.valueOf(jsonObject.optInt("max_health", 1)));

            character.setRace(Races.get(jsonObject.optString("race", "")));
            Log.d("Loaded Race", jsonObject.optString("race", ""));
            Log.d("Does it exist?", String.valueOf(Races.containsKey(jsonObject.optString("race", ""))));
            Log.d("Current Race", character.getRace().getName());

            if(character.getRace().hasSubraces()){
                character.setSubrace(Subraces.get(jsonObject.optString("subrace", "")));
                Log.d("Loaded Subrace", jsonObject.optString("subrace", ""));
            }

            int classCount = jsonObject.optInt("class_count", 1);
            for(int i = 0; i < classCount; i++){
                JSONObject Class = jsonObject.getJSONArray("classes").getJSONObject(i);
                character.getPlayerClasses().set(i ,Classes.get(Class.getString("name")));
                Log.d("Loaded Player Class #" + i, Class.getString("name"));
                Log.d("Current Player Class #" + i, character.getPlayerClasses().get(i).getName());
                character.getPlayerClasses().get(i).setLevel(Class.getInt("level"));
                Log.d("Loaded Player Class #" + i + " Level", String.valueOf(Class.getInt("level")));
                Log.d("Current Player Class #" + i + " Level", String.valueOf(character.getPlayerClasses().get(i).getLevel()));
                if(character.getPlayerClasses().get(i).HasSubclasses()) {
                    character.getPlayerClasses().get(i).setSubclass(Subclasses.get(Class.getString("subclass")));
                    Log.d("Loaded Player Class #" + i + " Subclass", Class.getString("subclass"));
                    Log.d("Current Player Class #" + i + " Subclass", character.getPlayerClasses().get(i).getSubclass().getName());
                }
            }

            character.getBaseAbilityScores().put(Strength, jsonObject.optInt("strength", 0));
            Log.d("Loaded Strength", String.valueOf((jsonObject.optInt("strength", 0))));

            character.getBaseAbilityScores().put(Dexterity, jsonObject.optInt("dexterity", 0));
            Log.d("Loaded Dexterity", String.valueOf((jsonObject.optInt("dexterity", 0))));

            character.getBaseAbilityScores().put(Constitution, jsonObject.optInt("constitution", 0));
            Log.d("Loaded Constitution", String.valueOf((jsonObject.optInt("constitution", 0))));

            character.getBaseAbilityScores().put(Intelligence, jsonObject.optInt("intelligence", 0));
            Log.d("Loaded Intelligence", String.valueOf((jsonObject.optInt("intelligence", 0))));

            character.getBaseAbilityScores().put(Wisdom, jsonObject.optInt("wisdom", 0));
            Log.d("Loaded Wisdom", String.valueOf((jsonObject.optInt("wisdom", 0))));

            character.getBaseAbilityScores().put(Charisma, jsonObject.optInt("charisma", 0));
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

            for(int i = 0; i < jsonObject.optInt("note_count", 0); i++){
                character.Notes.add(jsonObject.optString("note" + i, ""));
                Log.d("Note #" + i, character.Notes.get(i));
            }

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
                            Races.get(RaceName).addSubrace(Subraces.get(jsonObject.getString("name")));
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
//                    Log.d("Selectable Features", String.valueOf(jsonObject.getJSONArray("selectableFeatures").length()));
//                    Log.d("Class Features", jsonObject.getJSONArray("selectableFeatures").getJSONObject(0).getJSONArray("availableFeatures").getJSONObject(0).getJSONObject("feat").getString("name"));
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
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Spell.");
            throw new RuntimeException(e);
        }
    }

//    public static void assignFeatures(Context context){
//        Log.d("Jason", "He was just born in Assigning.");
//        String dir = "dndclasses";
//        AM = context.getAssets();
//        try {
//            String[] fileNames = AM.list(dir);
//            if (fileNames != null) {
//                int j = 0;
//                for (String fileName : fileNames) {
//                    String fullPath = dir + "/" + fileName;
//                    InputStream inputStream = AM.open(fullPath);
//                    int size = inputStream.available();
//                    byte[] buffer = new byte[size];
//                    inputStream.read(buffer);
//                    inputStream.close();
//                    String jsonString = new String(buffer, StandardCharsets.UTF_8);
//                    JSONObject jsonObject = new JSONObject(jsonString);
//                }
//            }
//        }
//        catch (Exception e){
//            Log.d("Jason?", "Shot dead in Assigning.");
//            throw new RuntimeException(e);
//        }
//    }

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
            Log.d("Jason?", "Shot dead in Background.");
            throw new RuntimeException(e);
        }
    }

    public static void parseBackgrounds(Context context, String dir) {
        Log.d("Jason", "He was just born in Background.");
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
                    String materialCost = "";
                    Backgrounds.put(jsonObject.getString("name"), new Background(
                            jsonObject.getString("name"),
                            jsonObject.getInt("goldPieces")
                    ));
                    Log.d("Background #" + i, jsonObject.getString("name"));
                    i++;
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Background.");
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
                            jsonObject.optDouble("value", 0),
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

    public static void parseWeapons(Context context, String dir) {
        Log.d("Jason", "He was just born in Weapon.");
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
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Weapon.");
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
