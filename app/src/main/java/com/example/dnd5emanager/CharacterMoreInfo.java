package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.Backgrounds;
import static com.example.dnd5emanager.DataClasses.Constants.CurrentCharacter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.Background;
import com.example.dnd5emanager.DataClasses.Constants;
import com.example.dnd5emanager.databinding.CharacterMoreInfoBinding;

import java.util.ArrayList;
import java.util.Arrays;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link ThirdFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class CharacterMoreInfo extends Fragment {
    private CharacterMoreInfoBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = CharacterMoreInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView Racial_Strength = view.findViewById(R.id.racial_strength);
        String RacialStrength = "Racial Strength: +" + CurrentCharacter.getRace().getAbilityBonus(Constants.Strength);
        Racial_Strength.setText(RacialStrength);

        TextView Racial_Dexterity = view.findViewById(R.id.racial_dexterity);
        String RacialDexterity = "Racial Dexterity: +" + CurrentCharacter.getRace().getAbilityBonus(Constants.Dexterity);
        Racial_Dexterity.setText(RacialDexterity);

        TextView Racial_Constitution = view.findViewById(R.id.racial_constitution);
        String RacialConstitution = "Racial Constitution: +" + CurrentCharacter.getRace().getAbilityBonus(Constants.Constitution);
        Racial_Constitution.setText(RacialConstitution);

        TextView Racial_Intelligence = view.findViewById(R.id.racial_intelligence);
        String RacialIntelligence = "Racial Intelligence: +" + CurrentCharacter.getRace().getAbilityBonus(Constants.Intelligence);
        Racial_Intelligence.setText(RacialIntelligence);

        TextView Racial_Wisdom = view.findViewById(R.id.racial_wisdom);
        String RacialWisdom = "Racial Wisdom: +" + CurrentCharacter.getRace().getAbilityBonus(Constants.Wisdom);
        Racial_Wisdom.setText(RacialWisdom);

        TextView Racial_Charisma = view.findViewById(R.id.racial_charisma);
        String RacialCharisma = "Racial Charisma: +" + CurrentCharacter.getRace().getAbilityBonus(Constants.Charisma);
        Racial_Charisma.setText(RacialCharisma);

        TextView ASI_Strength = view.findViewById(R.id.asi_strength);
        String ASIStrength = "ASI Strength: +" + CurrentCharacter.getRace().getAbilityBonus(Constants.Strength);
        ASI_Strength.setText(ASIStrength);

        TextView ASI_Dexterity = view.findViewById(R.id.asi_dexterity);
        String ASIDexterity = "ASI Dexterity: +" + CurrentCharacter.getRace().getAbilityBonus(Constants.Dexterity);
        ASI_Dexterity.setText(ASIDexterity);

        TextView ASI_Constitution = view.findViewById(R.id.asi_constitution);
        String ASIConstitution = "ASI Constitution: +" + CurrentCharacter.getRace().getAbilityBonus(Constants.Constitution);
        ASI_Constitution.setText(ASIConstitution);

        TextView ASI_Intelligence = view.findViewById(R.id.asi_intelligence);
        String ASIIntelligence = "ASI Intelligence: +" + CurrentCharacter.getRace().getAbilityBonus(Constants.Intelligence);
        ASI_Intelligence.setText(ASIIntelligence);

        TextView ASI_Wisdom = view.findViewById(R.id.asi_wisdom);
        String ASIWisdom = "ASI Wisdom: +" + CurrentCharacter.getRace().getAbilityBonus(Constants.Wisdom);
        ASI_Wisdom.setText(ASIWisdom);

        TextView ASI_Charisma = view.findViewById(R.id.asi_charisma);
        String ASICharisma = "ASI Charisma: +" + CurrentCharacter.getRace().getAbilityBonus(Constants.Charisma);
        ASI_Charisma.setText(ASICharisma);

        TextView About = view.findViewById(R.id.character_more_info_about);
        TextView Personality = view.findViewById(R.id.character_more_info_personality);
        TextView Bonds = view.findViewById(R.id.character_more_info_bonds);
        TextView Ideals = view.findViewById(R.id.character_more_info_ideals);
        TextView Flaws = view.findViewById(R.id.character_more_info_flaws);
        TextView Background = view.findViewById(R.id.character_more_info_background);
        TextView Alignment = view.findViewById(R.id.character_more_info_alignment);

        String AboutVal = "About: " +  CurrentCharacter.getAbout();
        String PersonalityVal = "Personality Traits: " + CurrentCharacter.getPersonality();
        String BondsVal = "Bonds: " + CurrentCharacter.getBonds();
        String IdealsVal = "Ideals: " + CurrentCharacter.getIdeals();
        String FlawsVal = "Flaws: " + CurrentCharacter.getFlaws();
        String BackgroundVal = "Background: " + CurrentCharacter.getBackground();
        String AlignmentVal = "Alignment: " + CurrentCharacter.getAlignment();

        About.setText(AboutVal);
        Personality.setText(PersonalityVal);
        Bonds.setText(BondsVal);
        Ideals.setText(IdealsVal);
        Flaws.setText(FlawsVal);
        Background.setText(BackgroundVal);
        Alignment.setText(AlignmentVal);

        AlertDialog.Builder LoreEditor = new AlertDialog.Builder(requireContext());

        binding.characterMoreInfoAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.d("Editing Lore", "About");
                    EditText EditAbout = new EditText(getContext());
                    EditAbout.setText(About.getText().toString().replace("About: ", ""));
                    LoreEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            String Text = "About: " + EditAbout.getText().toString();
                            About.setText(Text);
                            CurrentCharacter.setAbout(EditAbout.getText().toString());
                        }
                    });
                    LoreEditor.setView(EditAbout);
                    LoreEditor.show();
            }
        });

        binding.characterMoreInfoPersonality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.d("Editing Lore", "Personality");
                    EditText EditPersonality = new EditText(getContext());
                    EditPersonality.setText(Personality.getText().toString().replace("Personality Traits: ", ""));
                    LoreEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            String Text = "Personality Traits: " + EditPersonality.getText().toString();
                            Personality.setText(Text);
                            CurrentCharacter.setPersonality(EditPersonality.getText().toString());
                        }
                    });
                    LoreEditor.setView(EditPersonality);
                    LoreEditor.show();
            }
        });

        binding.characterMoreInfoBonds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.d("Editing Lore", "Bonds");
                    EditText EditBonds = new EditText(getContext());
                    EditBonds.setText(Bonds.getText().toString().replace("Bonds: ", ""));
                    LoreEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            String Text = "Bonds: " + EditBonds.getText().toString();
                            Bonds.setText(Text);
                            CurrentCharacter.setBonds(EditBonds.getText().toString());
                        }
                    });
                    LoreEditor.setView(EditBonds);
                    LoreEditor.show();
            }
        });

        binding.characterMoreInfoIdeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.d("Editing Lore", "Ideals");
                    EditText EditIdeals = new EditText(getContext());
                    EditIdeals.setText(Ideals.getText().toString().replace("Ideals: ", ""));
                    LoreEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            String Text = "Ideals: " + EditIdeals.getText().toString();
                            Ideals.setText(Text);
                            CurrentCharacter.setIdeals(EditIdeals.getText().toString());
                        }
                    });
                    LoreEditor.setView(EditIdeals);
                    LoreEditor.show();
            }
        });

        binding.characterMoreInfoFlaws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.d("Editing Lore", "Flaws");
                    EditText EditFlaws = new EditText(getContext());
                    EditFlaws.setText(Flaws.getText().toString().replace("Flaws: ", ""));
                    LoreEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            String Text = "Flaws: " + EditFlaws.getText().toString();
                            Flaws.setText(Text);
                            CurrentCharacter.setFlaws(EditFlaws.getText().toString());
                        }
                    });
                    LoreEditor.setView(EditFlaws);
                    LoreEditor.show();
            }
        });

        binding.characterMoreInfoBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Editing Lore", "Background");
                Spinner EditBackground = new Spinner(getContext());
                ArrayList<Background> BackgroundAL = new ArrayList<Background>(Arrays.asList(Backgrounds.values().toArray(new Background[0])));
                String[] BackgroundNames = new String[BackgroundAL.size()];
                for(int i = 0; i < BackgroundNames.length; i++){
                    BackgroundNames[i] = BackgroundAL.get(i).getName();
                }
                Arrays.sort(BackgroundNames);
                ArrayAdapter<String> BackgroundAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, BackgroundNames);
                BackgroundAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                EditBackground.setAdapter(BackgroundAdapter);
                LoreEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        Background.setText("Background: " + EditBackground.getSelectedItem().toString());
                        CurrentCharacter.setBackground(EditBackground.getSelectedItem().toString());
                    }
                });
                LoreEditor.setView(EditBackground);
                LoreEditor.show();
            }
        });

        binding.characterMoreInfoAlignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Editing Lore", "Alignment");
                Spinner EditAlignment = new Spinner(getContext());
                String[] Alignments = {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
                ArrayAdapter<String> AlignmentAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, Alignments);
                AlignmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                EditAlignment.setAdapter(AlignmentAdapter);
                LoreEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        Alignment.setText("Alignment: " + EditAlignment.getSelectedItem().toString());
                        CurrentCharacter.setBackground(EditAlignment.getSelectedItem().toString());
                    }
                });
                LoreEditor.setView(EditAlignment);
                LoreEditor.show();
            }
        });

        binding.characterMoreInfoBackButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterMoreInfo.this).navigate(R.id.goToCharacterView);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}