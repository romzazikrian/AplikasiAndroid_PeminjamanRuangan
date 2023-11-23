package com.room.interior;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.firestore.FirebaseFirestore;
import com.room.interior.databinding.ActivityDaftarBinding;

import java.util.HashMap;
import java.util.Map;

public class DaftarActivity extends BaseActivity {

    ActivityDaftarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDaftarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tombol1.setOnClickListener(view -> setIntent(LoginActivity.class));
        binding.daftar.setOnClickListener(view -> {
            if (binding.editTextFullName.getText().toString().isEmpty()){
                setToast("Nama Lengkap Tidak Boleh Kosong");
            } else if (binding.editTextEmail.getText().toString().isEmpty()){
                setToast("Email Tidak Boleh Kosong");
            } else if (binding.editTextPassword.getText().toString().isEmpty()){
                setToast("Kata Sandi Tidak Boleh Kosong");
            } else if (binding.editTextConfirmPassword.getText().toString().isEmpty()){
                setToast("Konfirmasi Kata Sandi Tidak Boleh Kosong");
            } else {
                if (binding.editTextPassword.getText().toString().equals(binding.editTextConfirmPassword.getText().toString())){
                    setToast("Sedang Di Proses");
                    Map<String, Object> userData = new HashMap<>();
                    userData.put("name", binding.editTextFullName.getText().toString());
                    userData.put("email", binding.editTextEmail.getText().toString());
                    userData.put("password", binding.editTextPassword.getText().toString());
                    setNama(binding.editTextFullName.getText().toString());
                    FirebaseFirestore.getInstance().collection("user").add(userData).addOnSuccessListener(documentReference -> {
                        setId(documentReference.getId());
                        setIntent(BerandaActivity.class);
                    }).addOnFailureListener(e -> setToast("Silahkan Periksa Koneksi Internet Anda"));
                } else {
                    setToast("Silahkan Ulangi Kata Sandi Anda, Kata Sandi Anda Tidak Valid");
                }
            }
        });
    }
}