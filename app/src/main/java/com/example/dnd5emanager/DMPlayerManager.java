package com.example.dnd5emanager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.DmPlayerManagerBinding;


import java.util.ArrayList;
import java.util.List;


public class DMPlayerManager extends Fragment {

    private DmPlayerManagerBinding binding;


    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container
            ) {

        binding = DmPlayerManagerBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        binding.toSheet.setOnClickListener(v ->
//                NavHostFragment.findNavController(DMPlayerManager.this).navigate(R.id.goToCampaignSheet));
//        binding.dpmToMain.setOnClickListener(v ->
//                NavHostFragment.findNavController(DMPlayerManager.this).navigate(R.id.action_DMManager_to_campaignList));

    }

    public static ArrayList<PlayerCharacter> Characters = new ArrayList<PlayerCharacter>(List.of(new PlayerCharacter()));

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
