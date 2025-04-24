package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.CurrentCharacter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.Methods;
import com.example.dnd5emanager.databinding.CharacterViewBinding;

import java.io.File;
import java.util.ArrayList;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link ThirdFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class CharacterView extends Fragment {
    private CharacterViewBinding binding;

    TextView CharacterName;
    TextView CharacterRace;
    TextView CharacterClass;
    TextView InitiativeBonus;
    TextView Strength;
    TextView StrengthValue;
    TextView StrengthMod;
    TextView StrengthSave;
    TextView Dexterity;
    TextView DexterityValue;
    TextView DexterityMod;
    TextView DexteritySave;
    TextView Constitution;
    TextView ConstitutionValue;
    TextView ConstitutionMod;
    TextView ConstitutionSave;
    TextView Intelligence;
    TextView IntelligenceValue;
    TextView IntelligenceMod;
    TextView IntelligenceSave;
    TextView Wisdom;
    TextView WisdomValue;
    TextView WisdomMod;
    TextView WisdomSave;
    TextView Charisma;
    TextView CharismaValue;
    TextView CharismaMod;
    TextView CharismaSave;
    TextView CurrentHealth;
    TextView MaxHealth;

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

        Methods.saveCharacter(requireContext(), CurrentCharacter);

        CharacterName = view.findViewById(R.id.characterName);

        CharacterRace = view.findViewById(R.id.characterRace);

        CharacterClass = view.findViewById(R.id.characterClass);

        InitiativeBonus = view.findViewById(R.id.character_view_initiative_bonus_value);

        Strength = view.findViewById(R.id.character_creator_page_one_edit_strength);
        StrengthValue = view.findViewById(R.id.character_view_strength_value);
        StrengthMod = view.findViewById(R.id.character_view_strength_mod);
        StrengthSave = view.findViewById(R.id.character_view_strength_save);

        Dexterity = view.findViewById(R.id.character_creator_page_one_edit_dexterity);
        DexterityValue = view.findViewById(R.id.character_view_dexterity_value);
        DexterityMod = view.findViewById(R.id.character_view_dexterity_mod);
        DexteritySave = view.findViewById(R.id.character_view_dexterity_save);

        Constitution = view.findViewById(R.id.character_creator_page_one_edit_constitution);
        ConstitutionValue = view.findViewById(R.id.character_view_constitution_value);
        ConstitutionMod = view.findViewById(R.id.character_view_constitution_mod);
        ConstitutionSave = view.findViewById(R.id.character_view_constitution_save);

        Intelligence = view.findViewById(R.id.character_creator_page_one_edit_intelligence);
        IntelligenceValue = view.findViewById(R.id.character_view_intelligence_value);
        IntelligenceMod = view.findViewById(R.id.character_view_intelligence_mod);
        IntelligenceSave = view.findViewById(R.id.character_view_intelligence_save);

        Wisdom = view.findViewById(R.id.character_creator_page_one_edit_wisdom);
        WisdomValue = view.findViewById(R.id.character_view_wisdom_value);
        WisdomMod = view.findViewById(R.id.character_view_wisdom_mod);
        WisdomSave = view.findViewById(R.id.character_view_wisdom_save);

        Charisma = view.findViewById(R.id.character_creator_page_one_edit_charisma);
        CharismaValue = view.findViewById(R.id.character_view_charisma_value);
        CharismaMod = view.findViewById(R.id.character_view_charisma_mod);
        CharismaSave = view.findViewById(R.id.character_view_charisma_save);

        CurrentHealth = view.findViewById(R.id.character_view_current_health);
        MaxHealth = view.findViewById(R.id.character_view_max_health);

        updateName();
        if(CurrentCharacter.getRace() != null) {
            Log.d("Race Before", CurrentCharacter.getRace().getName());
        }
        else{
            Log.d("Race Before", "Null");
        }
        updateRace();
//        Log.d("Race After", CurrentCharacter.getRace().getName());
        updateClass();
        updateStats();
        updateHealth();

        binding.movementLayout.setOnClickListener(v -> {
            Log.d("Hi!", "That's all!");
        });

        binding.characterViewBackButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterView.this).navigate(R.id.goToCharacterList);
        });
        binding.toDice.setOnClickListener(v ->
                NavHostFragment.findNavController(CharacterView.this).navigate(R.id.goToDiceRoller));

        binding.characterViewDeleteCharacter.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterView.this).navigate(R.id.goToCharacterList);
            File file = new File(requireContext().getFilesDir(), CurrentCharacter.getName() + ".json");
            CurrentCharacter = null;
            file.delete();
        });

        binding.characterViewMoreInformation.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterView.this).navigate(R.id.goToCharacterMoreInfo);
            Methods.saveCharacter(requireContext(), CurrentCharacter);
        });

        binding.characterViewAddHealth.setOnClickListener(v -> {
            CurrentCharacter.setCurrentHealth(CurrentCharacter.getCurrentHealth() + 1);
            CurrentHealth.setText(String.valueOf(CurrentCharacter.getCurrentHealth()));
            Methods.saveCharacter(requireContext(), CurrentCharacter);
        });

        binding.characterViewSubtractHealth.setOnClickListener(v -> {
            CurrentCharacter.setCurrentHealth(CurrentCharacter.getCurrentHealth() - 1);
            CurrentHealth.setText(String.valueOf(CurrentCharacter.getCurrentHealth()));
            Methods.saveCharacter(requireContext(), CurrentCharacter);
        });
    }

    public void updateName(){
        CharacterName.setText(CurrentCharacter.getName());
    }

    public void updateRace(){
        String DisplayRace = "";
        if(CurrentCharacter.getRace() != null) {
            if (CurrentCharacter.getRace().HasSubraces()) {
                //If a subrace exists, it will prioritize displaying that, because it's more detailed.
                DisplayRace += CurrentCharacter.getSubrace().getName() + " ";
            } else {
                //When no subrace is present, the "base" race is shown.
                DisplayRace += CurrentCharacter.getRace().getName();
            }
            CharacterRace.setText(DisplayRace);
        }
    }

    public void updateClass(){

        if(CurrentCharacter.getPrimaryClass() != null) {
            StringBuilder DisplayClass = new StringBuilder();
            ArrayList<String> Multiclasses = new ArrayList<>();
            for(int i = 0; i < CurrentCharacter.getPlayerClasses().size(); i++){
                Multiclasses.add("Level " + CurrentCharacter.getPlayerClasses().get(i).getLevel() + " " + CurrentCharacter.getPlayerClasses().get(i).getName());
            }
            for(int i = 0; i < Multiclasses.size(); i++){
                DisplayClass.append(Multiclasses.get(i));
                if(i < Multiclasses.size() - 1){
                    DisplayClass.append("/");
                }
            }
            CharacterClass.setText(DisplayClass.toString());
        }
    }

    public void updateStats(){
        updateStrength();
        updateDexterity();
        updateConstitution();
        updateIntelligence();
        updateWisdom();
        updateCharisma();
    }

    public void updateStrength(){
        StrengthValue.setText(String.valueOf(CurrentCharacter.getStrength()));
        CurrentCharacter.setStrengthBonus();
        StrengthMod.setText(String.valueOf(CurrentCharacter.getStrengthBonus()));
        StrengthSave.setText(String.valueOf(CurrentCharacter.getStrengthSave()));
    }

    public void updateDexterity(){
        CurrentCharacter.setDexterity();
        CurrentCharacter.setDexterityBonus();
        DexterityValue.setText(String.valueOf(CurrentCharacter.getDexterity()));
        DexterityMod.setText(String.valueOf(CurrentCharacter.getDexterityBonus()));
        DexteritySave.setText(String.valueOf(CurrentCharacter.getDexteritySave()));
        CurrentCharacter.setInitiativeBonus();
        InitiativeBonus.setText(String.valueOf(CurrentCharacter.getInitiativeBonus()));
    }

    public void updateConstitution(){
        CurrentCharacter.setConstitution();
        CurrentCharacter.setConstitutionBonus();
        ConstitutionValue.setText(String.valueOf(CurrentCharacter.getConstitution()));
        ConstitutionMod.setText(String.valueOf(CurrentCharacter.getConstitutionBonus()));
        ConstitutionSave.setText(String.valueOf(CurrentCharacter.getConstitutionSave()));
    }

    public void updateIntelligence(){
        CurrentCharacter.setIntelligence();
        CurrentCharacter.setIntelligenceBonus();
        IntelligenceValue.setText(String.valueOf(CurrentCharacter.getIntelligence()));
        IntelligenceMod.setText(String.valueOf(CurrentCharacter.getIntelligenceBonus()));
        IntelligenceSave.setText(String.valueOf(CurrentCharacter.getIntelligenceSave()));
    }

    public void updateWisdom(){
        CurrentCharacter.setWisdom();
        CurrentCharacter.setWisdomBonus();
        WisdomValue.setText(String.valueOf(CurrentCharacter.getWisdom()));
        WisdomMod.setText(String.valueOf(CurrentCharacter.getWisdomBonus()));
        WisdomSave.setText(String.valueOf(CurrentCharacter.getWisdomSave()));
    }

    public void updateCharisma(){
        CurrentCharacter.setCharisma();
        CurrentCharacter.setCharismaBonus();
        CharismaValue.setText(String.valueOf(CurrentCharacter.getCharisma()));
        CharismaMod.setText(String.valueOf(CurrentCharacter.getCharismaBonus()));
        CharismaSave.setText(String.valueOf(CurrentCharacter.getCharismaSave()));
    }

    public void updateHealth(){
        updateCurrentHealth();
        updateMaxHealth();
    }

    public void updateCurrentHealth(){
        CurrentHealth.setText(String.valueOf(CurrentCharacter.getCurrentHealth()));
    }

    public void updateMaxHealth(){
        MaxHealth.setText(String.valueOf(CurrentCharacter.getMaxHealth()));
    }

    @Override
    public void onDestroyView() {
        if(CurrentCharacter != null)
            Methods.saveCharacter(requireContext(), CurrentCharacter);
        super.onDestroyView();
        binding = null;
    }
}