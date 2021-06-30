package com.example.keephealty.model.register;

import com.google.gson.annotations.SerializedName;

public class RegisterData {

	@SerializedName("name")
	private String name;

	@SerializedName("nomor")
	private String nomor;

	@SerializedName("email")
	private String email;

	@SerializedName("alamat")
	private String alamat;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setNomor(String nomor){
		this.nomor = nomor;
	}

	public String getNomor(){
		return nomor;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}
}