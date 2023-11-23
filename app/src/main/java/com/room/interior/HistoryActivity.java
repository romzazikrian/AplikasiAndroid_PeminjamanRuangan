package com.room.interior;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.room.interior.databinding.ActivityHistoryBinding;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends BaseActivity {

    ActivityHistoryBinding binding;
    List<DocumentSnapshot> list = new ArrayList<>();
    FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.kalender.setOnClickListener(view -> setIntent(KalenderActivity.class));
        binding.ruangan.setOnClickListener(view -> setIntent(RuanganActivity.class));
        binding.beranda.setOnClickListener(view -> setIntent(BerandaActivity.class));
        binding.saya.setOnClickListener(view -> setIntent(SayaActivity.class));
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FirestoreRecyclerAdapter();
        binding.recycler.setAdapter(adapter);

        FirebaseFirestore.getInstance().collection("user").document(getId()).collection("peminjaman").get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        list.addAll(task.getResult().getDocuments());
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(e -> setToast("Silahkan periksa koneksi internet anda"));
    }

    private class FirestoreRecyclerAdapter extends RecyclerView.Adapter<UserViewHolder> {

        @NonNull
        @Override
        public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
            return new UserViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
            DocumentSnapshot document = list.get(position);
            holder.bind(document.getString("gedung"), document.getString("ruangan"), document.getString("jumlah"));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private static class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView textGedung;
        private TextView textRuangan;
        private TextView textJumlah;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textGedung = itemView.findViewById(R.id.nama_gedung);
            textRuangan = itemView.findViewById(R.id.nama_ruangan);
            textJumlah = itemView.findViewById(R.id.jumlah);
        }

        public void bind(String gedung, String ruangan, String jumlah) {
            textGedung.setText(gedung);
            textRuangan.setText(ruangan);
            textJumlah.setText(jumlah + " orang");
        }
    }
}