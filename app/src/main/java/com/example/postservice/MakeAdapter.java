package com.example.postservice;


import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import okhttp3.ResponseBody;

public class MakeAdapter extends RecyclerView.Adapter<MakeAdapter.MakeViewHolder> {

    private Context context;
    private List<String> makeList;

    public MakeAdapter(Context context , List<String> makeList) {
        this.context = context;
        this.makeList = makeList;
    }

    @NonNull
    @Override
    public MakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.make_row,parent,false);
        return new MakeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MakeViewHolder holder, int position) {
        holder.tvMake.setText(this.makeList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return this.makeList.size();
    }

    public  class MakeViewHolder extends RecyclerView.ViewHolder{

        TextView tvMake;

        public MakeViewHolder(@NonNull View view) {
            super(view);
            tvMake=view.findViewById(R.id.tvMake);
        }
    }

}
