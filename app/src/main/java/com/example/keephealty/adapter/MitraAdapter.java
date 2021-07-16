package com.example.keephealty.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.keephealty.R;
import com.example.keephealty.model.mitra.MitraData;

import java.util.ArrayList;
import java.util.List;

public class MitraAdapter extends RecyclerView.Adapter<MitraAdapter.MitraViewHolder> implements Filterable {

    private List<MitraData> mitraList, mitraListFull;
    private Context context;
    private final String BASE_URL = "http://192.168.43.201/";

    public MitraAdapter(List<MitraData> mitraList, Context context) {
        this.mitraList = mitraList;
        this.context = context;
        mitraListFull = new ArrayList<>(mitraList);
    }

    @NonNull
    @Override
    public MitraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mitra_item, parent, false);
        MitraViewHolder viewHolder = new MitraViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MitraViewHolder holder, final int position) {
        String imgName = this.mitraList.get(position).getFoto();
        imgName = imgName.replace(" ", "%20");
//        String imgUrl = "http://192.168.1.9:8000/ktp/"+this.mitraList.get(position).getKtp();
//        String imgUrl = "http://192.168.43.135:8000/ktp/"+this.mitraList.get(position).getKtp();
        String imgUrl = BASE_URL + "project_keep_healthy/web/Keep-Healthy/web_jadi/public/user/" + imgName;
        Glide.with(context).load(imgUrl).placeholder(R.mipmap.ic_launcher).into(holder.img);
        holder.tvName.setText(this.mitraList.get(position).getNama());
        holder.tvService.setText(this.mitraList.get(position).getLayanan_servis());
        holder.tvPhone.setText(this.mitraList.get(position).getNomor());

        // aksi
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://api.whatsapp.com/send?phone=62" + mitraList.get(position).getNomor();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
//                Toast.makeText(context, mitraList.get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.mitraList.size();
    }

    @Override
    public Filter getFilter() {
        final Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                List<MitraData> filteredList = new ArrayList<>();
                if (charSequence == null || charSequence.length() == 0) {
                    filteredList.addAll(mitraListFull);
                } else {
                    String filterPattern = charSequence.toString().toLowerCase().trim();
                    for (MitraData item : mitraListFull) {
                        if (item.getLayanan_servis().toLowerCase().contains(filterPattern)) {
                            filteredList.add(item);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mitraList.clear();
                mitraList.addAll((List) results.values);
                notifyDataSetChanged();
            }
        };
        return filter;
    }

    public class MitraViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView tvName, tvService, tvPhone;

        public MitraViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_mitra);
            tvName = itemView.findViewById(R.id.tv_name);
            tvService = itemView.findViewById(R.id.tv_service);
            tvPhone = itemView.findViewById(R.id.tv_phone);
        }
    }
}
