package com.example.keephealty.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMitra {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    List<Mitra> listMitra;

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

    public List<Mitra> getListMitra() {
        return listMitra;
    }

    public void setListMitra(List<Mitra> listMitra) {
        this.listMitra = listMitra;
    }
}
