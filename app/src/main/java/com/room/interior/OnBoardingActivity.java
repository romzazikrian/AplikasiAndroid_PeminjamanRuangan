package com.room.interior;

import android.os.Bundle;
import android.view.View;

import com.room.interior.databinding.ActivityOnBoardingBinding;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends BaseActivity {

    ActivityOnBoardingBinding binding;
    List<Integer> list = new ArrayList<>();
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list.add(R.drawable.ic_depan_1);
        list.add(R.drawable.ic_depan_2);
        list.add(R.drawable.ic_depan_3);

        binding.image.setImageResource(list.get(position));
        binding.tombol.setOnClickListener(view -> {
            position++;
            if (position > 1) {
                if (position > 2){
                    setIntent(DaftarActivity.class);
                } else {
                    binding.image.setImageResource(list.get(position));
                    binding.tombol.setText("Daftar");
                    binding.bottom.setVisibility(View.VISIBLE);
                }
            } else binding.image.setImageResource(list.get(position));
        });

        binding.tombol1.setOnClickListener(view -> setIntent(LoginActivity.class));
    }
}