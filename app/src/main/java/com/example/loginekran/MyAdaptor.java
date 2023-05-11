package com.example.loginekran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdaptor extends  RecyclerView.Adapter<MyAdaptor.Myholder>
{

    private ArrayList<Urunler> urunler;
    public MyAdaptor(Context context, ArrayList<Urunler> urunler)
    {
        this.urunler=urunler;
    }
    public void setFilteredList(ArrayList<Urunler> filteredList)
    {
        this.urunler=filteredList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.urunler,parent,false);
        return new Myholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position)
    {
        holder.txt_urunismi.setText(urunler.get(position).getUrunismi());
        holder.txt_fiyat.setText(urunler.get(position).getFiyat());
        holder.txt_urunresmi.setImageResource(urunler.get(position).getUrunresmii());
    }
    @Override
    public int getItemCount()
    {
        return urunler.size();
    }
    public class Myholder extends RecyclerView.ViewHolder
    {
        TextView txt_urunismi,txt_fiyat;
        ImageView txt_urunresmi;
        public Myholder(@NonNull View itemView)
        {
            super(itemView);
            txt_urunismi=itemView.findViewById(R.id.texturunismi);
            txt_fiyat=itemView.findViewById(R.id.txturunfiyat);
            txt_urunresmi=itemView.findViewById(R.id.txturunresim);
        }
    }
}
