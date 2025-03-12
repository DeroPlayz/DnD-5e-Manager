package com.example.dnd5emanager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.HelpBinding;
import com.example.dnd5emanager.databinding.SettingsBinding;

import java.util.ArrayList;
import java.util.List;


public class Settings extends Fragment {

    private SettingsBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = SettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.SettingsBack.setOnClickListener(v ->
                NavHostFragment.findNavController(Settings.this).navigate(R.id.action_Settings_to_MainMenu));

    }

    public static ArrayList<PlayerCharacter> Characters = new ArrayList<PlayerCharacter>(List.of(new PlayerCharacter()));

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
