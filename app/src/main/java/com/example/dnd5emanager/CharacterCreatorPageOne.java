package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.Classes;
import static com.example.dnd5emanager.DataClasses.Constants.Races;
import static com.example.dnd5emanager.DataClasses.Constants.Subclasses;
import static com.example.dnd5emanager.DataClasses.Constants.Subraces;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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
        RacialStrengthBonus = view.findViewById(R.id.RACIAL_STRENGTH);
        RacialDexterityBonus = view.findViewById(R.id.RACIAL_DEXTERITY);
        RacialConstitutionBonus = view.findViewById(R.id.RACIAL_CONSTITUTION);
        RacialIntelligenceBonus = view.findViewById(R.id.RACIAL_INTELLIGENCE);
        RacialWisdomBonus = view.findViewById(R.id.RACIAL_WISDOM);
        RacialCharismaBonus = view.findViewById(R.id.RACIAL_CHARISMA);

        Name = view.findViewById(R.id.character_creator_page_one_edit_name);
//        Name.setOnFocusChangeListener(textChanges);
        Level = view.findViewById(R.id.character_creator_page_one_edit_level);
//        Level.setOnFocusChangeListener(textChanges);
        Race = view.findViewById(R.id.character_creator_page_one_edit_race);
//        Race.setOnFocusChangeListener(textChanges);
        Subrace = view.findViewById(R.id.character_creator_page_one_edit_subrace);
//        Subrace.setOnFocusChangeListener(textChanges);
        Class = view.findViewById(R.id.character_creator_page_one_edit_class);
//        Class.setOnFocusChangeListener(textChanges);
        Subclass = view.findViewById(R.id.character_creator_page_one_edit_subclass);
//        Subclass.setOnFocusChangeListener(textChanges);
        Strength = view.findViewById(R.id.EDIT_STRENGTH);
//        Strength.setOnFocusChangeListener(textChanges);
        Dexterity = view.findViewById(R.id.EDIT_DEXTERITY);
//        Dexterity.setOnFocusChangeListener(textChanges);
        Constitution = view.findViewById(R.id.EDIT_CONSTITUTION);
//        Constitution.setOnFocusChangeListener(textChanges);
        Intelligence = view.findViewById(R.id.EDIT_INTELLIGENCE);
//        Intelligence.setOnFocusChangeListener(textChanges);
        Wisdom = view.findViewById(R.id.EDIT_WISDOM);
//        Wisdom.setOnFocusChangeListener(textChanges);
        Charisma = view.findViewById(R.id.EDIT_CHARISMA);
//        Charisma.setOnFocusChangeListener(textChanges);

        loadRaces();
        loadSubraces();
        loadClasses();
        loadSubclasses();

        super.onViewCreated(view, savedInstanceState);
        binding.characterCreatorPageOneEditRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateRace();
                if (Race != null) {
                    Subrace.setEnabled(true);
                    Subrace.setClickable(true);
                    Subrace.setVisibility(View.VISIBLE);
                    loadSubraces();
                    if (!Objects.requireNonNull(Races.get(Race.getSelectedItem().toString())).HasSubraces()) {
                        Subrace.setEnabled(false);
                        Subrace.setClickable(false);
                        Subrace.setVisibility(View.INVISIBLE);
                    }
                }
                updateStats();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.characterCreatorPageOneEditClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateClass();
                if (Class != null) {
                    Subclass.setEnabled(true);
                    Subclass.setClickable(true);
                    Subclass.setVisibility(View.VISIBLE);
                    loadSubclasses();
                    if (!Objects.requireNonNull(Classes.get(Class.getSelectedItem().toString())).HasSubclasses()) {
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
            NewCharacter.setMaxHealth(NewCharacter.getPrimaryClass().getHitDie());
            TextView Health = view.findViewById(R.id.character_creator_page_one_edit_health);
            Health.setText(String.valueOf(NewCharacter.getMaxHealth()));
        });

        binding.characterCreatorPageOneRollHealth.setOnClickListener(v -> {
            NewCharacter.setMaxHealth((int) (Math.random() * NewCharacter.getPrimaryClass().getHitDie()) + 1);
            TextView Health = view.findViewById(R.id.character_creator_page_one_edit_health);
            Health.setText(String.valueOf(NewCharacter.getMaxHealth()));
        });

        binding.characterCreatorPageOneNextPage.setOnClickListener(v -> {
            Name = view.findViewById(R.id.character_creator_page_one_edit_name);
            Health = view.findViewById(R.id.character_creator_page_one_edit_health);
            Level = view.findViewById(R.id.character_creator_page_one_edit_level);
            Strength = view.findViewById(R.id.STRENGTH_TEXT);
            Dexterity = view.findViewById(R.id.DEXTERITY_TEXT);
            Constitution = view.findViewById(R.id.CONSTITUTION_TEXT);
//            Intelligence = view.findViewById(R.id.character_creator_page_one_edit_intelligence);
//            Wisdom = view.findViewById(R.id.character_creator_page_one_edit_wisdom);
//            Charisma = view.findViewById(R.id.character_creator_page_one_edit_charisma);

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
                update();
                if(Race.getSelectedItem() == null){
                    NewCharacter.setRace(Races.get("Aarakocra"));
                }
                if(Class.getSelectedItem() == null){
                    NewCharacter.setPrimaryClass(Classes.get("Artificer"));
                }
                NavHostFragment.findNavController(CharacterCreatorPageOne.this).navigate(R.id.goToCharacterCreatorPageTwo);
            }
        });

        binding.characterCreatorPageOneBackButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterCreatorPageOne.this).navigate(R.id.goToCharacterList);
        });

        binding.characterCreatorPageOneRollStats.setOnClickListener(v -> {
            NewCharacter.setBaseStrength(setStat());
            Strength.setText(String.valueOf(NewCharacter.getBaseStrength()));

            NewCharacter.setBaseDexterity(setStat());
            Dexterity.setText(String.valueOf(NewCharacter.getBaseDexterity()));

            NewCharacter.setBaseConstitution(setStat());
            Constitution.setText(String.valueOf(NewCharacter.getBaseConstitution()));

            NewCharacter.setBaseIntelligence(setStat());
            Intelligence.setText(String.valueOf(NewCharacter.getBaseIntelligence()));

            NewCharacter.setBaseWisdom(setStat());
            Wisdom.setText(String.valueOf(NewCharacter.getBaseWisdom()));

            NewCharacter.setBaseCharisma(setStat());
            Charisma.setText(String.valueOf(NewCharacter.getBaseCharisma()));
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

    public void update(){
        updateRace();
        updateSubrace();
        updateClass();
        updateSubclass();
        updateStats();
        updateInfo();
    }
    public void updateInfo() {
        NewCharacter.setName(Name.getText().toString());
        NewCharacter.setLevel(NewCharacter.getPrimaryClass(), 1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
            if(Level.getText() != null && !Level.getText().isEmpty()){
                NewCharacter.setLevel(NewCharacter.getPrimaryClass(), Integer.parseInt(Level.getText().toString()));
            }
        }
        NewCharacter.setCurrentHealth(NewCharacter.getMaxHealth());
    }

    public void updateStats(){
        if(!Strength.getText().toString().isEmpty()){
            NewCharacter.setBaseStrength(Integer.parseInt(Strength.getText().toString()));
        }
        else{NewCharacter.setBaseStrength(0);}

        if(!Dexterity.getText().toString().isEmpty()){
            NewCharacter.setBaseDexterity(Integer.parseInt(Dexterity.getText().toString()));
        }
        else{NewCharacter.setBaseDexterity(0);}

        if(!Constitution.getText().toString().isEmpty()){
            NewCharacter.setBaseConstitution(Integer.parseInt(Constitution.getText().toString()));
        }
        else{NewCharacter.setBaseConstitution(0);}

        if(!Intelligence.getText().toString().isEmpty()){
            NewCharacter.setBaseIntelligence(Integer.parseInt(Intelligence.getText().toString()));
        }
        else{NewCharacter.setBaseIntelligence(0);}

        if(!Wisdom.getText().toString().isEmpty()){
            NewCharacter.setBaseWisdom(Integer.parseInt(Wisdom.getText().toString()));
        }
        else{NewCharacter.setBaseWisdom(0);}

        if(!Charisma.getText().toString().isEmpty()){
            NewCharacter.setBaseCharisma(Integer.parseInt(Charisma.getText().toString()));
        }
        else{NewCharacter.setBaseCharisma(0);}

        NewCharacter.setStrengthBonus();
        NewCharacter.setDexterityBonus();
        NewCharacter.setConstitutionBonus();
        NewCharacter.setIntelligenceBonus();
        NewCharacter.setWisdomBonus();
        NewCharacter.setCharismaBonus();


        if(NewCharacter.getRace().getStrengthBonus() > 0){
            String s = "+" + NewCharacter.getRace().getStrengthBonus();
            RacialStrengthBonus.setText(s);
        }
        else if(NewCharacter.getRace().getStrengthBonus() < 0){
            String s = "-" + NewCharacter.getRace().getStrengthBonus();
            RacialStrengthBonus.setText(s);
        }
        else{
            String s = "" + NewCharacter.getRace().getStrengthBonus();
            RacialStrengthBonus.setText(s);
        }

        if(NewCharacter.getRace().getDexterityBonus() > 0){
            String s = "+" + NewCharacter.getRace().getDexterityBonus();
            RacialDexterityBonus.setText(s);
        }
        else if(NewCharacter.getRace().getDexterityBonus() < 0){
            String s = "-" + NewCharacter.getRace().getDexterityBonus();
            RacialDexterityBonus.setText(s);
        }
        else{
            String s = "" + NewCharacter.getRace().getDexterityBonus();
            RacialDexterityBonus.setText(s);
        }

        if(NewCharacter.getRace().getConstitutionBonus() > 0){
            String s = "+" + NewCharacter.getRace().getConstitutionBonus();
            RacialConstitutionBonus.setText(s);
        }
        else if(NewCharacter.getRace().getConstitutionBonus() < 0){
            String s = "-" + NewCharacter.getRace().getConstitutionBonus();
            RacialConstitutionBonus.setText(s);
        }
        else{
            String s = "" + NewCharacter.getRace().getConstitutionBonus();
            RacialConstitutionBonus.setText(s);
        }

        if(NewCharacter.getRace().getIntelligenceBonus() > 0){
            String s = "+" + NewCharacter.getRace().getIntelligenceBonus();
            RacialIntelligenceBonus.setText(s);
        }
        else if(NewCharacter.getRace().getIntelligenceBonus() < 0){
            String s = "-" + NewCharacter.getRace().getIntelligenceBonus();
            RacialIntelligenceBonus.setText(s);
        }
        else{
            String s = "" + NewCharacter.getRace().getIntelligenceBonus();
            RacialIntelligenceBonus.setText(s);
        }

        if(NewCharacter.getRace().getWisdomBonus() > 0){
            String s = "+" + NewCharacter.getRace().getWisdomBonus();
            RacialWisdomBonus.setText(s);
        }
        else if(NewCharacter.getRace().getWisdomBonus() < 0){
            String s = "-" + NewCharacter.getRace().getWisdomBonus();
            RacialWisdomBonus.setText(s);
        }
        else{
            String s = "" + NewCharacter.getRace().getWisdomBonus();
            RacialWisdomBonus.setText(s);
        }

        if(NewCharacter.getRace().getCharismaBonus() > 0){
            String s = "+" + NewCharacter.getRace().getCharismaBonus();
            RacialCharismaBonus.setText(s);
        }
        else if(NewCharacter.getRace().getCharismaBonus() < 0){
            String s = "-" + NewCharacter.getRace().getCharismaBonus();
            RacialCharismaBonus.setText(s);
        }
        else{
            String s = "" + NewCharacter.getRace().getCharismaBonus();
            RacialCharismaBonus.setText(s);
        }

    }

    public void loadRaces(){
        RaceAL = new ArrayList<Race>(Arrays.asList(Races.values().toArray(new Race[0])));
        RaceNames = new String[RaceAL.size()];
        for(int i = 0; i < RaceNames.length; i++){
            RaceNames[i] = RaceAL.get(i).getName();
        }
        Arrays.sort(RaceNames);
        RaceAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, RaceNames);
        RaceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Race.setAdapter(RaceAdapter);
    }

    public void loadSubraces(){
        SubraceAL = new ArrayList<Subrace>(Arrays.asList(Subraces.values().toArray(new Subrace[0])));
        SubraceNames = new String[SubraceAL.size()];
        ArrayList<String> ValidSubraceNames = new ArrayList<>();
        for(int i = 0; i < SubraceNames.length; i++) {
            if(NewCharacter.getRace() != null){
                if (SubraceAL.get(i).getParentRace().equals(NewCharacter.getRace().getName())) {
                    ValidSubraceNames.add(SubraceAL.get(i).getName());
                }
            }
        }
        SubraceNames = ValidSubraceNames.toArray(new String[0]);
        Arrays.sort(SubraceNames);
        SubraceAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, SubraceNames);
        SubraceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Subrace.setAdapter(SubraceAdapter);
    }

    public void loadClasses(){
        ClassAL = new ArrayList<CharacterClass>(Arrays.asList(Classes.values().toArray(new CharacterClass[0])));
        ClassNames = new String[ClassAL.size()];
        for(int i = 0; i < ClassNames.length; i++){
            ClassNames[i] = ClassAL.get(i).getName();
        }
        Arrays.sort(ClassNames);
        ClassAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, ClassNames);
        ClassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Class.setAdapter(ClassAdapter);
    }

    public void loadSubclasses(){
        SubclassAL = new ArrayList<Subclass>(Arrays.asList(Subclasses.values().toArray(new Subclass[0])));
        SubclassNames = new String[SubclassAL.size()];
        ArrayList<String> ValidSubclassNames = new ArrayList<>();
        for(int i = 0; i < SubclassNames.length; i++){
            if(SubclassAL.get(i).getParentClass().equals(NewCharacter.getPrimaryClass().getName())){
                ValidSubclassNames.add(SubclassAL.get(i).getName());
            }
        }
        SubclassNames = ValidSubclassNames.toArray(new String[0]);
        Arrays.sort(SubclassNames);
        SubclassAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, SubclassNames);
        SubclassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Subclass.setAdapter(SubclassAdapter);
    }

    public void updateRace(){
        NewCharacter.setRace(Races.get(Race.getSelectedItem().toString()));
        Log.d("Updated Race", NewCharacter.getRace().getName());
    };

    public void updateSubrace(){
        if(NewCharacter.getRace().HasSubraces()){
            NewCharacter.setSubrace(Subraces.get(Subrace.getSelectedItem().toString()));
            Log.d("Updated Subrace", NewCharacter.getSubrace().getName());
        }
    }

    public void updateClass(){
        NewCharacter.setPrimaryClass(Classes.get(Class.getSelectedItem().toString()));
    }

    public void updateSubclass(){
        NewCharacter.getPrimaryClass().setSubclass(Subclasses.get(Subclass.getSelectedItem().toString()));
    }
}