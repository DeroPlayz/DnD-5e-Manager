package com.example.dnd5emanager;

import static com.example.dnd5emanager.MainMenu.CurrentCharacter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.dnd5emanager.databinding.CharacterMoreInfoBinding;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link ThirdFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class CharacterMoreInfo extends Fragment {
    private CharacterMoreInfoBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = CharacterMoreInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView About = view.findViewById(R.id.character_more_info_about);
        TextView Personality = view.findViewById(R.id.character_more_info_personality);
        TextView Bonds = view.findViewById(R.id.character_more_info_bonds);
        TextView Ideals = view.findViewById(R.id.character_more_info_ideals);
        TextView Flaws = view.findViewById(R.id.character_more_info_flaws);
        String AboutVal = "About: " +  CurrentCharacter.getAbout();
        String PersonalityVal = "Personality Traits: " + CurrentCharacter.getPersonality();
        String BondsVal = "Bonds: " + CurrentCharacter.getBonds();
        String IdealsVal = "Ideals: " + CurrentCharacter.getIdeals();
        String FlawsVal = "Flaws: " + CurrentCharacter.getFlaws();

        About.setText(AboutVal);
        Personality.setText(PersonalityVal);
        Bonds.setText(BondsVal);
        Ideals.setText(IdealsVal);
        Flaws.setText(FlawsVal);
        MainMenu.saveCharacter(requireContext(), CurrentCharacter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}