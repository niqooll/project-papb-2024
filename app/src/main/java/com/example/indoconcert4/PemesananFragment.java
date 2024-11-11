package com.example.indoconcert4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class PemesananFragment extends Fragment {
    private TextView judulTextView, judul2Textview, lokasiTextView, hargaTextView, totalHargaTextView;
    private ImageView gambarImageView, tombolBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pemesanan, container, false);

        judulTextView = view.findViewById(R.id.tvJudul);
        judul2Textview = view.findViewById(R.id.tvJudul2);
        lokasiTextView = view.findViewById(R.id.tvLokasi);
        hargaTextView = view.findViewById(R.id.tvHarga);
        totalHargaTextView = view.findViewById(R.id.tvTotalHarga);
        gambarImageView = view.findViewById(R.id.ivGambar);
        tombolBack = view.findViewById(R.id.btBack);

        // Ambil data dari Bundle
        Bundle args = getArguments();
        if (args != null) {
            judulTextView.setText(args.getString("judul"));
            judul2Textview.setText(args.getString("judul"));
            lokasiTextView.setText(args.getString("lokasi"));
            hargaTextView.setText(args.getString("harga"));
            totalHargaTextView.setText(args.getString("harga"));
            String imageUrl = args.getString("imageUrl");

            if (imageUrl != null) {
                Glide.with(this)
                        .load(imageUrl)
                        .into(gambarImageView);
            }
        }

        tombolBack.setOnClickListener(v -> requireActivity().onBackPressed());
        return view;
    }
}
