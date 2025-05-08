package com.example.dnd5emanager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.dnd5emanager.DataClasses.PlayerCharacter;

import com.example.dnd5emanager.databinding.DataViewBinding;


import java.util.ArrayList;
import java.util.List;

public class DataView extends Fragment {

    private DataViewBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = DataViewBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.dataViewBack.setOnClickListener(v ->
                NavHostFragment.findNavController(DataView.this).navigate(R.id.goToMainMenu));
        binding.spellsinfo.setOnClickListener(v ->
                NavHostFragment.findNavController(DataView.this).navigate(R.id.goTospellsInformation));
        binding.weaponsinfo.setOnClickListener(v ->
                NavHostFragment.findNavController(DataView.this).navigate(R.id.goToweaponsInfomration));
        binding.armorinfo.setOnClickListener(v ->
                NavHostFragment.findNavController(DataView.this).navigate(R.id.goToarmorInformation));
    }

    public static ArrayList<PlayerCharacter> Characters = new ArrayList<PlayerCharacter>(List.of(new PlayerCharacter()));

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

