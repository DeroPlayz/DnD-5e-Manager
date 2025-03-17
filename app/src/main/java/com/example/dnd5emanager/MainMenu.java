package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.*;

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
import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.DataClasses.Race;
import com.example.dnd5emanager.DataClasses.Spell;
import com.example.dnd5emanager.databinding.MainMenuBinding;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
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
        Button mainMenuViewCharacters = view.findViewById(R.id.main_menu_view_characters);
        mainMenuViewCharacters.setTextSize(45);
        Button mainMenuViewDMMenu = view.findViewById(R.id.main_menu_view_d_m_menu);
        mainMenuViewDMMenu.setTextSize(45);
        Button mainMenuViewData = view.findViewById(R.id.main_menu_view_data);
        mainMenuViewData.setTextSize(45);
        Button mainMenuSettings = view.findViewById(R.id.main_menu_settings);
        mainMenuSettings.setTextSize(45);
        Button mainMenuHelpPage = view.findViewById(R.id.main_menu_help_page);
        mainMenuHelpPage.setTextSize(45);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.d("Race Count", String.valueOf(Files.exists(Paths.get("assets/races"))));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void parseJson(File jsonFile){
        ObjectMapper mapper = new ObjectMapper();
        var data = mapper.readValue(jsonFile, java.util.Map.class);
        
    }
//    public int countFiles(String directoryPath) {
//        AssetManager AM = requireContext().getAssets();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            AM.list("assets")
//        }
//    }
}