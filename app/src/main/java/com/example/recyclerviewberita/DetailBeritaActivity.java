package com.example.recyclerviewberita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recyclerviewberita.model.BeritaModel;

public class DetailBeritaActivity extends AppCompatActivity {

    ImageView imageBerita;
    TextView txtTitle,txtDetailKategori,txtDeskripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);

        imageBerita= findViewById(R.id.imageBeritaDetail);
        txtDetailKategori= findViewById(R.id.txtKategoriDetail);
        txtTitle= findViewById(R.id.txtTitle);
        txtDeskripsi= findViewById(R.id.txtDeskripsi);

        BeritaModel berita = getIntent().getExtras().getParcelable("beritaModel");

        Glide.with(this).load(berita.getImages()).into(imageBerita);
        txtDetailKategori.setText(berita.getKategori());
        txtTitle.setText(berita.getJudul());
        txtDeskripsi.setText(berita.getDeskripsi());
    }
}