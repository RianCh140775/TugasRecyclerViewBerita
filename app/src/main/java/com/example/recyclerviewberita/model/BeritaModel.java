package com.example.recyclerviewberita.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BeritaModel implements Parcelable {

    private String judul;
    private String kategori;
    private String images;
    private String deskripsi;

    public BeritaModel(String judul, String kategori, String images, String deskripsi) {
        this.judul = judul;
        this.kategori = kategori;
        this.images = images;
        this.deskripsi = deskripsi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.kategori);
        dest.writeString(this.images);
        dest.writeString(this.deskripsi);
    }

    public void readFromParcel(Parcel source) {
        this.judul = source.readString();
        this.kategori = source.readString();
        this.images = source.readString();
        this.deskripsi = source.readString();
    }

    protected BeritaModel(Parcel in) {
        this.judul = in.readString();
        this.kategori = in.readString();
        this.images = in.readString();
        this.deskripsi = in.readString();
    }

    public static final Creator<BeritaModel> CREATOR = new Creator<BeritaModel>() {
        @Override
        public BeritaModel createFromParcel(Parcel source) {
            return new BeritaModel(source);
        }

        @Override
        public BeritaModel[] newArray(int size) {
            return new BeritaModel[size];
        }
    };
}
