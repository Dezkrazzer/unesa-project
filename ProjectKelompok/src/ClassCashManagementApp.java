import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClassCashManagementApp {

//  ⚠️ ==========[ DEKLARASI VARIABLE ]========== ⚠️
    static ArrayList<String> namaSiswa = new ArrayList<>(); // ✅ Format data string
    static ArrayList<Double> kasSiswa = new ArrayList<>();
    static ArrayList<String> alasanPengeluaran = new ArrayList<>();
    static ArrayList<Double> pengeluaranKas = new ArrayList<>();
    static boolean running = true; // ✅ Format data boolean
    static double totalKas = 0; // ✅ Format data double
    static double totalPemasukan = 0;
    static double totalPengeluaran = 0;
//  ⛔ =======[ END OF DEKLARASI VARIABLE]======= ⛔

    public static void main(String[] args) {

//      ✅ ==========[ NAMA APLIKASI ]========== ✅
        System.out.println("╔==============================================╗");
        System.out.println("|>>>                                        <<<|");
        System.out.println("|>>       Aplikasi Pendataan Kas Kelas       <<|");
        System.out.println("|>>>                                        <<<|");
        System.out.println("╚==============================================╝");
//      ⛔ ==========[ END OF SECTION ]========== ⛔

        try (Scanner scanner = new Scanner(System.in)) {

//          ✅ ==========[ LOOPING (WHILE) ]========== ✅
            while (running) {

//              ✅ ==========[ MENU UTAMA (FUNCTION) ]========== ✅
                tampilkanPilihanMenu();
                int pilihan = scanner.nextInt();

//              ✅ ==========[ PILIHAN (SWTICH CASE) ]========== ✅
                switch (pilihan) {
                    case 1 ->
                        tambahDataSiswa(scanner);
                    case 2 ->
                        tambahKasSiswa(scanner);
                    case 3 ->
                        pengeluaranKas(scanner);
                    case 4 ->
                        tampilkanRekapKas();
                    case 5 ->
                        hapusDataSiswa(scanner);
                    case 6 ->
                        tampilkanTotalKas();
                    case 7 ->
                        cekProfilSiswa(scanner);
                    case 8 -> {
                        tampilkanPenutup();
                        return; // Keluar dari aplikasi
                    }
                    default ->
                        System.out.println("[ERROR] | Pilihanmu tidak valid, coba lagi.");
                }
            }

            scanner.close();
        }
    }

//  ✅ ==========[ MENU UTAMA (FUNCTIION) ]========== ✅
    public static void tampilkanPilihanMenu() {
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
        System.out.print("> Pilih menu: ");
    }
//  ⛔ ==========[ END OF SECTION ]========== ⛔

//  ✅==========[ PEMINDAHAN SWITCH CASE TO REKRUSIF ]========== ✅

//  ⚠️ ==========[ CASE 1 | MENAMBAH DATA SISWA ]========== ⚠️
    public static void tambahDataSiswa(Scanner scanner) {
        try {
            System.out.print("> Masukkan nama siswa: ");
            scanner.nextLine();
            String nama = scanner.nextLine();
            while (nama.length() < 2 || nama.length() > 10) {
                System.out.println("[ERROR] | Nama harus memiliki 2 hingga 10 huruf. Silakan coba lagi.");
                System.out.print("> Masukkan nama siswa: ");
                nama = scanner.nextLine();
            }
            System.out.println("[INFO] | Nama disimpan dengan huruf kapital: " + nama.toUpperCase());
            System.out.print("> Masukkan jumlah kas " + nama.toUpperCase() + ": ");
            double kas = scanner.nextDouble();

            String formatRupiah = String.format("Rp%,d", (int) kas).replace(",", ".");
            System.out.println("[INFO] | Kas " + nama.toUpperCase() + " " + formatRupiah);

            namaSiswa.add(nama.toUpperCase());
            kasSiswa.add(kas);
            totalKas += kas;
            totalPemasukan += kas;
            System.out.println("[SUCCESS] | Data siswa berhasil ditambahkan.");
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] | Input tidak valid, hanya angka yang diterima.");
            scanner.nextLine();
        }
    }
//  ⛔ ==========[ END OF SECTION ]========== ⛔

//  ⚠️ ==========[ CASE 2 | MENAMBAH KAS SISWA SAMA ]========== ⚠️
    public static void tambahKasSiswa(Scanner scanner) {
        try {
            System.out.println("\nDaftar Siswa:");
            for (int i = 0; i < namaSiswa.size(); i++) {
                String formatRupiah = String.format("Rp%,d", kasSiswa.get(i).intValue());
                formatRupiah = formatRupiah.replace(",", ".");
                System.out.printf("%d. %s - Kas: %s\n", (i + 1), namaSiswa.get(i), formatRupiah);
            }
            System.out.print("> Masukkan nomor siswa yang ingin menambah kas: ");
            int nomorSiswa = scanner.nextInt();
            System.out.print("> Masukkan jumlah kas tambahan: ");
            double tambahanKas = scanner.nextDouble();

            if (nomorSiswa > 0 && nomorSiswa <= namaSiswa.size()) {
                kasSiswa.set(nomorSiswa - 1, kasSiswa.get(nomorSiswa - 1) + tambahanKas);
                totalKas += tambahanKas;
                totalPemasukan += tambahanKas;
                System.out.println("[SUCCESS] | Kas berhasil ditambahkan.");
            } else {
                System.out.println("[ERROR] | Nomor siswa tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] | Input tidak valid, hanya angka yang diterima.");
            scanner.nextLine();
        }
    }
//  ⛔ ==========[ END OF SECTION ]========== ⛔

//  ⚠️ ==========[ CASE 3 | MENCATAT PENGELUARAN KAS ]========== ⚠️
    public static void pengeluaranKas(Scanner scanner) {
        try {
            System.out.print("> Masukkan jumlah pengeluaran kas: ");
            double pengeluaranKasAmount = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("> Masukkan keterangan pengeluaran: ");
            String keteranganPengeluaran = scanner.nextLine();

            if (pengeluaranKasAmount <= totalKas) {

                totalPengeluaran += pengeluaranKasAmount;
                pengeluaranKas.add(pengeluaranKasAmount);
                alasanPengeluaran.add(keteranganPengeluaran);
                System.out.println("[INFO] | Keterangan: " + keteranganPengeluaran);
                String formatRupiah = String.format("Rp%,d", (int) pengeluaranKasAmount).replace(",", ".");
                System.out.println("[SUCCESS] | Pengeluaran sebesar " + formatRupiah + " berhasil dicatat.");
            } else {
                System.out.println("[ERROR] | Total kas tidak mencukupi dengan pengeluaran tersebut.");
            }
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] | Input tidak valid, hanya angka yang diterima.");
            scanner.nextLine();
        }
    }
//  ⛔ ==========[ END OF SECTION ] ========== ⛔

//  ⚠️ ==========[ CASE 4 | MENAMPILKAN REKAP KAS ]========== ⚠️
    public static void tampilkanRekapKas() {
        totalKas -= totalPengeluaran;
        if (namaSiswa.isEmpty()) {
            System.out.println("Belum ada data siswa.");
        } else {
            System.out.println("|==========================================================================|");
            System.out.println("|    |            PEMASUKAN               |            PENGELUARAN         |");
            System.out.println("|==========================================================================|");
            System.out.println("| NO | NAMA SISWA          |    JUMLAH    | KETERANGAN        |   JUMLAH   |");
            System.out.println("|----|---------------------|--------------|-------------------|------------|");

//          ✅ ==========[ Looping Tampilkan Pemasukan (for) ]========== ✅
            for (int i = 0; i < namaSiswa.size(); i++) {
                String formatRupiahPemasukan = String.format("Rp%,d", kasSiswa.get(i).intValue());

                System.out.printf("| %-2d | %-19s | %-12s | %-17s | %-10s |\n",
                        (i + 1),
                        namaSiswa.get(i),
                        formatRupiahPemasukan.replace(",", "."),
                        "",
                        "");
            }
            System.out.println("|----|---------------------|--------------|-------------------|------------|");
//          ✅ ==========[ Tampilkan Pengeluaran ]========== ✅
            for (int i = 0; i < alasanPengeluaran.size(); i++) {
                String formatRupiahPengeluaran = String.format("Rp%,d", pengeluaranKas.get(i).intValue());
                System.out.printf("| %-2s | %-19s | %-12s | %-17s | %-10s |\n",
                        (i + 1),
                        "",
                        "",
                        alasanPengeluaran.get(i),
                        formatRupiahPengeluaran.replace(",", "."));
            }
            String formatTotalPemasukan = String.format("Rp%,d", (int) totalPemasukan).replace(",", "."); 
            String formatTotalPengeluaran = String.format("Rp%,d", (int) totalPengeluaran).replace(",", "."); 
            String formatTotalKas = String.format("Rp%,d", (int) totalKas).replace(",", "."); 
            String kasDalamNominal = konversiAngkaKeNominal((long) totalKas);
            System.out.println("|----|---------------------|--------------|-------------------|------------|");
            System.out.printf("| %-24s | %-45s |\n", "TOTAL PEMASUKAN:", formatTotalPemasukan);
            System.out.printf("| %-24s | %-45s |\n", "TOTAL PENGELUARAN:", formatTotalPengeluaran);
            System.out.printf("| %-24s | %-45s |\n", "JUMLAH KAS SEKARANG:", formatTotalKas);
            System.out.printf("| %-24s | %-45s |\n", "TERBILANG:", kasDalamNominal + " Rupiah");
            System.out.println("|==========================================================================|");
        }
    }
// ⛔ ==========[ END OF SECTION ]========== ⛔

//  ⚠️ ==========[ CASE 5 | MENGHAPUS DATA SISWA]========== ⚠️
    public static void hapusDataSiswa(Scanner scanner) {
        try {
            System.out.println("\nDaftar Siswa:");
            for (int i = 0; i < namaSiswa.size(); i++) {
                System.out.printf("%d. %s - Kas: Rp%,.2f\n", i + 1, namaSiswa.get(i), kasSiswa.get(i));
            }
            System.out.print("> Masukkan nomor siswa yang ingin dihapus: ");
            int nomorSiswa = scanner.nextInt(); // ✅ Format data int

            if (nomorSiswa > 0 && nomorSiswa <= namaSiswa.size()) {
                totalKas -= kasSiswa.get(nomorSiswa - 1);
                namaSiswa.remove(nomorSiswa - 1);
                kasSiswa.remove(nomorSiswa - 1);
                System.out.println("[SUCCESS] | Data siswa berhasil dihapus.");
            } else {
                System.out.println("[ERROR] | Nomor siswa tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] | Input yang kamu masukkan tidak valid.");
            scanner.nextLine();
        }
    }
//  ⛔ ==========[ END OF SECTION]========== ⛔

//  ⚠️ ==========[ CASE 6 | MELIHAT TOTAL KAS ]========== ⚠️
    public static void tampilkanTotalKas() {
        String formatRupiah = String.format("Rp%,d", (int) totalKas).replace(",", ".");
        System.out.println("\nTotal kas saat ini: " + formatRupiah);
                            
        String kasDalamNominal = konversiAngkaKeNominal((long) totalKas);
        System.out.println("Total Kas terbilang: " + kasDalamNominal + " rupiah");
    }
//  ⛔ ==========[ END OF SECTION ]========== ⛔

//  ⚠️ ==========[ CASE 7 | PROFILE SISWA ]========== ⚠️
    public static void cekProfilSiswa(Scanner scanner) {
        try {
            System.out.println("\nDaftar Siswa:");
            for (int i = 0; i < namaSiswa.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, namaSiswa.get(i));
            }

            System.out.print("> Masukkan nomor siswa untuk melihat profil: ");
            int nomorSiswa = scanner.nextInt();

            if (nomorSiswa > 0 && nomorSiswa <= namaSiswa.size()) {
                String nama = namaSiswa.get(nomorSiswa - 1);
                double totalKasSiswa = kasSiswa.get(nomorSiswa - 1);

 //             ✅ ==========[ 1 | Mengubah Nama ke Huruf Kapital ] ========== ✅
                System.out.println("|Nama siswa dalam huruf besar: |" + nama.toUpperCase());

//              ✅ ==========[ 2 | Mengubah Nama ke Huruf Kecil ]========== ✅
                System.out.println("|Nama siswa dalam huruf kecil: |" + nama.toLowerCase());

//              ✅ ==========[ 3 | Mengambil Inisial Nama ]========== ✅
                String inisial = nama.substring(0, 1).toUpperCase() + ".";
                System.out.println("|Inisial Nama                : |" + inisial);

//              ✅ ==========[ 4 | Validasi Panjang Nama ] ========== ✅
                System.out.println("|Panjang Nama                : |" + nama.length() + " karakter");

//              ✅ ==========[ 5 | Membalik Nama ]========= ✅
                String namaTerbalik = new StringBuilder(nama).reverse().toString();
                System.out.println("|Nama Terbalik               : |" + namaTerbalik);

//              ✅ ==========[ 6 | Format Total Kas Siswa ke Rupiah ]========= ✅
                String formatKas = String.format("Rp%,d", (int) totalKasSiswa).replace(",", ".");
                System.out.println("|Total Kas Siswa             : |" + formatKas);


                formatTabel();
            } else {
                System.out.println("[ERROR] | Nomor siswa tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] | Input tidak valid.");
            scanner.nextLine();
        }
    }
//  ⛔ ==========[ END OF SECTION ]========== ⛔

//  ⚠️ ==========[ CREDIT SECTION (FUNCTION) ]========== ⚠️
    public static void tampilkanPenutup() {
        System.out.println("|-----------------------------------------------|");
        System.out.println("|  TERIMAKASIH TELAH MENGGUNAKAN APLIKASI KAMI  |");
        System.out.println("|            <<< KELOMPOK EMPAT >>>             |");
        System.out.println("|-----------------------------------------------|");
        System.out.printf("| %-25s |  %-15s  |%n", "NAMA", "NIM");
        System.out.println("|-----------------------------------------------|");
        System.out.printf("| %-25s |  %-15s  |%n", "Fadly Fais Fajarruddin", "24111814015");
        System.out.printf("| %-25s |  %-15s  |%n", "Lazuardi Akbar Imani", "24111814119");
        System.out.printf("| %-25s |  %-15s  |%n", "Faqih Rafasha Argandhi", "24111814032");
        System.out.printf("| %-25s |  %-15s  |%n", "Febriana Nur Ain", "24111814006");
        System.out.printf("| %-25s |  %-15s  |%n", "Leony Andika Triwicaksono", "24111814022");
        System.out.printf("| %-25s |  %-15s  |%n", "Manda Fatimah Azaziah", "24111814044");
        System.out.printf("| %-25s |  %-15s  |%n", "Muhammad Rifki Maulana", "24111814084");
        System.out.println("|-----------------------------------------------|");
        System.out.println("|              JANGAN LUPA MAKAN                |");
        System.out.println("|-----------------------------------------------|");
    }
//  ⛔ ==========[ END OF SECTION ]========== ⛔

//  ✅ Fungsi untuk memformat tampilan tabel ✅
    public static void formatTabel() {
        System.out.println("|==============================|==============================|");
    }

//  ✅ ==========[ KONVERSI ANGKA (REKURSIF) ]========== ✅
    public static String konversiAngkaKeNominal(long angka) {
        String[] satuan = {
            "", "se", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan", "sepuluh", "sebelas"
        };
        String hasil;

        if (angka < 12) {
            hasil = satuan[(int) angka];
        } else if (angka < 20) {
            hasil = satuan[(int) angka % 10] + " belas";
        } else if (angka < 100) {
            hasil = satuan[(int) angka / 10] + " puluh " + konversiAngkaKeNominal(angka % 10);
        } else if (angka < 1000) {
            hasil = satuan[(int) angka / 100] + " ratus " + konversiAngkaKeNominal(angka % 100);
        } else if (angka < 1000000) {
            hasil = konversiAngkaKeNominal(angka / 1000) + " ribu " + konversiAngkaKeNominal(angka % 1000);
        } else if (angka < 1000000000) {
            hasil = konversiAngkaKeNominal(angka / 1000000) + " juta " + konversiAngkaKeNominal(angka % 1000000);
        } else {
            hasil = konversiAngkaKeNominal(angka / 1000000000) + " miliar " + konversiAngkaKeNominal(angka % 1000000000);
        }

        return hasil.trim();
    }
//  ⛔ ==========[ END OF SECTION ]========== ⛔
}
