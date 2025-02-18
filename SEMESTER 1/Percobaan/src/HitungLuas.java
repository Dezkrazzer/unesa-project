import java.util.Scanner;

public class HitungLuas {
    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {

            //Input panjang
            System.out.print("Masukkan panjang: ");
            double panjang = input.nextDouble();

            //Input lebar
            System.out.print("Masukkan lebar: ");
            double lebar = input.nextDouble();

            //Variable luas
            double luas = panjang * lebar;

            //Output
            System.out.println("=====[ HASIL HITUNGAN ]=====");
            System.out.println("Panjang: " + panjang);
            System.out.println("Lebar: " + lebar);
            System.out.println("Hasil luas adalah: " + luas);
            System.out.println("============================");
            System.out.println(" ");
            System.out.println("- By Lazuardi Akbar");
        }
    }
}
