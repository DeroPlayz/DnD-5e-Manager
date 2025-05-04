package com.example.dnd5emanager;

import static com.example.dnd5emanager.DataClasses.Constants.Characters;
import static com.example.dnd5emanager.DataClasses.Constants.CurrentCharacter;
import static com.example.dnd5emanager.DataClasses.Methods.LoadFromInternalStorage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
        //Finds the TextView element for the character name textbox.
        TextView CharacterName = view.findViewById(R.id.characterName);
        //Sets the textbox's value to the in-progress character's name.
        if(CurrentCharacter != null && CharacterName != null){
            CharacterName.setText(CurrentCharacter.getName());
        }
        binding.characterListMakeNewCharacter.setOnClickListener(v ->
                NavHostFragment.findNavController(CharacterList.this)
                        .navigate(R.id.goToCharacterCreatorPageOne)
        );

        LoadFromInternalStorage(requireContext());

        String[] CharacterNames = Characters.keySet().toArray(new String[0]);

        ScrollView character_list = view.findViewById(R.id.character_list);

        for(int i = 0; i < CharacterNames.length; i++){
            CardView CharCard = new CardView(requireContext());

            ConstraintLayout Constraint = new ConstraintLayout(requireContext());

            LayoutParams Wrap = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            LayoutParams Zero = new LayoutParams(0, 0);

            ImageView Icon = new ImageView(requireContext());
            Constraint.addView(Icon);
            Icon.setImageResource(R.drawable.person);
            Icon.setLayoutParams(Wrap);
            Icon.setTop(0);
            Icon.setBottom(0);
            Icon.setLeft(5);

            TextView Name = new TextView(requireContext());
            Constraint.addView(Name);
            Name.setText(CharacterNames[i]);
            Name.setLayoutParams(Zero);
            Name.setTop(10);
            Name.setLeft(10);

            TextView Race = new TextView(requireContext());
            Constraint.addView(Race);
            if(Characters.get(CharacterNames[i]).getRace().hasSubraces()){
                Race.setText(Characters.get(CharacterNames[i]).getSubrace().getName());
            }
            else{
                Race.setText(Characters.get(CharacterNames[i]).getRace().getName());
            }
            Race.setLayoutParams(Zero);
            Race.setTop(10);
            Race.setLeft(10);

            TextView Class = new TextView(requireContext());
            Constraint.addView(Class);
            String ClassString = "Level" + Characters.get(CharacterNames[i]).getLevel() + " " + Characters.get(CharacterNames[i]).getPrimaryClass().getSubclass().getName();
            Class.setText(ClassString);
            Class.setLayoutParams(Zero);
            Class.setTop(10);
            Class.setLeft(10);

            CharCard.setLayoutParams(Wrap);
            CharCard.setId(i);
            CharCard.addView(Constraint);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}