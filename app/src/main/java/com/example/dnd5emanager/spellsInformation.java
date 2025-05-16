package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.Spells;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.Spell;
import com.example.dnd5emanager.databinding.SpellsInformationBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class spellsInformation extends Fragment {

    private SpellsInformationBinding binding;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = SpellsInformationBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] SpellNames = Spells.keySet().toArray(new String[0]);
        Arrays.sort(SpellNames);

        Spinner SpellSelected = view.findViewById(R.id.spellSelector);
        ArrayAdapter<String> spellAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, SpellNames);
        spellAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpellSelected.setAdapter(spellAdapter);

        TextView SchoolAndStrength = view.findViewById(R.id.spellSchool);
        TextView CastingTime = view.findViewById(R.id.spellCastingTime);
        TextView Range = view.findViewById(R.id.spellRange);
        TextView Description = view.findViewById(R.id.spellDescription);
        TextView SupportedClasses = view.findViewById(R.id.supportedClasses);
        TextView Components = view.findViewById(R.id.spellComponents);
        TextView Materials = view.findViewById(R.id.spellMaterials);

        SpellSelected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spell SelectedSpell = Spells.get(SpellSelected.getSelectedItem().toString());
                if (CastingTime != null) {
                    String CastTime = getString(R.string.colon_casting_time) + " " + SelectedSpell.getCastTime();
                    CastingTime.setText(CastTime);
                }
                if (Range != null) {
                    String SpellRange = getString(R.string.word_range) + " " + SelectedSpell.getRange();
                    Range.setText(SpellRange);
                }
                if (Description != null) {
                    Description.setText(SelectedSpell.getDescription());
                }
                if (SupportedClasses != null) {
                    String Classes = getString(R.string.phrase_supported_classes) + " " + Arrays.toString(SelectedSpell.getClasses());
                    SupportedClasses.setText(Classes);
                }
                if (Components != null) {
                    ArrayList<String> CompArray = new ArrayList<>();
                    String Comp = getString(R.string.colon_components) + " ";
                    if(SelectedSpell.getVerbal()){
                        CompArray.add(getString(R.string.word_verbal));
                    }
                    if(SelectedSpell.getSomatic()){
                        CompArray.add(getString(R.string.word_somatic));
                    }
                    if(SelectedSpell.getMaterial()) {
                        CompArray.add(getString(R.string.word_material));
                    }
                    Comp += Arrays.toString(CompArray.toArray());
                    Components.setText(Comp);
                }
                if (Materials != null) {
                    String Mats = getString(R.string.colon_materials) + " " + SelectedSpell.getMaterialCost();
                    Materials.setText(Mats);
                }
                if(SchoolAndStrength != null){
                    String School = SelectedSpell.getSchool();
                    String Level = "";

                    String FinalString = "";

                    if(SelectedSpell.getLevel() == 0){
                        Level = "Cantrip";
                        FinalString = School.substring(0,1).toUpperCase() + School.substring(1) + " Cantrip";
                    }

                    else{
                        if(SelectedSpell.getLevel() == 1){
                            Level = "1st Level";
                        }
                        else if(SelectedSpell.getLevel() == 2){
                            Level = "2nd Level";
                        }
                        else if(SelectedSpell.getLevel() == 3){
                            Level = "3rd Level";
                        }
                        else {
                            Level = SelectedSpell.getLevel() + "th Level";
                        }
                        FinalString = Level + " " + School.substring(0,1).toUpperCase() + School.substring(1);
                    }

                    SchoolAndStrength.setText(FinalString);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.backtodataview.setOnClickListener(v ->
                NavHostFragment.findNavController(spellsInformation.this).navigate(R.id.goToData));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
