package com.example.keephealty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.keephealty.R;
import com.example.keephealty.model.Profile;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.UserViewHolder> {

    private List<Profile> dataList;
    private Context mContext;


    public ProfileAdapter(Context mContext, List<Profile> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.profile_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final UserViewHolder holder, final int position) {
        holder.tv_text.setText(dataList.get(position).getText());
        holder.img_icon.setImageResource(dataList.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_text;
        private ImageView img_icon;

        public UserViewHolder(View itemView) {
            super(itemView);

            tv_text = itemView.findViewById(R.id.tv_text_profile);
            img_icon = itemView.findViewById(R.id.img_icon_profile);
        }
    }
}