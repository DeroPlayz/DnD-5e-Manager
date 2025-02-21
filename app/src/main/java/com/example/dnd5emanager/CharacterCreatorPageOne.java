package com.example.dnd5emanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.ClassAndLevel;
import com.example.dnd5emanager.DataClasses.Constants;
import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.CharacterCreatorPageOneBinding;

public class CharacterCreatorPageOne extends Fragment {

    private CharacterCreatorPageOneBinding binding;
    static PlayerCharacter NewCharacter = new PlayerCharacter();

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = CharacterCreatorPageOneBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

//    private View.OnFocusChangeListener RaceListener(View view){
//        Spinner Race = view.findViewById(R.id.character_creator_page_one_select_race);
//        Spinner Subrace = view.findViewById(R.id.character_creator_page_one_select_subrace);
//        if(Race.getSelectedItem().toString().equals("Aarakocra")){
//            Subrace.setEnabled(false);
//            Subrace.setClickable(false);
//            Subrace.setVisibility(View.INVISIBLE);
//        };
//    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        EditText Name = view.findViewById(R.id.character_creator_page_one_enter_name);
        EditText Level = view.findViewById(R.id.character_creator_page_one_enter_level);
        Spinner Race = view.findViewById(R.id.character_creator_page_one_select_race);
        Spinner Subrace = view.findViewById(R.id.character_creator_page_one_select_subrace);
        Spinner Class = view.findViewById(R.id.character_creator_page_one_select_class);
        super.onViewCreated(view, savedInstanceState);
        View.OnFocusChangeListener onFocusChangeListener = null;
        binding.characterCreatorPageOneSelectRace.setOnFocusChangeListener(onFocusChangeListener);
        binding.characterCreatorPageOneViewCharacterDemo.setOnClickListener(v -> {
            NewCharacter.setName(Name.getText().toString());
            CharacterCreatorPageOne.NewCharacter.getClasses().add(new ClassAndLevel(Constants.findClass(Class.getSelectedItem().toString()), Integer.parseInt(Level.getText().toString())));

            NavHostFragment.findNavController(CharacterCreatorPageOne.this).navigate(R.id.goToCharacterView);
            }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}