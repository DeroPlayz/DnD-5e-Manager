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

        TextView CastingTime = view.findViewById(R.id.spellCastingTime);
        TextView Range = view.findViewById(R.id.spellRange);
        TextView Description = view.findViewById(R.id.SpellDescription);
        TextView SupportedClasses = view.findViewById(R.id.supportedClasses);
        TextView Components = view.findViewById(R.id.spellComponents);

        SpellSelected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spell SelectedSpell = Spells.get(SpellSelected.getSelectedItem().toString());
                if (CastingTime != null) {
                    CastingTime.setText(SelectedSpell.getCastTime());
                }
                if (Range != null) {
                    Range.setText(SelectedSpell.getRange());
                }
                if (Description != null) {
                    Description.setText(SelectedSpell.getDescription());
                }
                if (SupportedClasses != null) {
                    SupportedClasses.setText(Arrays.toString(SelectedSpell.getClasses()));
                }
                if (Components != null) {
                    Components.setText(SelectedSpell.getMaterialCost());
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
