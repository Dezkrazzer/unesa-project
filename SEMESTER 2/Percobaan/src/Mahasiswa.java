import java.util.ArrayList;

// Kelas Mahasiswa dengan Enkapsulasi
public class Mahasiswa {
    private String nama; // Atribut private
    private String nim;  // Atribut private
    private double nilai; // Atribut private

    // Konstruktor
    public Mahasiswa(String nama, String nim, double nilai) {
        this.nama = nama;
        this.nim = nim;
        this.nilai = nilai;
    }

    // Metode getter untuk nama
    public String getNama() {
        return nama;
    }

    // Metode setter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Metode getter untuk NIM
    public String getNim() {
        return nim;
    }

    // Metode setter untuk NIM
    public void setNim(String nim) {
        if (nim.matches("[0-9]+") && nim.length() > 2) {
            this.nim = nim;
        }else {
            System.out.println(">>> Nim harus angka  <<<");
        }
    }

    // Metode getter untuk nilai
    public double getNilai() {
        return nilai;
    }

    // Metode setter untuk nilai
    public void setNilai(double nilai) {
        if (nilai >= 0 && nilai <= 100) { // Validasi nilai
            this.nilai = nilai;
        } else {
            System.out.println(">>> Nilai harus antara 0 dan 100 <<<");
        }
    }

    // Metode untuk mencari mahasiswa berdasarkan NIM
   public static Mahasiswa cariMahasiswa(ArrayList<Mahasiswa> daftar, String nim) {
        for (Mahasiswa m : daftar) {
            if (m.getNim().equals(nim)) {
                return m; // Mengembalikan objek mahasiswa jika ditemukan
            }
        }
        return null; // Mengembalikan null jika tidak ditemukan
    }

    // Metode Quick Sort

    public static ArrayList<Mahasiswa> quickSort(ArrayList<Mahasiswa> list){
        quickSortLoop(list, 0, list.size() - 1);
        return list;
    }

    private static void quickSortLoop(ArrayList<Mahasiswa> daftar, int low, int high) {
        if (low < high) {
            int pi = partition(daftar, low, high);
            quickSortLoop(daftar, low, pi - 1);  // Sebelah kiri pivot
            quickSortLoop(daftar, pi + 1, high); // Sebelah kanan pivot
        }
    }

    // Metode untuk mempartisi array
    private static int partition(ArrayList<Mahasiswa> daftar, int low, int high) {
        String pivot = daftar.get(high).getNama(); // Mengambil nama sebagai pivot
        int i = (low - 1); // Indeks elemen yang lebih kecil

        for (int j = low; j < high; j++) {
            // Jika nama mahasiswa saat ini lebih kecil atau sama dengan pivot
            if (daftar.get(j).getNama().compareTo(pivot) <= 0) {
                i++;
                // Tukar daftar[i] dan daftar[j]
                Mahasiswa temp = daftar.get(i);
                daftar.set(i, daftar.get(j));
                daftar.set(j, temp);
            }
        }

        // Tukar daftar[i + 1] dan daftar[high] (pivot)
        Mahasiswa temp = daftar.get(i + 1);
        daftar.set(i + 1, daftar.get(high));
        daftar.set(high, temp);

        return i + 1; // Mengembalikan indeks pivot
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", NIM: " + nim + ", Nilai: " + nilai;
    }
}
