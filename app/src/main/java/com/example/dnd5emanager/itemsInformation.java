package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.Items;

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

import com.example.dnd5emanager.DataClasses.Item;
import com.example.dnd5emanager.databinding.ItemsInformationBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class itemsInformation extends Fragment {
private ItemsInformationBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = ItemsInformationBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] ItemNames = Items.keySet().toArray(new String[0]);
        Arrays.sort(ItemNames);

        Spinner ItemSelected = view.findViewById(R.id.weaponSelector);
        ArrayAdapter<String> weaponAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, ItemNames);
        weaponAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ItemSelected.setAdapter(weaponAdapter);

        TextView Rarity = view.findViewById(R.id.itemRarity);
        TextView Description = view.findViewById(R.id.itemDescription);
        TextView Type = view.findViewById(R.id.itemType);
        TextView Value = view.findViewById(R.id.itemValue);
        TextView Weight = view.findViewById(R.id.itemWeight);
        TextView Tags = view.findViewById(R.id.itemTags);

        ItemSelected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Item SelectedItem = Items.get(ItemSelected.getSelectedItem().toString());

                if (Description != null) {
                    String Desc = getString(R.string.colon_description) + " " + SelectedItem.getDescription();
                    Description.setText(Desc);
                }
                if (Rarity != null) {
                    String RarityStr = getString(R.string.colon_rarity) + " " + SelectedItem.getRarity();
                    Rarity.setText(RarityStr);
                }
                if (Value != null) {
                    String Val = getString(R.string.colon_value) + " " + SelectedItem.getValue() + " " + SelectedItem.getCoinType();
                    Value.setText(Val);
                }
                if (Type != null) {
                    String TypeStr = getString(R.string.colon_type) + " " + SelectedItem.getType();
                    Type.setText(TypeStr);
                }
                if (Weight != null) {
                    String Wt = getString(R.string.colon_weight) + " " + SelectedItem.getWeight() + " " + SelectedItem.getWeightUnit();
                    Weight.setText(Wt);
                }
                if (Tags != null) {
                    ArrayList<String> TagList = new ArrayList<>();
                    if (SelectedItem.isAmmo()) {
                        TagList.add("Ammo");
                    }
                    if (SelectedItem.isCursed()) {
                        TagList.add("Cursed");
                    }
                    if (SelectedItem.isMagic()) {
                        TagList.add("Magic");
                    }
                    if (SelectedItem.isEquipment()) {
                        TagList.add("Equipment");
                    }
                    if (SelectedItem.isSpellcastingFocus()) {
                        TagList.add("Spellcasting Focus");
                    }
                    if (SelectedItem.isTemplate()) {
                        TagList.add("Template");
                    }
                    if (SelectedItem.isValueMultiplier()) {
                        TagList.add("Value Multiplier");
                    }
                    if (SelectedItem.isWeightMultiplier()) {
                        TagList.add("Weight Multiplier");
                    }
                    if (SelectedItem.isRequiresAttunement()) {
                        TagList.add("Requires Attunement");
                    }
                    ArrayList<String> TagsFormatted = new ArrayList<>();
                    for (int i = 0; i < TagList.size(); i++) {
                        TagsFormatted.add("\n");
                        TagsFormatted.add(TagList.get(i).replace(" ", "-"));
                    }

                    String TagsStr = getString(R.string.colon_tag) + " " + Arrays.toString(TagsFormatted.toArray());
                    TagsStr = TagsStr.replace("[", "");
                    TagsStr = TagsStr.replace("]", "");
                    TagsStr = TagsStr.replace(",", "");
                    TagsStr = TagsStr.replace(" ", "");
                    TagsStr = TagsStr.replace("-", " ");
                    Tags.setText(TagsStr);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        binding.backtodataview.setOnClickListener(v ->
                NavHostFragment.findNavController(itemsInformation.this).navigate(R.id.goToData));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
