package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.*;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.DataClasses.Race;
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

    public static final ArrayList<Race> RacesInit = new ArrayList<Race>(List.of(Aarakocra,
        Aasimar, Bugbear, Catfolk, Centaur, Changeling, Dragonborn, Dwarf, Elf, Firbolg, Genasi,
        Gith, Gnome, Goblin, Goliath, HalfElf, HalfHag, HalfOrc, Halfling, Hobgoblin, Human,
        HumanRevenant, Kalashtar, Kenku, Kobold, Leonin, Lizardfolk, Loxodon, MarkOfDetectionHalfElf,
        MarkOfFindingHalfOrc, MarkOfHandlingHuman, MarkOfMakingHuman, MarkOfPassageHuman,
        MarkOfSentinelHuman, MarkOfStormHalfElf, MindFlayer, Minotaur, Orc, Satyr, Shifter, Tabaxi,
        Tiefling, Tortle, Triton, Vampire, VariantHuman, Vedalken, Viashino, Warforged, Wolfborn,
        YuanTiPureblood
    ));
    public static ArrayList<Race> Races = RacesInit;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}