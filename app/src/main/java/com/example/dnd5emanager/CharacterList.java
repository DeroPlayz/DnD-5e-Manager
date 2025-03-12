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

        binding.characterListBack.setOnClickListener(v ->
                NavHostFragment.findNavController(CharacterList.this)
                        .navigate(R.id.action_CharacterList_to_MainMenu)
        );
        binding.characterListViewCharacterDemo.setOnClickListener(v ->
                NavHostFragment.findNavController(CharacterList.this)
                        .navigate(R.id.action_CharacterList_to_CharacterView)
        );
        binding.characterListMakeNewCharacter.setOnClickListener(v ->
                NavHostFragment.findNavController(CharacterList.this)
                        .navigate(R.id.action_CharacterList_to_CharacterCreatorPageOne)
        );

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}