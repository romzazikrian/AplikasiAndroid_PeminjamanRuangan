package com.room.interior;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private static String nama = "";
    private static String id = "";
    private static String namaGedung = "";
    private static String namaRuangan = "";
    private static String namaJumlah = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setToast(String Message) {
        Toast.makeText(this, Message, Toast.LENGTH_LONG).show();
    }

    public void setIntent(Class<?> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        BaseActivity.nama = nama;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        BaseActivity.id = id;
    }

    public static String getNamaGedung() {
        return namaGedung;
    }

    public static void setNamaGedung(String namaGedung) {
        BaseActivity.namaGedung = namaGedung;
    }

    public static String getNamaRuangan() {
        return namaRuangan;
    }

    public static void setNamaRuangan(String namaRuangan) {
        BaseActivity.namaRuangan = namaRuangan;
    }

    public static String getNamaJumlah() {
        return namaJumlah;
    }

    public static void setNamaJumlah(String namaJumlah) {
        BaseActivity.namaJumlah = namaJumlah;
    }
}