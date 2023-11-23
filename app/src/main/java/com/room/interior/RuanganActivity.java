package com.room.interior;

import android.os.Bundle;
import android.view.View;

import com.room.interior.databinding.ActivityRuanganBinding;

public class RuanganActivity extends BaseActivity {

    ActivityRuanganBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRuanganBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.kalender.setOnClickListener(view -> setIntent(KalenderActivity.class));
        binding.beranda.setOnClickListener(view -> setIntent(BerandaActivity.class));
        binding.history.setOnClickListener(view -> setIntent(HistoryActivity.class));
        binding.saya.setOnClickListener(view -> setIntent(SayaActivity.class));

        binding.ruangana1.setOnClickListener(view -> {
            setNamaGedung("Gedung A");
            setNamaRuangan("Ruangan 402-A");
            setNamaJumlah("40");
            setIntent(DetailRuanganActivity.class);
        });

        binding.ruangana2.setOnClickListener(view -> {
            setNamaGedung("Gedung A");
            setNamaRuangan("Ruangan 401-A");
            setNamaJumlah("40");
            setIntent(DetailRuanganActivity.class);
        });

        binding.ruangana3.setOnClickListener(view -> {
            setNamaGedung("Gedung A");
            setNamaRuangan("LAB 1 A");
            setNamaJumlah("40");
            setIntent(DetailRuanganActivity.class);
        });

        binding.ruangana4.setOnClickListener(view -> {
            setNamaGedung("Gedung A");
            setNamaRuangan("LAB 2 A");
            setNamaJumlah("40");
            setIntent(DetailRuanganActivity.class);
        });

        binding.ruangana5.setOnClickListener(view -> {
            setNamaGedung("Gedung A");
            setNamaRuangan("AULA A");
            setNamaJumlah("40");
            setIntent(DetailRuanganActivity.class);
        });

        binding.ruanganb1.setOnClickListener(view -> {
            setNamaGedung("Gedung B");
            setNamaRuangan("Ruangan 201-B");
            setNamaJumlah("40");
            setIntent(DetailRuanganActivity.class);
        });

        binding.ruanganb2.setOnClickListener(view -> {
            setNamaGedung("Gedung B");
            setNamaRuangan("Ruangan 202-B");
            setNamaJumlah("40");
            setIntent(DetailRuanganActivity.class);
        });

        binding.ruanganb3.setOnClickListener(view -> {
            setNamaGedung("Gedung B");
            setNamaRuangan("Ruangan 203 B");
            setNamaJumlah("40");
            setIntent(DetailRuanganActivity.class);
        });

        binding.ruanganb4.setOnClickListener(view -> {
            setNamaGedung("Gedung B");
            setNamaRuangan("Ruangan 302 B");
            setNamaJumlah("40");
            setIntent(DetailRuanganActivity.class);
        });

        binding.ruanganb5.setOnClickListener(view -> {
            setNamaGedung("Gedung B");
            setNamaRuangan("Ruangan 303 B");
            setNamaJumlah("40");
            setIntent(DetailRuanganActivity.class);
        });

        binding.ruanganict1.setOnClickListener(view -> {
            setNamaGedung("Gedung ICT");
            setNamaRuangan("Lab Gambar");
            setNamaJumlah("40");
            setIntent(DetailRuanganActivity.class);
        });

        binding.ruanganict2.setOnClickListener(view -> {
            setNamaGedung("Gedung ICT");
            setNamaRuangan("301 ICT B");
            setNamaJumlah("40");
            setIntent(DetailRuanganActivity.class);
        });

        binding.ruanganict3.setOnClickListener(view -> {
            setNamaGedung("Gedung ICT");
            setNamaRuangan("201 ICT B");
            setNamaJumlah("40");
            setIntent(DetailRuanganActivity.class);
        });
    }
}