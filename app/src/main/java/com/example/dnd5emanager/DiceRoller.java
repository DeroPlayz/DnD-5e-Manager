package com.example.dnd5emanager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.DataViewBinding;
import com.example.dnd5emanager.databinding.DiceRollerBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DiceRoller extends Fragment {
    private DiceRollerBinding binding;
    ImageView diceImage;
    Random random = new Random();

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    )
    {

        binding = com.example.dnd5emanager.databinding.DiceRollerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    private void rotateDice() {
        int i = random.nextInt(5)+1;
        Animation anim = AnimationUtils.loadAnimation(diceImage.getContext(), R.anim.rotate);
        diceImage.startAnimation(anim);
        switch(i){
            case 1:
                diceImage.setImageResource(R.drawable.dice1);
                break;
            case 2:
                diceImage.setImageResource(R.drawable.dice2);
                break;
            case 3:
                diceImage.setImageResource(R.drawable.dice3);
                break;
            case 4:
                diceImage.setImageResource(R.drawable.dice4);
                break;
            case 5:
                diceImage.setImageResource(R.drawable.dice5);
                break;
            case 6:
                diceImage.setImageResource(R.drawable.dice6);
                break;
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.diceRollerBack.setOnClickListener(v ->
                NavHostFragment.findNavController(DiceRoller.this).navigate(R.id.goToMainMenu));

        diceImage = view.findViewById(R.id.dice_image);

        diceImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                rotateDice();
            }
        });

    };

    public static ArrayList<PlayerCharacter> Characters = new ArrayList<PlayerCharacter>(List.of(new PlayerCharacter()));

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}


