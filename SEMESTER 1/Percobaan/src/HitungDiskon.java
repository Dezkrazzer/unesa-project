import java.util.Scanner;

public class HitungDiskon {
        public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {

            //Tampilan nama aplikasi
            System.out.println("=====[ APLIKASI KASIR ]=====");

            //Input nomor antrian
            System.out.print("Masukkan nomor antrian: ");
            int nomorAntrian = input.nextInt();

            //Input nama customer
            System.out.print("Nama Customer: ");
            String namaCustomer = input.next();

            //Input total belanja
            System.out.print("Masukkan total belanja: Rp");
            double totalBelanja = input.nextDouble();

            //Condition Cek diskonnya
            double diskon = 0;
            boolean isDisc50 = totalBelanja > 500000;
            boolean isDisc25 = totalBelanja > 250000;
            
            if (isDisc50) {
                diskon = 0.50;
            } else if (isDisc25) {
                diskon = 0.25;
            } else {
                diskon = 0.0;
            }

            double totalDiskon = totalBelanja * diskon;
            double totalBill = totalBelanja - totalDiskon;

            //Final output
            System.out.println("=====[ BILL PEMBAYARAN ]=====");
            System.out.println("Nomor Antrian: " + nomorAntrian);
            System.out.println("Nama Customer: " + namaCustomer);
            System.out.println("Total Belanja: Rp" + totalBelanja);
            System.out.println("Diskon: " + (int)(diskon * 100) + "%");
            System.out.println(" ");
            System.out.println("Total bayar: " + totalBill);
            System.out.println(" ");
            System.out.println("- By Lazuardi Akbar");
        }
    }
}
