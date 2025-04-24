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

        AlertDialog.Builder LoreEditor = new AlertDialog.Builder(requireContext());

//Log.d("Current About Edit", EditAbout.getText().toString());

        binding.characterMoreInfoAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.d("Editing Lore", "About");
                    EditText EditAbout = new EditText(getContext());
                    EditAbout.setText(About.getText().toString().replace("About: ", ""));
                    LoreEditor.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            About.setText("About: " + EditAbout.getText().toString());
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
                            Personality.setText("Personality Traits: " + EditPersonality.getText().toString());
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
                            Bonds.setText("Bonds: " + EditBonds.getText().toString());
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
                            Ideals.setText("Ideals: " + EditIdeals.getText().toString());
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
                            Flaws.setText("Flaws: " + EditFlaws.getText().toString());
                            CurrentCharacter.setFlaws(EditFlaws.getText().toString());
                        }
                    });
                    LoreEditor.setView(EditFlaws);
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