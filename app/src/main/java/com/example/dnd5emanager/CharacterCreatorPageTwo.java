package com.example.dnd5emanager;

import static com.example.dnd5emanager.CharacterCreatorPageOne.NewCharacter;
import static com.example.dnd5emanager.DataClasses.Constants.*;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.databinding.CharacterCreatorPageTwoBinding;

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
        binding.characterCreatorPageTwoBackButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterCreatorPageTwo.this).navigate(R.id.goToCharacterCreatorPageOne);
        });
        binding.toCharacterView.setOnClickListener(v -> {
            TextView Personality = view.findViewById(R.id.character_creator_page_two_personality);
            TextView Ideals = view.findViewById(R.id.character_creator_page_two_ideals);
            TextView Bonds = view.findViewById(R.id.character_creator_page_two_bonds);
            TextView Flaws = view.findViewById(R.id.character_creator_page_two_flaws);
            TextView About = view.findViewById(R.id.character_creator_page_two_about);
            Spinner Background = view.findViewById(R.id.character_creator_page_two_background);
            Spinner Alignment = view.findViewById(R.id.character_creator_page_two_alignment);

            NewCharacter.setPersonality(Personality.getText().toString());
            NewCharacter.setIdeals(Ideals.getText().toString());
            NewCharacter.setBonds(Bonds.getText().toString());
            NewCharacter.setFlaws(Flaws.getText().toString());
            NewCharacter.setAbout(About.getText().toString());
//            NewCharacter.setBackground(Background.getSelectedItem().toString());
//            NewCharacter.setAlignment(Alignment.getSelectedItem().toString());

            CurrentCharacter = NewCharacter;

            NavHostFragment.findNavController(CharacterCreatorPageTwo.this).navigate(R.id.goToCharacterView);
        });

        super.onViewCreated(view, savedInstanceState);

    }


    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}