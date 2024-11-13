package ekardi.mobile.projekpam;

public class ItemRiwayat {
    public String namaKonser;
    public String Tanggal;
    public String Jam;
    public String Harga;
    public String image;


    public ItemRiwayat(String namaKonser, String Tanggal, String Jam, String Harga, String image) {
        this.namaKonser = namaKonser;
        this.Tanggal = Tanggal;
        this.Jam = Jam;
        this.Harga = Harga;
        this.image = image;
    }

    public String getNamaKonser() {
        return namaKonser;
    }

    public void setNamaKonser(String namaKonser) {
        this.namaKonser = namaKonser;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public String getJam() {
        return Jam;
    }

    public void setJam(String jam) {
        Jam = jam;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

