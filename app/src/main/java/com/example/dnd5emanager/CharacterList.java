package com.example.dnd5emanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dnd5emanager.databinding.CharacterListBinding;

public class CharacterList extends Fragment {

    private CharacterListBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CharacterListBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.characterListBackButton.setOnClickListener(v ->
                NavHostFragment.findNavController(CharacterList.this)
                        .navigate(R.id.goToMainMenu)
        );
//        binding.characterListViewCharacterDemo.setOnClickListener(v ->
//                NavHostFragment.findNavController(CharacterList.this)
//                        .navigate(R.id.goToCharacterView)
//        );
        binding.characterListMakeNewCharacter.setOnClickListener(v ->
                NavHostFragment.findNavController(CharacterList.this)
                        .navigate(R.id.goToCharacterCreatorPageOne)
        );

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}