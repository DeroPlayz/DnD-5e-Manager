package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.CurrentCharacter;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

        EditText EditLore = new EditText(getContext());

        AlertDialog.Builder EditSelectedLore = new AlertDialog.Builder(getContext());
        EditSelectedLore.setView(EditLore);

        AlertDialog.Builder EditCategoryTitle = new AlertDialog.Builder(getContext());

        EditCategoryTitle.setItems(new String[]{"Edit About", "Edit Personality", "Edit Bonds", "Edit Ideals", "Edit Flaws"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditCategoryTitle.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        if(which == 0){
                            CurrentCharacter.setAbout(EditLore.getText().toString());
                            Log.d("CharacterMoreInfo", CurrentCharacter.getAbout());
                        }
                        else if(which == 1){
                            CurrentCharacter.setPersonality(EditLore.getText().toString());
                            Log.d("CharacterMoreInfo", CurrentCharacter.getPersonality());
                        }
                        else if(which == 2){
                            CurrentCharacter.setBonds(EditLore.getText().toString());
                            Log.d("CharacterMoreInfo", CurrentCharacter.getBonds());
                        }
                        else if(which == 3){
                            CurrentCharacter.setIdeals(EditLore.getText().toString());
                            Log.d("CharacterMoreInfo", CurrentCharacter.getIdeals());
                        }
                        else if(which == 4){
                            CurrentCharacter.setFlaws(EditLore.getText().toString());
                            Log.d("CharacterMoreInfo", CurrentCharacter.getFlaws());
                        }
                    }
                });
                if(which == 0){
                    EditLore.setText(CurrentCharacter.getAbout());
                    EditSelectedLore.show();
                }
                else if(which == 1){
                    EditLore.setText(CurrentCharacter.getPersonality());
                    EditSelectedLore.show();
                }
            }
        });


        AlertDialog EditChooseCategory = EditCategoryTitle.create();

        binding.characterMoreInfoBackButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterMoreInfo.this).navigate(R.id.goToCharacterView);
        });


        binding.characterMoreInfoEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(!inEditMode[0]){
//                    About.setEnabled(false);
//                    About.setClickable(false);
//                    About.setVisibility(View.INVISIBLE);
//                    Personality.setEnabled(false);
//                    Personality.setClickable(false);
//                    Personality.setVisibility(View.INVISIBLE);
//                    Bonds.setEnabled(false);
//                    Bonds.setClickable(false);
//                    Bonds.setVisibility(View.INVISIBLE);
//                    Ideals.setEnabled(false);
//                    Ideals.setClickable(false);
//                    Ideals.setVisibility(View.INVISIBLE);
//                    Flaws.setEnabled(false);
//                    Flaws.setClickable(false);
//                    Flaws.setVisibility(View.INVISIBLE);
//                    inEditMode[0] = true;
//                    EditChooseCategory.show();
//                }
//                else if(inEditMode[0]){
//                    About.setEnabled(true);
//                    About.setClickable(true);
//                    About.setVisibility(View.VISIBLE);
//                    Personality.setEnabled(true);
//                    Personality.setClickable(true);
//                    Personality.setVisibility(View.VISIBLE);
//                    Bonds.setEnabled(true);
//                    Bonds.setClickable(true);
//                    Bonds.setVisibility(View.VISIBLE);
//                    Ideals.setEnabled(true);
//                    Ideals.setClickable(true);
//                    Ideals.setVisibility(View.VISIBLE);
//                    Flaws.setEnabled(true);
//                    Flaws.setClickable(true);
//                    Flaws.setVisibility(View.VISIBLE);
//                    inEditMode[0] = false;
//                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}