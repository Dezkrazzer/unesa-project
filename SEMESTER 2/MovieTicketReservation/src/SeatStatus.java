import java.util.Arrays;

class SeatStatus {
    String jadwal;
    char[][] seats;

    public SeatStatus(String jadwal) {
        this.jadwal = jadwal;
        this.seats = new char[6][8];
        for (char[] row : seats) {
            Arrays.fill(row, 'O'); // O berarti kursi kosong
        }
    }
}
