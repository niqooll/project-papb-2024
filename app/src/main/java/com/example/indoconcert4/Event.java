package com.example.indoconcert4;

public class Event {
    public String judul, lokasi,harga, deskripsi,imageUrl;

    // Constructor yang benar
    public Event(String g, String j,String l, String h, String d) {
        this.judul = j;
        this.imageUrl = g;
        this.lokasi = l;
        this.harga = h;
        this.deskripsi = d;
    }
}
