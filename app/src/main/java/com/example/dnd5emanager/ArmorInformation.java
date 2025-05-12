package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.Armor;

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

import com.example.dnd5emanager.DataClasses.Armor;
import com.example.dnd5emanager.databinding.ArmorInformationBinding;

import java.util.Arrays;

public class ArmorInformation extends Fragment {
    private ArmorInformationBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = ArmorInformationBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] ArmorNames = Armor.keySet().toArray(new String[0]);
        Arrays.sort(ArmorNames);

        Spinner ArmorSelected = view.findViewById(R.id.armorSelector);
        ArrayAdapter<String> armorAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, ArmorNames);
        armorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArmorSelected.setAdapter(armorAdapter);

        TextView ArmorClass = view.findViewById(R.id.armorClass);
        TextView ArmorPrice = view.findViewById(R.id.armorPrice);
        TextView ArmorWeight = view.findViewById(R.id.armorWeight);
        TextView ArmorType = view.findViewById(R.id.armorType);

        ArmorSelected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Armor SelectedArmor = Armor.get(ArmorSelected.getSelectedItem().toString());
                if (ArmorClass != null) {
                    String AC = "Armor Class: " + SelectedArmor.getArmorClass();
                    if(!SelectedArmor.getModifierFormatted().isEmpty()){
                        AC += " + " + SelectedArmor.getModifierFormatted() + " Modifier";
                    }
                    if(SelectedArmor.getMaxModBonus() > 0){
                        AC += " (Max of " + SelectedArmor.getMaxModBonus() + ")";
                    }
                    ArmorClass.setText(AC);
                }
                if (ArmorPrice != null) {
                    ArmorPrice.setText("Price: " + SelectedArmor.getCost());
                }
                if (ArmorWeight != null) {
                    String Weight = "Weight:" + SelectedArmor.getWeight();
                    if(SelectedArmor.getStealthDisadvantage()){
                        Weight += " (Disadvantage on Stealth)";
                    }
                    ArmorWeight.setText(Weight);
                }
                if (ArmorType != null) {
                    ArmorType.setText("Type: " + SelectedArmor.getArmorType());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.backtodataview.setOnClickListener(v ->
                NavHostFragment.findNavController(ArmorInformation.this).navigate(R.id.goToData));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
