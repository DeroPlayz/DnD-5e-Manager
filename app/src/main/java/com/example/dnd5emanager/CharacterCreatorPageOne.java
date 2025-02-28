package com.example.dnd5emanager;

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

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.Constants;
import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.CharacterCreatorPageOneBinding;

import java.util.ArrayList;

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

    private EditText Name;
    private EditText Level;
    private Spinner Race;
    private Spinner Subrace;

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Resources resources = getResources();
        PlayerCharacter NewCharacter = new PlayerCharacter();
        Name = view.findViewById(R.id.character_creator_page_one_enter_name);
        Level = view.findViewById(R.id.character_creator_page_one_enter_level);
        Race = view.findViewById(R.id.character_creator_page_one_select_race);
        Subrace = view.findViewById(R.id.character_creator_page_one_select_subrace);

        ArrayList<String> Selection = new ArrayList<>();
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, Selection);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner Class = view.findViewById(R.id.character_creator_page_one_select_class);

        super.onViewCreated(view, savedInstanceState);
        OnFocusChangeListener onFocusChangeListener = null;
        binding.characterCreatorPageOneSelectRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (Race != null) {
                    Adapter.clear();
                    Subrace.setEnabled(true);
                    Subrace.setClickable(true);
                    Subrace.setVisibility(View.VISIBLE);
                    Subrace.setAdapter(Adapter);
                    for (int i = 0; i < Constants.Races.size(); i++) {
//                        Log.d("Race Name", String.valueOf(Race.getSelectedItem().toString()));
//                        Log.d("Current Iterated Race", String.valueOf(Constants.Races.get(i).getName()));
//                        Log.d("Matches?", String.valueOf(Race.getSelectedItem().toString().equals(Constants.Races.get(i).getName())));
                        if (Race.getSelectedItem().toString().equals(Constants.Races.get(i).getName())) {
                            Log.d("Has Subraces?", String.valueOf(Constants.Races.get(i).getHasSubraces()));
                            if(!Constants.Races.get(i).getHasSubraces()){
                                Subrace.setEnabled(false);
                                Subrace.setClickable(false);
                                Subrace.setVisibility(View.INVISIBLE);
                                Log.d("No Subraces", "This race has no subraces.");
                            }
                            else{
                                Log.d("Subraces", "This race has subraces.");
                                for(int j = 0; j < Constants.Subraces.size(); j++) {
                                    if (Constants.Subraces.get(j).getParentRace().getName().equals(Race.getSelectedItem().toString())) {
                                        Log.d("Current Subrace:", String.valueOf(Constants.Subraces.get(j).getName()));
                                        Adapter.add(Constants.Subraces.get(j).getName());
                                    }
                                }
                            }
                        }
                    }
//                    Log.d("Selection:", String.valueOf(Selection.toString()));
//                    Adapter.clear();                Log.d("Adapter Change", "Adapter cleared.");
//                    Adapter.addAll(Selection);      Log.d("Adapter Change", "Added all items from Selection.");
                    Adapter.notifyDataSetChanged(); Log.d("Adapter Change", "Notified adapter of data set change.");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.characterCreatorPageOneViewCharacterDemo.setOnClickListener(v -> {
            Log.d("FUCK!", "FUCK!");
//            NewCharacter.setName(Name.getText().toString());
//            NewCharacter.getClasses().add(new ClassAndLevel(Constants.findClass(Class.getSelectedItem().toString()), Integer.parseInt(Level.getText().toString())));
//            NewCharacter.setLevel(Integer.parseInt(String.valueOf(Level.getText())));
//            NewCharacter.setRace((com.example.dnd5emanager.DataClasses.Race) Race.getSelectedItem());
//            NewCharacter.setSubrace((com.example.dnd5emanager.DataClasses.Subrace) Subrace.getSelectedItem());

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