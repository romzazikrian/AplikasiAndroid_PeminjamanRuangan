package com.room.interior;

import android.os.Bundle;

import com.google.firebase.firestore.FirebaseFirestore;
import com.room.interior.databinding.ActivityDetailRuanganBinding;

import java.util.HashMap;
import java.util.Map;

public class DetailRuanganActivity extends BaseActivity {

    ActivityDetailRuanganBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailRuanganBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.chat.setOnClickListener(view -> setIntent(ChatActivity.class));
        binding.namaGedung.setText(getNamaGedung());
        binding.namaRuangan.setText(getNamaRuangan());
        binding.jumlah.setText(getNamaJumlah());
        binding.deskripsi.setText(getNamaRuangan() + " merupakan ruangan kelas yang bisa dipakai untuk pembelajaran tatap muka. Tak hanya itu ruangan ini juga sering dipakai rapat organisasi maupun unit kegiatan mahasiswa.");
        binding.peminjam.setOnClickListener(view -> {
            setToast("Sedang Di Proses");
            Map<String, Object> userData = new HashMap<>();
            userData.put("gedung", getNamaGedung());
            userData.put("ruangan", getNamaRuangan());
            userData.put("jumlah", getNamaJumlah());
            FirebaseFirestore.getInstance().collection("user").document(getId()).collection("peminjaman").add(userData).addOnSuccessListener(documentReference -> {
                setToast("Ruangan Berhasil Dipinjam");
                setIntent(HistoryActivity.class);
            }).addOnFailureListener(e -> setToast("Silahkan Periksa Koneksi Internet Anda"));
        });
    }
}