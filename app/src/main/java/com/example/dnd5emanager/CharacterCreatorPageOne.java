package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.*;
import static com.example.dnd5emanager.MainMenu.Races;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.CharacterCreatorPageOneBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class CharacterCreatorPageOne extends Fragment {

    private CharacterCreatorPageOneBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = CharacterCreatorPageOneBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public static PlayerCharacter NewCharacter = new PlayerCharacter();
    private EditText Name;
    private EditText Level;
    private EditText Health;
    private Spinner Race;
    private Spinner Subrace;
    private Spinner Class;
    private ArrayList<String> Selection = new ArrayList<>();
    private TextView Strength;
    private TextView Dexterity;
    private TextView Constitution;
    private TextView Intelligence;
    private TextView Wisdom;
    private TextView Charisma;

    private ArrayAdapter<String> Adapter;
    TextView RacialStrengthBonus;
    TextView RacialDexterityBonus;
    TextView RacialConstitutionBonus;
    TextView RacialIntelligenceBonus;
    TextView RacialWisdomBonus;
    TextView RacialCharismaBonus;

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        OnFocusChangeListener textChanges = new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                update(v);
            }
        };

        RacialStrengthBonus = view.findViewById(R.id.character_creator_page_one_racial_strength);
        RacialDexterityBonus = view.findViewById(R.id.character_creator_page_one_racial_dexterity);
        RacialConstitutionBonus = view.findViewById(R.id.character_creator_page_one_racial_constitution);
        RacialIntelligenceBonus = view.findViewById(R.id.character_creator_page_one_racial_intelligence);
        RacialWisdomBonus = view.findViewById(R.id.character_creator_page_one_racial_wisdom);
        RacialCharismaBonus = view.findViewById(R.id.character_creator_page_one_racial_charisma);

        Resources resources = getResources();

        Name = view.findViewById(R.id.character_creator_page_one_edit_name);
        Name.setOnFocusChangeListener(textChanges);
        Level = view.findViewById(R.id.character_creator_page_one_edit_level);
        Level.setOnFocusChangeListener(textChanges);
        Race = view.findViewById(R.id.character_creator_page_one_edit_race);
        Race.setOnFocusChangeListener(textChanges);
        Subrace = view.findViewById(R.id.character_creator_page_one_edit_subrace);
        Subrace.setOnFocusChangeListener(textChanges);
        Class = view.findViewById(R.id.character_creator_page_one_edit_class);
        Class.setOnFocusChangeListener(textChanges);
        Strength = view.findViewById(R.id.character_creator_page_one_edit_strength);
        Strength.setOnFocusChangeListener(textChanges);
        Dexterity = view.findViewById(R.id.character_creator_page_one_edit_dexterity);
        Dexterity.setOnFocusChangeListener(textChanges);
        Constitution = view.findViewById(R.id.character_creator_page_one_edit_constitution);
        Constitution.setOnFocusChangeListener(textChanges);
        Intelligence = view.findViewById(R.id.character_creator_page_one_edit_intelligence);
        Intelligence.setOnFocusChangeListener(textChanges);
        Wisdom = view.findViewById(R.id.character_creator_page_one_edit_wisdom);
        Wisdom.setOnFocusChangeListener(textChanges);
        Charisma = view.findViewById(R.id.character_creator_page_one_edit_charisma);
        Charisma.setOnFocusChangeListener(textChanges);

        String[] RaceArray = new String[Races.size()];
        for(int i = 0; i < Races.size(); i++){
            RaceArray[i] = Races.get(i).getName();
        }
        Adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, RaceArray);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Race.setAdapter(Adapter);

        Adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, Selection);

        super.onViewCreated(view, savedInstanceState);
        binding.characterCreatorPageOneEditRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (Race != null) {
                    Adapter.clear();
                    Subrace.setEnabled(true);
                    Subrace.setClickable(true);
                    Subrace.setVisibility(View.VISIBLE);
                    Subrace.setAdapter(Adapter);
                    for (int i = 0; i < Races.size(); i++) {
//                        Log.d("Race Length:", i + " out of " + Races.size());
                        if (Race.getSelectedItem().toString().equals(Races.get(i).getName())) {
                            if (!Races.get(i).getHasSubraces()) {
                                Subrace.setEnabled(false);
                                Subrace.setClickable(false);
                                Subrace.setVisibility(View.INVISIBLE);
                            } else {
                                for (int j = 0; j < Subraces.size(); j++) {
                                    if (Subraces.get(j).getParentRace().getName().equals(Race.getSelectedItem().toString())) {
                                        Adapter.add(Subraces.get(j).getName());
                                    }
                                }
                            }
                        }
                    }
                    updateRace(view);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.characterCreatorPageOneMinimumHealth.setOnClickListener(v ->{
            NewCharacter.setMaxHealth(1);
            TextView Health = view.findViewById(R.id.character_creator_page_one_edit_health);
            Health.setText(String.valueOf(NewCharacter.getMaxHealth()));
        });

        binding.characterCreatorPageOneMaximumHealth.setOnClickListener(v ->{
            updateClass();
            NewCharacter.setMaxHealth(NewCharacter.getPrimaryClass().getHitDie());
            TextView Health = view.findViewById(R.id.character_creator_page_one_edit_health);
            Health.setText(String.valueOf(NewCharacter.getMaxHealth()));
        });

        binding.characterCreatorPageOneRollHealth.setOnClickListener(v -> {
            updateClass();
            NewCharacter.setMaxHealth(NewCharacter.getPrimaryClass().rollInitialHealth());
            TextView Health = view.findViewById(R.id.character_creator_page_one_edit_health);
            Health.setText(String.valueOf(NewCharacter.getMaxHealth()));
        });

        binding.characterCreatorPageOneViewCharacter.setOnClickListener(v -> {
            Name = view.findViewById(R.id.character_creator_page_one_edit_name);
            Health = view.findViewById(R.id.character_creator_page_one_edit_health);
            Level = view.findViewById(R.id.character_creator_page_one_edit_level);
            Strength = view.findViewById(R.id.character_creator_page_one_edit_strength);
            Dexterity = view.findViewById(R.id.character_creator_page_one_edit_dexterity);
            Constitution = view.findViewById(R.id.character_creator_page_one_edit_constitution);
            Intelligence = view.findViewById(R.id.character_creator_page_one_edit_intelligence);
            Wisdom = view.findViewById(R.id.character_creator_page_one_edit_wisdom);
            Charisma = view.findViewById(R.id.character_creator_page_one_edit_charisma);

            Snackbar snackbar = Snackbar.make(v, "", Snackbar.LENGTH_LONG);
            ArrayList<String> MissingData = new ArrayList<>();

            if(Name.getText().toString().isEmpty()){
                MissingData.add("Name");
            }
            if(Level.getText().toString().isEmpty()){
                updateClass();
                NewCharacter.setLevel(NewCharacter.getPrimaryClass(), 1);
            }
            if(Health.getText().toString().isEmpty()){
                MissingData.add("Health");
            }
            if(Strength.getText().toString().isEmpty()){
                MissingData.add("Strength");
            }
            if(Dexterity.getText().toString().isEmpty()){
                MissingData.add("Dexterity");
            }
            if(Constitution.getText().toString().isEmpty()){
                MissingData.add("Constitution");
            }
            if(Intelligence.getText().toString().isEmpty()){
                MissingData.add("Intelligence");
            }
            if(Wisdom.getText().toString().isEmpty()){
                MissingData.add("Wisdom");
            }
            if(Charisma.getText().toString().isEmpty()){
                MissingData.add("Charisma");
            }

            if(!MissingData.isEmpty()){
                StringBuilder warning = new StringBuilder("Missing Information - Please add your character's ");
                for(int i = 0; i < MissingData.size(); i++){
                    warning.append(MissingData.get(i));
                    if(i < MissingData.size() - 1){
                        warning.append(", ");
                    }
                    if(i == MissingData.size() - 1){
                        warning.append(".");
                    }
                }
                snackbar.setText(warning);
                snackbar.show();
            }
            else{
                update(v);
                CurrentCharacter = NewCharacter;
                NavHostFragment.findNavController(CharacterCreatorPageOne.this).navigate(R.id.goToCharacterCreatorPageTwo);
            }
        });

        binding.characterCreatorPageOneBackButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterCreatorPageOne.this).navigate(R.id.goToCharacterList);
        });

        binding.characterCreatorPageOneRollStats.setOnClickListener(v -> {
            NewCharacter.setStrength(setStat());
            Strength.setText(String.valueOf(NewCharacter.getStrength()));

            NewCharacter.setDexterity(setStat());
            Dexterity.setText(String.valueOf(NewCharacter.getDexterity()));

            NewCharacter.setConstitution(setStat());
            Constitution.setText(String.valueOf(NewCharacter.getConstitution()));

            NewCharacter.setIntelligence(setStat());
            Intelligence.setText(String.valueOf(NewCharacter.getIntelligence()));

            NewCharacter.setWisdom(setStat());
            Wisdom.setText(String.valueOf(NewCharacter.getWisdom()));

            NewCharacter.setCharisma(setStat());
            Charisma.setText(String.valueOf(NewCharacter.getCharisma()));
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public int setStat(){
        int[] dice = {0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            dice[i] = (int) (Math.random() * 6) + 1;
        }
        int lowestValIndex = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] < dice[lowestValIndex]) {
                lowestValIndex = i;
            }
        }
        dice[lowestValIndex] = 0;
        int total = 0;
        for (int i = 0; i < dice.length; i++) {
            total += dice[i];
        }
        return total;
    }


    public void update(View view){
        updateRace(view);
        updateClass();
        updateAbilities(view);
        NewCharacter.setName(Name.getText().toString());
        TextView Level = view.findViewById(R.id.character_creator_page_one_edit_level);
        NewCharacter.setCurrentHealth(NewCharacter.getMaxHealth());
    }

    public void updateAbilities(View view){
        if(Strength != null && !Strength.getText().toString().isEmpty()){
            NewCharacter.setStrength(Integer.parseInt(Strength.getText().toString()));
        }
        else{NewCharacter.setStrength(0);}

        if(Dexterity != null && !Dexterity.getText().toString().isEmpty()){
            NewCharacter.setDexterity(Integer.parseInt(Dexterity.getText().toString()));
        }
        else{NewCharacter.setDexterity(0);}

        if(Constitution != null && !Constitution.getText().toString().isEmpty()){
            NewCharacter.setConstitution(Integer.parseInt(Constitution.getText().toString()));
        }
        else{NewCharacter.setConstitution(0);}

        if(Intelligence != null && !Intelligence.getText().toString().isEmpty()){
            NewCharacter.setIntelligence(Integer.parseInt(Intelligence.getText().toString()));
        }
        else{NewCharacter.setIntelligence(0);}

        if(Wisdom != null && !Wisdom.getText().toString().isEmpty()){
            NewCharacter.setWisdom(Integer.parseInt(Wisdom.getText().toString()));
        }
        else{NewCharacter.setWisdom(0);}

        if(Charisma != null && !Charisma.getText().toString().isEmpty()){
            NewCharacter.setCharisma(Integer.parseInt(Charisma.getText().toString()));
        }
        else{NewCharacter.setCharisma(0);}
    }

    @SuppressLint("SetTextI18n")
    public void updateRace(View view) {
        for (int i = 0; i < Races.size(); i++) {
            if (Race.getSelectedItem().toString().equals(Races.get(i).getName())) {
                NewCharacter.setRace(Races.get(i));
//                Log.d("Race", "Found");
            }
        }
        if (NewCharacter.getRace().getHasSubraces()) {
            for (int i = 0; i < Subraces.size(); i++) {
                if (Subrace.getSelectedItem().toString().equals(Subraces.get(i).getName())) {
                    NewCharacter.setSubrace(Subraces.get(i));
                }
            }
        }
        RacialStrengthBonus.setText(String.valueOf(NewCharacter.getRace().getStrengthBonus()));
        if (Integer.parseInt(RacialStrengthBonus.getText().toString()) > 0) {
            RacialStrengthBonus.setText("+" + RacialStrengthBonus.getText());
        }
        RacialDexterityBonus.setText(String.valueOf(NewCharacter.getRace().getDexterityBonus()));
        if (Integer.parseInt(RacialDexterityBonus.getText().toString()) > 0) {
            RacialDexterityBonus.setText("+" + RacialDexterityBonus.getText());
        }
        RacialConstitutionBonus.setText(String.valueOf(NewCharacter.getRace().getConstitutionBonus()));
        if (Integer.parseInt(RacialConstitutionBonus.getText().toString()) > 0) {
            RacialConstitutionBonus.setText("+" + RacialConstitutionBonus.getText());
        }
        RacialIntelligenceBonus.setText(String.valueOf(NewCharacter.getRace().getIntelligenceBonus()));
        if (Integer.parseInt(RacialIntelligenceBonus.getText().toString()) > 0) {
            RacialIntelligenceBonus.setText("+" + RacialIntelligenceBonus.getText());
        }
        RacialWisdomBonus.setText(String.valueOf(NewCharacter.getRace().getWisdomBonus()));
        if (Integer.parseInt(RacialWisdomBonus.getText().toString()) > 0) {
            RacialWisdomBonus.setText("+" + RacialWisdomBonus.getText());
        }
        RacialCharismaBonus.setText(String.valueOf(NewCharacter.getRace().getCharismaBonus()));
        if (Integer.parseInt(RacialCharismaBonus.getText().toString()) > 0) {
            RacialCharismaBonus.setText("+" + RacialCharismaBonus.getText());
        }
    }

    public void updateClass(){
        NewCharacter.clearClasses();
        for (int i = 0; i < CharacterClasses.size(); i++) {
            if (Class.getSelectedItem().toString().equals(CharacterClasses.get(i).getName())) {
                NewCharacter.setPrimaryClass(CharacterClasses.get(i));
                break;
            }
        }
    }
}