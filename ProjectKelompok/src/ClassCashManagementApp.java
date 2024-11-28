import java.util.ArrayList;
import java.util.Scanner;

public class ClassCashManagementApp {
    public static void main(String[] args) {

        // Nama aplikasi
        System.out.println("|==============================================|");
        System.out.println("|>>>                                        <<<|");
        System.out.println("|>>       Aplikasi Pendataan Kas Kelas       <<|");
        System.out.println("|>>>                                        <<<|");
        System.out.println("|==============================================|");

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

                // Tampilkan menu utama dalam format
                System.out.println("\n|==============================================|");
                System.out.println("|>>               Menu Utama                 <<|");
                System.out.println("|==============================================|");
                System.out.printf("| %-2s | %-39s |\n", "1", "Tambah data siswa");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "2", "Tambah kas pada siswa yang sama");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "3", "Pengeluaran kas");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "4", "Tampilkan rekap kas");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "5", "Hapus data siswa");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "6", "Tampilkan total kas");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "7", "Cek profil siswa");
                System.out.println("|==============================================|");
                System.out.printf("| %-2s | %-39s |\n", "8", "Keluar");
                System.out.println("|==============================================|");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();

                // Pilihan menu menggunakan switch case
                switch (pilihan) {

                    // Tambah data siswa
                    case 1 -> {
                        System.out.print("Masukkan nama siswa: ");
                        scanner.nextLine();
                        String nama = scanner.nextLine();
                        
                        // Manipulasi string
                        System.out.println("Nama disimpan dengan huruf kapital: " + nama.toUpperCase());
                        System.out.print("Masukkan jumlah kas " + nama.toUpperCase() + ": " );
                        double kas = scanner.nextDouble();
                        String formatRupiah = String.format("Rp %,d", (int) kas);
                        System.out.println("Kas: " + nama.toUpperCase() + formatRupiah);
                        
                        // Tambahkan data ke ArrayList
                        namaSiswa.add(nama.toUpperCase());
                        kasSiswa.add(kas);
                        totalKas += kas; // Tambahkan ke total kas
                        totalPemasukan += kas; // Tambahkan ke total pemasukan
                        System.out.println("Data berhasil ditambahkan!");
                    }

                    // Tambah kas pada siswa yang sama
                    case 2 -> {
                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa.");
                        } else {
                            System.out.println("\nDaftar Siswa:");
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                String formatRupiah = String.format("Rp %,d", kasSiswa.get(i).intValue());
                                System.out.printf("%d. %s - Kas: %s\n", (i + 1), namaSiswa.get(i), formatRupiah);
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

                    // Pengeluaran kas
                    case 3 -> {
                        System.out.print("Masukkan jumlah pengeluaran kas: ");
                        double pengeluaranKasAmount = scanner.nextDouble();
                        scanner.nextLine();
                        
                        System.out.print("Masukkan keterangan pengeluaran: ");
                        String keteranganPengeluaran = scanner.nextLine();

                        if (pengeluaranKasAmount <= totalKas) {
                            // Kurangi total kas
                            totalKas -= pengeluaranKasAmount;
                            totalPengeluaran += pengeluaranKasAmount; // Tambahkan ke total pengeluaran
                            pengeluaranKas.add(pengeluaranKasAmount);
                            alasanPengeluaran.add(keteranganPengeluaran);
                            System.out.println("Keterangan: " + keteranganPengeluaran);
                            String formatRupiah = String.format("Rp %,d", (int) pengeluaranKasAmount);
                            System.out.println("Pengeluaran sebesar " + formatRupiah + " berhasil dicatat.");
                        } else {
                            System.out.println("Total kas tidak mencukupi untuk pengeluaran sebesar itu.");
                        }
                    }

                    // Tampilkan rekap kas
                    case 4 -> {
                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa.");
                        } 
                        else {
                            System.out.println("|==========================================================================|");
                            System.out.println("|    |            PEMASUKAN               |            PENGELUARAN         |");
                            System.out.println("|==========================================================================|");
                            System.out.println("| NO | NAMA SISWA          |    JUMLAH    | KETERANGAN        |   JUMLAH   |");
                            System.out.println("|----|---------------------|--------------|-------------------|------------|");
                            
                            // Tampilkan Pemasukan
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                String formatRupiahPemasukan = String.format("Rp %,d", kasSiswa.get(i).intValue());
                                System.out.printf("| %-2d | %-19s | %-12s | %-17s | %-10s |\n", 
                                                  (i + 1), 
                                                  namaSiswa.get(i), 
                                                  formatRupiahPemasukan, 
                                                  "", 
                                                  "");
                            }
                            System.out.println("|----|---------------------|--------------|-------------------|------------|");
                            // Tampilkan Pengeluaran
                            for (int i = 0; i < alasanPengeluaran.size(); i++) {
                                String formatRupiahPengeluaran = String.format("Rp %,d", pengeluaranKas.get(i).intValue());
                                System.out.printf("| %-2s | %-19s | %-12s | %-17s | %-10s |\n", 
                                                  (i + 1), 
                                                  "", 
                                                  "", 
                                                  alasanPengeluaran.get(i), 
                                                  formatRupiahPengeluaran);
                            }
                        String formatTotalPemasukan = String.format("Rp %,d", (int) totalPemasukan);
                        String formatTotalPengeluaran = String.format("Rp %,d", (int) totalPengeluaran);
                        String formatTotalKas = String.format("Rp %,d", (int) totalKas);
                        System.out.println("|----|---------------------|--------------|-------------------|------------|");
                        System.out.printf("| %-24s | %-45s |\n", "TOTAL PEMASUKAN:", formatTotalPemasukan);
                        System.out.printf("| %-24s | %-45s |\n", "TOTAL PENGELUARAN:", formatTotalPengeluaran);
                        System.out.printf("| %-24s | %-45s |\n", "JUMLAH KAS SEKARANG:", formatTotalKas);
                        System.out.println("|==========================================================================|");
                        }
                    }

                    // Hapus data siswa (menghapus siswa sepenuhnya)
                    case 5 -> {

                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa untuk dihapus.");
                        } else {
                            System.out.println("\nDaftar Siswa:");
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                String formatRupiah = String.format("Rp %,d", kasSiswa.get(i).intValue());
                                System.out.printf("%d. %s - Kas: %s\n", (i + 1), namaSiswa.get(i), formatRupiah);
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

                    // Tampilkan total kas
                    case 6 -> {
                        String formatRupiah = String.format("Rp %,d", (int) totalKas);
                        System.out.println("Total kas saat ini: " + formatRupiah);
                    }

                    case 7 ->{
                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa.");
                        } else {
                            System.out.println("\nDaftar Siswa:");
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                System.out.printf("%d. %s\n", (i + 1), namaSiswa.get(i));
                            }
                    
                            System.out.print("Masukkan nomor siswa untuk melihat profil: ");
                            int nomorSiswa = scanner.nextInt();
                    
                            if (nomorSiswa > 0 && nomorSiswa <= namaSiswa.size()) {
                                String nama = namaSiswa.get(nomorSiswa - 1);
                                double totalKasSiswa = kasSiswa.get(nomorSiswa - 1);
                    
                                // 1. Mengubah Nama ke Huruf Kapital
                                System.out.println("Nama (Huruf Besar): " + nama.toUpperCase());
                    
                                // 2. Mengubah Nama ke Huruf Kecil
                                System.out.println("Nama (Huruf Kecil): " + nama.toLowerCase());
                    
                                // 3. Mengambil Inisial Nama
                                String inisial = nama.substring(0, 1).toUpperCase() + ".";
                                System.out.println("Inisial Nama: " + inisial);
                    
                                // 4. Validasi Panjang Nama
                                System.out.println("Panjang Nama: " + nama.length() + " karakter");
                    
                                // 5. Membalik Nama
                                String namaTerbalik = new StringBuilder(nama).reverse().toString();
                                System.out.println("Nama Terbalik: " + namaTerbalik);
                    
                                // 6. Format Total Kas Siswa ke Rupiah
                                String formatKas = String.format("Rp %,d", (int) totalKasSiswa);
                                System.out.println("Total Kas Siswa: " + formatKas);

                            } else {
                                System.out.println("Nomor siswa tidak valid.");
                            }
                        }
                    }

                    // Keluar dari aplikasi
                    case 8 -> {
                        running = false;
                        System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    }

                    default -> System.out.println("Pilihan tidak valid, coba lagi.");
                }
            }

            scanner.close();
        }
    }
}