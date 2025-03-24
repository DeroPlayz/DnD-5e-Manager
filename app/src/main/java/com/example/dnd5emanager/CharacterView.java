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

        TextView Strength = view.findViewById(R.id.character_creator_page_one_edit_strength);
        TextView Dexterity = view.findViewById(R.id.character_creator_page_one_edit_dexterity);
        TextView Constitution = view.findViewById(R.id.character_creator_page_one_edit_constitution);
        TextView Intelligence = view.findViewById(R.id.character_creator_page_one_edit_intelligence);
        TextView Wisdom = view.findViewById(R.id.character_creator_page_one_edit_wisdom);
        TextView Charisma = view.findViewById(R.id.character_creator_page_one_edit_charisma);

        //Finds the TextView element for the character name textbox.
        TextView CharacterName = view.findViewById(R.id.characterName);
        //Sets the textbox's value to the in-progress character's name.
        CharacterName.setText(CurrentCharacter.getName());

        //Second verse, same as the first; this time, for the character's race.
        TextView CharacterRace = view.findViewById(R.id.characterRace);
        TextView CharacterClass = view.findViewById(R.id.characterClass);

        String RaceDisp = "";
        if(CurrentCharacter.getRace() != null) {
            if (CurrentCharacter.getRace().getHasSubraces()) {
                //If a subrace exists, it will prioritize displaying that, because it's more detailed.
                RaceDisp += CurrentCharacter.getSubrace().getName() + " ";
            } else {
                //When no subrace is present, the "base" race is shown.
                RaceDisp += CurrentCharacter.getRace().getName();
            }
        }

        String ClassDisp = "";
        if(CurrentCharacter.getPrimaryClass() != null) {
            ClassDisp += CurrentCharacter.getPrimaryClass().getName();
        }

        //Updates the visible textbox.
        CharacterRace.setText(RaceDisp);
        CharacterClass.setText(ClassDisp);

        //Just like the other two. These aren't great descriptions of functionality, but I'm f***ing exhausted. It's 11 pm.
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

//        Log.d("NG Class?", String.valueOf(NewCharacter.getPrimaryClass()));
//        Log.d("CG Class?", String.valueOf(CurrentCharacter.getPrimaryClass()));
//        Log.d("CG Class Count?", String.valueOf(CurrentCharacter.getClasses().size()));

        TextView StrengthValue = view.findViewById(R.id.character_view_strength_value);
        StrengthValue.setText(String.valueOf(CurrentCharacter.getStrength()));
        TextView StrengthMod = view.findViewById(R.id.character_view_strength_mod);
        StrengthMod.setText(String.valueOf(CurrentCharacter.getStrengthBonus()));
        TextView StrengthSave = view.findViewById(R.id.character_view_strength_save);
        StrengthSave.setText(String.valueOf(CurrentCharacter.getStrengthSave()));

        TextView DexterityValue = view.findViewById(R.id.character_view_dexterity_value);
        DexterityValue.setText(String.valueOf(CurrentCharacter.getDexterity()));
        TextView DexterityMod = view.findViewById(R.id.character_view_dexterity_mod);
        DexterityMod.setText(String.valueOf(CurrentCharacter.getDexterityBonus()));
        TextView DexteritySave = view.findViewById(R.id.character_view_dexterity_save);
        DexteritySave.setText(String.valueOf(CurrentCharacter.getDexteritySave()));

        TextView ConstitutionValue = view.findViewById(R.id.character_view_constitution_value);
        ConstitutionValue.setText(String.valueOf(CurrentCharacter.getConstitution()));
        TextView ConstitutionMod = view.findViewById(R.id.character_view_constitution_mod);
        ConstitutionMod.setText(String.valueOf(CurrentCharacter.getConstitutionBonus()));
        TextView ConstitutionSave = view.findViewById(R.id.character_view_constitution_save);
        ConstitutionSave.setText(String.valueOf(CurrentCharacter.getConstitutionSave()));

        TextView IntelligenceValue = view.findViewById(R.id.character_view_intelligence_value);
        IntelligenceValue.setText(String.valueOf(CurrentCharacter.getIntelligence()));
        TextView IntelligenceMod = view.findViewById(R.id.character_view_intelligence_mod);
        IntelligenceMod.setText(String.valueOf(CurrentCharacter.getIntelligenceBonus()));
        TextView IntelligenceSave = view.findViewById(R.id.character_view_intelligence_save);
        IntelligenceSave.setText(String.valueOf(CurrentCharacter.getIntelligenceSave()));

        TextView WisdomValue = view.findViewById(R.id.character_view_wisdom_value);
        WisdomValue.setText(String.valueOf(CurrentCharacter.getWisdom()));
        TextView WisdomMod = view.findViewById(R.id.character_view_wisdom_mod);
        WisdomMod.setText(String.valueOf(CurrentCharacter.getWisdomBonus()));
        TextView WisdomSave = view.findViewById(R.id.character_view_wisdom_save);
        WisdomSave.setText(String.valueOf(CurrentCharacter.getWisdomSave()));

        TextView CharismaValue = view.findViewById(R.id.character_view_charisma_value);
        CharismaValue.setText(String.valueOf(CurrentCharacter.getCharisma()));
        TextView CharismaMod = view.findViewById(R.id.character_view_charisma_mod);
        CharismaMod.setText(String.valueOf(CurrentCharacter.getCharismaBonus()));
        TextView CharismaSave = view.findViewById(R.id.character_view_charisma_save);
        CharismaSave.setText(String.valueOf(CurrentCharacter.getCharismaSave()));

        TextView CurrentHealth = view.findViewById(R.id.character_view_current_health);
        CurrentHealth.setText(String.valueOf(CurrentCharacter.getCurrentHealth()));
        TextView MaxHealth = view.findViewById(R.id.character_view_max_health);
        MaxHealth.setText(String.valueOf(CurrentCharacter.getMaxHealth()));

        binding.characterViewBackButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterView.this).navigate(R.id.goToCharacterList);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}