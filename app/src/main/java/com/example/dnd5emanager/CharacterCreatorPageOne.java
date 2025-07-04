package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.Classes;
import static com.example.dnd5emanager.DataClasses.Constants.Races;
import static com.example.dnd5emanager.DataClasses.Constants.Subclasses;
import static com.example.dnd5emanager.DataClasses.Constants.Subraces;

import android.os.*;
import android.util.Log;
import android.view.*;
import android.widget.*;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.*;
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

    ArrayList<Subrace> SubraceAL;
    String[] SubraceNames;

    ArrayList<CharacterClass> ClassAL;
    String[] ClassNames;

    ArrayList<Subclass> SubclassAL;
    String[] SubclassNames;

    TextView RacialStrengthBonus;
    TextView RacialDexterityBonus;
    TextView RacialConstitutionBonus;
    TextView RacialIntelligenceBonus;
    TextView RacialWisdomBonus;
    TextView RacialCharismaBonus;

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                NavHostFragment.findNavController(CharacterCreatorPageOne.this).navigate(R.id.goToCharacterList);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

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
                    if (!Objects.requireNonNull(Races.get(Race.getSelectedItem().toString())).hasSubraces()) {
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
            Strength = view.findViewById(R.id.EDIT_STRENGTH);
            Dexterity = view.findViewById(R.id.EDIT_DEXTERITY);
            Constitution = view.findViewById(R.id.EDIT_CONSTITUTION);
            Intelligence = view.findViewById(R.id.EDIT_INTELLIGENCE);
            Wisdom = view.findViewById(R.id.EDIT_WISDOM);
            Charisma = view.findViewById(R.id.EDIT_CHARISMA);

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

        binding.characterCreatorPageOneBackButton.setOnClickListener(v -> NavHostFragment.findNavController(CharacterCreatorPageOne.this).navigate(R.id.goToCharacterList));

        binding.characterCreatorPageOneRollStats.setOnClickListener(v -> {
            NewCharacter.getBaseAbilityScores().put(Constants.Strength, setStat());
            Strength.setText(String.valueOf(NewCharacter.getBaseAbilityScores().get(Constants.Strength)));

            NewCharacter.getBaseAbilityScores().put(Constants.Dexterity, setStat());
            Dexterity.setText(String.valueOf(NewCharacter.getBaseAbilityScores().get(Constants.Dexterity)));

            NewCharacter.getBaseAbilityScores().put(Constants.Constitution, setStat());
            Constitution.setText(String.valueOf(NewCharacter.getBaseAbilityScores().get(Constants.Constitution)));

            NewCharacter.getBaseAbilityScores().put(Constants.Intelligence, setStat());
            Intelligence.setText(String.valueOf(NewCharacter.getBaseAbilityScores().get(Constants.Intelligence)));

            NewCharacter.getBaseAbilityScores().put(Constants.Wisdom, setStat());
            Wisdom.setText(String.valueOf(NewCharacter.getBaseAbilityScores().get(Constants.Wisdom)));

            NewCharacter.getBaseAbilityScores().put(Constants.Charisma, setStat());
            Charisma.setText(String.valueOf(NewCharacter.getBaseAbilityScores().get(Constants.Charisma)));
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
        for (int die : dice) {
            total += die;
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
            NewCharacter.getBaseAbilityScores().put(Constants.Strength, Integer.parseInt(Strength.getText().toString()));
        }
        else{NewCharacter.getBaseAbilityScores().put(Constants.Strength, 0);}

        if(!Dexterity.getText().toString().isEmpty()){
            NewCharacter.getBaseAbilityScores().put(Constants.Dexterity, Integer.parseInt(Dexterity.getText().toString()));
        }
        else{NewCharacter.getBaseAbilityScores().put(Constants.Dexterity, 0);}

        if(!Constitution.getText().toString().isEmpty()){
            NewCharacter.getBaseAbilityScores().put(Constants.Constitution, Integer.parseInt(Constitution.getText().toString()));
        }
        else{NewCharacter.getBaseAbilityScores().put(Constants.Constitution, 0);}

        if(!Intelligence.getText().toString().isEmpty()){
            NewCharacter.getBaseAbilityScores().put(Constants.Intelligence, Integer.parseInt(Intelligence.getText().toString()));
        }
        else{NewCharacter.getBaseAbilityScores().put(Constants.Intelligence, 0);}

        if(!Wisdom.getText().toString().isEmpty()){
            NewCharacter.getBaseAbilityScores().put(Constants.Wisdom, Integer.parseInt(Wisdom.getText().toString()));
        }
        else{NewCharacter.getBaseAbilityScores().put(Constants.Wisdom, 0);}

        if(!Charisma.getText().toString().isEmpty()){
            NewCharacter.getBaseAbilityScores().put(Constants.Charisma, Integer.parseInt(Charisma.getText().toString()));
        }
        else{NewCharacter.getBaseAbilityScores().put(Constants.Charisma, 0);}


        if(NewCharacter.getRace().getAbilityBonus(Constants.Strength) > -1){
            String s = "+" + NewCharacter.getRace().getAbilityBonus(Constants.Strength);
            RacialStrengthBonus.setText(s);
        }
        else if(NewCharacter.getRace().getAbilityBonus(Constants.Strength) < 0){
            String s = "-" + NewCharacter.getRace().getAbilityBonus(Constants.Strength);
            RacialStrengthBonus.setText(s);
        }
        else{
            String s = "" + NewCharacter.getRace().getAbilityBonus(Constants.Strength);
            RacialStrengthBonus.setText(s);
        }

        if(NewCharacter.getRace().getAbilityBonus(Constants.Dexterity) > 0){
            String s = "+" + NewCharacter.getRace().getAbilityBonus(Constants.Dexterity);
            RacialDexterityBonus.setText(s);
        }
        else if(NewCharacter.getRace().getAbilityBonus(Constants.Dexterity) < 0){
            String s = "-" + NewCharacter.getRace().getAbilityBonus(Constants.Dexterity);
            RacialDexterityBonus.setText(s);
        }
        else{
            String s = "" + NewCharacter.getRace().getAbilityBonus(Constants.Dexterity);
            RacialDexterityBonus.setText(s);
        }

        if(NewCharacter.getRace().getAbilityBonus(Constants.Constitution) > 0){
            String s = "+" + NewCharacter.getRace().getAbilityBonus(Constants.Constitution);
            RacialConstitutionBonus.setText(s);
        }
        else if(NewCharacter.getRace().getAbilityBonus(Constants.Constitution) < 0){
            String s = "-" + NewCharacter.getRace().getAbilityBonus(Constants.Constitution);
            RacialConstitutionBonus.setText(s);
        }
        else{
            String s = "" + NewCharacter.getRace().getAbilityBonus(Constants.Constitution);
            RacialConstitutionBonus.setText(s);
        }

        if(NewCharacter.getRace().getAbilityBonus(Constants.Intelligence) > 0){
            String s = "+" + NewCharacter.getRace().getAbilityBonus(Constants.Intelligence);
            RacialIntelligenceBonus.setText(s);
        }
        else if(NewCharacter.getRace().getAbilityBonus(Constants.Intelligence) < 0){
            String s = "-" + NewCharacter.getRace().getAbilityBonus(Constants.Intelligence);
            RacialIntelligenceBonus.setText(s);
        }
        else{
            String s = "" + NewCharacter.getRace().getAbilityBonus(Constants.Intelligence);
            RacialIntelligenceBonus.setText(s);
        }

        if(NewCharacter.getRace().getAbilityBonus(Constants.Wisdom) > 0){
            String s = "+" + NewCharacter.getRace().getAbilityBonus(Constants.Wisdom);
            RacialWisdomBonus.setText(s);
        }
        else if(NewCharacter.getRace().getAbilityBonus(Constants.Wisdom) < 0){
            String s = "-" + NewCharacter.getRace().getAbilityBonus(Constants.Wisdom);
            RacialWisdomBonus.setText(s);
        }
        else{
            String s = "" + NewCharacter.getRace().getAbilityBonus(Constants.Wisdom);
            RacialWisdomBonus.setText(s);
        }

        if(NewCharacter.getRace().getAbilityBonus(Constants.Charisma) > 0){
            String s = "+" + NewCharacter.getRace().getAbilityBonus(Constants.Charisma);
            RacialCharismaBonus.setText(s);
        }
        else if(NewCharacter.getRace().getAbilityBonus(Constants.Charisma) < 0){
            String s = "-" + NewCharacter.getRace().getAbilityBonus(Constants.Charisma);
            RacialCharismaBonus.setText(s);
        }
        else{
            String s = "" + NewCharacter.getRace().getAbilityBonus(Constants.Charisma);
            RacialCharismaBonus.setText(s);
        }

    }

    public void loadRaces(){
        RaceAL = new ArrayList<>(Arrays.asList(Races.values().toArray(new Race[0])));
        RaceNames = new String[RaceAL.size()];
        for(int i = 0; i < RaceNames.length; i++){
            RaceNames[i] = RaceAL.get(i).getName();
        }
        Arrays.sort(RaceNames);
        ArrayAdapter<String> raceAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, RaceNames);
        raceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Race.setAdapter(raceAdapter);
    }

    public void loadSubraces(){
        SubraceAL = new ArrayList<>(Arrays.asList(Subraces.values().toArray(new Subrace[0])));
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
        ArrayAdapter<String> subraceAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, SubraceNames);
        subraceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Subrace.setAdapter(subraceAdapter);
    }

    public void loadClasses(){
        ClassAL = new ArrayList<>(Arrays.asList(Classes.values().toArray(new CharacterClass[0])));
        ClassNames = new String[ClassAL.size()];
        for(int i = 0; i < ClassNames.length; i++){
            ClassNames[i] = ClassAL.get(i).getName();
        }
        Arrays.sort(ClassNames);
        ArrayAdapter<String> classAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, ClassNames);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Class.setAdapter(classAdapter);
    }

    public void loadSubclasses(){
        SubclassAL = new ArrayList<>(Arrays.asList(Subclasses.values().toArray(new Subclass[0])));
        SubclassNames = new String[SubclassAL.size()];
        ArrayList<String> ValidSubclassNames = new ArrayList<>();
        for(int i = 0; i < SubclassNames.length; i++){
            if(SubclassAL.get(i).getParentClass().equals(NewCharacter.getPrimaryClass().getName())){
                ValidSubclassNames.add(SubclassAL.get(i).getName());
            }
        }
        SubclassNames = ValidSubclassNames.toArray(new String[0]);
        Arrays.sort(SubclassNames);
        ArrayAdapter<String> subclassAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, SubclassNames);
        subclassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Subclass.setAdapter(subclassAdapter);
    }

    public void updateRace(){
        NewCharacter.setRace(Races.get(Race.getSelectedItem().toString()));
        Log.d("Updated Race", NewCharacter.getRace().getName());
    }

    public void updateSubrace(){
        if(NewCharacter.getRace().hasSubraces()){
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