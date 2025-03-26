package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.*;
import static com.example.dnd5emanager.MainMenu.CurrentCharacter;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.CharacterCreatorPageTwoBinding;

import java.util.ArrayList;

public class CharacterCreatorPageTwo extends Fragment {

    private CharacterCreatorPageTwoBinding binding;
    private EditText Bonds;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = CharacterCreatorPageTwoBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Log.d("New Guy:", CharacterCreatorPageOne.NewCharacter.getPrimaryClass().getName());
        binding.characterCreatorPageTwoBackButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterCreatorPageTwo.this).navigate(R.id.goToCharacterCreatorPageOne);
        });
        binding.tocharacterview.setOnClickListener(v -> {
            TextView Personality = view.findViewById(R.id.character_creator_page_two_personality);
            TextView Ideals = view.findViewById(R.id.character_creator_page_two_ideals);
            TextView Bonds = view.findViewById(R.id.character_creator_page_two_bonds);
            TextView Flaws = view.findViewById(R.id.character_creator_page_two_flaws);
            TextView About = view.findViewById(R.id.character_creator_page_two_about);
            Spinner Background = view.findViewById(R.id.character_creator_page_two_background);
            Spinner Alignment = view.findViewById(R.id.character_creator_page_two_alignment);
            CurrentCharacter.setPersonality(Personality.getText().toString());
            CurrentCharacter.setIdeals(Ideals.getText().toString());
            CurrentCharacter.setBonds(Bonds.getText().toString());
            CurrentCharacter.setFlaws(Flaws.getText().toString());
            CurrentCharacter.setAbout(About.getText().toString());
            CurrentCharacter.setBackground(Background.getSelectedItem().toString());
            CurrentCharacter.setAlignment(Alignment.getSelectedItem().toString());

            NavHostFragment.findNavController(CharacterCreatorPageTwo.this).navigate(R.id.goToCharacterView);
        });

        super.onViewCreated(view, savedInstanceState);

    }


    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}