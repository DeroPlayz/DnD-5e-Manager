package com.example.dnd5emanager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dnd5emanager.databinding.CharacterListBinding;
import com.example.dnd5emanager.databinding.FragmentThirdBinding;
import com.example.dnd5emanager.databinding.MainMenuBinding;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link ThirdFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class ThirdFragment extends Fragment {
    private FragmentThirdBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonThird.setOnClickListener(v ->
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_SecondFragment_to_thirdFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
