package com.example.dnd5emanager;

import static com.example.dnd5emanager.CharacterCreatorPageOne.NewCharacter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.dnd5emanager.databinding.CharacterViewBinding;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link ThirdFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class CharacterView extends Fragment {
    private CharacterViewBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = CharacterViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Finds the TextView element for the character name textbox.
        TextView CharacterName = view.findViewById(R.id.characterName);
        //Sets the textbox's value to the in-progress character's name.
        CharacterName.setText(NewCharacter.getName());

        //Second verse, same as the first; this time, for the character's race.
        TextView CharacterRace = view.findViewById(R.id.characterRace);

        String RaceDisp = "";
        if(NewCharacter.getRace().getHasSubraces()){
            //If a subrace exists, it will prioritize displaying that, because it's more detailed.
            RaceDisp += NewCharacter.getSubrace().getName() + " ";
        }
        else {
            //When no subrace is present, the "base" race is shown.
            RaceDisp += NewCharacter.getRace().getName();
        }
        //Updates the visible textbox.
        CharacterRace.setText(RaceDisp);

        //Just like the other two. These aren't great descriptions of functionality, but I'm fucking exhausted. It's 11 pm.
        TextView CharacterLevel = view.findViewById(R.id.characterLevel);
        String LevelDisp = "";
        LevelDisp += "Level " + NewCharacter.getLevel() + " ";
        CharacterLevel.setText(LevelDisp);

    }

    @Override
    public void onDestroyView() {
//        CharacterCreatorPageOne.NewCharacter = new PlayerCharacter();
        super.onDestroyView();
        binding = null;
    }
}
