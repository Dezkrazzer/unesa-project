public class MovieList {
    private String judulFilm;
    private double harga;
    private String showTime; // Sekarang hanya menyimpan satu waktu tayang
    private double jumlahTiket;
    protected String noSeat;
    protected int auditorium;

    public MovieList(
        String judulFilm, 
        double harga, 
        String showTime,  // Ubah menjadi String tunggal
        double jumlahTiket, 
        String noSeat, 
        int auditorium) {

            this.judulFilm = judulFilm;
            this.harga = harga;
            this.showTime = showTime;  // Inisialisasi satu waktu tayang saja
            this.jumlahTiket = jumlahTiket;
            this.noSeat = noSeat;
            this.auditorium = auditorium;
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

    public String getShowTime() { // Perubahan disini
        return showTime;
    }

    public void setShowTime(String showTime) { // Perubahan disini
        this.showTime = showTime;
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

    protected int getAuditorium() {
        return auditorium;
    }
    
    protected void setAuditorium(int auditorium) {
        this.auditorium = auditorium;
    }

    protected double hitungHargaTotal() {
        return harga * jumlahTiket;
    }
    /* 
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
    */
}
