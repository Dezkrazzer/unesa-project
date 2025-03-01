import java.util.Scanner;
public class testkursi {

    public static void main(String[] args) {
        // Inisialisasi kursi bioskop (O = kosong, X = sudah dipesan)
        char[][] seats = {
            {'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O'}
        };

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                // Menampilkan kursi
                System.out.println("LAYAR BIOSKOP");
                for (char[] seat : seats) {
                    for (int j = 0; j < seat.length; j++) {
                        System.out.print("[" + seat[j] + "] ");
                    }
                    System.out.println();
                }

                // Meminta input pemesanan
                System.out.print("Masukkan baris (1-4) atau 0 untuk keluar: ");
                int row = scanner.nextInt();
                if (row == 0) break;
                
                System.out.print("Masukkan kolom (1-6): ");
                int col = scanner.nextInt();
                
                // Cek ketersediaan kursi
                if (row < 1 || row > seats.length || col < 1 || col > seats[0].length) {
                    System.out.println("Posisi kursi tidak valid!");
                } else if (seats[row - 1][col - 1] == 'X') {
                    System.out.println("Kursi sudah dipesan!");
                } else {
                    // Pesan kursi
                    seats[row - 1][col - 1] = 'X';
                    System.out.println("Kursi berhasil dipesan!");
                }
            }
        }
        System.out.println("Terima kasih telah menggunakan layanan kami!");
    }
}
