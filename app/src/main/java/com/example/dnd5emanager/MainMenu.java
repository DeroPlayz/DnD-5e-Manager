package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.*;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import java.io.File;
import com.example.dnd5emanager.DataClasses.Background;
import com.example.dnd5emanager.DataClasses.Constants;
import com.example.dnd5emanager.DataClasses.Feature;
import com.example.dnd5emanager.DataClasses.Item;
import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.DataClasses.Armor;
import com.example.dnd5emanager.DataClasses.Race;
import com.example.dnd5emanager.DataClasses.Spell;
import com.example.dnd5emanager.databinding.MainMenuBinding;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class MainMenu extends Fragment {
    public static PlayerCharacter CurrentCharacter = new PlayerCharacter();
    public static ArrayList<PlayerCharacter> Characters = new ArrayList<PlayerCharacter>();
    public static ArrayList<Race> Races = new ArrayList<Race>();
//    public static ArrayList<Subrace> Subraces = new ArrayList<Subrace>();
//    public static ArrayList<Monster> Monsters = new ArrayList<Monster>();

    public static ArrayList<String> Classes = new ArrayList<String>();
    //    public static ArrayList<Subclass> Subclasses = new ArrayList<Subclass>();
    public static ArrayList<Spell> Spells = new ArrayList<Spell>();

    public static ArrayList<Background> Backgrounds = new ArrayList<Background>();
    public static ArrayList<Feature> Features = new ArrayList<Feature>();
//    public static ArrayList<Feat> Feats = new ArrayList<Feat>();

    public static ArrayList<Item> Items = new ArrayList<Item>();
//    public static ArrayList<Weapon> Weapons = new ArrayList<Weapon>();
    public static ArrayList<Armor> Armor = new ArrayList<Armor>();

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
                    boolean hasSubraces = false;

                    Races.add(new Race(
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
                        jsonObject.getJSONObject("abilityScores").getInt("cha"),
                        hasSubraces
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

                    Spells.add(new Spell(
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

                    Features.add(new Feature(
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
                    Items.add(new Item(
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
                    JSONObject jsonObject = new JSONObject(jsonString);
                    Armor.add(new Armor(
                            jsonObject.getString("name"),
                            jsonObject.getString("category"),
                            jsonObject.getInt("cost"),
                            jsonObject.getString("description"),
                            jsonObject.getBoolean("isAttuned"),
                            jsonObject.getBoolean("isCustom"),
                            jsonObject.getBoolean("isProficient"),
                            jsonObject.getInt("maxModifierBonus"),
                            jsonObject.getString("modifierFormatted"),
                            jsonObject.getBoolean("stealthDisadvantage"),
                            jsonObject.getInt("weight")
                    ));
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
                    InputStream inputStream = AM.open(fullPath);
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    inputStream.close();
                    String jsonString = new String(buffer, StandardCharsets.UTF_8);
                    JSONObject jsonObject = new JSONObject(jsonString);
                    Armor.add(new Armor(
                            jsonObject.getString("name"),
                            jsonObject.getString("category"),
                            jsonObject.getInt("cost"),
                            jsonObject.getString("description"),
                            jsonObject.getBoolean("isAttuned"),
                            jsonObject.getBoolean("isCustom"),
                            jsonObject.getBoolean("isProficient"),
                            jsonObject.getInt("maxModifierBonus"),
                            jsonObject.getString("modifierFormatted"),
                            jsonObject.getBoolean("stealthDisadvantage"),
                            jsonObject.getInt("weight")
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
        String[] arr=new String[array.length()];
        for(int i=0; i<arr.length; i++) {
            arr[i]=array.optString(i);
        }
        return arr;
    }
}