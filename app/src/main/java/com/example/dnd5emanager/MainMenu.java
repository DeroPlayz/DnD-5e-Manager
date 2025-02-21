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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}