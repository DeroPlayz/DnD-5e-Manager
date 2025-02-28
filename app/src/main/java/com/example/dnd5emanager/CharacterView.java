package com.example.dnd5emanager;

import static com.example.dnd5emanager.CharacterCreatorPageOne.NewCharacter;
import static com.example.dnd5emanager.DataClasses.Constants.Characters;

import android.os.Bundle;
import android.util.Log;
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
//        Log.d("Guy After:", CharacterCreatorPageOne.NewCharacter.getName());
        TextView CharacterName = view.findViewById(R.id.characterName);
        CharacterName.setText(NewCharacter.getName());

        TextView RaceDisplayer = view.findViewById(R.id.characterRace);
        String RaceDisp = "";
        if(NewCharacter.getRace().getHasSubraces()){
            RaceDisp += NewCharacter.getSubrace().getName() + " ";
        }
        RaceDisp += NewCharacter.getRace().getName();
        RaceDisplayer.setText(RaceDisp);

        TextView CharacterLevel = view.findViewById(R.id.characterLevel);
        String LevelDisp = "";
        LevelDisp += "Level " + NewCharacter.getLevel() + " ";
        CharacterLevel.setText(LevelDisp);

    }

    @Override
    public void onDestroyView() {
//        CharacterCreatorPageOne.NewCharacter = new PlayerCharacter();
        super.onDestroyView();
        binding = null;
    }
}
