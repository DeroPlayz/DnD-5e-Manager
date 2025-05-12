package com.example.dnd5emanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.CampaignSheetBinding;

import java.util.ArrayList;
import java.util.List;


public class CampaignSheet extends Fragment {

    private CampaignSheetBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CampaignSheetBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        binding.BackToList.setOnClickListener(v ->
//                NavHostFragment.findNavController(CampaignSheet .this).navigate(R.id.goToMainMenu));
//        binding.toPlayerManager.setOnClickListener(v ->
//                NavHostFragment.findNavController(CampaignSheet .this).navigate(R.id.goToDMPlayerManager));
    }

    public static ArrayList<PlayerCharacter> Characters = new ArrayList<PlayerCharacter>(List.of(new PlayerCharacter()));

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
