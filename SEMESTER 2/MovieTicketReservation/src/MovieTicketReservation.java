import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class MovieTicketReservation {

    // Menggunakan ArrayList MovieList untuk menyimpan data film
    static ArrayList<MovieList> movieList = new ArrayList<>();

    public static void main(String[] args) {

        //      🟩 ==========[ NAMA APLIKASI ]========== 🟩
        System.out.println("╔==============================================╗");
        System.out.println("|>>>                                        <<<|");
        System.out.println("|>>             Aplikasi Bioskop             <<|");
        System.out.println("|>>>                                        <<<|");
        System.out.println("╚==============================================╝");

        //  🟩 ==========[ LOOPING (WHILE) ]========== 🟩
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) { // ⚠️ Looping: while
                movieFunction.tampilkanPilihanMenu(); // ⚠️ Function
                int pilihan = scanner.nextInt(); // ⚠️ Type Data: int

                switch (pilihan) { // ⚠️ Percabangan: switch-case
                    case 1 -> tampilkanJadwal(); // Menampilkan jadwal
                    case 2 -> cariTiket(scanner); // Memesan tiket
                    case 3 -> {
                        System.out.println("Terima kasih, keluar dari aplikasi.");
                        return; // Keluar dari aplikasi
                    }
                    default -> System.out.println("[ERROR] | Pilihanmu tidak valid, coba lagi.");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("[ERROR] | Input tidak valid, silakan coba lagi.");
        }
    }



    @SuppressWarnings("Convert2Lambda")
    public static void tampilkanJadwal() {
        // Menambahkan jadwal film
        ArrayList<String> avengersTimes = new ArrayList<>();
        avengersTimes.add("14.00");
        avengersTimes.add("17.00");
        avengersTimes.add("20.00");
        avengersTimes.add("23.00");
        avengersTimes.add("02.00");
    
        movieList.add(new MovieList("Avengers: End Game", 50000, avengersTimes, 0, "", 0.1));
    
        ArrayList<String> minionsTimes = new ArrayList<>();
        minionsTimes.add("10.00");
        minionsTimes.add("12.00");
        minionsTimes.add("15.00");
    
        movieList.add(new MovieList("Minions", 40000, minionsTimes, 0, "", 0.05));
    
        ArrayList<String> lionKingTimes = new ArrayList<>();
        lionKingTimes.add("13.00");
        lionKingTimes.add("16.00");
        lionKingTimes.add("19.00");
    
        movieList.add(new MovieList("The Lion King", 45000, lionKingTimes, 0, "", 0.08));
    
        // Urutkan film berdasarkan waktu tayang terawal
        Collections.sort(movieList, new Comparator<MovieList>() {
            @Override
            public int compare(MovieList m1, MovieList m2) {
                // Ambil waktu tayang pertama dari masing-masing film
                String time1 = m1.getShowTimes().get(0);
                String time2 = m2.getShowTimes().get(0);
    
                // Mengurutkan berdasarkan waktu tayang pertama film
                return time1.compareTo(time2);
            }
        });
    
        // Menampilkan semua film yang tersedia dengan jadwal terurut
        for (int i = 0; i < movieList.size(); i++) {
            MovieList movie = movieList.get(i);
            System.out.println("\n" + (i + 1) + ". " + movie.getJudulFilm());
    
            // Menampilkan waktu tayang terurut
            System.out.print("    Waktu: ");
            ArrayList<String> sortedTimes = movie.getShowTimes(); // Mengambil daftar waktu tayang
            for (String time : sortedTimes) {
                System.out.print(time + " ");
            }
            System.out.println();
        }
    }

    public static void cariTiket(Scanner scanner) {
        System.out.print("Masukkan nama film yang ingin dicari: ");
        scanner.nextLine();  
        String filmYangDicari = scanner.nextLine();
    
        MovieList filmYangDitemukan = null;
        for (MovieList movie : movieList) {
            if (movie.getJudulFilm().equalsIgnoreCase(filmYangDicari)) {
                filmYangDitemukan = movie;
                break;
            }
        }
    
        if (filmYangDitemukan == null) {
            System.out.println("[ERROR] | Film tidak ditemukan!");
            return;
        }
    
        // Menampilkan informasi film yang ditemukan
        System.out.println("\nFilm yang ditemukan: " + filmYangDitemukan.getJudulFilm());
        System.out.println("Harga per tiket: Rp" + String.format("%,.0f", filmYangDitemukan.getHarga()).replace(",", "."));
        System.out.print("Waktu tayang: ");
        for (String time : filmYangDitemukan.getShowTimes()) {
            System.out.print(time + " ");
        }
        System.out.println();
    
        // Meminta input untuk memilih waktu tayang
        System.out.print("Pilih waktu tayang (masukkan jam): ");
        String waktuTayangDipilih = scanner.nextLine();
    
        // Mengecek apakah waktu tayang yang dipilih ada
        if (!filmYangDitemukan.getShowTimes().contains(waktuTayangDipilih)) {
            System.out.println("[ERROR] | Waktu tayang tidak tersedia.");
            return;
        }
    
        // Meminta input untuk jumlah tiket yang ingin dipesan
        int jumlahTiket = 0;
        while (true) {
            System.out.print("Masukkan jumlah tiket yang ingin dibeli: ");
            try {
                jumlahTiket = scanner.nextInt();
                if (jumlahTiket <= 0) {
                    System.out.println("[ERROR] | Jumlah tiket harus lebih besar dari 0.");
                } else {
                    break;  // Keluar dari loop jika input valid
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] | Input tidak valid, silakan coba lagi.");
                scanner.next();  // Menghapus input yang salah
            }
        }
    
        // Memperbarui jumlah tiket yang tersedia
        filmYangDitemukan.setJumlahTiket(jumlahTiket);
    
        // Menghitung total harga dengan diskon
        double totalHarga = filmYangDitemukan.hitungHargaTotal();
        
        // Menampilkan informasi pemesanan tiket
        System.out.println("\nPemesanan Tiket");
        System.out.println("Film       : " + filmYangDitemukan.getJudulFilm());
        System.out.println("Waktu      : " + waktuTayangDipilih);
        System.out.println("Jumlah Tiket: " + jumlahTiket);
        System.out.println("Total Harga: Rp" + String.format("%,.0f", totalHarga).replace(",", "."));
        System.out.println("\nTerima kasih telah memesan tiket!");
    }
    
    }

