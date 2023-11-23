package com.room.interior;

import android.os.Bundle;

import com.room.interior.databinding.ActivityBerandaBinding;

public class BerandaActivity extends BaseActivity {

    ActivityBerandaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBerandaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.kalender.setOnClickListener(view -> setIntent(KalenderActivity.class));
        binding.ruangan.setOnClickListener(view -> setIntent(RuanganActivity.class));
        binding.history.setOnClickListener(view -> setIntent(HistoryActivity.class));
        binding.saya.setOnClickListener(view -> setIntent(SayaActivity.class));
        binding.text.setText("Selamat Datang \n" + getNama());
        binding.search.setOnClickListener(view -> setToast("Masih Tahap Pengembangan"));
        binding.filter.setOnClickListener(view -> setToast("Masih Tahap Pengembangan"));
        binding.cardGa.setOnClickListener(view -> setToast("Masih Tahap Pengembangan"));
        binding.cardGb.setOnClickListener(view -> setToast("Masih Tahap Pengembangan"));
        binding.cardGict.setOnClickListener(view -> setToast("Masih Tahap Pengembangan"));
        binding.cardGsg.setOnClickListener(view -> setToast("Masih Tahap Pengembangan"));
    }
}