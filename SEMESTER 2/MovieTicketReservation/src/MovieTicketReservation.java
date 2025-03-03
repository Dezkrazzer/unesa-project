import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MovieTicketReservation {
    // Menyimpan data film
    static ArrayList<MovieList> movieList = new ArrayList<>();

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
                    case 2 -> cariTiket(scanner); 
                    case 3 -> {
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


    public static void cariTiket(Scanner scanner) {
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
    
        // Menampilkan semua waktu tayang yang tersedia
        System.out.println("\nFilm yang ditemukan: " + filmYangDicari);
        System.out.println("Harga per tiket: Rp" + String.format("%,.0f", hasilPencarian.get(0).getHarga()).replace(",", "."));
        
        for (int i = 0; i < hasilPencarian.size(); i++) {
            System.out.println((i + 1) + ". " + hasilPencarian.get(i).getShowTime());
        }

        // Memilih waktu tayang
        System.out.print("Pilih waktu tayang (nomor): ");
        int waktuPilihan = scanner.nextInt();
    
        if (waktuPilihan < 1 || waktuPilihan > hasilPencarian.size()) {
            System.out.println("[ERROR] | Pilihan tidak valid.");
            return;
        }

        MovieList filmYangDipilih = hasilPencarian.get(waktuPilihan - 1);
    
        // Meminta input untuk jumlah tiket yang ingin dipesan
        int jumlahTiket = 0;
        while (true) {
            System.out.print("Masukkan jumlah tiket yang ingin dibeli: ");
            try {
                jumlahTiket = scanner.nextInt();
                if (jumlahTiket <= 0) {
                    System.out.println("[ERROR] | Jumlah tiket harus lebih besar dari 0.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] | Input tidak valid, silakan coba lagi.");
                scanner.next();
            }
        }
    
        // Memperbarui jumlah tiket yang tersedia
        filmYangDipilih.setJumlahTiket(jumlahTiket);
    
        // Menghitung total harga
        double totalHarga = filmYangDipilih.hitungHargaTotal();
        
        // Menampilkan informasi pemesanan tiket
        System.out.println("\nPemesanan Tiket");
        System.out.println("Film       : " + filmYangDipilih.getJudulFilm());
        System.out.println("Waktu      : " + filmYangDipilih.getShowTime());
        System.out.println("Jumlah Tiket: " + jumlahTiket);
        System.out.println("Total Harga: Rp" + String.format("%,.0f", totalHarga).replace(",", "."));
        System.out.println("\nTerima kasih telah memesan tiket!!");
    }
}
