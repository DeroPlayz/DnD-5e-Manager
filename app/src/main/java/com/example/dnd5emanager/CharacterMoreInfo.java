package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.CurrentCharacter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.Methods;
import com.example.dnd5emanager.databinding.CharacterMoreInfoBinding;

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

        TextView About = view.findViewById(R.id.character_more_info_about);
        TextView Personality = view.findViewById(R.id.character_more_info_personality);
        TextView Bonds = view.findViewById(R.id.character_more_info_bonds);
        TextView Ideals = view.findViewById(R.id.character_more_info_ideals);
        TextView Flaws = view.findViewById(R.id.character_more_info_flaws);
        String AboutVal = "About: " +  CurrentCharacter.getAbout();
        String PersonalityVal = "Personality Traits: " + CurrentCharacter.getPersonality();
        String BondsVal = "Bonds: " + CurrentCharacter.getBonds();
        String IdealsVal = "Ideals: " + CurrentCharacter.getIdeals();
        String FlawsVal = "Flaws: " + CurrentCharacter.getFlaws();

        About.setText(AboutVal);
        Personality.setText(PersonalityVal);
        Bonds.setText(BondsVal);
        Ideals.setText(IdealsVal);
        Flaws.setText(FlawsVal);

        final boolean[] inEditMode = {false};

        AlertDialog.Builder LoreEditor = new AlertDialog.Builder(requireContext());

        binding.characterMoreInfoAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inEditMode[0]) {
                    Log.d("Editing Lore", "About");
                    EditText EditAbout = new EditText(getContext());
                    EditAbout.setText(About.getText().toString().replace("About: ", ""));
                    LoreEditor.setView(EditAbout);
                    LoreEditor.show();
                    LoreEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            About.setText("About: " + EditAbout.getText());
                            CurrentCharacter.setAbout(EditAbout.getText().toString());
                        }
                    });
                }
            }
        });

        binding.characterMoreInfoPersonality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inEditMode[0]) {
                    Log.d("Editing Lore", "Personality");
                    EditText EditPersonality = new EditText(getContext());
                    EditPersonality.setText(Personality.getText().toString().replace("Personality Traits: ", ""));
                    LoreEditor.setView(EditPersonality);
                    LoreEditor.show();
                    LoreEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            Personality.setText("Personality Traits: " + EditPersonality.getText());
                            CurrentCharacter.setPersonality(EditPersonality.getText().toString());
                        }
                    });
                }
            }
        });

        binding.characterMoreInfoBonds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inEditMode[0]) {
                    Log.d("Editing Lore", "Bonds");
                    EditText EditBonds = new EditText(getContext());
                    EditBonds.setText(Bonds.getText().toString().replace("Bonds: ", ""));
                    LoreEditor.setView(EditBonds);
                    LoreEditor.show();
                    LoreEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            Bonds.setText("Bonds: " + EditBonds.getText());
                            CurrentCharacter.setBonds(EditBonds.getText().toString());
                        }
                    });
                }
            }
        });

        binding.characterMoreInfoIdeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inEditMode[0]) {
                    Log.d("Editing Lore", "Ideals");
                    EditText EditIdeals = new EditText(getContext());
                    EditIdeals.setText(Ideals.getText().toString().replace("Ideals: ", ""));
                    LoreEditor.setView(EditIdeals);
                    LoreEditor.show();
                    LoreEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            Ideals.setText("Ideals: " + EditIdeals.getText());
                            CurrentCharacter.setIdeals(EditIdeals.getText().toString());
                        }
                    });
                }
            }
        });

        binding.characterMoreInfoFlaws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inEditMode[0]) {
                    Log.d("Editing Lore", "Flaws");
                    EditText EditFlaws = new EditText(getContext());
                    EditFlaws.setText(Flaws.getText().toString().replace("Flaws: ", ""));
                    LoreEditor.setView(EditFlaws);
                    LoreEditor.show();
                    LoreEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            Flaws.setText("Flaws: " + EditFlaws.getText());
                            CurrentCharacter.setFlaws(EditFlaws.getText().toString());
                        }
                    });
                }
            }
        });

        binding.characterMoreInfoBackButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterMoreInfo.this).navigate(R.id.goToCharacterView);
        });

        binding.characterMoreInfoEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!inEditMode[0]){
                    inEditMode[0] = true;
                }
                else if(inEditMode[0]){
                    inEditMode[0] = false;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}