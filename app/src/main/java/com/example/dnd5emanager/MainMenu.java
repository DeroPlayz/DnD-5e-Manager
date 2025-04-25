package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Methods.Initialize;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.example.dnd5emanager.GlobalVariables.hasInitialized;

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
import com.google.android.material.snackbar.Snackbar;

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
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class MainMenu extends Fragment{

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
        if(!hasInitialized){
            Initialize(requireContext());
            hasInitialized = true;
        }

        binding.mainMenuViewCharacters.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenu.this).navigate(R.id.goToCharacterList)
        );
        binding.mainMenuViewDMMenu.setOnClickListener(v -> {
            Snackbar snackbar = Snackbar.make(v, "DM Manager is still under development.", Snackbar.LENGTH_LONG);
            snackbar.show();
//                NavHostFragment.findNavController(MainMenu.this).navigate(R.id.goToDMManager)
        });
        binding.mainMenuViewData.setOnClickListener(v ->{
            Snackbar snackbar = Snackbar.make(v, "Compendium is still under development.", Snackbar.LENGTH_LONG);
            snackbar.show();
//                NavHostFragment.findNavController(MainMenu.this).navigate(R.id.goToData)
        });

        binding.mainMenuSettings.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenu.this).navigate(R.id.goToSettings)
        );
        binding.mainMenuHelpPage.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenu.this).navigate(R.id.goToHelp)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}