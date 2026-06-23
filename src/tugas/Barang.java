package tugas;

public class Barang {
    // Atribut model
    private String nama;
    private double harga;
    private int stok;

    // Constructor lengkap
    public Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter untuk masing-masing atribut
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Method keBaris() untuk memformat penyimpanan teks ke dalam berkas file
    public String keBaris() {
        return nama + ";" + harga + ";" + stok;
    }

    // Method info() untuk mencetak visual keterangan barang ke console
    public String info() {
        return nama + " - Rp" + harga + " (Stok: " + stok + ")";
    }
}