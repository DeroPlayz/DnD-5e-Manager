package com.example.dnd5emanager;

import android.os.Bundle;
import android.view.*;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.dnd5emanager.databinding.DmPlayerManagerBinding;

public class DMPlayerManager extends Fragment {

    private DmPlayerManagerBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container) {
        binding = DmPlayerManagerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
