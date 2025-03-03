package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.CurrentCharacter;

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

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Finds the TextView element for the character name textbox.
        TextView CharacterName = view.findViewById(R.id.characterName);
        //Sets the textbox's value to the in-progress character's name.
        CharacterName.setText(CurrentCharacter.getName());

        //Second verse, same as the first; this time, for the character's race.
        TextView CharacterRace = view.findViewById(R.id.characterRace);

        String RaceDisp = "";
        if(CurrentCharacter.getRace().getHasSubraces()){
            //If a subrace exists, it will prioritize displaying that, because it's more detailed.
            RaceDisp += CurrentCharacter.getSubrace().getName() + " ";
        }
        else {
            //When no subrace is present, the "base" race is shown.
            RaceDisp += CurrentCharacter.getRace().getName();
        }
        //Updates the visible textbox.
        CharacterRace.setText(RaceDisp);

        //Just like the other two. These aren't great descriptions of functionality, but I'm fucking exhausted. It's 11 pm.
        TextView CharacterLevel = view.findViewById(R.id.characterLevel);
        String LevelDisp = "";
        for(int i = 0; i < CurrentCharacter.getClassCount(); i++)
        LevelDisp += "Level " + CurrentCharacter.getLevel() + " ";
        CharacterLevel.setText(LevelDisp);

        TextView Strength = view.findViewById(R.id.character_view_strength_value);
        TextView Dexterity = view.findViewById(R.id.character_view_dexterity_value);
        TextView Constitution = view.findViewById(R.id.character_view_constitution_value);
        TextView Intelligence = view.findViewById(R.id.character_view_intelligence_value);
        TextView Wisdom = view.findViewById(R.id.character_view_wisdom_value);
        TextView Charisma = view.findViewById(R.id.character_view_charisma_value);
        String StrengthString = "Strength: " + String.valueOf(CurrentCharacter.getStrength());
        String DexterityString = "Dexterity: " + String.valueOf(CurrentCharacter.getDexterity());
        String ConstitutionString = "Constitution: " + String.valueOf(CurrentCharacter.getConstitution());
        String IntelligenceString = "Intelligence: " + String.valueOf(CurrentCharacter.getIntelligence());
        String WisdomString = "Wisdom: " + String.valueOf(CurrentCharacter.getWisdom());
        String CharismaString = "Charisma: " + String.valueOf(CurrentCharacter.getCharisma());

        Strength.setText(StrengthString);
        Dexterity.setText(DexterityString);
        Constitution.setText(ConstitutionString);
        Intelligence.setText(IntelligenceString);
        Wisdom.setText(WisdomString);
        Charisma.setText(CharismaString);
    }

    @Override
    public void onDestroyView() {
//        CharacterCreatorPageOne.NewCharacter = new PlayerCharacter();
        super.onDestroyView();
        binding = null;
    }
}