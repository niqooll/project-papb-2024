package com.example.indoconcert4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter {
    private final Context ctx;
    private final List<Event> daftar;

    public EventAdapter(Context ctx, List<Event> daftar) {
        this.ctx = ctx;
        this.daftar = daftar;
    }

    private class VH extends RecyclerView.ViewHolder {

        private final TextView judul;
        private final ImageView imageUrl;
        private final TextView harga;
        private final TextView lokasi;
        private final TextView deskripsi;
        private final Button btPesan;

        private VH(@NonNull View itemView) {
            super(itemView);
            this.judul = itemView.findViewById(R.id.Judul);
            this.imageUrl = itemView.findViewById(R.id.gambar1);
            this.harga = itemView.findViewById(R.id.Harga);
            this.lokasi = itemView.findViewById(R.id.Lokasi);
            this.deskripsi = itemView.findViewById(R.id.Deskripsi);
            this.btPesan = itemView.findViewById(R.id.btPesan);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.ctx).inflate(R.layout.item_event,parent,false);
        VH vh = new VH(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Event event = this.daftar.get(position);
        VH vh = (VH) holder;
        vh.judul.setText(event.judul);
        vh.lokasi.setText(event.lokasi);
        vh.harga.setText(event.harga);
        vh.deskripsi.setText(event.deskripsi);
        Glide.with(ctx)
                .load(event.imageUrl) // URL gambar
                .into(vh.imageUrl); // ImageView tempat menampilkan gambar

        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, "Tiket: " + event.judul + " di " + event.lokasi, Toast.LENGTH_SHORT).show();
            }
        });

        vh.btPesan.setOnClickListener(view -> {
            PemesananFragment pemesananFragment = new PemesananFragment();
            Bundle args = new Bundle();
            args.putString("judul", event.judul);
            args.putString("lokasi", event.lokasi);
            args.putString("harga", event.harga);
            args.putString("deskripsi", event.deskripsi);
            args.putString("imageUrl", event.imageUrl);
            pemesananFragment.setArguments(args);

            ((MainActivity) ctx).getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, pemesananFragment)
                    .addToBackStack(null)
                    .commit();
        });


    }

    @Override
    public int getItemCount() {
        return this.daftar.size();
    }




}
