package com.example.dnd5emanager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.ClassAndLevel;
import com.example.dnd5emanager.DataClasses.Constants;
import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.DataClasses.Subrace;
import com.example.dnd5emanager.databinding.CharacterCreatorPageOneBinding;

import java.util.ArrayList;
import java.util.List;

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

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        EditText Name = view.findViewById(R.id.character_creator_page_one_enter_name);
        EditText Level = view.findViewById(R.id.character_creator_page_one_enter_level);
        Spinner Race = view.findViewById(R.id.character_creator_page_one_select_race);
        Spinner Subrace = view.findViewById(R.id.character_creator_page_one_select_subrace);

        Spinner Class = view.findViewById(R.id.character_creator_page_one_select_class);
        super.onViewCreated(view, savedInstanceState);
        OnFocusChangeListener onFocusChangeListener = null;
        binding.characterCreatorPageOneSelectRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                android.content.res.Resources resources = getResources();

                if (Race != null) {
                    Subrace.setEnabled(true);
                    Subrace.setClickable(true);
                    Subrace.setVisibility(View.VISIBLE);
                    for (int i = 0; i < Constants.Races.size(); i++) {
                        Log.d("Race Name", String.valueOf(Race.getSelectedItem().toString()));
                        Log.d("Current Iterated Race", String.valueOf(Constants.Races.get(i).getName()));
                        Log.d("Matches?", String.valueOf(Race.getSelectedItem().toString().equals(Constants.Races.get(i).getName())));
                        if (Race.getSelectedItem().toString().equals(Constants.Races.get(i).getName())) {
                            if(!Constants.Races.get(i).getHasSubraces()){
                                Log.d("", "I have no idea what I'm doing.");
                                Subrace.setEnabled(false);
                                Subrace.setClickable(false);
                                Subrace.setVisibility(View.INVISIBLE);
                                ArrayList<Subrace> Selection = new ArrayList();
                                ArrayAdapter<Subrace> Adapter = new ArrayAdapter<Subrace>(getContext(), android.R.layout.simple_spinner_item, Selection);
                                Subrace.setAdapter(Adapter);
                                for(int j = 0; j < Constants.Subraces.size(); j++) {
                                    if (Constants.Subraces.get(j).getParentRace().getName().equals(Race.getSelectedItem().toString())) {
                                        Selection.add(Constants.Subraces.get(j));
                                    }
                                }
                                Adapter.clear();
                                Adapter.addAll(Selection);
                                Adapter.notifyDataSetChanged();
                            }
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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