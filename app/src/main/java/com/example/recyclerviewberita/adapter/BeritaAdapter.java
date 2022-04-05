package com.example.recyclerviewberita.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerviewberita.DetailBeritaActivity;
import com.example.recyclerviewberita.R;
import com.example.recyclerviewberita.model.BeritaModel;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>{
    private List<BeritaModel> listBerita;
    private Context context;

    public BeritaAdapter(List<BeritaModel> listBerita, Context context) {
        this.listBerita = listBerita;
        this.context = context;
    }

    //untuk deklarasi layout item
    @NonNull
    @Override
    public BeritaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout,parent,false);
        return new BeritaViewHolder(view);
    }

    //untuk setting view seperti set text button onclick set image dan sebagainya
    @Override
    public void onBindViewHolder(@NonNull BeritaViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(listBerita.get(position).getImages()).into(holder.imageBerita);
        holder.txtJudul.setText(listBerita.get(position).getJudul());
        holder.txtKategori.setText(listBerita.get(position).getKategori());
        if (listBerita.get(position).getKategori().equalsIgnoreCase("health")){
            holder.txtBullet.setTextColor(ColorStateList.valueOf(Color.RED));
        }else if (listBerita.get(position).getKategori().equalsIgnoreCase("travel")){
            holder.txtBullet.setTextColor(ColorStateList.valueOf(Color.GREEN));
        }

        holder.txtJudul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailBeritaActivity.class);
                intent.putExtra("beritaModel",listBerita.get(position));
                context.startActivity(intent);
            }
        });
    }

    //IMPORTANT! jumlah looping dari LIST
    @Override
    public int getItemCount() {
        return listBerita.size();
    }

    //Kelas view holder yang berguna untuk menginialisasi kebutuhan didalam item layout
    public class BeritaViewHolder extends RecyclerView.ViewHolder{

        ImageView imageBerita;
        TextView txtJudul,txtBullet,txtKategori;
        CardView cardButton;

        public BeritaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageBerita = itemView.findViewById(R.id.imageBerita);
            cardButton = itemView.findViewById(R.id.cardButton);
            txtJudul = itemView.findViewById(R.id.txtJudul);
            txtBullet = itemView.findViewById(R.id.txtBullet);
            txtKategori = itemView.findViewById(R.id.txtKategori);
        }
    }
}
