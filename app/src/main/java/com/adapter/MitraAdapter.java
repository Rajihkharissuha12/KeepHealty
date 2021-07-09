    package com.adapter;

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
import com.example.keep_healthy.R;
import com.example.keep_healthy.model.Mitra;

import java.util.ArrayList;
import java.util.List;

public class MitraAdapter extends RecyclerView.Adapter<MitraAdapter.MitraViewHolder> implements Filterable {

    List<Mitra> mitraList;
    Context context;

    public MitraAdapter(List<Mitra> mitraList, Context context) {
        this.mitraList = mitraList;
        this.context = context;
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
        String imgName = this.mitraList.get(position).getKtp();
        imgName = imgName.replace(" ", "%20");
//        String imgUrl = "http://192.168.43.135:8000/ktp/"+this.mitraList.get(position).getKtp();
        String imgUrl = "http://192.168.43.135:8000/ktp/"+imgName;
        Glide.with(context).load(imgUrl).into(holder.img);
        holder.tvName.setText(this.mitraList.get(position).getNama());
        holder.tvService.setText(this.mitraList.get(position).getLayanan_servis());
        holder.tvPhone.setText(this.mitraList.get(position).getNomor());

        // aksi
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://api.whatsapp.com/send?phone="+mitraList.get(position).getNomor();
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
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0) {
                    filterResults.count = mitraList.size();
                    filterResults.values = mitraList;
                }
                else {
                    List<Mitra> resultMitra = new ArrayList<>();
                    String searchQuery = constraint.toString().toLowerCase();

                    for(Mitra item:mitraList) {
                        if(item.getLayanan_servis().contains(searchQuery)) {
                            resultMitra.add(item);
                        }
                        filterResults.count = mitraList.size();
                        filterResults.values = mitraList;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        };
        return filter;
    }

    public class MitraViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView tvName, tvService, tvPhone;

        public MitraViewHolder(View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.img_mitra);
            tvName = itemView.findViewById(R.id.tv_name);
            tvService = itemView.findViewById(R.id.tv_service);
            tvPhone = itemView.findViewById(R.id.tv_phone);
        }
    }
}
