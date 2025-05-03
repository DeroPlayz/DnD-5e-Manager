package com.example.dnd5emanager;

import static com.example.dnd5emanager.CharacterCreatorPageOne.NewCharacter;
import static com.example.dnd5emanager.DataClasses.Constants.Backgrounds;
import static com.example.dnd5emanager.DataClasses.Constants.CurrentCharacter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.Background;
import com.example.dnd5emanager.databinding.CharacterCreatorPageTwoBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class CharacterCreatorPageTwo extends Fragment {
    private TextView Personality;
    private TextView Ideals;
    private TextView Bonds;
    private TextView Flaws;
    private TextView About;
    private Spinner Background;
    private Spinner Alignment;

    private CharacterCreatorPageTwoBinding binding;
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = CharacterCreatorPageTwoBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Personality = view.findViewById(R.id.character_creator_page_two_personality);
        Ideals = view.findViewById(R.id.character_creator_page_two_ideals);
        Bonds = view.findViewById(R.id.character_creator_page_two_bonds);
        Flaws = view.findViewById(R.id.character_creator_page_two_flaws);
        About = view.findViewById(R.id.character_creator_page_two_about);
        Background = view.findViewById(R.id.character_creator_page_two_background);
        Alignment = view.findViewById(R.id.character_creator_page_two_alignment);

        loadBackgrounds();
        loadAlignments();

        binding.characterCreatorPageTwoBackButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterCreatorPageTwo.this).navigate(R.id.goToCharacterCreatorPageOne);
        });

        binding.toCharacterView.setOnClickListener(v -> {
            if(Personality.getText() != null){
                NewCharacter.setPersonality(Personality.getText().toString());
            }

            if(Ideals.getText() != null){
                NewCharacter.setIdeals(Ideals.getText().toString());
            }

            if(Bonds.getText() != null){
                NewCharacter.setBonds(Bonds.getText().toString());
            }

            if(Flaws.getText() != null){
                NewCharacter.setFlaws(Flaws.getText().toString());
            }

            if(About.getText() != null){
                NewCharacter.setAbout(About.getText().toString());
            }

            if(Background.getSelectedItem() != null){
                NewCharacter.setBackground(Background.getSelectedItem().toString());
            }

            if(Alignment.getSelectedItem() != null){
                NewCharacter.setAlignment(Alignment.getSelectedItem().toString());
            }

            CurrentCharacter = NewCharacter;

            NavHostFragment.findNavController(CharacterCreatorPageTwo.this).navigate(R.id.goToCharacterView);
        });

        super.onViewCreated(view, savedInstanceState);

    }

    public void loadBackgrounds(){
        ArrayList<Background> BackgroundAL = new ArrayList<Background>(Arrays.asList(Backgrounds.values().toArray(new Background[0])));
        String[] BackgroundNames = new String[BackgroundAL.size()];
        for(int i = 0; i < BackgroundNames.length; i++){
            BackgroundNames[i] = BackgroundAL.get(i).getName();
        }
        Arrays.sort(BackgroundNames);
        ArrayAdapter<String> BackgroundAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, BackgroundNames);
        BackgroundAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Background.setAdapter(BackgroundAdapter);
    }

    public void loadAlignments(){
        String[] Alignments = {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
        ArrayAdapter<String> AlignmentAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, Alignments);
        AlignmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Alignment.setAdapter(AlignmentAdapter);
    }

    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}