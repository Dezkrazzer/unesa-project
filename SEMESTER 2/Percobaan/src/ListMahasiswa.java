import java.util.ArrayList;

public class ListMahasiswa {
    public static void main(String[] args) {
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();

        listMahasiswa.add(new Mahasiswa("Lazuardi Akbar Imani", "24111814119", "Informatika"));
        listMahasiswa.add(new Mahasiswa("Fadli Fais Fajaruddin", "24111814015", "Informatika"));
        listMahasiswa.add(new Mahasiswa("Rifki Maulana", "24111814084", "Informatika"));

        for (Mahasiswa mhs : listMahasiswa) {
            mhs.tampilkanMahasiswa();
            System.out.println("-------------------------");
        }
        System.out.println("\nBy: Lazuardi Akbar");
    }
}

class Mahasiswa {
    String nama;
    String nim;
    String jurusan;

    Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    void tampilkanMahasiswa() {
        System.out.println("Nama: " + this.nama);
        System.out.println("NIM: " + this.nim);
        System.out.println("Jurusan: " + this.jurusan);
    }
}