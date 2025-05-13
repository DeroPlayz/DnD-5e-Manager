package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.Weapons;

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

import com.example.dnd5emanager.DataClasses.Weapon;
import com.example.dnd5emanager.databinding.WeaponsInformationBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class weaponsInformation extends Fragment {
private WeaponsInformationBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = WeaponsInformationBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] WeaponNames = Weapons.keySet().toArray(new String[0]);
        Arrays.sort(WeaponNames);

        Spinner WeaponSelected = view.findViewById(R.id.weaponSelector);
        ArrayAdapter<String> weaponAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, WeaponNames);
        weaponAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        WeaponSelected.setAdapter(weaponAdapter);

        TextView Damage = view.findViewById(R.id.weaponDamage);
        TextView Description = view.findViewById(R.id.weaponDescription);
        TextView Type = view.findViewById(R.id.weaponType);
        TextView Rarity = view.findViewById(R.id.weaponRarity);
        TextView Bonuses = view.findViewById(R.id.weaponBonuses);
        TextView Tags = view.findViewById(R.id.weaponTags);
        TextView Projectile = view.findViewById(R.id.weaponProjectile);

        WeaponSelected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Weapon SelectedWeapon = Weapons.get(WeaponSelected.getSelectedItem().toString());
                if (Damage != null) {
                    String DMG = getString(R.string.text_weapon_damage) + " " + SelectedWeapon.getDamage();
                    Damage.setText(DMG);
                }
                if (Description != null) {
                    String Desc = getString(R.string.text_weapon_description) + " " + SelectedWeapon.getDescription();
                    Description.setText(Desc);
                }
                if (Type != null) {
                    String TypeStr = getString(R.string.text_weapon_type) + " " + SelectedWeapon.getType();
                    Type.setText(TypeStr);
                }
                if (Rarity != null) {
                    String RarityStr = getString(R.string.text_weapon_rarity) + " " + SelectedWeapon.getRarity();
                    Rarity.setText(RarityStr);
                }
                if (Bonuses != null) {
                    String BonusesStr = getString(R.string.text_weapon_attack_bonus) + " " + SelectedWeapon.getAttackBonus();
//                    BonusesStr += "\n" + getString(R.string.text_weapon_damage_bonus) + " " + SelectedWeapon.
                    Bonuses.setText(BonusesStr);
                }
                if (Tags != null) {
                    ArrayList<String> TagList = new ArrayList<>();
                    if (SelectedWeapon.getSimple()) {
                        TagList.add("Simple");
                    }
                    if (SelectedWeapon.getFinesse()) {
                        TagList.add("Finesse");
                    }
                    if (SelectedWeapon.getVersatile()) {
                        TagList.add("Versatile");
                    }
                    if (SelectedWeapon.getLight()) {
                        TagList.add("Light");
                    }
                    if (SelectedWeapon.getHeavy()) {
                        TagList.add("Heavy");
                    }
                    if (SelectedWeapon.getSilver()) {
                        TagList.add("Silver");
                    }
                    if (SelectedWeapon.getTwoHanded()) {
                        TagList.add("Two-Handed");
                    }
                    if (SelectedWeapon.getRequiresAttunement()) {
                        TagList.add("Requires Attunement");
                    }
                    if (SelectedWeapon.getAttuned()) {
                        TagList.add("Attuned");
                    }
                    if (SelectedWeapon.getSpecial()) {
                        TagList.add("Special");
                    }
                    if (SelectedWeapon.getCustom()) {
                        TagList.add("Custom");
                    }
                    if (SelectedWeapon.getImprovised()) {
                        TagList.add("Improvised");
                    }
                    if (SelectedWeapon.getHasReach()) {
                        TagList.add("Reach");
                    }
                    if (SelectedWeapon.getRanged()) {
                        TagList.add("Ranged");
                    }
                    if (SelectedWeapon.getLoading()) {
                        TagList.add("Loading");
                    }
                    if (SelectedWeapon.getThrown()) {
                        TagList.add("Thrown");
                    }
                    ArrayList<String> TagsFormatted = new ArrayList<>();
                    for (int i = 0; i < TagList.size(); i++) {
                        TagsFormatted.add("\n");
                        TagsFormatted.add(TagList.get(i).replace(" ", "-"));
                    }

                    String TagsStr = getString(R.string.text_weapon_tag) + " " + Arrays.toString(TagsFormatted.toArray());
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
                NavHostFragment.findNavController(weaponsInformation.this).navigate(R.id.goToData));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
