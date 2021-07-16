package com.example.keephealty.model.mitra;

import com.google.gson.annotations.SerializedName;

public class MitraData {
    @SerializedName("id")
    private int id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("nomor")
    private String nomor;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("ktp")
    private String ktp;
    @SerializedName("foto")
    private String foto;
    @SerializedName("layanan_servis")
    private String layanan_servis;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;

    public MitraData(){}

    public MitraData(int id, String nama, String nomor, String alamat, String ktp, String foto, String layanan_servis, String created_at, String updated_at) {
        this.id = id;
        this.nama = nama;
        this.nomor = nomor;
        this.alamat = alamat;
        this.ktp = ktp;
        this.foto = foto;
        this.layanan_servis = layanan_servis;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLayanan_servis() {
        return layanan_servis;
    }

    public void setLayanan_servis(String layanan_servis) {
        this.layanan_servis = layanan_servis;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
