package com.example.dnd5emanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.CharacterViewBinding;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link ThirdFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class CharacterView extends Fragment {
    private CharacterViewBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = CharacterViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int CharNum = MainMenu.Characters.size()-1;

        TextView CharacterName = view.findViewById(R.id.characterName);
        CharacterName.setText(CharacterCreatorPageOne.NewCharacter.getName());

        TextView CharacterLevel = view.findViewById(R.id.characterLevel);
        String LevelDisp = "";
        LevelDisp += "Level " + CharacterCreatorPageOne.NewCharacter.getLevel() + " ";
        if(CharacterCreatorPageOne.NewCharacter.getClasses().get(0).getSubclass().getName() != CharacterCreatorPageOne.NewCharacter.getClasses().get(0).getCharClass().getName()){
            LevelDisp += CharacterCreatorPageOne.NewCharacter.getClasses().get(0).getSubclass().getName() + " ";
        }
        LevelDisp += CharacterCreatorPageOne.NewCharacter.getClasses().get(0).getCharClass().getName();

        CharacterLevel.setText(LevelDisp);

    }

    @Override
    public void onDestroyView() {
        CharacterCreatorPageOne.NewCharacter = new PlayerCharacter();
        super.onDestroyView();
        binding = null;
    }
}
