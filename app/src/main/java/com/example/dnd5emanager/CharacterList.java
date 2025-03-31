package com.example.dnd5emanager;
import static com.example.dnd5emanager.MainMenu.CurrentCharacter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        binding.listToview.setOnClickListener(v ->
                        NavHostFragment.findNavController(CharacterList.this)
                                .navigate(R.id.goToCharacterView)
        );
        //Finds the TextView element for the character name textbox.
        TextView CharacterName = view.findViewById(R.id.characterName);
        //Sets the textbox's value to the in-progress character's name.
        if(CurrentCharacter != null){
            CharacterName.setText(CurrentCharacter.getName());
        }
        binding.characterListMakeNewCharacter.setOnClickListener(v ->
                NavHostFragment.findNavController(CharacterList.this)
                        .navigate(R.id.goToCharacterCreatorPageOne)
        );

        TextView CharacterRace = view.findViewById(R.id.characterRace);
        String RaceDisp = "";
        if(CurrentCharacter != null && CurrentCharacter.getRace() != null) {
            if (CurrentCharacter.getRace().HasSubraces()) {
                //If a subrace exists, it will prioritize displaying that, because it's more detailed.
                RaceDisp += CurrentCharacter.getSubrace().getName() + " ";
            } else {
                //When no subrace is present, the "base" race is shown.
                RaceDisp += CurrentCharacter.getRace().getName();
            }
        }
        CharacterRace.setText(RaceDisp);


        TextView CharacterLevel = view.findViewById(R.id.characterLevel);
        String LevelDisp = "";

        if(CurrentCharacter != null) {
            LevelDisp += CurrentCharacter.getLevel() + " ";
        }
        CharacterLevel.setText(LevelDisp);
        
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}