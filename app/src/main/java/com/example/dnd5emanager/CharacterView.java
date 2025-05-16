package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.CurrentCharacter;
import static com.example.dnd5emanager.DataClasses.Constants.Skills;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
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

import com.example.dnd5emanager.DataClasses.CharacterClass;
import com.example.dnd5emanager.DataClasses.Constants;
import com.example.dnd5emanager.DataClasses.Methods;
import com.example.dnd5emanager.DataClasses.PlayerCharacter;
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

    ViewGroup NoteLayout;
    ArrayList<TextView> NoteTextViews = new ArrayList<>();

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

        NoteLayout = view.findViewById(R.id.note_list);

        loadName(view);
        loadRace(view);
        loadClassAndLevel(view);
        loadHealth(view);
        loadStats(view);

//        loadNotes(view);
//
//        AlertDialog.Builder NoteEditor = new AlertDialog.Builder(requireContext());
//
//        for(int i = 0; i < CurrentCharacter.Notes.size(); i++) {
//            String currentNoteText = CurrentCharacter.Notes.get(i);
//            int j = i;
//            NoteTextViews.get(i).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("Note Editing", "So far, so good.");
//                    EditText EditNote = new EditText(getContext());
//                    EditNote.setText(currentNoteText);
//                    NoteEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                        @Override
//                        public void onDismiss(DialogInterface dialog) {
//                            String Text = EditNote.getText().toString();
//                            if(!Text.isEmpty()){
//                                NoteTextViews.get(j).setText(Text);
//                                CurrentCharacter.Notes.set(j, Text);
//                                formatNotes(NoteTextViews.get(j));
//                                if(NoteTextViews.get(j).getParent() == null){
//                                    NoteLayout.addView(NoteTextViews.get(j), j);
//                                }
//                                loadNotes(view);
//                            }
//                        }
//                    });
//                    NoteEditor.setView(EditNote);
//                    NoteEditor.show();
//                }
//            });
//        }
//        Log.d("All", "set!");
//
//        binding.characterViewAddNote.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("Note Editing", "So far, so good.");
//                EditText EditNote = new EditText(getContext());
//                EditNote.setText("");
//                NoteEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                    @Override
//                    public void onDismiss(DialogInterface dialog) {
//                        String Text = EditNote.getText().toString();
//                        if(!Text.isEmpty()){
//                            Log.d("New Note Contents", Text);
//                            createNote(Text);
//                            TextView NewNote = new TextView(requireContext());
//                            NewNote.setText(Text);
//                            formatNotes(NewNote);
//                            NoteTextViews.add(NewNote);
//                            NoteLayout.addView(NewNote);
//                        }
//                    }
//                });
//                NoteEditor.setView(EditNote);
//                NoteEditor.show();
//            }
//        });

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

//    public void formatNotes(TextView t){
//        t.setTextColor(getResources().getColor(R.color.black, requireContext().getTheme()));
//        t.setTextSize(18);
//        t.setLeft(10);
//        t.setRight(0);
//        t.setBottom(12);
//    }
//
//    public void createNote(String s){
//        CurrentCharacter.Notes.add(s);
//    }
//
//    public void loadNotes(View view){
//        if(!CurrentCharacter.Notes.isEmpty()){
//            for(int i = 0; i < CurrentCharacter.Notes.size(); i++){
//                TextView Note = new TextView(requireContext());
//                Note.setText(CurrentCharacter.Notes.get(i));
//                formatNotes(Note);
//                NoteTextViews.add(Note);
//                Log.d("Note #" + i, CurrentCharacter.Notes.get(i));
////            }
////            for(int i = 0; i < NoteTextViews.size(); i++){
//                NoteLayout.addView(NoteTextViews.get(i), i);
//            }
//        }
//        else{
//            CurrentCharacter.Notes.add("");
//            loadNotes(view);
//        }
//    }

    public void levelUp(PlayerCharacter Character, CharacterClass Class, int Level){
        Character.getPlayerClasses().get(Character.getPlayerClasses().indexOf(Class)).setLevel(Level);
        int CurrentLevel = Character.getPlayerClasses().get(Character.getPlayerClasses().indexOf(Class)).getLevel();
        if(CurrentLevel == 4 || CurrentLevel == 8 || CurrentLevel == 12 || CurrentLevel == 16 || CurrentLevel == 19){
//            abilityScoreImprovement();
        }
        AlertDialog.Builder FeaturesDialog;
        StringBuilder Features;

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
        TextView AnimalHandling = view.findViewById(R.id.animal_handling);
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

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Acrobatics)) > -1){
            Acrobatics.setText("Acrobatics  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Acrobatics)));
        }
        else{
            Acrobatics.setText("Acrobatics  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Acrobatics)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.AnimalHandling)) > -1){
            AnimalHandling.setText("Animal Handling  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.AnimalHandling)));
        }
        else{
            AnimalHandling.setText("Animal Handling  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.AnimalHandling)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Arcana)) > -1){
            Arcana.setText("Arcana  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Arcana)));
        }
        else{
            Arcana.setText("Arcana  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Arcana)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Athletics)) > -1){
            Athletics.setText("Athletics  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Athletics)));
        }
        else{
            Athletics.setText("Athletics  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Athletics)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Deception)) > -1){
            Deception.setText("Deception  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Deception)));
        }
        else{
            Deception.setText("Deception  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Deception)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.History)) > -1){
            History.setText("History  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.History)));
        }
        else{
            History.setText("History  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.History)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Insight)) > -1){
            Insight.setText("Insight  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Insight)));
        }
        else{
            Insight.setText("Insight  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Insight)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Intimidation)) > -1){
            Intimidation.setText("Intimidation  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Intimidation)));
        }
        else{
            Intimidation.setText("Intimidation  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Intimidation)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Investigation)) > -1){
            Investigation.setText("Investigation  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Investigation)));
        }
        else{
            Investigation.setText("Investigation  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Investigation)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Medicine)) > -1){
            Medicine.setText("Medicine  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Medicine)));
        }
        else{
            Medicine.setText("Medicine  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Medicine)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Nature)) > -1){
            Nature.setText("Nature  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Nature)));
        }
        else{
            Nature.setText("Nature  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Nature)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Perception)) > -1){
            Perception.setText("Perception  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Perception)));
        }
        else{
            Perception.setText("Perception  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Perception)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Performance)) > -1){
            Performance.setText("Performance  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Performance)));
        }
        else{
            Performance.setText("Performance  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Performance)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Persuasion)) > -1){
            Persuasion.setText("Persuasion  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Persuasion)));
        }
        else{
            Persuasion.setText("Persuasion  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Persuasion)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Religion)) > -1){
            Religion.setText("Religion  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Religion)));
        }
        else{
            Religion.setText("Religion  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Religion)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.SleightOfHand)) > -1){
            SleightOfHand.setText("Sleight Of Hand  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.SleightOfHand)));
        }
        else{
            SleightOfHand.setText("Sleight Of Hand  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.SleightOfHand)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Stealth)) > -1){
            Stealth.setText("Stealth  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Stealth)));
        }
        else{
            Stealth.setText("Stealth  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Stealth)));
        }

        if(CurrentCharacter.getAbilityMod(Skills.get(Constants.Survival)) > -1){
            Survival.setText("Survival  +" + CurrentCharacter.getAbilityMod(Skills.get(Constants.Survival)));
        }
        else{
            Survival.setText("Survival  " + CurrentCharacter.getAbilityMod(Skills.get(Constants.Survival)));
        }
    }

    public void loadStrength(View view){
        TextView StrengthValue = view.findViewById(R.id.character_view_strength_value);
        StrengthValue.setText(String.valueOf(CurrentCharacter.getAbilityScore(Constants.Strength)));

        TextView StrengthMod = view.findViewById(R.id.character_view_strength_mod);
        StrengthMod.setText(String.valueOf(CurrentCharacter.getAbilityMod(Constants.Strength)));

        TextView StrengthSave = view.findViewById(R.id.character_view_strength_save);
        StrengthSave.setText(String.valueOf(CurrentCharacter.getAbilityMod(Constants.Strength)));

        Log.d("Current Strength", String.valueOf(CurrentCharacter.getAbilityScore(Constants.Strength)));
    }

    public void loadDexterity(View view){
        TextView DexterityValue = view.findViewById(R.id.character_view_dexterity_value);
        DexterityValue.setText(String.valueOf(CurrentCharacter.getAbilityScore(Constants.Dexterity)));

        TextView DexterityMod = view.findViewById(R.id.character_view_dexterity_mod);
        DexterityMod.setText(String.valueOf(CurrentCharacter.getAbilityMod(Constants.Dexterity)));

        TextView DexteritySave = view.findViewById(R.id.character_view_dexterity_save);
        DexteritySave.setText(String.valueOf(CurrentCharacter.getAbilityMod(Constants.Dexterity)));

        Log.d("Current Dexterity", String.valueOf(CurrentCharacter.getAbilityScore(Constants.Dexterity)));
    }

    public void loadConstitution(View view){
        TextView ConstitutionValue = view.findViewById(R.id.character_view_constitution_value);
        ConstitutionValue.setText(String.valueOf(CurrentCharacter.getAbilityScore(Constants.Constitution)));

        TextView ConstitutionMod = view.findViewById(R.id.character_view_constitution_mod);
        ConstitutionMod.setText(String.valueOf(CurrentCharacter.getAbilityMod(Constants.Constitution)));

        TextView ConstitutionSave = view.findViewById(R.id.character_view_constitution_save);
        ConstitutionSave.setText(String.valueOf(CurrentCharacter.getAbilityMod(Constants.Constitution)));

        Log.d("Current Constitution", String.valueOf(CurrentCharacter.getAbilityScore(Constants.Constitution)));
    }

    public void loadIntelligence(View view){
        TextView IntelligenceValue = view.findViewById(R.id.character_view_intelligence_value);
        IntelligenceValue.setText(String.valueOf(CurrentCharacter.getAbilityScore(Constants.Intelligence)));

        TextView IntelligenceMod = view.findViewById(R.id.character_view_intelligence_mod);
        IntelligenceMod.setText(String.valueOf(CurrentCharacter.getAbilityMod(Constants.Intelligence)));

        TextView IntelligenceSave = view.findViewById(R.id.character_view_intelligence_save);
        IntelligenceSave.setText(String.valueOf(CurrentCharacter.getAbilityMod(Constants.Intelligence)));

        Log.d("Current Intelligence", String.valueOf(CurrentCharacter.getAbilityScore(Constants.Intelligence)));
    }

    public void loadWisdom(View view){
        TextView WisdomValue = view.findViewById(R.id.character_view_wisdom_value);
        WisdomValue.setText(String.valueOf(CurrentCharacter.getAbilityScore(Constants.Wisdom)));

        TextView WisdomMod = view.findViewById(R.id.character_view_wisdom_mod);
        WisdomMod.setText(String.valueOf(CurrentCharacter.getAbilityMod(Constants.Wisdom)));

        TextView WisdomSave = view.findViewById(R.id.character_view_wisdom_save);
        WisdomSave.setText(String.valueOf(CurrentCharacter.getAbilityMod(Constants.Wisdom)));

        Log.d("Current Wisdom", String.valueOf(CurrentCharacter.getAbilityScore(Constants.Wisdom)));
    }

    public void loadCharisma(View view){
        TextView CharismaValue = view.findViewById(R.id.character_view_charisma_value);
        CharismaValue.setText(String.valueOf(CurrentCharacter.getAbilityScore(Constants.Charisma)));

        TextView CharismaMod = view.findViewById(R.id.character_view_charisma_mod);
        CharismaMod.setText(String.valueOf(CurrentCharacter.getAbilityMod(Constants.Charisma)));

        TextView CharismaSave = view.findViewById(R.id.character_view_charisma_save);
        CharismaSave.setText(String.valueOf(CurrentCharacter.getAbilityMod(Constants.Charisma)));

        Log.d("Current Charisma", String.valueOf(CurrentCharacter.getAbilityScore(Constants.Charisma)));
    }

    @Override
    public void onDestroyView() {
        if(CurrentCharacter != null)
            Methods.saveCharacter(requireContext(), CurrentCharacter);
        super.onDestroyView();
        binding = null;
    }
}