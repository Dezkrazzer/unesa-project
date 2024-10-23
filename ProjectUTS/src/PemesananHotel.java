import java.util.ArrayList;
import java.util.Scanner;

public class PemesananHotel {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<String> pemesanan = new ArrayList<>(); //Digunakan untuk menyimpan ringkasan pesanan
            boolean ulang = true;

            // Nama aplikasi
            System.out.println("===============================================");
            System.out.println("          APLIKASI PEMESANAN HOTEL DELLUNA   ");
            System.out.println("===============================================");

            while (ulang) {
                // Input nama tamu (String)
                System.out.print("Masukkan nama Anda: ");
                String namaTamu = scanner.nextLine();

                // Input jumlah malam menginap (Int)
                System.out.print("Masukkan jumlah malam menginap: ");
                int jumlahMalam = scanner.nextInt();

                // Pilih tipe kamar (switch case)
                System.out.println("Pilih tipe kamar:");
                System.out.println("1. Standar (Rp500,000 per malam)");
                System.out.println("2. Deluxe (Rp750,000 per malam)");
                System.out.println("3. Suite (Rp1,000,000 per malam)");
                System.out.print("Masukkan pilihan tipe kamar (1-3): ");
                int tipeKamar = scanner.nextInt();
                double hargaKamar;

                switch (tipeKamar) {
                    case 1 -> hargaKamar = 500000;
                    case 2 -> hargaKamar = 750000;
                    case 3 -> hargaKamar = 1000000;
                    default -> {
                        System.out.println("Pilihan tidak valid, menggunakan tipe Standar.");
                        hargaKamar = 500000;
                    }
                }

                // Input sarapan (boolean)
                System.out.print("Apakah Anda ingin sarapan? (true/false): ");
                boolean denganSarapan = scanner.nextBoolean();
                double biayaSarapan = denganSarapan ? 50000 : 0;

                // Hitung total biaya (double)
                double totalBiaya = (hargaKamar + biayaSarapan) * jumlahMalam;

                // Kondisi diskon
                if (totalBiaya > 2000000) {
                    System.out.println("Anda mendapatkan diskon 10%!");
                    totalBiaya *= 0.9;
                } else {
                    System.out.println("Anda tidak mendapatkan diskon.");
                }

                // Menyimpan ringkasan ke ArrayList
                String ringkasan = "Nama: " + namaTamu + ", Jumlah Malam: " + jumlahMalam + 
                                   ", Tipe Kamar: " + (tipeKamar == 1 ? "Standar" : tipeKamar == 2 ? "Deluxe" : "Suite") +
                                   ", Sarapan: " + (denganSarapan ? "Ya" : "Tidak") + ", Total: Rp" + totalBiaya;
                pemesanan.add(ringkasan);

                // Tampilkan Ringkasan Pemesanan
                System.out.println("===============================================");
                System.out.println("               RINGKASAN PEMESANAN              ");
                System.out.println("===============================================");
                System.out.printf("| %-20s : %-20s |\n", "Nama Tamu", namaTamu);
                System.out.printf("| %-20s : %-20d |\n", "Jumlah Malam", jumlahMalam);
                System.out.printf("| %-20s : %-20s |\n", "Tipe Kamar", (tipeKamar == 1 ? "Standar" : tipeKamar == 2 ? "Deluxe" : "Suite"));
                System.out.printf("| %-20s : %-20s |\n", "Dengan Sarapan", (denganSarapan ? "Ya" : "Tidak"));
                System.out.printf("| %-20s : %-20.2f |\n", "Total Biaya", totalBiaya);
                System.out.println("===============================================");

                // Tanyakan apakah ingin melakukan pemesanan lagi
                System.out.print("Apakah Anda ingin melakukan pemesanan lain? (true/false): ");
                ulang = scanner.nextBoolean();
                scanner.nextLine(); // Mengosongkan buffer
            }

            // Output seluruh pemesanan menggunakan looping (for)
            System.out.println("\n===============================================");
            System.out.println("           SEMUA PEMESANAN YANG DILAKUKAN       ");
            System.out.println("===============================================");

            for (int i = 0; i < pemesanan.size(); i++) {
                System.out.println("+----------------------------------------------+");
                System.out.printf("| %-45s |\n", "Pemesanan ke-" + (i + 1));
                System.out.println("+----------------------------------------------+");
                String[] detailPemesanan = pemesanan.get(i).split(", ");
                for (String detail : detailPemesanan) {
                    System.out.printf("| %-45s |\n", detail);
                }
                System.out.println("+----------------------------------------------+");
            }
        }
        // Author Section
        System.out.println("***********************************************");
        System.out.println("**         Aplikasi ini dibuat oleh          **");
        System.out.println("**         Lazuardi Akbar Imani              **");
        System.out.println("***********************************************");
    }
}
