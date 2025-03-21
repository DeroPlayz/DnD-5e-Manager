package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.*;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.CharacterCreatorPageTwoBinding;

import java.util.ArrayList;

public class CharacterCreatorPageTwo extends Fragment {

    private CharacterCreatorPageTwoBinding binding;
    private EditText Bonds;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = CharacterCreatorPageTwoBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        binding.characterCreatorPageTwoBackButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterCreatorPageTwo.this).navigate(R.id.goToCharacterCreatorPageOne);
        });
        binding.toocharacterview.setOnClickListener(v -> {
            NavHostFragment.findNavController(CharacterCreatorPageTwo.this).navigate(R.id.goToCharacterView);
        });
        super.onViewCreated(view, savedInstanceState);

    }


    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}