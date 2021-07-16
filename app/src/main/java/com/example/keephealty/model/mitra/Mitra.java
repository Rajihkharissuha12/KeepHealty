package com.example.keephealty.model.mitra;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Mitra {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    List<MitraData> listMitra;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MitraData> getListMitra() {
        return listMitra;
    }

    public void setListMitra(List<MitraData> listMitra) {
        this.listMitra = listMitra;
    }
}
