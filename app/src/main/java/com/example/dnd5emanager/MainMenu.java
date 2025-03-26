package com.example.dnd5emanager;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.Background;
import com.example.dnd5emanager.DataClasses.CharacterClass;
import com.example.dnd5emanager.DataClasses.Feature;
import com.example.dnd5emanager.DataClasses.Item;
import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.DataClasses.Armor;
import com.example.dnd5emanager.DataClasses.Race;
import com.example.dnd5emanager.DataClasses.Spell;
import com.example.dnd5emanager.DataClasses.Subrace;
import com.example.dnd5emanager.databinding.MainMenuBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainMenu extends Fragment {
    public static PlayerCharacter CurrentCharacter = new PlayerCharacter();
    public static Map<String, PlayerCharacter> Characters = new HashMap<>();
    public static Map<String, Race> Races = new HashMap<>();
    public static Map<String, Subrace> Subraces = new HashMap<>();
//    public static Map<String, Monster> Monsters = new HashMap<>();

    public static Map<String, CharacterClass> Classes = new HashMap<>();
    //    public static Map<String, Subclass> Subclasses = new HashMap<>();
    public static Map<String, Spell> Spells = new HashMap<>();

    public static Map<String, Background> Backgrounds = new HashMap<>();
    public static Map<String, Feature> Features = new HashMap<>();
//    public static Map<String, Feat> Feats = new HashMap<>();

    public static Map<String, Item> Items = new HashMap<>();
//    public static Map<String, Weapon> Weapons = new HashMap<>();
    public static Map<String, Armor> Armor = new HashMap<>();

    private MainMenuBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = MainMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.mainMenuViewCharacters.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenu.this).navigate(R.id.goToCharacterList)
        );
        binding.mainMenuViewData.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenu.this).navigate(R.id.goToData)
        );
        binding.mainMenuSettings.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenu.this).navigate(R.id.goToSettings)
        );
        binding.mainMenuHelpPage.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenu.this).navigate(R.id.goToHelp)
        );
        binding.mainMenuViewDMMenu.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenu.this).navigate(R.id.goToDMManager)
        );

        parseRaces(requireContext(), "races");
        parseSubraces(requireContext(), "subraces");
        parseClasses(requireContext(), "dndclasses");
        parseSpells(requireContext(), "spells");
        parseFeatures(requireContext(), "features");
        parseItems(requireContext(), "items");
        parseArmor(requireContext(), "armor");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void parseRaces(Context context, String dir) {
        //Log.d("Jason", "He was just born.");
        AssetManager AM = context.getAssets();
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
                    Log.d("Race Name", jsonObject.getString("name"));
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "He's dead.");
            throw new RuntimeException(e);
        }
    }

    public void parseSubraces(Context context, String dir) {
        //Log.d("Jason", "He was just born.");
        AssetManager AM = context.getAssets();
        try {
            String[] folderNames = AM.list(dir);
            if (folderNames != null) {
                for (String folderName : folderNames) {
                    String parentPath = dir + "/" + folderName;
                    String[] fileNames = AM.list(dir + "/" + folderName);
                    if(fileNames != null){
                        for(String fileName : fileNames){
                            String fullPath = parentPath + "/" + fileName;
//                            Log.d("Path", parentPath);
                            InputStream inputStream = AM.open(fullPath);
                            int size = inputStream.available();
                            byte[] buffer = new byte[size];
                            inputStream.read(buffer);
                            inputStream.close();
                            String jsonString = new String(buffer, StandardCharsets.UTF_8);
                            JSONObject jsonObject = new JSONObject(jsonString);
                            Subrace TempSub = new Subrace(
                                    jsonObject.getString("name"),
//                                    Log.d("name", jsonObject.getString("name"));
                                    jsonObject.getInt("ac"),
//                                    Log.d("ac", String.valueOf(jsonObject.getInt("ac")));
                                    jsonObject.getJSONObject("speed").getInt("normal"),
//                                    Log.d("speed: normal", String.valueOf(jsonObject.getJSONObject("speed").getInt("normal")));
                                    jsonObject.getJSONObject("speed").getInt("fly"),
//                                    Log.d("speed: fly", String.valueOf(jsonObject.getJSONObject("speed").getInt("fly")));
                                    jsonObject.getJSONObject("speed").getInt("climb"),
//                                    Log.d("speed: climb", String.valueOf(jsonObject.getJSONObject("speed").getInt("climb")));
                                    jsonObject.getJSONObject("speed").getInt("swim"),
//                                    Log.d("speed: swim", String.valueOf(jsonObject.getJSONObject("speed").getInt("swim")));
                                    jsonObject.getJSONObject("speed").getInt("burrow"),
//                                    Log.d("speed: burrow", String.valueOf(jsonObject.getJSONObject("speed").getInt("burrow")));
                                    jsonObject.getJSONObject("abilityScores").getInt("str"),
//                                    Log.d("abilityScores: str", String.valueOf(jsonObject.getJSONObject("abilityScores").getInt("str")));
                                    jsonObject.getJSONObject("abilityScores").getInt("dex"),
//                                    Log.d("abilityScores: dex", String.valueOf(jsonObject.getJSONObject("abilityScores").getInt("dex")));
                                    jsonObject.getJSONObject("abilityScores").getInt("con"),
//                                    Log.d("abilityScores: con", String.valueOf(jsonObject.getJSONObject("abilityScores").getInt("con")));
                                    jsonObject.getJSONObject("abilityScores").getInt("intelligence"),
//                                    Log.d("abilityScores: intelligence", String.valueOf(jsonObject.getJSONObject("abilityScores").getInt("intelligence")));
                                    jsonObject.getJSONObject("abilityScores").getInt("wis"),
//                                    Log.d("abilityScores: wis", String.valueOf(jsonObject.getJSONObject("abilityScores").getInt("wis")));
                                    jsonObject.getJSONObject("abilityScores").getInt("cha")
//                                    Log.d("abilityScore: cha", String.valueOf(jsonObject.getJSONObject("abilityScores").getInt("cha")));
                            );
                            Subraces.put(jsonObject.getString("name"), TempSub);
                            String RaceName = folderName.replace("_Subraces", "");
                            RaceName = RaceName.replace("_", " ");
                            Log.d("Current Race Name", RaceName);
                            Log.d("Current Race Null", String.valueOf(Races.get(RaceName) == null) );
                            Log.d("Current Subrace Name", Subraces.keySet().toArray(new String[0])[Subraces.size() - 1]);
                            Log.d("Current Subrace Null", String.valueOf(Subraces.keySet().toArray(new String[0])[Subraces.size() - 1] == null));
                            Log.d("", "");
                            Races.get(RaceName).addSubrace(Subraces.get(TempSub.getName()));
                        }
                    }
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "He's dead.");
            throw new RuntimeException(e);
        }
    }

    public void parseClasses(Context context, String dir) {
        //Log.d("Jason", "He was just born.");
        AssetManager AM = context.getAssets();
        try {
            String[] fileNames = AM.list(dir);
            if (fileNames != null) {
                for (String fileName : fileNames) {
                    String fullPath = dir + "/" + fileName;
                    Log.d("Input Stream", fullPath);
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
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "He's dead.");
            throw new RuntimeException(e);
        }
    }

    public void parseSpells(Context context, String dir) {
        //Log.d("Jason", "He was just born.");
        AssetManager AM = context.getAssets();
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
            Log.d("Jason?", "He's dead.");
            throw new RuntimeException(e);
        }
    }

    public void parseFeatures(Context context, String dir) {
        //Log.d("Jason", "He was just born.");
        AssetManager AM = context.getAssets();
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
            Log.d("Jason?", "He's dead.");
            throw new RuntimeException(e);
        }
    }

    public void parseItems(Context context, String dir) {
        //Log.d("Jason", "He was just born.");
        AssetManager AM = context.getAssets();
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
            Log.d("Jason?", "He's dead.");
            throw new RuntimeException(e);
        }
    }

    public void parseArmor(Context context, String dir) {
        //Log.d("Jason", "He was just born.");
        AssetManager AM = context.getAssets();
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
            Log.d("Jason?", "He's dead.");
            throw new RuntimeException(e);
        }
    }

    private String[] toStringArray(JSONArray array) {
        if(array==null)
            return null;
        String[] arr = new String[array.length()];
        for(int i=0; i<arr.length; i++) {
            arr[i]=array.optString(i);
        }
        return arr;
    }

    private Armor[] toArmorArray(JSONArray array) throws JSONException {
        if(array==null)
            return null;
        Armor[] arr = new Armor[array.length()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Armor.get(array.optString(i));
        }
        return arr;
    }
}