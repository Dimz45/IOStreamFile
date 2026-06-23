package bagian2.bacatulis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TugasMandiri {

    public static void main(String[] args) {
        String namaBerkas = "hari.txt";
        
        // ==========================================
        // SOAL 1: Menulis 5 Hari & Membacanya Kembali
        // ==========================================
        System.out.println("--- Soal 1: Menulis & Membaca 5 Hari ---");
        String[] limaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        
        // Proses Menulis (Overwrite / Membuat baru)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaBerkas))) {
            for (String hari : limaHari) {
                writer.write(hari);
                writer.newLine(); // Membuat baris baru setelah nama hari
            }
            System.out.println("Berhasil menulis 5 nama hari ke '" + namaBerkas + "'.");
        } catch (IOException e) {
            System.out.println("Gagal menulis berkas: " + e.getMessage());
        }
        
        // Proses Membaca dan Menampilkan
        System.out.println("\nIsi berkas saat ini:");
        bacaDanTampilkanBerkas(namaBerkas);
        System.out.println(); // Jarak baris


        // ==========================================
        // SOAL 2: Menambahkan (Append) 2 Hari Lagi
        // ==========================================
        System.out.println("--- Soal 2: Menambahkan (Append) 2 Hari ---");
        String[] duaHariTambahan = {"Sabtu", "Minggu"};
        
        // Proses Append (FileWriter diberi parameter 'true')
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaBerkas, true))) {
            for (String hari : duaHariTambahan) {
                writer.write(hari);
                writer.newLine();
            }
            System.out.println("Berhasil menambahkan 2 nama hari lagi.");
        } catch (IOException e) {
            System.out.println("Gagal menambahkan data ke berkas: " + e.getMessage());
        }
        
        // Tampilkan seluruh isi berkas setelah di-append
        System.out.println("\nIsi berkas setelah ditambahkan:");
        bacaDanTampilkanBerkas(namaBerkas);
        System.out.println(); // Jarak baris


        // ==========================================
        // SOAL 3: Menghitung Jumlah Baris
        // ==========================================
        System.out.println("--- Soal 3: Menghitung Jumlah Baris ---");
        int jumlahBaris = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(namaBerkas))) {
            while (reader.readLine() != null) {
                jumlahBaris++;
            }
            System.out.println("Jumlah total baris di dalam '" + namaBerkas + "': " + jumlahBaris + " baris.");
        } catch (IOException e) {
            System.out.println("Gagal menghitung baris berkas: " + e.getMessage());
        }
    }

    /**
     * Helper method untuk membaca berkas dan menampilkannya ke layar console
     */
    private static void bacaDanTampilkanBerkas(String namaFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                System.out.println("- " + baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca berkas: " + e.getMessage());
        }
    }
}