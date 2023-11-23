package com.room.interior;

import android.os.Bundle;

import com.room.interior.databinding.ActivityKalenderBinding;

public class KalenderActivity extends BaseActivity {

    ActivityKalenderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKalenderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.beranda.setOnClickListener(view -> setIntent(BerandaActivity.class));
        binding.ruangan.setOnClickListener(view -> setIntent(RuanganActivity.class));
        binding.history.setOnClickListener(view -> setIntent(HistoryActivity.class));
        binding.saya.setOnClickListener(view -> setIntent(SayaActivity.class));
    }
}