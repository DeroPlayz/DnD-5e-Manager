package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.Races;
import static com.example.dnd5emanager.DataClasses.Constants.Subraces;

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
    private Spinner Race;
    private Spinner Subrace;


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Resources resources = getResources();
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
                    for (int i = 0; i < Races.size(); i++) {
//                        Log.d("Race Name", String.valueOf(Race.getSelectedItem().toString()));
//                        Log.d("Current Iterated Race", String.valueOf(Constants.Races.get(i).getName()));
//                        Log.d("Matches?", String.valueOf(Race.getSelectedItem().toString().equals(Constants.Races.get(i).getName())));
                        if (Race.getSelectedItem().toString().equals(Races.get(i).getName())) {
                            Log.d("Has Subraces?", String.valueOf(Races.get(i).getHasSubraces()));
                            if(!Races.get(i).getHasSubraces()){
                                Subrace.setEnabled(false);
                                Subrace.setClickable(false);
                                Subrace.setVisibility(View.INVISIBLE);
                                Log.d("No Subraces", "This race has no subraces.");
                            }
                            else{
                                Log.d("Subraces", "This race has subraces.");
                                for(int j = 0; j < Subraces.size(); j++) {
                                    if (Subraces.get(j).getParentRace().getName().equals(Race.getSelectedItem().toString())) {
                                        Log.d("Current Subrace:", String.valueOf(Subraces.get(j).getName()));
                                        Adapter.add(Subraces.get(j).getName());
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
            NewCharacter.setName(Name.getText().toString());
            for(int i = 0; i < Races.size(); i++){
                if(Race.getSelectedItem().toString().equals(Races.get(i).getName())) {
                    NewCharacter.setRace(Races.get(i));
                }
            }
            if(NewCharacter.getRace().getHasSubraces()) {
                for(int i = 0; i < Subraces.size(); i++){
                    if(Subrace.getSelectedItem().toString().equals(Subraces.get(i).getName())) {
                        NewCharacter.setSubrace(Subraces.get(i));
                }
}
            }
//            Log.d("What his name SHOULD be:", Name.getText().toString());
//            Log.d("Guy Before:", CharacterCreatorPageOne.NewCharacter.getName());

            NavHostFragment.findNavController(CharacterCreatorPageOne.this).navigate(R.id.goToCharacterView);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}