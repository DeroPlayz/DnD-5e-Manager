package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.*;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
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

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}