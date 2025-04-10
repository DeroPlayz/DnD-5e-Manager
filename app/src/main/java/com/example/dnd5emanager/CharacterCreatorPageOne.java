package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.Classes;
import static com.example.dnd5emanager.DataClasses.Constants.Races;
import static com.example.dnd5emanager.DataClasses.Constants.Subclasses;
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

import com.example.dnd5emanager.DataClasses.CharacterClass;
import com.example.dnd5emanager.DataClasses.Constants;
import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.DataClasses.Race;
import com.example.dnd5emanager.DataClasses.Subclass;
import com.example.dnd5emanager.DataClasses.Subrace;
import com.example.dnd5emanager.databinding.CharacterCreatorPageOneBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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
    private Spinner Subclass;
    private TextView Strength;
    private TextView Dexterity;
    private TextView Constitution;
    private TextView Intelligence;
    private TextView Wisdom;
    private TextView Charisma;

    ArrayList<Race> RaceAL;
    String[] RaceNames;
    private ArrayAdapter<String> RaceAdapter;

    ArrayList<Subrace> SubraceAL;
    String[] SubraceNames;
    private ArrayAdapter<String> SubraceAdapter;

    ArrayList<CharacterClass> ClassAL;
    String[] ClassNames;
    private ArrayAdapter<String> ClassAdapter;

    ArrayList<Subclass> SubclassAL;
    String[] SubclassNames;
    private ArrayAdapter<String> SubclassAdapter;

    TextView RacialStrengthBonus;
    TextView RacialDexterityBonus;
    TextView RacialConstitutionBonus;
    TextView RacialIntelligenceBonus;
    TextView RacialWisdomBonus;
    TextView RacialCharismaBonus;

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        NewCharacter.setPrimaryClass(Classes.get("Artificer"));
        OnFocusChangeListener textChanges = new OnFocusChangeListener() {
            @Override public void onFocusChange(View v, boolean hasFocus){update(v);}
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
        Subclass = view.findViewById(R.id.character_creator_page_one_edit_subclass);
        Subclass.setOnFocusChangeListener(textChanges);
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

        updateRace();

        super.onViewCreated(view, savedInstanceState);
        binding.characterCreatorPageOneEditRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateRace();
                if (Race != null) {
                    Log.d("Race", "Not null");
                    Subrace.setEnabled(true);
                    Log.d("Subrace", "Enabled");
                    Subrace.setClickable(true);
                    Log.d("Subrace", "Clickable");
                    Subrace.setVisibility(View.VISIBLE);
                    Log.d("Subrace", "Visible");

                    updateSubrace();

                    Log.d("Subraces?", String.valueOf(Objects.requireNonNull(Races.get(Race.getSelectedItem().toString())).HasSubraces()));

                    if (!Objects.requireNonNull(Races.get(Race.getSelectedItem().toString())).HasSubraces()) {
                        Subrace.setEnabled(false);
                        Log.d("Subrace", "Disabled");
                        Subrace.setClickable(false);
                        Log.d("Subrace", "Unclickable");
                        Subrace.setVisibility(View.INVISIBLE);
                        Log.d("Subrace", "Invisible");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.characterCreatorPageOneEditClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateClass();
                if (Subclass != null) {
                    Log.d("Subclass", "Not null.");
                    Subclass.setEnabled(true);
                    Log.d("Subclass", "Enabled.");
                    Subclass.setClickable(true);
                    Log.d("Subclass", "Clickable.");
                    Subclass.setVisibility(View.VISIBLE);
                    Log.d("Subclass", "Visible.");
                    Subclass.setAdapter(SubclassAdapter);
                    Log.d("Subclass", "Adapter set.");
                    Log.d("Subclasses?", String.valueOf(Objects.requireNonNull(Classes.get(Class.getSelectedItem().toString())).HasSubclasses()));
                    if(!NewCharacter.getPrimaryClass().HasSubclasses()){
                        Subclass.setEnabled(false);
                        Subclass.setClickable(false);
                        Subclass.setVisibility(View.INVISIBLE);
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
            NewCharacter.setMaxHealth(NewCharacter.getPrimaryClass().getHitDieMaxValue());
            TextView Health = view.findViewById(R.id.character_creator_page_one_edit_health);
            Health.setText(String.valueOf(NewCharacter.getMaxHealth()));
        });

        binding.characterCreatorPageOneRollHealth.setOnClickListener(v -> {
            Log.d("Hit Die", String.valueOf(NewCharacter.getPrimaryClass().getHitDieMaxValue()));
            NewCharacter.setMaxHealth((int) (Math.random() * NewCharacter.getPrimaryClass().getHitDieMaxValue()) + 1);
            TextView Health = view.findViewById(R.id.character_creator_page_one_edit_health);
            Health.setText(String.valueOf(NewCharacter.getMaxHealth()));
        });

        binding.characterCreatorPageOneNextPage.setOnClickListener(v -> {
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
            else{
                NewCharacter.setLevel(NewCharacter.getPrimaryClass(), Integer.parseInt(Level.getText().toString()));
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
                Constants.CurrentCharacter = NewCharacter;
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
        updateRace();
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

    public void updateRace(){
        RaceAL = new ArrayList<Race>(Arrays.asList(Races.values().toArray(new Race[0])));
        RaceNames = new String[RaceAL.size()];
        for(int i = 0; i < RaceNames.length; i++){
            Log.d("Race #" + i, RaceAL.get(i).getName());
            RaceNames[i] = RaceAL.get(i).getName();
        }
        Log.d("Race Selected Null?", String.valueOf(Race.getSelectedItem() != null));
        if(Race.getSelectedItem() != null) {
            NewCharacter.setRace(Races.get(Race.getSelectedItem().toString()));
        }
        RaceAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, RaceNames);
        RaceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Race.setAdapter(RaceAdapter);
//        updateSubrace();
    }

    public void updateSubrace(){
        SubraceAL = new ArrayList<Subrace>(Arrays.asList(Subraces.values().toArray(new Subrace[0])));
        SubraceNames = new String[SubraceAL.size()];
        for(int i = 0; i < SubraceNames.length; i++){
            if(SubraceAL.get(i).getParentRace().equals(NewCharacter.getRace().getName())){
                SubraceNames[i] = SubraceAL.get(i).getName();
            }
        }

        SubraceAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, SubraceNames);
        SubraceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Subrace.setAdapter(SubraceAdapter);
    }


    public void updateClass(){
        if(Class.getSelectedItem() != null){
            NewCharacter.setPrimaryClass(Classes.get(Class.getSelectedItem().toString()));
            SubclassNames = new String[NewCharacter.getPrimaryClass().getSubclasses().size()];
            for(int i = 0; i < NewCharacter.getPrimaryClass().getSubclasses().size(); i++){
                if(NewCharacter.getPrimaryClass().getSubclasses().get(i) != null){
                    Log.d("Subclass #" + i, NewCharacter.getPrimaryClass().getSubclasses().get(i).getName());
                    SubclassNames[i] = NewCharacter.getPrimaryClass().getSubclasses().get(i).getName();
                }
            }
            updateSubclass();
        }
    }

    public void updateSubclass(){
        Log.d("Subclass Map Length", String.valueOf(Subclasses.size()));
        Log.d("Is Subclasses Map null?", String.valueOf(Subclasses == null));
        SubclassAL = new ArrayList<Subclass>(Arrays.asList(Subclasses.values().toArray(new Subclass[0])));
        String[] SubclassNames = new String[SubclassAL.size()];
        if(Subclass.getSelectedItem() != null) {
            Log.d("Functional?", "Hell yeah!");
            Log.d("Subclass Selected Item", Subclass.getSelectedItem().toString());
            NewCharacter.getPrimaryClass().setSubclass(Subclasses.get(Subclass.getSelectedItem().toString()));
            Log.d("Subs", "Updated.");
            SubclassAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, SubclassNames);
            Log.d("Adapter", "Reassigned.");
            SubclassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Log.d("Subs", "Dropdown changed.");
            Subclass.setAdapter(SubclassAdapter);
            Log.d("Subclass", "Adapter set.");
        }
    }
}