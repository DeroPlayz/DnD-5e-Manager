package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Armor.initializeArmor;
import static com.example.dnd5emanager.DataClasses.CharacterClass.initializeClasses;
import static com.example.dnd5emanager.DataClasses.Constants.Armor;
import static com.example.dnd5emanager.DataClasses.Constants.Characters;
import static com.example.dnd5emanager.DataClasses.Constants.Charisma;
import static com.example.dnd5emanager.DataClasses.Constants.Classes;
import static com.example.dnd5emanager.DataClasses.Constants.Constitution;
import static com.example.dnd5emanager.DataClasses.Constants.Dexterity;
import static com.example.dnd5emanager.DataClasses.Constants.Intelligence;
import static com.example.dnd5emanager.DataClasses.Constants.Races;
import static com.example.dnd5emanager.DataClasses.Constants.Strength;
import static com.example.dnd5emanager.DataClasses.Constants.Subclasses;
import static com.example.dnd5emanager.DataClasses.Constants.Subraces;
import static com.example.dnd5emanager.DataClasses.Constants.Wisdom;
import static com.example.dnd5emanager.DataClasses.Feat.initializeFeats;
import static com.example.dnd5emanager.DataClasses.Feature.initializeFeatures;
import static com.example.dnd5emanager.DataClasses.Item.initializeItems;
import static com.example.dnd5emanager.DataClasses.Race.initializeRaces;
import static com.example.dnd5emanager.DataClasses.Spell.initializeSpells;
import static com.example.dnd5emanager.DataClasses.Weapon.initializeWeapons;

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
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Methods {

    public static void Initialize(Context c){
        initializeRaces(c);
        initializeClasses(c);

        initializeItems(c);
        initializeWeapons(c);
        initializeArmor(c);

        initializeSpells(c);
        initializeFeatures(c);
        initializeFeats(c);

        LoadFromInternalStorage(c);
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
            for(int i = 0; i < character.getClasses().size(); i++){
                CharacterClass currentClass = character.getClasses().get(i);
                JSONObject Class = new JSONObject();
                Class.put("name", currentClass.getName());
                Log.d("Saved Player Class #" + i + " Name", character.getClasses().get(i).getName());
                Class.put("level", currentClass.getLevel());
                Log.d("Saved Player Class #" + i + " Level", String.valueOf(character.getClasses().get(i).getLevel()));
                if(currentClass.HasSubclasses()){
                    Class.put("subclass", currentClass.getSubclass().getName());
                    Log.d("Saved Player Class #" + i + " Subclass", character.getClasses().get(i).getSubclass().getName());
                }
//                Class.put("hit_die", currentClass.getHitDie());
                Classes.put(Class);
                Log.d("Saved Player Class #" + i, character.getClasses().get(i).getName());
            }
            jsonObject.put("classes", Classes);
            Log.d("Saved Player Classes", "Saved all " + character.getClasses().size() + " of them.");


            jsonObject.put("class_count", character.getClasses().size());
            Log.d("Saved Player Class Count", String.valueOf(character.getClasses().size()));

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

            for(int i = 0; i < character.Notes.size() - 1; i++){
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
                character.getClasses().set(i ,Classes.get(Class.getString("name")));
                Log.d("Loaded Player Class #" + i, Class.getString("name"));
                Log.d("Current Player Class #" + i, character.getClasses().get(i).getName());
                character.getClasses().get(i).setLevel(Class.getInt("level"));
                Log.d("Loaded Player Class #" + i + " Level", String.valueOf(Class.getInt("level")));
                Log.d("Current Player Class #" + i + " Level", String.valueOf(character.getClasses().get(i).getLevel()));
                if(character.getClasses().get(i).HasSubclasses()) {
                    character.getClasses().get(i).setSubclass(Subclasses.get(Class.getString("subclass")));
                    Log.d("Loaded Player Class #" + i + " Subclass", Class.getString("subclass"));
                    Log.d("Current Player Class #" + i + " Subclass", character.getClasses().get(i).getSubclass().getName());
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

//            for(int i = 0; i < jsonObject.optInt("note_count", 0) - 1; i++){
//                if(!jsonObject.optString("note" + i, "").isEmpty()){
//                    character.Notes.add(jsonObject.optString("note" + i, ""));
//                    Log.d("Note #" + i, character.Notes.get(i));
//                }
//            }

            Log.d("LoadCharacter", "Character loaded from: " + file.getAbsolutePath());
            return character;
        } catch (JSONException | IOException e) {
            Log.e("LoadCharacter", "Error loading character", e);
            return null; // Or handle the error as appropriate for your app
        }
    }

    public static String[] toStringArray(JSONArray array) {
        if(array==null)
            return null;
        String[] arr = new String[array.length()];
        for(int i=0; i<arr.length; i++) {
            arr[i]=array.optString(i);
        }
        return arr;
    }

    public static Armor[] toArmorArray(JSONArray array) throws JSONException {
        if (array == null)
            return null;
        Armor[] arr = new Armor[array.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Armor.get(array.optString(i));
        }
        return arr;
    }
}
