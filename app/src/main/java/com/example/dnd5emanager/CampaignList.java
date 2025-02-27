package com.example.dnd5emanager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.CampaignListBinding;
import com.example.dnd5emanager.databinding.DmManagerBinding;

import java.util.ArrayList;
import java.util.List;


public class CampaignList extends Fragment {

    private CampaignListBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CampaignListBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.campaignBack.setOnClickListener(v ->
                NavHostFragment.findNavController(CampaignList.this).navigate(R.id.action_campaignList_to_DMManager));
        binding.goplayerlist.setOnClickListener(v ->
                NavHostFragment.findNavController(CampaignList.this).navigate(R.id.action_campaignList_to_campaignSheet));
    }

    public static ArrayList<PlayerCharacter> Characters = new ArrayList<PlayerCharacter>(List.of(new PlayerCharacter()));

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}