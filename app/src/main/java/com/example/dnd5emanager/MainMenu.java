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
import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.DataClasses.Race;
import com.example.dnd5emanager.DataClasses.Spell;
import com.example.dnd5emanager.databinding.MainMenuBinding;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class MainMenu extends Fragment {

    public static AssetManager AM;
    public static ArrayList<PlayerCharacter> Characters = new ArrayList<PlayerCharacter>();
    public static ArrayList<Race> Races = new ArrayList<Race>();
//    public static ArrayList<Subrace> Subraces = new ArrayList<Subrace>();
//    public static ArrayList<Monster> Monsters = new ArrayList<Monster>();

    public static ArrayList<String> Classes = new ArrayList<String>();
//    public static ArrayList<Subclass> Subclasses = new ArrayList<Subclass>();
    public static ArrayList<Spell> Spells = new ArrayList<Spell>();

//    public static ArrayList<Background> Backgrounds = new ArrayList<Background>();
//    public static ArrayList<Feat> Feats = new ArrayList<Feat>();

//    public static ArrayList<Item> Items = new ArrayList<Item>();

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

        parseJson(requireContext(), "races");
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            Log.d("Race Count", String.valueOf(Files.exists(Paths.get("assets/races"))));
//        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void parseJson(Context context, String dir) {
        Log.d("Jason", "He was just born.");
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
                    RealRaces.add(new Race(
                        (String) jsonObject.getString("name"),
                        (int) jsonObject.get("ac"),
                        (int) jsonObject.getJSONArray("speed").getString(0);
                        (int) jsonObject.get("speed").get("normal"),
                        (int) jsonObject.get("speed").get("fly"),
                        (int) jsonObject.get("speed").get("climb"),
                        (int) jsonObject.get("speed").get("swim"),
                        (int) jsonObject.get("speed").get("burrow"),
                        (int) jsonObject.get("abilityScores").get("str"),
                        (int) jsonObject.get("abilityScores").get("dex"),
                        (int) jsonObject.get("abilityScores").get("con"),
                        (int) jsonObject.get("abilityScores").get("intelligence"),
                        (int) jsonObject.get("abilityScores").get("wis"),
                        (int) jsonObject.get("abilityScores").get("cha"),
                    ));
                }
            }
            else{
                Log.d("Jason?", "He's dead.");
            }
        } catch (IOException | JSONException e) {
            Log.d("Jason?", "He's dead.");
            throw new RuntimeException(e);
        }
    }

//    public void processJSONObject(JSONObject jsonObject, String filename) throws JSONException{
//        String name = jsonObject.getString("name");
//        int ac = jsonObject.getInt("ac");
//
//    }

//    public int countFiles(String directoryPath) {
//        AssetManager AM = requireContext().getAssets();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            AM.list("assets")
//        }
//    }
}