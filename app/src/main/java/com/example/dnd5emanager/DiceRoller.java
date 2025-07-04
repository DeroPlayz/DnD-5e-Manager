package com.example.dnd5emanager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.*;
import android.view.animation.*;
import android.widget.ImageView;

import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.*;

import java.util.*;

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
    public static int rollDice(int count, int sides){
        int[] dice = new int[count];
        for (int i = 0; i < 4; i++) {
            dice[i] = (int) (Math.random() * sides) + 1;
        }
        int total = 0;
        for (int i = 0; i < dice.length; i++) {
            total += dice[i];
        }
        return total;
    }
    private void rotateDice6() {
        int i = random.nextInt(6)+1;
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
    private void rotateDice8() {
        int i = random.nextInt(8)+1;
        Animation anim = AnimationUtils.loadAnimation(diceImage.getContext(), R.anim.rotate);
        diceImage.startAnimation(anim);
        switch(i){
            case 1:
                diceImage.setImageResource(R.drawable.eightsidedsideone);
                break;
            case 2:
                diceImage.setImageResource(R.drawable.eightsidedsidetwo);
                break;
            case 3:
                diceImage.setImageResource(R.drawable.eightsidedsidethree);
                break;
            case 4:
                diceImage.setImageResource(R.drawable.eightsidedsidefour);
                break;
            case 5:
                diceImage.setImageResource(R.drawable.eightsidedsidefive);
                break;
            case 6:
                diceImage.setImageResource(R.drawable.eightsidedsidesix);
                break;
            case 7:
                diceImage.setImageResource(R.drawable.eightsidedsideseven);
                break;
            case 8:
                diceImage.setImageResource(R.drawable.eightsidedsideeight);
                break;
        }
    }
    private void rotateDice10() {
        int i = random.nextInt(10)+1;
        Animation anim = AnimationUtils.loadAnimation(diceImage.getContext(), R.anim.rotate);

        diceImage.startAnimation(anim);
        switch(i){
            case 1:
                diceImage.setImageResource(R.drawable.tensidedsideone);
                break;
            case 2:
                diceImage.setImageResource(R.drawable.tensidedsidetwo);
                break;
            case 3:
                diceImage.setImageResource(R.drawable.tensidedsidethree);
                break;
            case 4:
                diceImage.setImageResource(R.drawable.tensidedsidefour);
                break;
            case 5:
                diceImage.setImageResource(R.drawable.tensidedsidefive);
                break;
            case 6:
                diceImage.setImageResource(R.drawable.tensidedsidesix);
                break;
            case 7:
                diceImage.setImageResource(R.drawable.tensidedsideseven);
                break;
            case 8:
                diceImage.setImageResource(R.drawable.tensidedsideeight);
                break;
            case 9:
                diceImage.setImageResource(R.drawable.tensidedsidenine);
                break;
            case 10:
                diceImage.setImageResource(R.drawable.tensidedsideten);
                break;

        }
    }
    private void rotateDice12() {
        int i = random.nextInt(12)+1;
        Animation anim = AnimationUtils.loadAnimation(diceImage.getContext(), R.anim.rotate);
        diceImage.startAnimation(anim);
        switch(i){
            case 1:
                diceImage.setImageResource(R.drawable.twelvesidedsideone);
                break;
            case 2:
                diceImage.setImageResource(R.drawable.twelvesidedsidetwo);
                break;
            case 3:
                diceImage.setImageResource(R.drawable.twelvesidedsidethree);
                break;
            case 4:
                diceImage.setImageResource(R.drawable.twelvesidedsidefour);
                break;
            case 5:
                diceImage.setImageResource(R.drawable.twelvesidedsidefive);
                break;
            case 6:
                diceImage.setImageResource(R.drawable.twelvesidedsidesix);
                break;
            case 7:
                diceImage.setImageResource(R.drawable.twelvesidedsideseven);
                break;
            case 8:
                diceImage.setImageResource(R.drawable.twelvesidedsideeight);
                break;
            case 9:
                diceImage.setImageResource(R.drawable.twelvesidedsidenine);
                break;
            case 10:
                diceImage.setImageResource(R.drawable.twelvesidedsideten);
                break;
            case 11:
                diceImage.setImageResource(R.drawable.twelvesidedsideeleven);
                break;
            case 12:
                diceImage.setImageResource(R.drawable.twelvesidedsidetwelve);
                break;

        }
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.diceRollerBack.setOnClickListener(v ->
                NavHostFragment.findNavController(DiceRoller.this).navigate(R.id.goToMainMenu));

        diceImage = view.findViewById(R.id.dice_image);


        binding.sixSide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                rotateDice6();
            }
        });
        binding.eightSide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                rotateDice8();
            }
        });
        binding.tenSide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                rotateDice10();
            }
        });
        binding.twelveSide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                rotateDice12();
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


