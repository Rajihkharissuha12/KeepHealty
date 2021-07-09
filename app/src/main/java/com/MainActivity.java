package com;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.keep_healthy.adapter.MitraAdapter;
import com.example.keep_healthy.model.GetMitra;
import com.example.keep_healthy.model.Mitra;
import com.example.keep_healthy.rest.ApiClient;
import com.example.keep_healthy.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private RecyclerView recyclerMitra;
    private MitraAdapter mitraAdapter;
    private List<Mitra> listMitra;
    private List<Mitra> searchMitra;
    private EditText editSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSearch = findViewById(R.id.edit_query);
        recyclerMitra = findViewById(R.id.recycler_mitra);
        recyclerMitra.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        
        loadData();
        searchMitra = new ArrayList<>();
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0) {
                    if(searchMitra.size() > 0) {
                        Log.d("cari", "kosongkan list pencarian");
                        searchMitra.clear();
                    }
                    // melakukan pencarian
                    Log.d("cari", s.toString());
                    for(Mitra item:listMitra) {
                        String data = item.getLayanan_servis().toLowerCase();
                        if(data.contains(s.toString().toLowerCase())) {
                            searchMitra.add(item);
                        }
                    }
                    mitraAdapter = new MitraAdapter(searchMitra, MainActivity.this);
                    recyclerMitra.setAdapter(mitraAdapter);
                }
                else {
                    // jika kolom pencarian kosong
                    Log.d("cari", "kolom kosong");
                    loadData();
//                    mitraAdapter = new MitraAdapter(listMitra, getApplicationContext());
//                    recyclerMitra.setAdapter(mitraAdapter);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void loadData() {
        Call<GetMitra> callMitra = apiInterface.getMitra();
        callMitra.enqueue(new Callback<GetMitra>() {
            @Override
            public void onResponse(Call<GetMitra> call, Response<GetMitra> response) {
                listMitra = response.body().getListMitra();
                Log.d("get mitra", "Jumlah data : " + String.valueOf(listMitra.size()));
                mitraAdapter = new MitraAdapter(listMitra, MainActivity.this);
                recyclerMitra.setAdapter(mitraAdapter);
            }

            @Override
            public void onFailure(Call<GetMitra> call, Throwable t) {
                Log.e("error mitra", t.toString());
            }
        });
    }
}