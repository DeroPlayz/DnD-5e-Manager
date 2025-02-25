package com.example.dnd5emanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.MainMenuBinding;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Fragment {

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
    }

    public static ArrayList<PlayerCharacter> Characters = new ArrayList<PlayerCharacter>(List.of(new PlayerCharacter()));

    public static final ArrayList<String> RacesInit = new ArrayList<String>(List.of("Aarakocra", "Aasimar",
            "Bugbear", "Catfolk", "Centaur", "Changeling", "Dragonborn", "Dwarf", "Elf", "Firbolg",
            "Genasi", "Gith", "Gnome", "Goblin", "Goliath", "Half-Elf", "Half-Hag", "Half-Orc",
            "Halfling", "Hobgoblin", "Human", "Human Revenant", "Kalashtar", "Kenku", "Kobold",
            "Leonin", "Lizardfolk", "Loxodon", "Mark of Detection Half-Elf", "Mark of Finding Half-Orc",
            "Mark of Handling Human", "Mark of Making Human", "Mark of Passage Human",
            "Mark of Sentinel Human", "Mark of Storm Half-Elf", "Mindflayer", "Minotaur", "Orc",
            "Satyr", "Shifter", "Tabaxi", "Tiefling", "Tortle", "Triton", "Vampire", "Variant Human",
            "Vedalken", "Viashino", "Warforged", "Wolfborn", "Yuan-Ti Pureblood"
    ));
    public static ArrayList<String> Races = new ArrayList<String>(List.of("Aarakocra", "Aasimar",
            "Bugbear", "Catfolk", "Centaur", "Changeling", "Dragonborn", "Dwarf", "Elf", "Firbolg",
            "Genasi", "Gith", "Gnome", "Goblin", "Goliath", "Half-Elf", "Half-Hag", "Half-Orc",
            "Halfling", "Hobgoblin", "Human", "Human Revenant", "Kalashtar", "Kenku", "Kobold",
            "Leonin", "Lizardfolk", "Loxodon", "Mark of Detection Half-Elf", "Mark of Finding Half-Orc",
            "Mark of Handling Human", "Mark of Making Human", "Mark of Passage Human",
            "Mark of Sentinel Human", "Mark of Storm Half-Elf", "Mindflayer", "Minotaur", "Orc",
            "Satyr", "Shifter", "Tabaxi", "Tiefling", "Tortle", "Triton", "Vampire", "Variant Human",
            "Vedalken", "Viashino", "Warforged", "Wolfborn", "Yuan-Ti Pureblood"
    ));

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}