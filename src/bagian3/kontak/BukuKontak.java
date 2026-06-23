package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BukuKontak {
    // ArrayList yang menampung objek bertipe Kontak
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;
    
    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }
    
    // Menambah satu kontak ke koleksi
    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }
    
    // Menampilkan seluruh koleksi beserta nomor urut
    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        if (daftar.isEmpty()) {
            System.out.println("(Tidak ada kontak)");
        } else {
            for (int i = 0; i < daftar.size(); i++) {
                Kontak k = daftar.get(i);
                System.out.println((i + 1) + ". " + k.info());
            }
        }
    }
    
    // Menyimpan seluruh kontak ke berkas
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Kontak berhasil disinkronisasi ke berkas " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }
    
    // Membaca kembali kontak dari berkas ke dalam ArrayList
    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                // Soal 2: memecah baris menjadi tiga bagian (nama;nomor;email)
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2]));
                }
            }
            System.out.println("Kontak dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }
    
    public int jumlahKontak() {
        return daftar.size();
    }
    
    // Soal 1: Method cariKontak berdasarkan nama
    public void cariKontak(String nama) {
        for (Kontak k : daftar) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Ditemukan: " + k.info());
                return; // Keluar dari method jika sudah ketemu
            }
        }
        System.out.println("Kontak \"" + nama + "\" tidak ditemukan.");
    }

    // Soal 3: Method hapusKontak berdasarkan nama, langsung panggil simpanKeBerkas()
    public void hapusKontak(String nama) {
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                daftar.remove(i);
                System.out.println("Kontak \"" + nama + "\" berhasil dihapus dari memori.");
                
                // Panggil simpanKeBerkas agar perubahan ikut tersimpan di harddisk (Soal 3)
                simpanKeBerkas(); 
                return;
            }
        }
        System.out.println("Gagal menghapus, kontak \"" + nama + "\" tidak ditemukan.");
    }
}