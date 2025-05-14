package com.example.dnd5emanager;

import android.os.Bundle;
import android.view.*;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.dnd5emanager.DataClasses.PlayerCharacter;
import com.example.dnd5emanager.databinding.DmManagerBinding;

import java.util.*;

public class DMManager extends Fragment {

    private DmManagerBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = DmManagerBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public static ArrayList<PlayerCharacter> Characters = new ArrayList<PlayerCharacter>(List.of(new PlayerCharacter()));

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
