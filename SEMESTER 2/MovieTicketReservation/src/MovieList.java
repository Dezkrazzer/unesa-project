import java.util.ArrayList;

public class MovieList {
    private String judulFilm;
    private double harga;
    private ArrayList<String> showTimes;  // Menggunakan ArrayList untuk beberapa waktu tayang
    private double jumlahTiket;
    protected String noSeat;
    protected double discountRate;

    public MovieList(
        String judulFilm, 
        double harga, 
        ArrayList<String> showTimes,  // Ubah konstruktor agar menerima list waktu tayang
        double jumlahTiket, 
        String noSeat, 
        double discountRate) {

            this.judulFilm = judulFilm;
            this.harga = harga;
            this.showTimes = showTimes;  // Inisialisasi daftar waktu tayang
            this.jumlahTiket = jumlahTiket;
            this.noSeat = noSeat;
            this.discountRate = discountRate;
    }

    // Getter dan Setter
    public String getJudulFilm() {
        return judulFilm;
    }

    public void setJudulFilm(String judulFilm) {
        this.judulFilm = judulFilm;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga >= 0) {
            this.harga = harga;
        } else {
            System.out.println("[ERROR] Harga yang dimasukkan tidak valid");
        }
    }

    public ArrayList<String> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(ArrayList<String> showTimes) {
        this.showTimes = showTimes;
    }

    public double getJumlahTiket() {
        return jumlahTiket;
    }

    public void setJumlahTiket(double jumlahTiket) {
        this.jumlahTiket = jumlahTiket;
    }

    protected String getNoSeat() {
        return noSeat;
    }

    protected void setNoSeat(String noSeat) {
        this.noSeat = noSeat;
    }

    protected double getDiscountRate() {
        return discountRate;
    }
    
    protected void setDiscountRate(double discountRate) {
        if (discountRate >= 0 && discountRate <= 1) {
            this.discountRate = discountRate;
        } else {
            System.out.println("[ERROR] Diskon yang dimasukkan tidak valid");
        }
    }

    protected double hitungHargaTotal() {
        double total = harga * jumlahTiket;
        double discount = total * discountRate;
        return total - discount;
    }

    public void displayInfo() {
        System.out.println("=====================================");
        System.out.println("       INFORMASI TIKET BIOSKOP       ");
        System.out.println("=====================================");
        System.out.println("Judul Film    : " + getJudulFilm());
        System.out.println("Harga         : " + String.format("Rp%,.0f", getHarga()).replace(",", "."));
        System.out.print("Show Time     : ");
        // Menampilkan semua waktu tayang
        for (String time : getShowTimes()) {
            System.out.print(time + " ");
        }
        System.out.println();
        System.out.println("Jumlah Tiket  : " + getJumlahTiket());
        System.out.println("No Seat       : " + getNoSeat());
        System.out.println("Diskon        : " + (getDiscountRate() * 100) + "%");
        System.out.println("-------------------------------------");
        System.out.println("Total Harga   : " + String.format("Rp%,.0f", hitungHargaTotal()).replace(",", "."));
        System.out.println("=====================================");
    }

}
