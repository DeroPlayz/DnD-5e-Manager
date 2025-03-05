package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.CharacterClasses;
import static com.example.dnd5emanager.DataClasses.Constants.CurrentCharacter;
import static com.example.dnd5emanager.DataClasses.Constants.Races;
import static com.example.dnd5emanager.DataClasses.Constants.Subraces;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
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

import com.example.dnd5emanager.DataClasses.Constants;
import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.CharacterCreatorPageOneBinding;

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
    private Spinner Race;
    private Spinner Subrace;
    private Spinner Class;


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Resources resources = getResources();
        Name = view.findViewById(R.id.character_creator_page_one_edit_name);
        Level = view.findViewById(R.id.character_creator_page_one_edit_level);
        Race = view.findViewById(R.id.character_creator_page_one_edit_race);
        Subrace = view.findViewById(R.id.character_creator_page_one_edit_subrace);
        Class = view.findViewById(R.id.character_creator_page_one_edit_class);

        ArrayList<String> Selection = new ArrayList<>();
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, Selection);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        super.onViewCreated(view, savedInstanceState);
        OnFocusChangeListener onFocusChangeListener = null;
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
                        if (Race.getSelectedItem().toString().equals(Races.get(i).getName())) {
                            if(!Races.get(i).getHasSubraces()){
                                Subrace.setEnabled(false);
                                Subrace.setClickable(false);
                                Subrace.setVisibility(View.INVISIBLE);
                            }
                            else{
                                for(int j = 0; j < Subraces.size(); j++) {
                                    if (Subraces.get(j).getParentRace().getName().equals(Race.getSelectedItem().toString())) {
                                        Adapter.add(Subraces.get(j).getName());
                                    }
                                }
                            }
                        }
                    }
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

        binding.characterCreatorPageOneViewCharacterDemo.setOnClickListener(v -> {
            update(v);
            CurrentCharacter = NewCharacter;
            NavHostFragment.findNavController(CharacterCreatorPageOne.this).navigate(R.id.goToCharacterView);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void update(View view){
        NewCharacter.setName(Name.getText().toString());
        TextView Level = view.findViewById(R.id.character_creator_page_one_edit_level);
        NewCharacter.setCurrentHealth(NewCharacter.getMaxHealth());
        updateAbilities(view);
        updateRace();
        updateClass();
    }

    public void updateAbilities(View view){
        TextView Strength = view.findViewById(R.id.character_creator_page_one_edit_strength);
        TextView Dexterity = view.findViewById(R.id.character_creator_page_one_edit_dexterity);
        TextView Constitution = view.findViewById(R.id.character_creator_page_one_edit_constitution);
        TextView Intelligence = view.findViewById(R.id.character_creator_page_one_edit_intelligence);
        TextView Wisdom = view.findViewById(R.id.character_creator_page_one_edit_wisdom);
        TextView Charisma = view.findViewById(R.id.character_creator_page_one_edit_charisma);

        if(Strength.getText().toString() == null){
            NewCharacter.setStrength(Integer.parseInt(Strength.getText().toString()));
        }
        else{NewCharacter.setStrength(0);}

        if(Dexterity.getText().toString() == null){
            NewCharacter.setDexterity(Integer.parseInt(Dexterity.getText().toString()));
        }
        else{NewCharacter.setDexterity(0);}

        if(Constitution.getText().toString() == null){
            NewCharacter.setConstitution(Integer.parseInt(Constitution.getText().toString()));
        }
        else{NewCharacter.setConstitution(0);}

        if(Intelligence.getText().toString() == null){
            NewCharacter.setIntelligence(Integer.parseInt(Intelligence.getText().toString()));
        }
        else{NewCharacter.setIntelligence(0);}

        if(Wisdom.getText().toString() == null){
            NewCharacter.setWisdom(Integer.parseInt(Wisdom.getText().toString()));
        }
        else{NewCharacter.setWisdom(0);}

        if(Charisma.getText().toString() == null){
            NewCharacter.setCharisma(Integer.parseInt(Charisma.getText().toString()));
        }
        else{NewCharacter.setCharisma(0);}
    }

    public void updateRace(){
        for(int i = 0; i < Races.size(); i++){
            if(Race.getSelectedItem().toString().equals(Races.get(i).getName())) {
                NewCharacter.setRace(Races.get(i));
            }
        }
        if(NewCharacter.getRace().getHasSubraces()) {
            for(int i = 0; i < Subraces.size(); i++){
                if(Subrace.getSelectedItem().toString().equals(Subraces.get(i).getName())) {
                    NewCharacter.setSubrace(Subraces.get(i));
                }
            }
        }
    }

    public void updateClass(){
        NewCharacter.clearClasses();
        for(int i = 0; i < CharacterClasses.size(); i++){
            if(Class.getSelectedItem().toString().equals(CharacterClasses.get(i).getName())) {
                NewCharacter.addClass(CharacterClasses.get(i));
                NewCharacter.setLevel(CharacterClasses.get(i), Integer.parseInt(Level.getText().toString())-1);
            }
        }
//        Log.d("Class", NewCharacter.getPrimaryClass().getName());
    }
}