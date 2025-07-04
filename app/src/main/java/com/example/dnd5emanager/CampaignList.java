package com.example.dnd5emanager;

import android.os.Bundle;
import android.view.*;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.CampaignListBinding;

import java.util.*;

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

//        binding.campaignBack.setOnClickListener(v ->
//                NavHostFragment.findNavController(CampaignList.this).navigate(R.id.goToMainMenu));
//        binding.goplayerlist.setOnClickListener(v ->
//                NavHostFragment.findNavController(CampaignList.this).navigate(R.id.goToDMManager));
    }

    public static ArrayList<PlayerCharacter> Characters = new ArrayList<PlayerCharacter>(List.of(new PlayerCharacter()));

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}