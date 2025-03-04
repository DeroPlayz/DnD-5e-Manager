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
//        for(int i = 0; i < CurrentCharacter.getClassCount(); i++)
        LevelDisp += "Level " + CurrentCharacter.getLevel() + " ";
        CharacterLevel.setText(LevelDisp);

        CurrentCharacter.setStrengthBonus();
        CurrentCharacter.setDexterityBonus();
        CurrentCharacter.setConstitutionBonus();
        CurrentCharacter.setIntelligenceBonus();
        CurrentCharacter.setWisdomBonus();
        CurrentCharacter.setCharismaBonus();

        TextView StrengthValue = view.findViewById(R.id.character_view_strength_value);
            TextView StrengthMod = view.findViewById(R.id.character_view_strength_mod);
            TextView StrengthSave = view.findViewById(R.id.character_view_strength_save);

        TextView DexterityValue = view.findViewById(R.id.character_view_dexterity_value);
            TextView DexterityMod = view.findViewById(R.id.character_view_dexterity_mod);
            TextView DexteritySave = view.findViewById(R.id.character_view_dexterity_save);

        TextView ConstitutionValue = view.findViewById(R.id.character_view_constitution_value);
            TextView ConstitutionMod = view.findViewById(R.id.character_view_constitution_mod);
            TextView ConstitutionSave = view.findViewById(R.id.character_view_constitution_save);

        TextView IntelligenceValue = view.findViewById(R.id.character_view_intelligence_value);
            TextView IntelligenceMod = view.findViewById(R.id.character_view_intelligence_mod);
            TextView IntelligenceSave = view.findViewById(R.id.character_view_intelligence_save);

        TextView WisdomValue = view.findViewById(R.id.character_view_wisdom_value);
            TextView WisdomMod = view.findViewById(R.id.character_view_wisdom_mod);
            TextView WisdomSave = view.findViewById(R.id.character_view_wisdom_save);

        TextView CharismaValue = view.findViewById(R.id.character_view_charisma_value);
            TextView CharismaMod = view.findViewById(R.id.character_view_charisma_mod);
            TextView CharismaSave = view.findViewById(R.id.character_view_charisma_save);

        StrengthValue.setText(String.valueOf(CurrentCharacter.getStrength()));
            StrengthMod.setText(String.valueOf(CurrentCharacter.getStrengthBonus()));
            StrengthSave.setText(String.valueOf(CurrentCharacter.getStrengthSave()));
        DexterityValue.setText(String.valueOf(CurrentCharacter.getDexterity()));
        ConstitutionValue.setText(String.valueOf(CurrentCharacter.getConstitution()));
        IntelligenceValue.setText(String.valueOf(CurrentCharacter.getIntelligence()));
        WisdomValue.setText(String.valueOf(CurrentCharacter.getWisdom()));
        CharismaValue.setText(String.valueOf(CurrentCharacter.getCharisma()));
    }

    @Override
    public void onDestroyView() {
//        CharacterCreatorPageOne.NewCharacter = new PlayerCharacter();
        super.onDestroyView();
        binding = null;
    }
}