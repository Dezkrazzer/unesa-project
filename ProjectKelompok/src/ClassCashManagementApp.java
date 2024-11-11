import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassCashManagementApp {
    public static void main(String[] args) {
        // Nama aplikasi
        System.out.println("==== Aplikasi Pendataan Kas Kelas ====");

        // Deklarasi variabel
        ArrayList<String> namaSiswa = new ArrayList<>();
        ArrayList<Double> kasSiswa = new ArrayList<>();
        ArrayList<String> alasanPengeluaran = new ArrayList<>();
        ArrayList<Double> pengeluaranKas = new ArrayList<>();
        boolean running = true;
        try (Scanner scanner = new Scanner(System.in)) {
            double totalKas = 0;
            double totalPemasukan = 0;
            double totalPengeluaran = 0;

            // Looping aplikasi (while)
            while (running) {
                // Tampilkan menu utama dalam format tabel/kotak
                System.out.println("\n===============================================");
                System.out.println("|               Menu Utama                    |");
                System.out.println("===============================================");
                System.out.printf("| %-2s | %-37s |\n", "1", "Tambah data siswa");
                System.out.println("-----------------------------------------------");
                System.out.printf("| %-2s | %-37s |\n", "2", "Tambah kas pada siswa yang sama");
                System.out.println("-----------------------------------------------");
                System.out.printf("| %-2s | %-37s |\n", "3", "Pengeluaran kas (kurangi total kas)");
                System.out.println("-----------------------------------------------");
                System.out.printf("| %-2s | %-37s |\n", "4", "Tampilkan rekap kas");
                System.out.println("-----------------------------------------------");
                System.out.printf("| %-2s | %-37s |\n", "5", "Hapus data siswa");
                System.out.println("-----------------------------------------------");
                System.out.printf("| %-2s | %-37s |\n", "6", "Tampilkan total kas");
                System.out.println("-----------------------------------------------");
                System.out.printf("| %-2s | %-37s |\n", "7", "Keluar");
                System.out.println("===============================================");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();

                // Pilihan menu menggunakan switch case
                switch (pilihan) {
                    case 1 -> {
                        // Tambah data siswa
                        System.out.print("Masukkan nama siswa: ");
                        scanner.nextLine(); // Membaca enter dari input sebelumnya
                        String nama = scanner.nextLine();
                        
                        // Manipulasi string
                        System.out.println("Nama disimpan dengan huruf kapital: " + nama.toUpperCase());

                        System.out.print("Masukkan jumlah kas siswa: ");
                        double kas = scanner.nextDouble();
                        
                        // Tambahkan data ke ArrayList
                        namaSiswa.add(nama);
                        kasSiswa.add(kas);
                        totalKas += kas; // Tambahkan ke total kas
                        totalPemasukan += kas; // Tambahkan ke total pemasukan
                        System.out.println("Data berhasil ditambahkan!");
                    }

                    case 2 -> {
                        // Tambah kas pada siswa yang sama
                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa.");
                        } else {
                            System.out.println("\nDaftar Siswa:");
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                System.out.printf("%d. %s - Kas: Rp %.2f\n", (i + 1), namaSiswa.get(i), kasSiswa.get(i));
                            }

                            System.out.print("Masukkan nomor siswa yang ingin menambah kas: ");
                            int nomorSiswa = scanner.nextInt();

                            if (nomorSiswa > 0 && nomorSiswa <= namaSiswa.size()) {
                                System.out.print("Masukkan jumlah kas tambahan: ");
                                double tambahanKas = scanner.nextDouble();

                                // Tambahkan kas pada siswa yang dipilih
                                kasSiswa.set(nomorSiswa - 1, kasSiswa.get(nomorSiswa - 1) + tambahanKas);
                                totalKas += tambahanKas; // Tambahkan ke total kas
                                totalPemasukan += tambahanKas; // Tambahkan ke total pemasukan
                                System.out.println("Kas berhasil ditambahkan untuk siswa " + namaSiswa.get(nomorSiswa - 1) + ".");
                            } else {
                                System.out.println("Nomor siswa tidak valid.");
                            }
                        }
                    }

                    case 3 -> {
                        // Pengeluaran kas (mengurangi total kas tanpa mengubah data siswa)
                        System.out.print("Masukkan jumlah pengeluaran kas: ");
                        double pengeluaranKasAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character after number input
                        
                        System.out.print("Masukkan keterangan pengeluaran: ");
                        String keteranganPengeluaran = scanner.nextLine();

                        if (pengeluaranKasAmount <= totalKas) {
                            // Kurangi total kas
                            totalKas -= pengeluaranKasAmount;
                            totalPengeluaran += pengeluaranKasAmount; // Tambahkan ke total pengeluaran
                            pengeluaranKas.add(pengeluaranKasAmount);
                            alasanPengeluaran.add(keteranganPengeluaran);
                            System.out.println("Pengeluaran sebesar Rp " + pengeluaranKasAmount + " berhasil dicatat.");
                            System.out.println("Keterangan: " + keteranganPengeluaran);
                            System.out.println("Total kas sekarang: Rp " + totalKas);
                        } else {
                            System.out.println("Total kas tidak mencukupi untuk pengeluaran sebesar itu.");
                        }
                    }

                    case 4 -> {
                        // Tampilkan rekap kas
                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa.");
                        } else {
                            System.out.println("|==========================================================================|");
                            System.out.println("|    |            PEMASUKAN               |            PENGELUARAN         |");
                            System.out.println("|==========================================================================|");
                            System.out.println("| NO | NAMA SISWA          |    JUMLAH    | KETERANGAN        |   JUMLAH   |");
                            System.out.println("|----|---------------------|--------------|-------------------|------------|");
                            
                            // Tampilkan Pemasukan
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                // Format untuk nama dan kas
                                System.out.printf("| %-2d | %-19s | %-12.2f | %-17s | %-10s |\n", 
                                                  (i + 1), 
                                                  namaSiswa.get(i), 
                                                  kasSiswa.get(i), 
                                                  "", 
                                                  "");
                            }
                            System.out.println("|----|---------------------|--------------|-------------------|------------|");
                            // Tampilkan Pengeluaran
                            for (int i = 0; i < alasanPengeluaran.size(); i++) {
                                // Format untuk pengeluaran
                                System.out.printf("| %-2s | %-19s | %-12s | %-17s | %-10.2f |\n", 
                                (i + 1), 
                                                  "", 
                                                  "", 
                                                  alasanPengeluaran.get(i), 
                                                  pengeluaranKas.get(i));
                            }
                            

                            System.out.println("|----|---------------------|--------------|-------------------|------------|");
                            System.out.printf("| %-24s | %-45.2f |\n", "TOTAL PEMASUKAN:", totalPemasukan);
                            System.out.printf("| %-24s | %-45.2f |\n", "TOTAL PENGELUARAN:", totalPengeluaran);
                            System.out.printf("| %-24s | %-45.2f |\n", "JUMLAH KAS SEKARANG:", totalKas);
                            System.out.println("|--------------------------------------------------------------------------|");
                        }
                    }

                    case 5 -> {
                        // Hapus data siswa (menghapus siswa sepenuhnya)
                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa untuk dihapus.");
                        } else {
                            System.out.println("\nDaftar Siswa:");
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                System.out.printf("%d. %s - Kas: Rp %.2f\n", (i + 1), namaSiswa.get(i), kasSiswa.get(i));
                            }

                            System.out.print("Masukkan nomor siswa yang ingin dihapus: ");
                            int nomorSiswa = scanner.nextInt();

                            if (nomorSiswa > 0 && nomorSiswa <= namaSiswa.size()) {
                                // Kurangi total kas dengan kas siswa yang dihapus
                                double kasDihapus = kasSiswa.get(nomorSiswa - 1);
                                totalKas -= kasDihapus;

                                // Hapus siswa dari ArrayList
                                namaSiswa.remove(nomorSiswa - 1);
                                kasSiswa.remove(nomorSiswa - 1);

                                System.out.println("Data berhasil dihapus. Kas dikurangi sebesar Rp " + kasDihapus);
                            } else {
                                System.out.println("Nomor siswa tidak valid.");
                            }
                        }
                    }

                    case 6 -> // Tampilkan total kas
                        System.out.println("Total kas yang terkumpul saat ini: Rp " + totalKas);

                    case 7 -> {
                        // Keluar dari aplikasi
                        running = false;
                        out.println("Terima kasih telah menggunakan aplikasi ini.");
                    }

                    default -> System.out.println("Pilihan tidak valid, coba lagi.");
                }
            }

            scanner.close();
        }
    }
}