package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.Characters;
import static com.example.dnd5emanager.DataClasses.Constants.CurrentCharacter;
import static com.example.dnd5emanager.DataClasses.Methods.LoadFromInternalStorage;

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

import com.example.dnd5emanager.databinding.CharacterListBinding;

public class CharacterList extends Fragment {

    private CharacterListBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CharacterListBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.characterListBackButton.setOnClickListener(v ->
                NavHostFragment.findNavController(CharacterList.this)
                        .navigate(R.id.goToMainMenu)
        );
        //Finds the TextView element for the character name textbox.
        TextView CharacterName = view.findViewById(R.id.characterName);
        //Sets the textbox's value to the in-progress character's name.
        if(CurrentCharacter != null && CharacterName != null){
            CharacterName.setText(CurrentCharacter.getName());
        }
        binding.characterListMakeNewCharacter.setOnClickListener(v ->
                NavHostFragment.findNavController(CharacterList.this)
                        .navigate(R.id.goToCharacterCreatorPageOne)
        );

        TextView CharacterRace = view.findViewById(R.id.characterRace);
        String RaceDisp = "";
        if(CurrentCharacter != null && CurrentCharacter.getRace() != null) {
            if (CurrentCharacter.getRace().hasSubraces()) {
                //If a subrace exists, it will prioritize displaying that, because it's more detailed.
                RaceDisp += CurrentCharacter.getSubrace().getName() + " ";
            } else {
                //When no subrace is present, the "base" race is shown.
                RaceDisp += CurrentCharacter.getRace().getName();
            }
        }
        if(CharacterRace != null){
            CharacterRace.setText(RaceDisp);
        }


        TextView CharacterLevel = view.findViewById(R.id.characterLevel);
        String LevelDisp = "";

        if(CurrentCharacter != null) {
            LevelDisp += CurrentCharacter.getLevel() + " ";
        }
        if(CharacterLevel != null){
            CharacterLevel.setText(LevelDisp);
        }

        Spinner CharacterList = view.findViewById(R.id.character_list_choose_character);

        LoadFromInternalStorage(requireContext());

        String[] CharacterNames = Characters.keySet().toArray(new String[0]);
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, CharacterNames);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CharacterList.setAdapter(Adapter);
        binding.characterListViewSelected.setOnClickListener(v ->{
            if(!Characters.isEmpty()){
                CurrentCharacter = Characters.get(CharacterList.getSelectedItem().toString());
                NavHostFragment.findNavController(CharacterList.this)
                        .navigate(R.id.goToCharacterView);
            }
            else{
                NavHostFragment.findNavController(CharacterList.this)
                        .navigate(R.id.goToCharacterCreatorPageOne);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}