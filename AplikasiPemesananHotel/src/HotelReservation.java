import java.util.Scanner;

public class HotelReservation {
    public static void main(String[] args) {
        // Nama Aplikasi
        System.out.println("===============================================");
        System.out.println("          APLIKASI PEMESANAN HOTEL DELUNA      ");
        System.out.println("===============================================");

        try (
        Scanner scanner = new Scanner(System.in)) {

            // Input nama tamu (String)
            System.out.print("Masukkan nama Anda: ");
            String namaTamu = scanner.nextLine();

            // Input jumlah malam menginap (int)
            System.out.print("Masukkan jumlah malam menginap: ");
            int jumlahMalam = scanner.nextInt();

            // Input tipe kamar (Switch case)
            System.out.println("===============================================");
            System.out.println("Pilih tipe kamar:");
            System.out.println("1. Standar (Rp500,000 per malam)");
            System.out.println("2. Deluxe (Rp750,000 per malam)");
            System.out.println("3. Suite (Rp1,000,000 per malam)");
            System.out.print("Masukkan pilihan tipe kamar (1-3): ");
            int tipeKamar = scanner.nextInt();
            double hargaKamar;

            switch (tipeKamar) { //Ini menggunakan rule switch karena saya pakai java 23
                case 1 -> hargaKamar = 500000;
                case 2 -> hargaKamar = 750000;
                case 3 -> hargaKamar = 1000000;
                default -> {
                    System.out.println("Pilihan tidak valid, menggunakan tipe Standar.");
                    hargaKamar = 500000;
                }
            }

            // Input apakah include sarapan atau nggak (boolean)
            System.out.print("Apakah Anda ingin sarapan? (true/false): ");
            boolean denganSarapan = scanner.nextBoolean();
            double biayaSarapan = denganSarapan ? 50000 : 0;

            // Menghitung total biaya
            double totalBiaya = (hargaKamar + biayaSarapan) * jumlahMalam;

            // Output hasil proses
            System.out.println("===============================================");
            System.out.println("               RINGKASAN PEMESANAN              ");
            System.out.println("===============================================");
            System.out.printf("| %-20s : %-20s |\n", "Nama Tamu", namaTamu);
            System.out.printf("| %-20s : %-20d |\n", "Jumlah Malam", jumlahMalam);
            System.out.printf("| %-20s : %-20s |\n", "Tipe Kamar", (tipeKamar == 1 ? "Standar" : tipeKamar == 2 ? "Deluxe" : "Suite"));
            System.out.printf("| %-20s : %-20s |\n", "Dengan Sarapan", (denganSarapan ? "Ya" : "Tidak"));
            System.out.printf("| %-20s : %-20.2f |\n", "Total Biaya", totalBiaya);
            System.out.println("===============================================");

            // Menentukan apakah biaya lebih dari 2 juta dapat diskon (if-else)
            if (totalBiaya > 2000000) {
                System.out.println("Anda mendapatkan diskon 5%!");
                totalBiaya *= 0.5;
                System.out.println("Total Biaya Setelah Diskon: Rp" + totalBiaya);
            } else {
                System.out.println("Anda tidak mendapatkan diskon.");
            }
        }

        // Output akhiran
        System.out.println("===============================================");
        System.out.println("      Terima kasih sudah memesan di hotel kami! ");
        System.out.println("===============================================");


        //Bagian Informasi Pembuat
        System.out.println(" ");
        System.out.println("***********************************************");
        System.out.println("**         Aplikasi ini dibuat oleh          **");
        System.out.println("**         Lazuardi Akbar Imani              **");
        System.out.println("***********************************************");
    }
}
