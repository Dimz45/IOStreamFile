// Nama: [Muhammad Dimas Surya Putra]
// NPM: [2410010315]

package tugas;

public class MainTugas {
    public static void main(String[] args) {
        // Tambahan Syarat 1: Menyimpan daftar nama kategori dalam array String ukuran tetap
        String[] kategori = {"Elektronik", "Pakaian", "Makanan", "Alat Tulis"};
        
        System.out.println("=== KATEGORI TOKO ===");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println("- " + kategori[i]);
        }
        System.out.println();

        // Tambahan Syarat 2: Membuat objek gudang pertama dan mengisi minimal 5 barang
        Gudang gudangUtama = new Gudang("barang.txt");
        
        System.out.println("=== TAHAP 1: INPUT & SIMPAN BARANG ===");
        gudangUtama.tambahBarang(new Barang("Laptop", 8500000, 5));
        gudangUtama.tambahBarang(new Barang("Smartphone", 3500000, 12));
        gudangUtama.tambahBarang(new Barang("Kemeja Flanel", 150000, 30));
        gudangUtama.tambahBarang(new Barang("Keripik Kentang", 15000, 100));
        gudangUtama.tambahBarang(new Barang("Buku Tulis", 5000, 250));
        
        gudangUtama.tampilkanSemua();
        gudangUtama.simpanKeBerkas();
        System.out.println();

        // Tambahan Syarat 3: Membuat objek Gudang baru untuk membuktikan data tersimpan permanen
        System.out.println("=== TAHAP 2: BUKTI DATA TERSTRUKTUR DARI BERKAS ===");
        Gudang gudangVerifikasi = new Gudang("barang.txt");
        
        // Memuat ulang data dari file txt
        gudangVerifikasi.muatDariBerkas();
        gudangVerifikasi.tampilkanSemua();
        
        // Menampilkan hasil kalkulasi total nilai seluruh aset barang
        System.out.println("Total Nilai Persediaan Barang: Rp" + gudangVerifikasi.totalNilai());
    }
}
