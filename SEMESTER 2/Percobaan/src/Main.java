import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Membuat ArrayList untuk menyimpan objek Mahasiswa
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();

        // Menambahkan objek Mahasiswa ke dalam ArrayList
        listMahasiswa.add(new Mahasiswa("Alice", "103", 85.5));
        listMahasiswa.add(new Mahasiswa("Diana", "104", 92.5));
        listMahasiswa.add(new Mahasiswa("Charlie", "102", 78.0));
        listMahasiswa.add(new Mahasiswa("Bob", "105", 90.0));
        listMahasiswa.add(new Mahasiswa("Ea", "101", 97.0));

        // Menampilkan daftar mahasiswa sebelum sorting
        System.out.println("Daftar Mahasiswa Sebelum Sorting:");
        for (Mahasiswa m : listMahasiswa) {
            System.out.println(m);
        }

        // Sorting berdasarkan nilai menggunakan Comparator
        listMahasiswa.sort(Comparator.comparingDouble(Mahasiswa::getNilai));

        // Menampilkan daftar mahasiswa setelah sorting
        System.out.println("\nDaftar Mahasiswa Setelah Sorting (Nilai Terendah):");
        for (Mahasiswa m : listMahasiswa) {
            System.out.println(m);
        }

        // Mengubah nilai mahasiswa menggunakan setter
        Mahasiswa mahasiswaEdit = listMahasiswa.get(1); // Mengambil objek
        mahasiswaEdit.setNama("Zzz"); // Mengubah nama
        mahasiswaEdit.setNim("Zzz"); // Mengubah nama
        mahasiswaEdit.setNilai(-1); // Mengubah nilai
        mahasiswaEdit.setNilai(100); // Mengubah nilai
        System.out.println("\nSetelah mengubah nilai " + mahasiswaEdit.getNama() + ": " );
        System.out.println(mahasiswaEdit);

        // Mencari mahasiswa berdasarkan NIM
        String nimDicari = "103";
        Mahasiswa mahasiswaDitemukan = Mahasiswa.cariMahasiswa(listMahasiswa, nimDicari);

        // Menampilkan hasil pencarian
        if (mahasiswaDitemukan != null) {
            System.out.println("\nMahasiswa dengan NIM " + nimDicari + " ditemukan:");
            System.out.println(mahasiswaDitemukan);
        } else {
            System.out.println("\nMahasiswa dengan NIM " + nimDicari + " tidak ditemukan.");
        }

        // Sorting berdasarkan nilai menggunakan Collections.sort()
        listMahasiswa.sort(Comparator.comparing(Mahasiswa::getNim));
        // Menampilkan daftar mahasiswa setelah sorting
        System.out.println("\nDaftar Mahasiswa Setelah Sorting (Berdasarkan NIM):");
        for (Mahasiswa m : listMahasiswa) {
            System.out.println(m);
        }

        // Mengurutkan daftar mahasiswa menggunakan Quick Sort
        ArrayList<Mahasiswa> quickSorted =  Mahasiswa.quickSort(listMahasiswa);
        System.out.println("\nDaftar Mahasiswa Setelah menggunakan Quick Sort");
        for (Mahasiswa m : quickSorted) {
            System.out.println(m);
        }
    }
}