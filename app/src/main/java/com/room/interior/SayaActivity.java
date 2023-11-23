package com.room.interior;

import android.os.Bundle;

import com.room.interior.databinding.ActivitySayaBinding;

public class SayaActivity extends BaseActivity {

    ActivitySayaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySayaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.nama.setText(getNama());
        binding.kalender.setOnClickListener(view -> setIntent(KalenderActivity.class));
        binding.ruangan.setOnClickListener(view -> setIntent(RuanganActivity.class));
        binding.history.setOnClickListener(view -> setIntent(HistoryActivity.class));
        binding.beranda.setOnClickListener(view -> setIntent(BerandaActivity.class));
    }
}