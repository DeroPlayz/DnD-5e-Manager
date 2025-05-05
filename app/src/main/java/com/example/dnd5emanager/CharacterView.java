package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.CurrentCharacter;
import static com.example.dnd5emanager.DataClasses.Constants.Skills;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.Constants;
import com.example.dnd5emanager.DataClasses.Methods;
import com.example.dnd5emanager.databinding.CharacterViewBinding;

import java.io.File;

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
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                NavHostFragment.findNavController(CharacterView.this).navigate(R.id.goToCharacterList);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

        super.onViewCreated(view, savedInstanceState);

        loadName(view);
        loadRace(view);
        loadClassAndLevel(view);
        loadHealth(view);
        loadStats(view);

        binding.characterViewBackButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterView.this).navigate(R.id.goToCharacterList);
            Methods.saveCharacter(requireContext(), CurrentCharacter);
        });

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

        binding.characterViewDiceRoller.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterView.this).navigate(R.id.goToDiceRoller);
            Methods.saveCharacter(requireContext(), CurrentCharacter);
        });
    }

    public void loadName(View view){
        TextView CharacterName = view.findViewById(R.id.characterName);
        CharacterName.setText(CurrentCharacter.getName());
    }

    public void loadRace(View view){
        TextView CharacterRace = view.findViewById(R.id.characterRace);
        String RaceDisp = "";
        if(CurrentCharacter.getRace() != null) {
            if (CurrentCharacter.getRace().hasSubraces()) {
                //If a subrace exists, it will prioritize displaying that, because it's more detailed.
                RaceDisp += CurrentCharacter.getSubrace().getName() + " ";
            } else {
                //When no subrace is present, the "base" race is shown.
                RaceDisp += CurrentCharacter.getRace().getName();
            }
        }
        CharacterRace.setText(RaceDisp);
    }

    public void loadClassAndLevel(View view){
        //Just like the other two. Not much to say.
        TextView CharacterLevel = view.findViewById(R.id.characterLevel);
        StringBuilder LevelDisp = new StringBuilder();
        for(int i = 0; i < CurrentCharacter.getPlayerClasses().size(); i++){
            LevelDisp.append("Level ").append(CurrentCharacter.getLevel()).append(" ").append(CurrentCharacter.getPlayerClasses().get(i).getName());
            if(i < CurrentCharacter.getPlayerClasses().size() - 1){
                LevelDisp.append(", ");
            }
        }
        CharacterLevel.setText(LevelDisp.toString());
    }

    public void loadHealth(View view){
        TextView CurrentHealth = view.findViewById(R.id.character_view_current_health);
        CurrentHealth.setText(String.valueOf(CurrentCharacter.getCurrentHealth()));
        TextView MaxHealth = view.findViewById(R.id.character_view_max_health);
        MaxHealth.setText(String.valueOf(CurrentCharacter.getMaxHealth()));

        binding.characterViewSubtractHealth.setOnClickListener(v -> {
            CurrentCharacter.setCurrentHealth(CurrentCharacter.getCurrentHealth() - 1);
            CurrentHealth.setText(String.valueOf(CurrentCharacter.getCurrentHealth()));
            Methods.saveCharacter(requireContext(), CurrentCharacter);
        });

        binding.characterViewAddHealth.setOnClickListener(v -> {
            CurrentCharacter.setCurrentHealth(CurrentCharacter.getCurrentHealth() + 1);
            CurrentHealth.setText(String.valueOf(CurrentCharacter.getCurrentHealth()));
            Methods.saveCharacter(requireContext(), CurrentCharacter);
        });
    }

    /** @noinspection DataFlowIssue*/
    @SuppressLint("SetTextI18n")
    public void loadStats(View view){
        loadStrength(view);
        loadDexterity(view);
        loadConstitution(view);
        loadIntelligence(view);
        loadWisdom(view);
        loadCharisma(view);

        TextView Acrobatics = view.findViewById(R.id.acrobatics);
        TextView Animal_Handling = view.findViewById(R.id.animal_handling);
        TextView Arcana = view.findViewById(R.id.arcana);
        TextView Athletics = view.findViewById(R.id.athletics);
        TextView Deception = view.findViewById(R.id.deception);
        TextView History = view.findViewById(R.id.history);
        TextView Insight = view.findViewById(R.id.insight);
        TextView Intimidation = view.findViewById(R.id.intimidation);
        TextView Investigation = view.findViewById(R.id.investigation);
        TextView Medicine = view.findViewById(R.id.medicine);
        TextView Nature = view.findViewById(R.id.nature);
        TextView Perception = view.findViewById(R.id.perception);
        TextView Performance = view.findViewById(R.id.performance);
        TextView Persuasion = view.findViewById(R.id.persuasion);
        TextView Religion = view.findViewById(R.id.religion);
        TextView SleightOfHand = view.findViewById(R.id.sleight_of_hand);
        TextView Stealth = view.findViewById(R.id.stealth);
        TextView Survival = view.findViewById(R.id.survival);

        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.getBaseAbilityScores().get(Skills.get(Constants.obatic))); > -1){
get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )))Acrobatics.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )));
        }
        else{
            Acrobatics.setText(Acrobatics.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Acrobatics)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.getBaseAbilityScores().get(Skills.get(Constants.malHandlin))); > -1){
get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )))Animal_Handling.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )));
        }
        else{
            Animal_Handling.setText(Animal_Handling.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.AnimalHandling)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.getBaseAbilityScores().get(Skills.get(Constants.an))); > -1){
get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )))Arcana.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )));
        }
        else{
            Arcana.setText(Arcana.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Arcana)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.getBaseAbilityScores().get(Skills.get(Constants.letic))); > -1){
get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )))Athletics.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )));
        }
        else{
            Athletics.setText(Athletics.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Athletics)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.getBaseAbilityScores().get(Skills.get(Constants.eptio))); > -1){
get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )))Deception.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )));
        }
        else{
            Deception.setText(Deception.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Deception)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.getBaseAbilityScores().get(Skills.get(Constants.tor)));> -1){
get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )))History.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )));
        }
        else{
            History.setText(History.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.History)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.getBaseAbilityScores().get(Skills.get(Constants.igh)));) > -1){
get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )))Insight.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )));
        }
        else{
            Insight.setText(Insight.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Insight)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.getBaseAbilityScores().get(Skills.get(Constants.imidatio)));) > -1){
get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )))Intimidation.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )));
        }
        else{
            Intimidation.setText(Intimidation.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Intimidation)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.getBaseAbilityScores().get(Skills.get(Constants.estigatio))); > -1){
get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )))Investigation.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(ConstantsgetBaseAbilityScores().get(Skills.get(Constants."  )));
        }
        else{
            Investigation.setText(Investigation.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.getBaseAbilityScores().get(Skills.get(Constants.estigatio)));)
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Medicine)) > -1){
            Medicine.setText(Medicine.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Medicine)));
        }
        else{
            Medicine.setText(Medicine.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Medicine)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Nature)) > -1){
            Nature.setText(Nature.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Nature)));
        }
        else{
            Nature.setText(Nature.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Nature)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Perception)) > -1){
            Perception.setText(Perception.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Perception)));
        }
        else{
            Perception.setText(Perception.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Perception)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Performance)) > -1){
            Performance.setText(Performance.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Performance)));
        }
        else{
            Performance.setText(Performance.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Performance)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Persuasion)) > -1){
            Persuasion.setText(Persuasion.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Persuasion)));
        }
        else{
            Persuasion.setText(Persuasion.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Persuasion)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Religion)) > -1){
            Religion.setText(Religion.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Religion)));
        }
        else{
            Religion.setText(Religion.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Religion)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.SleightOfHand)) > -1){
            SleightOfHand.setText(SleightOfHand.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.SleightOfHand)));
        }
        else{
            SleightOfHand.setText(SleightOfHand.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.SleightOfHand)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Stealth)) > -1){
            Stealth.setText(Stealth.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Stealth)));
        }
        else{
            Stealth.setText(Stealth.getText().toString() + "  -" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Stealth)));
        }
        if(CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Survival)) > -1){
            Survival.setText(Survival.getText().toString() + "  +" + CurrentCharacter.getBaseAbilityScores().get(Skills.get(Constants.Survival)));
        }
        else{
            Survival.setText(Survival.getText().toString() + "  -" + CurrentCharacter.getSurvival());
        }
    }

    public void loadStrength(View view){
        CurrentCharacter.setStrength();
        CurrentCharacter.setStrengthBonus();
        Log.d("Current Strength", String.valueOf(CurrentCharacter.getStrength()));

        TextView StrengthValue = view.findViewById(R.id.character_view_strength_value);
        StrengthValue.setText(String.valueOf(CurrentCharacter.getStrength()));

        TextView StrengthMod = view.findViewById(R.id.character_view_strength_mod);
        StrengthMod.setText(String.valueOf(CurrentCharacter.getStrengthBonus()));

        TextView StrengthSave = view.findViewById(R.id.character_view_strength_save);
        StrengthSave.setText(String.valueOf(CurrentCharacter.getStrengthSave()));
    }

    public void loadDexterity(View view){
        CurrentCharacter.setDexterity();
        CurrentCharacter.setDexterityBonus();
        Log.d("Current Dexterity", String.valueOf(CurrentCharacter.getDexterity()));

        TextView DexterityValue = view.findViewById(R.id.character_view_dexterity_value);
        DexterityValue.setText(String.valueOf(CurrentCharacter.getDexterity()));

        TextView DexterityMod = view.findViewById(R.id.character_view_dexterity_mod);
        DexterityMod.setText(String.valueOf(CurrentCharacter.getDexterityBonus()));

        TextView DexteritySave = view.findViewById(R.id.character_view_dexterity_save);
        DexteritySave.setText(String.valueOf(CurrentCharacter.getDexteritySave()));
    }

    public void loadConstitution(View view){
        CurrentCharacter.setConstitution();
        CurrentCharacter.setConstitutionBonus();
        Log.d("Current Constitution", String.valueOf(CurrentCharacter.getConstitution()));

        TextView ConstitutionValue = view.findViewById(R.id.character_view_constitution_value);
        ConstitutionValue.setText(String.valueOf(CurrentCharacter.getConstitution()));

        TextView ConstitutionMod = view.findViewById(R.id.character_view_constitution_mod);
        ConstitutionMod.setText(String.valueOf(CurrentCharacter.getConstitutionBonus()));

        TextView ConstitutionSave = view.findViewById(R.id.character_view_constitution_save);
        ConstitutionSave.setText(String.valueOf(CurrentCharacter.getConstitutionSave()));
    }

    public void loadIntelligence(View view){
        CurrentCharacter.setIntelligence();
        CurrentCharacter.setIntelligenceBonus();
        Log.d("Current Intelligence", String.valueOf(CurrentCharacter.getIntelligence()));

        TextView IntelligenceValue = view.findViewById(R.id.character_view_intelligence_value);
        IntelligenceValue.setText(String.valueOf(CurrentCharacter.getIntelligence()));

        TextView IntelligenceMod = view.findViewById(R.id.character_view_intelligence_mod);
        IntelligenceMod.setText(String.valueOf(CurrentCharacter.getIntelligenceBonus()));

        TextView IntelligenceSave = view.findViewById(R.id.character_view_intelligence_save);
        IntelligenceSave.setText(String.valueOf(CurrentCharacter.getIntelligenceSave()));
    }

    public void loadWisdom(View view){
        CurrentCharacter.setWisdom();
        CurrentCharacter.setWisdomBonus();
        Log.d("Current Wisdom", String.valueOf(CurrentCharacter.getWisdom()));

        TextView WisdomValue = view.findViewById(R.id.character_view_wisdom_value);
        WisdomValue.setText(String.valueOf(CurrentCharacter.getWisdom()));

        TextView WisdomMod = view.findViewById(R.id.character_view_wisdom_mod);
        WisdomMod.setText(String.valueOf(CurrentCharacter.getWisdomBonus()));

        TextView WisdomSave = view.findViewById(R.id.character_view_wisdom_save);
        WisdomSave.setText(String.valueOf(CurrentCharacter.getWisdomSave()));
    }

    public void loadCharisma(View view){
        CurrentCharacter.setCharisma();
        CurrentCharacter.setCharismaBonus();
        Log.d("Current Charisma", String.valueOf(CurrentCharacter.getCharisma()));

        TextView CharismaValue = view.findViewById(R.id.character_view_charisma_value);
        CharismaValue.setText(String.valueOf(CurrentCharacter.getCharisma()));

        TextView CharismaMod = view.findViewById(R.id.character_view_charisma_mod);
        CharismaMod.setText(String.valueOf(CurrentCharacter.getCharismaBonus()));

        TextView CharismaSave = view.findViewById(R.id.character_view_charisma_save);
        CharismaSave.setText(String.valueOf(CurrentCharacter.getCharismaSave()));
    }

    @Override
    public void onDestroyView() {
        if(CurrentCharacter != null)
            Methods.saveCharacter(requireContext(), CurrentCharacter);
        super.onDestroyView();
        binding = null;
    }
}