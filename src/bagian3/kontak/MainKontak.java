package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        // 1. Membuat objek pengelola dan mengisi data awal (Termasuk Email - Soal 2)
        BukuKontak buku = new BukuKontak("kontak.txt");
        
        System.out.println("=== TAHAP 1: MEMBUAT & MENYIMPAN KONTAK ===");
        buku.tambahKontak(new Kontak("Andi", "0811111", "andi@email.com"));
        buku.tambahKontak(new Kontak("Budi", "0822222", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@email.com"));
        
        buku.tampilkanSemua();
        buku.simpanKeBerkas();
        System.out.println();
        
        // 2. Membuat objek baru yang kosong untuk mensimulasikan pembacaan berkas (Soal 2)
        System.out.println("=== TAHAP 2: MEMUAT KEMBALI DARI BERKAS ===");
        BukuKontak bukuLain = new BukuKontak("kontak.txt");
        bukuLain.muatDariBerkas();
        bukuLain.tampilkanSemua();
        System.out.println();
        
        // 3. Pengujian Fitur Pencarian Kontak (Soal 1)
        System.out.println("=== TAHAP 3: UJI COBA PENCARIAN KONTAK ===");
        bukuLain.cariKontak("Budi");  // Skenario ada
        bukuLain.cariKontak("Doni");  // Skenario tidak ada
        System.out.println();
        
        // 4. Pengujian Fitur Hapus Kontak (Soal 3)
        System.out.println("=== TAHAP 4: UJI COBA HAPUS KONTAK ===");
        bukuLain.hapusKontak("Andi"); // Menghapus Andi
        System.out.println("\n--- Tampilan Akhir Daftar Kontak Setelah Dihapus ---");
        bukuLain.tampilkanSemua();
    }
}