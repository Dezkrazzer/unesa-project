import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MovieTicketReservation {
    // Menyimpan data film
    static ArrayList<MovieList> movieList = new ArrayList<>();

    private static final int ROWS = 6; // Jumlah baris kursi (A-F)
    private static final int COLS = 8; // Jumlah kolom kursi (1-8)
    private static final char[] ROW_LABELS = {'A', 'B', 'C', 'D', 'E', 'F'}; // Label baris

    private static final ArrayList<SeatStatus> seatList = new ArrayList<>();
    private static final ArrayList<MovieList> myTickets = new ArrayList<>();

    static {
        initializeMovieList();
    }

    private static void initializeMovieList() {
        // DATA FILM STUDIO 1
        movieList.add(new MovieList("Minions", 40000, "10:00", 0, "", 1));
        movieList.add(new MovieList("Interstellar", 40000, "12:00", 0, "", 1));
        movieList.add(new MovieList("Avengers: Endgame", 40000, "14:00", 0, "", 1));
        movieList.add(new MovieList("Spiderman", 40000, "16:00", 0, "", 1));
        movieList.add(new MovieList("The Lion King", 40000, "18:00", 0, "", 1));
        movieList.add(new MovieList("Yowis Ben 3", 40000, "20:00", 0, "", 1));
        movieList.add(new MovieList("Dilan 1990", 40000, "22:00", 0, "", 1));
        // DATA FILM STUDIO 2
        movieList.add(new MovieList("The Lion King", 40000, "10:00", 0, "", 2));
        movieList.add(new MovieList("Dilan 1990", 40000, "12:00", 0, "", 2));
        movieList.add(new MovieList("Yowis Ben 3", 40000, "14:00", 0, "", 2));
        movieList.add(new MovieList("Avengers: Endgame", 40000, "16:00", 0, "", 2));
        movieList.add(new MovieList("Minions", 40000, "18:00", 0, "", 2));
        movieList.add(new MovieList("Spiderman", 40000, "20:00", 0, "", 2));
        movieList.add(new MovieList("Interstellar", 40000, "22:00", 0, "", 2));
        // DATA FILM STUDIO 3
        movieList.add(new MovieList("Yowis Ben 3", 40000, "10:00", 0, "", 3));
        movieList.add(new MovieList("The Lion King", 40000, "12:00", 0, "", 3));
        movieList.add(new MovieList("Minions", 40000, "14:00", 0, "", 3));
        movieList.add(new MovieList("Interstellar", 40000, "16:00", 0, "", 3));
        movieList.add(new MovieList("Avengers: Endgame", 40000, "18:00", 0, "", 3));
        movieList.add(new MovieList("Dilan 1990", 40000, "20:00", 0, "", 3));
        movieList.add(new MovieList("Spiderman", 40000, "22:00", 0, "", 3));
    }

    public static void main(String[] args) { 
        movieFunction.tampilkanJudul();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) { 
                movieFunction.tampilkanPilihanMenu(); 
                int pilihan = scanner.nextInt(); 

                switch (pilihan) { 
                    case 1 -> tampilkanJadwal(); 
                    case 2 -> cariTiket(scanner, movieList);
                    case 3 -> lihatTiketSaya();
                    case 4 -> {
                        System.out.println("Terima kasih, keluar dari aplikasi.");
                        System.out.println("Credits: Lazuardi Akbar (24111814119)");
                        return;
                    }
                    default -> System.out.println("[ERROR] | Pilihanmu tidak valid, coba lagi.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] | Input tidak valid, silakan coba lagi.");
        }
    }

    public static void tampilkanJadwal() {
        // Mengumpulkan daftar waktu tayang dan studio
        List<String> showTimes = new ArrayList<>();
        List<Integer> studios = new ArrayList<>();
        List<MovieList> sortedMovies = new ArrayList<>(movieList);

        // Mengurutkan film berdasarkan waktu tayang
        Collections.sort(sortedMovies, Comparator.comparing(MovieList::getShowTime));

        // Mengumpulkan daftar waktu tayang dan studio
        for (MovieList movie : sortedMovies) {
            if (!showTimes.contains(movie.getShowTime())) {
                showTimes.add(movie.getShowTime());
            }
            if (!studios.contains(movie.getAuditorium())) {
                studios.add(movie.getAuditorium());
            }
        }
    
        System.out.print("------------------------------------------------------------------------------------");
        System.out.print("\n| Showtime |");
        for (int studio : studios) {
            System.out.printf("        Studio %-7d |", studio);
        }
        System.out.println("\n|----------|" + "-----------------------|".repeat(studios.size()));
    
        // Isi tabel
        for (String time : showTimes) {
            System.out.printf("| %-8s |", time);
            for (int studio : studios) {
                String film = "-";
                for (MovieList movie : sortedMovies) {
                    if (movie.getShowTime().equals(time) && movie.getAuditorium() == studio) {
                        film = movie.getJudulFilm();
                        break;
                    }
                }
                System.out.printf(" %-21s |", film);
            }
            System.out.println();
            
        }
        System.out.println("------------------------------------------------------------------------------------");
    }


    public static void cariTiket(Scanner scanner, ArrayList<MovieList> movieList) {
        System.out.print("Masukkan nama film yang ingin dicari: ");
        scanner.nextLine();
        String filmYangDicari = scanner.nextLine();

        ArrayList<MovieList> hasilPencarian = new ArrayList<>();
        for (MovieList movie : movieList) {
            if (movie.getJudulFilm().equalsIgnoreCase(filmYangDicari)) {
                hasilPencarian.add(movie);
            }
        }

        if (hasilPencarian.isEmpty()) {
            System.out.println("[ERROR] | Film tidak ditemukan!");
            return;
        }

        System.out.println("\nFilm yang ditemukan: " + filmYangDicari);
        System.out.println("Harga per tiket: Rp" + String.format("%,.0f", hasilPencarian.get(0).getHarga()).replace(",", "."));

        for (int i = 0; i < hasilPencarian.size(); i++) {
            System.out.println((i + 1) + ". " + hasilPencarian.get(i).getShowTime());
        }

        System.out.print("Pilih waktu tayang (nomor): ");
        int waktuPilihan = scanner.nextInt();

        if (waktuPilihan < 1 || waktuPilihan > hasilPencarian.size()) {
            System.out.println("[ERROR] | Pilihan tidak valid.");
            return;
        }

        MovieList filmYangDipilih = hasilPencarian.get(waktuPilihan - 1);
        String scheduleKey = filmYangDipilih.getJudulFilm() + " - " + filmYangDipilih.getShowTime();

        // Cek apakah jadwal ini sudah ada dalam seatList
        SeatStatus seatStatus = null;
        for (SeatStatus s : seatList) {
            if (s.jadwal.equals(scheduleKey)) {
                seatStatus = s;
                break;
            }
        }

        // Jika tidak ditemukan, buat yang baru
        if (seatStatus == null) {
            seatStatus = new SeatStatus(scheduleKey);
            seatList.add(seatStatus);
        }

        char[][] seats = seatStatus.seats; // Ambil status kursi dari jadwal yang dipilih

        int jumlahTiket;
        while (true) {
            System.out.print("Masukkan jumlah tiket yang ingin dibeli: ");
            try {
                jumlahTiket = scanner.nextInt();
                if (jumlahTiket <= 0) {
                    System.out.println("[ERROR] | Jumlah tiket harus lebih besar dari 0.");
                } else if (jumlahTiket > (ROWS * COLS)) {
                    System.out.println("[ERROR] | Jumlah tiket melebihi kapasitas bioskop.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] | Input tidak valid, silakan coba lagi.");
                scanner.next();
            }
        }

        tampilkanKursi(seats);

        StringBuilder kursiTerpilih = new StringBuilder();
        for (int i = 0; i < jumlahTiket; i++) {
            while (true) {
                System.out.print("Pilih kursi untuk tiket ke-" + (i + 1) + " (contoh: A4): ");
                String pilihanKursi = scanner.next().toUpperCase();

                if (pilihanKursi.length() < 2 || pilihanKursi.length() > 3) {
                    System.out.println("[ERROR] | Format kursi tidak valid. Gunakan format seperti A4.");
                    continue;
                }

                char barisChar = pilihanKursi.charAt(0);
                int barisIndex = -1;
                for (int j = 0; j < ROW_LABELS.length; j++) {
                    if (ROW_LABELS[j] == barisChar) {
                        barisIndex = j;
                        break;
                    }
                }

                if (barisIndex == -1) {
                    System.out.println("[ERROR] | Baris tidak valid.");
                    continue;
                }

                int kolomIndex;
                try {
                    kolomIndex = Integer.parseInt(pilihanKursi.substring(1)) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] | Nomor kursi tidak valid.");
                    continue;
                }

                if (kolomIndex < 0 || kolomIndex >= COLS) {
                    System.out.println("[ERROR] | Nomor kursi tidak valid.");
                    continue;
                }

                if (seats[barisIndex][kolomIndex] == 'X') {
                    System.out.println("[ERROR] | Kursi sudah dipesan, pilih yang lain.");
                } else {
                    seats[barisIndex][kolomIndex] = 'X';
                    if (kursiTerpilih.length() > 0) {
                        kursiTerpilih.append("; ");
                    }
                    kursiTerpilih.append(pilihanKursi);
                    break;
                }
            }
        }

        tampilkanKursi(seats);

        // Simpan nomor kursi ke dalam MovieList
        filmYangDipilih.setNoSeat(kursiTerpilih.toString());

        double totalHarga = filmYangDipilih.hitungHargaTotal();

        System.out.println("\nPemesanan Tiket");
        System.out.println("Film       : " + filmYangDipilih.getJudulFilm());
        System.out.println("Studio      : " + filmYangDipilih.getAuditorium());
        System.out.println("Waktu      : " + filmYangDipilih.getShowTime());
        System.out.println("Jumlah Tiket: " + jumlahTiket);
        System.out.println("Nomor Kursi : " + kursiTerpilih);
        System.out.println("Total Harga: Rp" + String.format("%,.0f", totalHarga).replace(",", "."));
        System.out.println("\nTerima kasih telah memesan tiket!!");

        myTickets.add(new MovieList(filmYangDipilih.getJudulFilm(), filmYangDipilih.getHarga(), 
        filmYangDipilih.getShowTime(), jumlahTiket, filmYangDipilih.getNoSeat(), 
        filmYangDipilih.getAuditorium()));
    }

    public static void tampilkanKursi(char[][] seats) {
        System.out.println("\nLAYAR BIOSKOP");
        System.out.println("=========================");
        for (int i = ROWS - 1; i >= 0; i--) {
            System.out.print(ROW_LABELS[i] + "  ");
            for (int j = 0; j < COLS; j++) {
                System.out.print("[" + seats[i][j] + "] ");
            }
            System.out.println();
        }
        System.out.print("    ");
        for (int j = 1; j <= COLS; j++) {
            System.out.printf("%-4d", j);
        }
        System.out.println();
    }

    public static void lihatTiketSaya() {
        if (myTickets.isEmpty()) {
            System.out.println("\nAnda belum memiliki tiket.");
            return;
        }
    
        System.out.println("\n📌 Tiket yang telah Anda pesan:");
        System.out.println("========================================");
        for (int i = 0; i < myTickets.size(); i++) {
            MovieList tiket = myTickets.get(i);
            System.out.println((i + 1) + ". Film: " + tiket.getJudulFilm());
            System.out.println("   Studio: " + tiket.getAuditorium());
            System.out.println("   Waktu : " + tiket.getShowTime());
            System.out.println("   Kursi : " + tiket.getNoSeat());
            System.out.println("   Jumlah Tiket: " + tiket.getJumlahTiket());
            System.out.println("   Total Harga : Rp" + String.format("%,.0f", tiket.hitungHargaTotal()).replace(",", "."));
            System.out.println("========================================");
        }
    }
}