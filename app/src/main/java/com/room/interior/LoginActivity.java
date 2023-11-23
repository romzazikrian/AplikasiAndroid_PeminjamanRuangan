package com.room.interior;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.room.interior.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tombol2.setOnClickListener(view -> setToast("Masih proses development"));
        binding.tombol1.setOnClickListener(view -> setIntent(DaftarActivity.class));
        binding.masuk.setOnClickListener(view -> {
            if (binding.editTextEmail.getText().toString().isEmpty()) {
                setToast("Silahkan masukkan email anda.");
            } else if (binding.editTextPassword.getText().toString().isEmpty()) {
                setToast("Silahkan masukkan password anda.");
            } else {
                setToast("Sedang Di Proses");
                FirebaseFirestore.getInstance().collection("user")
                        .get()
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                for (DocumentSnapshot document : task.getResult().getDocuments()) {
                                    if (document.getString("email").equals(binding.editTextEmail.getText().toString()) && document.getString("password").equals(binding.editTextPassword.getText().toString())) {
                                        setId(document.getId());
                                        setNama(document.getString("name"));
                                        setIntent(BerandaActivity.class);
                                        break;
                                    }
                                }
                            }
                        }).addOnFailureListener(e -> setToast("Silahkan periksa koneksi internet anda"));
            }
        });
    }
}