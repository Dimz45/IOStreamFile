package bagian3.kontak;

public class Kontak {
    // Atribut: data yang dimiliki setiap kontak (Soal 2: tambah email)
    private String nama;
    private String nomor;
    private String email; 
    
    // Constructor: diupdate agar menerima 3 parameter (Soal 2)
    public Kontak(String nama, String nomor, String email) {
        this.nama = nama;
        this.nomor = nomor;
        this.email = email;
    }
    
    // Getter: cara membaca atribut dari luar class
    public String getNama() {
        return nama;
    }
    
    public String getNomor() {
        return nomor;
    }

    public String getEmail() { // Getter untuk email (Soal 2)
        return email;
    }
    
    // Mengubah objek menjadi satu baris teks dengan pemisah ";" (Soal 2: disesuaikan 3 bagian)
    public String keBaris() {
        return nama + ";" + nomor + ";" + email;
    }
    
    // Mengembalikan keterangan kontak dalam bentuk teks (Soal 2: disesuaikan tampilan email)
    public String info() {
        return nama + " - " + nomor + " (" + email + ")";
    }
}