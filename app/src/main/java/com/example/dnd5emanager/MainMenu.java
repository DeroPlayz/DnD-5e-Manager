package com.example.dnd5emanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.CharacterClass;
import com.example.dnd5emanager.DataClasses.Constants;
import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.DataClasses.Race;
import com.example.dnd5emanager.databinding.MainMenuBinding;

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

        binding.buttonFirst.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenu.this)
                        .navigate(R.id.goToCharacterList)
        );
        binding.buttonFourth.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenu.this)
                        .navigate(R.id.goToData)
        );
    }

    public static final PlayerCharacter Matthew = new PlayerCharacter("Matthew", 15, 15, 15, 15, 15, 15, new Race(), Constants.Fighter, 1);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}